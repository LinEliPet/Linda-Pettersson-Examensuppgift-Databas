use movies;

-- adding directors
insert into director (director_name) VALUES ('Torsten Lareke');
insert into director (director_name) VALUES ('Andreas Lanis Lanhede');
insert into director (director_name) VALUES ('Daniel Lindberg');

-- adding genres
insert into genre (genre) values ('Action');
insert into genre (genre) values ('Drama');
insert into genre (genre) values ('Comedy');
insert into genre (genre) values ('Fantasy');
insert into genre (genre) values ('Sci-Fi');
insert into genre (genre) values ('Thriller');
insert into genre (genre) values ('Romance');

-- adding years
insert into releasedate (releasedate) values (1977);
insert into releasedate (releasedate) values (2022);
insert into releasedate (releasedate) values (2009);

-- adding movies
insert into movies (title, director_id, releasedate_id) values ('Jurassic Torun', 1, 1);
insert into movies (title, director_id, releasedate_id) values ('Daniels sticky chairs', 3, 3);
insert into movies (title, director_id, releasedate_id) values ('Fredde strikes again', 2, 3);
insert into movies (title, director_id, releasedate_id) values ('Fredde strikes', 2, 2);
insert into movies (title, director_id, releasedate_id) values ('Bend it like Safer', 1, 3);
insert into movies (title, director_id, releasedate_id) values ('Star Wars, return of the Redon', 3, 1);


-- adding genres to movies
insert into moviegenres (movie_id, genre_id) values (1, 2);
insert into moviegenres (movie_id, genre_id) values (1, 1);
insert into moviegenres (movie_id, genre_id) values (2, 7);
insert into moviegenres (movie_id, genre_id) values (3, 1);
insert into moviegenres (movie_id, genre_id) values (3, 6);
insert into moviegenres (movie_id, genre_id) values (4, 1);
insert into moviegenres (movie_id, genre_id) values (4, 6);
insert into moviegenres (movie_id, genre_id) values (5, 3);
insert into moviegenres (movie_id, genre_id) values (6, 5);
insert into moviegenres (movie_id, genre_id) values (6, 4);

-- adding addresses
insert into address (address, postalcode) VALUES ('The street 22A', 21219);
insert into address (address, postalcode) VALUES ('Rebelroad 27C', 23220);
insert into address (address, postalcode) VALUES ('Big hill 12', 19923);
insert into address (address, postalcode) VALUES ('Smal hill 54', 19923);
insert into address (address, postalcode) VALUES ('On the train 7B', 19923);

-- adding actors
insert into actor (actor_name, hometown, actor_age, address_id) VALUES ('Fredrik Lindah', 'Skurup', 30, 3);
insert into actor (actor_name, hometown, actor_age, address_id) VALUES ('Ismail Guven', 'Malmo', 28, 1);
insert into actor (actor_name, hometown, actor_age, address_id) VALUES ('Daniel Lindberg', 'Staffanstorp', 65, 4);
insert into actor (actor_name, hometown, actor_age, address_id) VALUES ('Redon Shaqiri', 'Malmo', 25, 1);
insert into actor (actor_name, hometown, actor_age, address_id) VALUES ('Torun Flink', 'Tosselilla', 16, 2);
insert into actor (actor_name, hometown, actor_age, address_id) VALUES ('Safer Kret', 'Tosselilla', 15, 2);
insert into actor (actor_name, hometown, actor_age, address_id) VALUES ('William Pihl', 'Akarp', 10, 5);

-- adding actors to movies
insert into actorrelations (movie_id, actor_id) VALUES (3, 1);
insert into actorrelations (movie_id, actor_id) VALUES (4, 1);
insert into actorrelations (movie_id, actor_id) VALUES (5, 2);
insert into actorrelations (movie_id, actor_id) VALUES (2, 3);
insert into actorrelations (movie_id, actor_id) VALUES (6, 4);
insert into actorrelations (movie_id, actor_id) VALUES (1, 5);
insert into actorrelations (movie_id, actor_id) VALUES (5, 6);
insert into actorrelations (movie_id, actor_id) VALUES (3, 7);
insert into actorrelations (movie_id, actor_id) VALUES (4, 7);
