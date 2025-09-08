USE Assignment1;

--DML INSERT DATA FOR ASSIGNMENT1
--Auto-increment ID does not require manual insertion.

-- table: game_genre
INSERT INTO game_genre (genre_name) VALUES
('MMO'),
('RPG'),
('Fighting'),
('Board/card game'),
('Real-time strategy'),
('A-AVG'),
('AVG'),
('Puzzle'),
('SLG'),
('Racing');


--Table game
INSERT INTO game (name, genre_id, release_date, price) VALUES
('Monster Hunter Wilds', 1, '2025-02-28', 69.99),
('Baldur''s Gate 3', 2, '2023-08-03', 69.99),
('The Witcher 3: Wild Hunt', 2, '2015-05-19', 39.99),
('Marvel Contest of Champions', 3, '2014-12-10', 0.00),
('Monopoly GO!', 4, '2023-04-11', 0.00),
('Dynasty Warriors ORIGINS', 5, '2025-01-14', 69.99),
('Elden Ring', 2, '2022-02-25', 59.99),
('The Elder Scrolls V: Skyrim', 2, '2011-11-11', 39.99),
('Final Fantasy VII Rebirth', 2, '2024-02-29', 69.99),
('Assassin''s Creed Valhalla', 6, '2020-11-10', 59.99),
('Phoenix Wright: Ace Attorney Trilogy', 7, '2019-04-09', 39.99),
('Puyo Puyo Tetris 2', 8, '2022-12-08', 39.99),
('The Sims 4', 9, '2017-11-17', 39.99),
('Gran Turismo 7', 10, '2022-03-04', 69.99);

--table game_mode
INSERT INTO game_mode (mode_name) VALUES
('Single-player'),
('Online Co-op'),
('Online Multiplayer');

--table platform
INSERT INTO platform (platform_name) VALUES
('PlayStation 5'),
('Xbox Series X/S'),
('PC'),
('GeForce Now'),
('macOS'),
('PlayStation 4'),
('Xbox One'),
('Nintendo Switch'),
('Android'),
('iOS'),
('Nintendo Switch 2');

--publisher
INSERT INTO publisher (publisher_name) VALUES
('Capcom'),
('Larian Studios'),
('CD Projekt Red'),
('Kabam'),
('Scopely'),
('Koei Tecmo'),
('Bandai Namco Games'),
('Bethesda Softworks'),
('Square Enix'),
('Ubisoft'),
('SEGA'),
('Electronic Arts'),
('Sony Interactive Entertainment');


--platform_has_game
INSERT INTO platform_has_game (game_id, platform_id) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(2, 1),
(2, 2),
(2, 3),
(2, 5),
(3, 1),
(3, 2),
(3, 3),
(3, 6),
(3, 7),
(3, 8),
(4, 3),
(4, 9),
(4, 10),
(5, 9),
(5, 10),
(6, 1),
(6, 2),
(6, 3),
(7, 1),
(7, 2),
(7, 3),
(7, 6),
(7, 7),
(8, 1),
(8, 2),
(8, 3),
(8, 6),
(8, 7),
(8, 8),
(9, 1),
(9, 3),
(10, 1),
(10, 2),
(10, 3),
(10, 6),
(10, 7),
(11, 3),
(11, 6),
(11, 7),
(11, 8),
(11, 9),
(11, 10),
(12, 1),
(12, 2),
(12, 3),
(12, 6),
(12, 7),
(12, 11),
(13, 3),
(13, 6),
(13, 7),
(13, 10),
(14, 1),
(14, 6);

--game_has_publisher
INSERT INTO game_has_publisher (game_id, publisher_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10),
(11, 1),
(12, 11),
(13, 12),
(14, 13);


--game_mode_has_game
INSERT INTO game_mode_has_game (game_id, game_mode_id) VALUES
(1, 1),
(1, 2),
(2, 1),
(2, 2),
(3, 1),
(4, 3),
(5, 3),
(6, 1),
(7, 1),
(8, 1),
(9, 1),
(10, 1),
(11, 1),
(12, 1),
(13, 1),
(14, 1),
(14, 2);

SELECT * FROM game;
SELECT * FROM game_mode;
SELECT * FROM game_mode_has_game;
SELECT * FROM publisher;
SELECT * FROM game_has_publisher;
SELECT * FROM platform;
SELECT * FROM platform_has_game;
SELECT * FROM game_genre;
