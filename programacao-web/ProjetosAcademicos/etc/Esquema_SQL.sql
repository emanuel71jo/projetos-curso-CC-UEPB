create schema api_projetos_academicos;

use api_projetos_academicos;


CREATE TABLE `addresses` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `street` varchar(255) NOT NULL,
  `number` varchar(255) DEFAULT NULL,
  `cep` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `teachers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `registration` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `course` varchar(255) DEFAULT NULL,
  `fk_address_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`fk_address_id`) REFERENCES `addresses` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `projects` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `area` varchar(255) DEFAULT NULL,
  `resume` varchar(255) DEFAULT NULL,
  `firstKeyWord` varchar(255) DEFAULT NULL,
  `secondKeyWord` varchar(255) DEFAULT NULL,
  `thirdKeyWord` varchar(255) DEFAULT NULL,
  `documentURL` varchar(255) DEFAULT NULL,
  `fk_teacher_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`fk_teacher_id`) REFERENCES `teachers` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `students` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `registration` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `course` varchar(255) DEFAULT NULL,
  `cpf` varchar(14) DEFAULT NULL,
  `fk_address_id` int(11) NOT NULL,
  `fk_project_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`fk_address_id`) REFERENCES `addresses` (`id`),
  FOREIGN KEY (`fk_project_id`) REFERENCES `projects` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
