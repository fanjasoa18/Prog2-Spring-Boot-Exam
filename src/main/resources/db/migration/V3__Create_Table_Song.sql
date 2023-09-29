--Table for Songs--
CREATE TABLE song
(
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    duration VARCHAR(100),
    album VARCHAR(255),
    release_year INT,
    lyrics TEXT,
    artist_id INT REFERENCES artist(id)
);