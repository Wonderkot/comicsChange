-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               5.6.24-log - MySQL Community Server (GPL)
-- ОС Сервера:                   Win64
-- HeidiSQL Версия:              9.2.0.4947
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Дамп структуры базы данных comicschange
DROP DATABASE IF EXISTS `comicschange`;
DROP DATABASE IF EXISTS `shop_core`;
CREATE DATABASE IF NOT EXISTS `shop_core` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `shop_core`;


-- Дамп структуры для таблица comicschange.authors
DROP TABLE IF EXISTS `authors`;
CREATE TABLE IF NOT EXISTS `authors` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` text NOT NULL,
  `SURNAME` text NOT NULL,
  `PATRONYMIC` text,
  `DELETED` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.


-- Дамп структуры для таблица comicschange.comics_book
DROP TABLE IF EXISTS `comics_book`;
CREATE TABLE IF NOT EXISTS `comics_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) CHARACTER SET utf8mb4 NOT NULL,
  `author_id` int(11) NOT NULL,
  `publisher_id` int(11) NOT NULL,
  `DELETED` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `title_UNIQUE` (`title`),
  KEY `FK_author_idx` (`author_id`),
  KEY `FK_publisher_idx` (`publisher_id`),
  CONSTRAINT `FK_author` FOREIGN KEY (`author_id`) REFERENCES `authors` (`ID`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `FK_publisher` FOREIGN KEY (`publisher_id`) REFERENCES `publishers` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.


-- Дамп структуры для таблица comicschange.have
DROP TABLE IF EXISTS `have`;
CREATE TABLE IF NOT EXISTS `have` (
  `user_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  KEY `FK_user_idx` (`user_id`),
  KEY `FK_book_idx` (`book_id`),
  CONSTRAINT `FK_book` FOREIGN KEY (`book_id`) REFERENCES `comics_book` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.


-- Дамп структуры для таблица comicschange.publishers
DROP TABLE IF EXISTS `publishers`;
CREATE TABLE IF NOT EXISTS `publishers` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) CHARACTER SET utf8mb4 DEFAULT NULL,
  `DELETED` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.


-- Дамп структуры для таблица comicschange.users
DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
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

-- Экспортируемые данные не выделены.


-- Дамп структуры для таблица comicschange.wish
DROP TABLE IF EXISTS `wish`;
CREATE TABLE IF NOT EXISTS `wish` (
  `user_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  KEY `FK_user_wish_idx` (`user_id`),
  KEY `FK_book_wish_idx` (`book_id`),
  CONSTRAINT `FK_book_wish` FOREIGN KEY (`book_id`) REFERENCES `comics_book` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_user_wish` FOREIGN KEY (`user_id`) REFERENCES `users` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
