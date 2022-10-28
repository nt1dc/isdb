CREATE TABLE IF NOT EXISTS world
(
    id   SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR
);

CREATE TABLE IF NOT EXISTS country
(
    id       SERIAL PRIMARY KEY NOT NULL,
    world_id INT REFERENCES world,
    name     VARCHAR
);

CREATE TABLE IF NOT EXISTS city
(
    id            SERIAL PRIMARY KEY NOT NULL,
    country_id    INT REFERENCES country,
    wonders_count INT,
    is_capital    BOOLEAN,
    founding_date DATE,
    name          VARCHAR
);

CREATE TABLE IF NOT EXISTS diaspora
(
    id         SERIAL PRIMARY KEY NOT NULL,
    country_id INT REFERENCES country

);

CREATE TABLE IF NOT EXISTS diaspora_city
(
    diaspora_id INT REFERENCES diaspora,
    city_id     INT REFERENCES city
);

CREATE TABLE IF NOT EXISTS human
(
    id              SERIAL PRIMARY KEY NOT NULL,
    diaspora_id     INT REFERENCES diaspora,
    city_id         INT REFERENCES city,
    name            VARCHAR,
    pleasure_factor INT
);

CREATE TABLE IF NOT EXISTS brain
(
    id       SERIAL PRIMARY KEY NOT NULL,
    human_id INT REFERENCES human
);

CREATE TABLE IF NOT EXISTS thought
(
    id    SERIAL PRIMARY KEY NOT NULL,
    state INT
);

CREATE TABLE IF NOT EXISTS brain_thought
(
    thought_id INT REFERENCES thought,
    brain_id   INT REFERENCES brain
);