CREATE DATABASE `comicschange` /*!40100 DEFAULT CHARACTER SET utf8 */;



CREATE TABLE `authors` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` TEXT() NOT NULL,
  `SURNAME` TEXT()  NOT NULL,
  `PATRONYMIC` TEXT()  DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `publishers` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) CHARACTER SET utf8mb4 DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `users` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `LOGIN` varchar(45) CHARACTER SET utf8mb4 NOT NULL,
  `PASSWORD` varchar(45) CHARACTER SET utf8mb4 NOT NULL,
  `email` varchar(45) CHARACTER SET utf8mb4 NOT NULL,
  `NAME` varchar(45) CHARACTER SET utf8mb4 NOT NULL,
  `SURNAME` varchar(45) CHARACTER SET utf8mb4 NOT NULL,
  `PATRONYMIC` varchar(45) CHARACTER SET utf8mb4 NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`),
  UNIQUE KEY `LOGIN_UNIQUE` (`LOGIN`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `comics_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) CHARACTER SET utf8mb4 NOT NULL,
  `author_id` int(11) NOT NULL,
  `publisher_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `title_UNIQUE` (`title`),
  KEY `FK_author_idx` (`author_id`),
  KEY `FK_publisher_idx` (`publisher_id`),
  CONSTRAINT `FK_author` FOREIGN KEY (`author_id`) REFERENCES `authors` (`ID`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `FK_publisher` FOREIGN KEY (`publisher_id`) REFERENCES `publishers` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `have` (
  `user_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  KEY `FK_user_idx` (`user_id`),
  KEY `FK_book_idx` (`book_id`),
  CONSTRAINT `FK_book` FOREIGN KEY (`book_id`) REFERENCES `comics_book` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;





CREATE TABLE `wish` (
  `user_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  KEY `FK_user_wish_idx` (`user_id`),
  KEY `FK_book_wish_idx` (`book_id`),
  CONSTRAINT `FK_book_wish` FOREIGN KEY (`book_id`) REFERENCES `comics_book` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_user_wish` FOREIGN KEY (`user_id`) REFERENCES `users` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
