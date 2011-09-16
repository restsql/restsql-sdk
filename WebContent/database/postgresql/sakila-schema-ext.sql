-- Adds test tables to sakila database
CREATE TABLE actor_genre ( actor_genre_id SMALLINT NOT NULL, actor_id SMALLINT NOT NULL, name VARCHAR(20) NOT NULL, foreign key (actor_id) references actor (actor_id) on delete cascade);
CREATE TABLE film_rating ( film_rating_id SMALLINT NOT NULL, film_id SMALLINT NOT NULL, stars SMALLINT NOT NULL, PRIMARY KEY (film_rating_id), foreign key (film_id) references film (film_id) on delete cascade);
CREATE TABLE test_timestamp ( id SMALLINT NOT NULL, time timestamp);