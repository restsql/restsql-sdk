-- Adds test tables to sakila database
CREATE TABLE IF NOT EXISTS actor_genre ( actor_genre_id SMALLINT UNSIGNED NOT NULL, actor_id SMALLINT UNSIGNED NOT NULL, name VARCHAR(20) NOT NULL, foreign key (actor_id) references actor (actor_id) on delete cascade);
CREATE TABLE IF NOT EXISTS film_rating ( film_rating_id SMALLINT UNSIGNED NOT NULL, film_id SMALLINT UNSIGNED NOT NULL, stars SMALLINT UNSIGNED NOT NULL, PRIMARY KEY (film_rating_id), foreign key (film_id) references film (film_id) on delete cascade);
