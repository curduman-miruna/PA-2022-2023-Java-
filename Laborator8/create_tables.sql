
CREATE TABLE IF NOT EXISTS albums
(
    id integer NOT NULL,
    release_year integer NOT NULL,
    title text COLLATE pg_catalog."default" NOT NULL,
    artist text COLLATE pg_catalog."default" NOT NULL,
    genre text[] COLLATE pg_catalog."default" NOT NULL,
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

CREATE TABLE album_genres (
    album_id INTEGER NOT NULL REFERENCES albums(id),
    genre_id INTEGER NOT NULL REFERENCES genres(id),
    PRIMARY KEY (album_id, genre_id)
);