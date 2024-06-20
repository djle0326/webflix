CREATE DATABASE webflix;
USE webflix;
CREATE TABLE user (
    userId VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    birthDate DATE,
    gender VARCHAR(50),
    nickname VARCHAR(255),
    password VARCHAR(255) NOT NULL,
    phoneNumber VARCHAR(255),
    email VARCHAR(255) NOT NULL,
    PRIMARY KEY (userId)
);
CREATE TABLE `webflix`.`movie` (
  `movie_id` INT NOT NULL,
  `movie_name` VARCHAR(45) NOT NULL,
  `movie_img` VARCHAR(45) NOT NULL,
  `movie_comment` VARCHAR(100) NOT NULL,
  `movie_explain` VARCHAR(1000) NOT NULL,
  PRIMARY KEY (`movie_id`));
  
  ALTER TABLE `webflix`.`movie` 
ADD COLUMN `movie_see_num` INT NULL AFTER `movie_explain`,
ADD COLUMN `movie_likes` INT NULL AFTER `movie_see_num`;

INSERT INTO movie (movie_id, movie_name, movie_img, movie_comment, movie_explain, movie_see_num, movie_likes) VALUES
(1, '가필드', 'img_url_1', 'comment_1', 'explain_1', 100, 10),
(2, '그녀가 죽었다', 'img_url_2', 'comment_2', 'explain_2', 150, 20),
(3, '범죄도시4', 'img_url_3', 'comment_3', 'explain_3', 200, 30),
(4, '설계자', 'img_url_4', 'comment_4', 'explain_4', 250, 40),
(5, '청춘18', 'img_url_5', 'comment_5', 'explain_5', 300, 50),
(6, '퓨리오사', 'img_url_6', 'comment_6', 'explain_6', 350, 60),
(7, '하이큐', 'img_url_7', 'comment_7', 'explain_7', 400, 70),
(8, '혹성탈출', 'img_url_8', 'comment_8', 'explain_8', 450, 80);

