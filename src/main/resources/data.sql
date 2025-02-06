INSERT INTO albums 
    (id, title, artist_name, release_date, tracks, duration_minutes) 
    VALUES 
    ('108b1f74-081c-4f8a-8cb2-308ec6debe74', 'Hurry Up Tomorrow', 'The Weeknd', '2025-01-31', 22, 109);

INSERT INTO physical_copies
    (id, album_id, available_copies, media_type, price)
    VALUES
    ('09c94eeb-c13b-477d-b4f8-46ac5cea0b17', '108b1f74-081c-4f8a-8cb2-308ec6debe74', 10, 'VINYL_2LP', 190000);

