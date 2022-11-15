CREATE TABLE IF NOT EXISTS real_world
(
    id SERIAL PRIMARY KEY NOT NULL
);
CREATE TABLE IF NOT EXISTS hell
(
    id               SERIAL PRIMARY KEY NOT NULL,
    produced_screams NUMERIC
);
CREATE TABLE IF NOT EXISTS distribution_layer
(
    id            SERIAL PRIMARY KEY NOT NULL,
    screams_count INT
        CONSTRAINT positive_scream_count CHECK ( screams_count > 0)
);
CREATE TABLE IF NOT EXISTS world
(
    id                    SERIAL PRIMARY KEY,
    name                  VARCHAR,
    real_world_id         INT NOT NULL UNIQUE REFERENCES real_world,
    hell_id               INT NOT NULL UNIQUE REFERENCES hell,
    distribution_layer_id INT NOT NULL UNIQUE REFERENCES distribution_layer,
    year                  INT NOT NULL DEFAULT (0)
        CONSTRAINT positive_year CHECK ( year >= 0 )
);

CREATE TABLE IF NOT EXISTS distribution_committee
(
    id                    SERIAL PRIMARY KEY NOT NULL,
    distribution_layer_id INT REFERENCES distribution_layer,
    estimation_error      NUMERIC
        CONSTRAINT positive_estimation_error CHECK ( estimation_error > 0 )
);

CREATE TABLE IF NOT EXISTS distributor
(
    id                        SERIAL PRIMARY KEY NOT NULL,
    distribution_committee_id INT REFERENCES distribution_committee,
    age                       INT
        CONSTRAINT positive_age check ( age > 0),
    mood                      INT
);
CREATE TABLE IF NOT EXISTS distributor_skill
(
    id               SERIAL PRIMARY KEY NOT NULL,
    distributor_id   INT REFERENCES distributor,
    name             VARCHAR,
    required_screams INT
        CONSTRAINT positive_required_screams check ( required_screams > 0)
);

CREATE TABLE IF NOT EXISTS human
(
    id                        SERIAL PRIMARY KEY NOT NULL,
    real_world_id             INT REFERENCES real_world,
    distribution_layer_id     INT REFERENCES distribution_layer,
    hell_id                   INT REFERENCES hell,
    age                       INT
        CONSTRAINT positive_age check ( age > 0),
    name                      VARCHAR,
    last_name                 VARCHAR,
    nationality               VARCHAR,
    number_of_good_deeds      INT                NOT NULL,
    CONSTRAINT positive_number_of_good_deeds check ( number_of_good_deeds >= 0),
    number_of_righteous_deeds INT                NOT NULL,
    sex                       INT,
    CONSTRAINT positive_number_of_righteous_deeds check ( number_of_good_deeds >= 0),
    CONSTRAINT attached_to_world check ( real_world_id IS NOT NULL or hell_id IS NOT NULL or
                                         distribution_layer_id IS NOT NULL )

);

CREATE TABLE IF NOT EXISTS demon
(
    id                SERIAL PRIMARY KEY NOT NULL,
    hell_id           INT REFERENCES hell,
    ages_left_in_hell NUMERIC
        CONSTRAINT positive_ages_left_in_hell check ( ages_left_in_hell > 0 )
);

CREATE TABLE IF NOT EXISTS demon_specialisation
(
    id    SERIAL PRIMARY KEY NOT NULL,
    name  VARCHAR,
    power NUMERIC
        CONSTRAINT positive_power check ( power > 0 )
);
CREATE TABLE IF NOT EXISTS demon_demon_specialisation
(
    demon_specialisation INT REFERENCES demon_specialisation,
    demon_id             INt REFERENCES demon
);


CREATE TABLE IF NOT EXISTS demon_human
(
    human_id INT REFERENCES human,
    demon_id INt REFERENCES demon
);

