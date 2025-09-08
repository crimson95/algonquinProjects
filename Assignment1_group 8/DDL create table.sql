USE Assignment1;

-- DROP 中间表（有外键依赖的先删）
IF OBJECT_ID('game_mode_has_game', 'U') IS NOT NULL DROP TABLE game_mode_has_game;
IF OBJECT_ID('game_has_publisher', 'U') IS NOT NULL DROP TABLE game_has_publisher;
IF OBJECT_ID('platform_has_game', 'U') IS NOT NULL DROP TABLE platform_has_game;

-- DROP 主表（无依赖的后删）
IF OBJECT_ID('game', 'U') IS NOT NULL DROP TABLE game;
IF OBJECT_ID('platform', 'U') IS NOT NULL DROP TABLE platform;
IF OBJECT_ID('publisher', 'U') IS NOT NULL DROP TABLE publisher;
IF OBJECT_ID('game_mode', 'U') IS NOT NULL DROP TABLE game_mode;
IF OBJECT_ID('game_genre', 'U') IS NOT NULL DROP TABLE game_genre;

--DDL create table
CREATE TABLE game_genre (
    id INT IDENTITY PRIMARY KEY,          
    genre_name VARCHAR(50) NOT NULL       
);


CREATE TABLE game (
    id INT IDENTITY PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    genre_id INT NOT NULL,
    release_date DATE,
    price DECIMAL(6,2),
    FOREIGN KEY (genre_id) REFERENCES game_genre(id)
);

CREATE TABLE platform (
    id INT IDENTITY PRIMARY KEY,               
    platform_name VARCHAR(50) NOT NULL,                                
);

--middle table 
CREATE TABLE platform_has_game (
    platform_id INT NOT NULL,
    game_id INT NOT NULL,
    PRIMARY KEY (platform_id, game_id),
    FOREIGN KEY (platform_id) REFERENCES platform(id),
    FOREIGN KEY (game_id) REFERENCES game(id)
);

---------------------------------------------------------
CREATE TABLE game_mode (
    id INT IDENTITY PRIMARY KEY,
    mode_name VARCHAR(50) NOT NULL
);

--middle table
CREATE TABLE game_mode_has_game (
    game_id INT NOT NULL,
    game_mode_id INT NOT NULL,
    PRIMARY KEY (game_id, game_mode_id),
    FOREIGN KEY (game_id) REFERENCES game(id),
    FOREIGN KEY (game_mode_id) REFERENCES game_mode(id)
);
---------------------------------------------------------
CREATE TABLE publisher (
    id INT IDENTITY PRIMARY KEY,
    publisher_name VARCHAR(100) NOT NULL
);

--middle table
CREATE TABLE game_has_publisher (
    game_id INT NOT NULL,
    publisher_id INT NOT NULL,
    PRIMARY KEY (game_id, publisher_id),
    FOREIGN KEY (game_id) REFERENCES game(id),
    FOREIGN KEY (publisher_id) REFERENCES publisher(id)
);

CREATE TABLE user_collection (
    id INT IDENTITY PRIMARY KEY,
    game_id INT NOT NULL,
	platform_id INT NOT NULL,
	FOREIGN KEY (platform_id, game_id) REFERENCES platform_has_game(platform_id, game_id)
);

DROP TABLE IF EXISTS user_collection;