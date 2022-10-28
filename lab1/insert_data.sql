INSERT INTO world
VALUES (1, 'BEST WORLD EVER');
INSERT INTO country
VALUES (1, 1, 'RUSSIA'),
       (2, 1, 'POLAND'),
       (3, 1, 'SWEDEN');
INSERT INTO city
VALUES (1, 1, 4, TRUE, current_date, 'ВЕКОВКА'),
       (2, 2, 1000, true, current_date, 'ECCO2K'),
       (3, 3, 7, TRUE, current_date, 'STOCKHOLM');
INSERT INTO diaspora
VALUES (1, 1),
       (2, 2),
       (3, 3);
INSERT INTO diaspora_city
VALUES (1, 1),
       (1, 2),
       (1, 3);
INSERT INTO human
VALUES (1, 1, 1, 'SEMEN', 1000000000),
       (2, 1, 2, 'DINA', 0);
INSERT INTO brain
VALUES (1, 1),
       (2, 2);
INSERT INTO thought
VALUES (1, 0);
INSERT INTO brain_thought
VALUES (1, 1),
       (1, 2);
