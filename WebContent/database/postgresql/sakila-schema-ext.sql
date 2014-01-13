-- Adds test tables to sakila database
CREATE TABLE actor_genre ( actor_genre_id SMALLINT NOT NULL, actor_id SMALLINT NOT NULL, name VARCHAR(20) NOT NULL, primary key (actor_genre_id), foreign key (actor_id) references actor (actor_id) on delete cascade);
CREATE TABLE film_rating ( film_rating_id SMALLINT NOT NULL, film_id SMALLINT NOT NULL, stars SMALLINT NOT NULL, PRIMARY KEY (film_rating_id), foreign key (film_id) references film (film_id) on delete cascade);
CREATE TABLE film_comment ( film_id SMALLINT NOT NULL, comment VARCHAR(128), foreign key (film_id) references film (film_id) on delete cascade);
CREATE TABLE film_genre ( film_id SMALLINT NOT NULL, genre VARCHAR(128), foreign key (film_id) references film (film_id) on delete cascade);
CREATE TABLE film_origin ( film_id SMALLINT NOT NULL, city VARCHAR(128), country VARCHAR(128), foreign key (film_id) references film (film_id) on delete cascade);
CREATE TABLE datetime ( id SMALLINT NOT NULL, time time, timestamp timestamp, date date, datetime timestamp);