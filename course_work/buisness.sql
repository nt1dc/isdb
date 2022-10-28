CREATE or replace FUNCTION add_good_and_righteous_deals() RETURNS trigger AS
$add_good_and_righteous_deals$
declare
    diff int = new.year - old.year;
BEGIN
    if (diff < 1) then
        return null;
    end if;
    UPDATE human
    SET number_of_good_deeds=number_of_good_deeds + floor(random() * 10 + 1)::int * diff,
        number_of_righteous_deeds=number_of_righteous_deeds + floor(random() * 10 + 1)::int * diff
    FROM world
    WHERE human.real_world_id IS NOT NULL;
    return new;
END;
$add_good_and_righteous_deals$
    LANGUAGE plpgsql;
CREATE or replace TRIGGER update_year
    before UPDATE
    ON world
--     for each row
EXECUTE procedure add_good_and_righteous_deals();


CREATE or replace FUNCTION validate_connected_to_only_one_layer() RETURNS TRIGGER AS
$moveToDistributionLayer$
BEGIN
    if (old.real_world_id is null and new.real_world_id is not null) then
        if (new.distribution_layer_id is not null or new.hell_id is not null) then
            return null;
        end if;
        new.hell_id = null;
        new.distribution_layer_id = null;
        return new;
    end if;

    if (old.distribution_layer_id is null and new.distribution_layer_id is not null) then
        if (new.real_world_id is not null or new.hell_id is not null) then
            return null;
        end if;
        new.real_world_id = null;
        new.hell_id = null;
        return new;
    end if;

    if (old.hell_id is null and new.hell_id is not null) then
        if (new.real_world_id is not null or new.distribution_layer_id is not null) then
            return null;
        end if;
        new.real_world_id = null;
        new.distribution_layer_id = null;
        return new;
    end if;
    return new;
END;
$moveToDistributionLayer$ LANGUAGE plpgsql;

CREATE or replace TRIGGER from_world_to_distributor
    before update
    on human
    for each row
execute procedure validate_connected_to_only_one_layer();


--
-- CREATE TRIGGER from_distributor_to_hell
--     AFTER update
--     on human
--     when ( old.distribution_layer_id is not null and new.distribution_layer_id is null)
-- execute procedure moveToHell(old.distribution_layer_id);
--
-- CREATE FUNCTION moveToHell(old_distribution_layer_id int) RETURNS void AS
-- $$
-- BEGIN
--     UPDATE human
--     SET hell_id = world.hell_id
--     FROM world
--     WHERE world.distribution_layer_id = old_distribution_layer_id;
-- END;
-- $$ LANGUAGE plpgsql;
--
-- CREATE FUNCTION find_demon_with_min_sinners_count() RETURNS int AS
-- $$
-- DECLARE
--     demon_with_min_sinners_count int;
-- BEGIN
--     select demon_id
--     into demon_with_min_sinners_count
--     from (select demon_id, count(*)::int c from demon_human group by demon_id) as d
--     order by d.c desc
--     limit 1;
--     return demon_with_min_sinners_count;
-- END
-- $$ LANGUAGE plpgsql;
--
-- CREATE FUNCTION setDemosToNewSinner(humanId int) RETURNS VOID AS
-- $$
-- BEGIN
--     INSERT INTO demon_human (human_id, demon_id)
--     VALUES (humanId, find_demon_with_min_sinners_count());
-- END
-- $$ LANGUAGE plpgsql;
--
--
