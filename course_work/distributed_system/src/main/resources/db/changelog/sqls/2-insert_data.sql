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
INSERT INTO demon
VALUES (1, 1, 666),
       (2, 1, 777);
INSERT INTO demon_specialisation
VALUES (1, 'СПРОСИТЬ МОДЕЛЬ ОСИ', 7),
       (2, 'ОТЦЕНТРОВАТЬ ДИВ', 10),
       (3, 'МИКРО ИНФАРКТ', 99);
INSERT INTO demon_demon_specialisation
VALUES (1, 1),
       (2, 1),
       (3, 2);
INSERT INTO human
VALUES (1, 1, null, null, 20, 'Dima', 'Antonov', 'я русский', 1, 100, 1),
       (2, null, 1, null, 20, 'Семен', 'Мокров', 'я русский', 5, 3, 1),
       (3, null, null, 1, 666, 'Евгений', 'Апоц', 'я русский', 228, 666, 1);
INSERT INTO demon_human
VALUES (3, 1),
       (3, 2),
       (2, 2);