INSERT INTO hell
VALUES (1, 0);

INSERT INTO real_world
VALUES (1);

INSERT INTO distribution_layer
VALUES (1, 1);

INSERT INTO world
VALUES (1, 'BEST WORLD EVER', 1, 1, 1, 1);
INSERT INTO distribution_committee
VALUES (1, 1, 1);
INSERT INTO distributor
VALUES (1, 1, 27, 0),
       (2, 1, 228, 0),
       (3, 1, 666, 1);
INSERT INTO distributor_skill
VALUES (1, 1, 'ОСИ', 777),
       (2, 1, 'ОПД', 1),
       (3, 2, 'ВЕБ', 13);
INSERT INTO demon (hell_id, ages_left_in_hell)
VALUES (1, 666),
       (1, 777);
INSERT INTO demon_specialisation (name, power)
VALUES ('СПРОСИТЬ МОДЕЛЬ ОСИ', 7),
       ('ОТЦЕНТРОВАТЬ ДИВ', 10),
       ('МИКРО ИНФАРКТ', 99);
INSERT INTO demon_demon_specialisation
VALUES (1, 1),
       (2, 1),
       (3, 2);
INSERT INTO human (real_world_id, distribution_layer_id, hell_id, age, name, last_name, nationality,
                   number_of_good_deeds, number_of_righteous_deeds, sex)
VALUES (1, null, null, 20, 'Dima', 'Antonov', 'я русский', 1, 100, 1),
       (null, 1, null, 20, 'Семен', 'Мокров', 'я русский', 5, 3, 1),
       (null, null, 1, 666, 'Евгений', 'Апоц', 'я русский', 5, 10, 1);
INSERT INTO demon_human (human_id, demon_id)
VALUES (3, 1),
       (3, 2);