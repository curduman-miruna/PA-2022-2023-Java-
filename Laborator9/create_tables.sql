-- Disable foreign key constraints
SET session_replication_role = replica;

-- Delete data from tables in reverse order to avoid foreign key constraint errors
DELETE FROM album_genres;
DELETE FROM albums;
DELETE FROM genres;
DELETE FROM artists;
DELETE FROM playlists;

-- Enable foreign key constraints
SET session_replication_role = DEFAULT;

CREATE TABLE IF NOT EXISTS public.albums
(
    id integer NOT NULL,
    release_year integer NOT NULL,
    title text COLLATE pg_catalog."default" NOT NULL,
    artist text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT albums_pkey PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS public.artists
(
    id integer NOT NULL,
    name text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT artists_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.genres
(
    id integer NOT NULL,
    name text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT genres_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.album_genres (
    album_id INTEGER NOT NULL REFERENCES albums(id),
    genre_id INTEGER NOT NULL REFERENCES genres(id),
    PRIMARY KEY (album_id, genre_id)
);

CREATE TABLE IF NOT EXISTS public.playlists (
  id integer NOT NULL,
  name TEXT NOT NULL,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  album_array text[] COLLATE pg_catalog."default" NOT NULL
);