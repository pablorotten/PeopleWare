create database peopleware;

CREATE TABLE `offer` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
  	`name` varchar(255) COLLATE utf8_bin NOT NULL,
  	`company` varchar(255) COLLATE utf8_bin NOT NULL,
  	`description` text COLLATE utf8_bin NOT NULL,
	`salary_range_min` DECIMAL(10,2) NOT NULL,
	`salary_range_max` DECIMAL(10,2) NOT NULL,
  	`working_time` int(3) NOT NULL,
  	PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `applicant` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
  	`name` varchar(255) COLLATE utf8_bin NOT NULL,
  	`surname` varchar(255) COLLATE utf8_bin NOT NULL,
  	`email` varchar(255) COLLATE utf8_bin NOT NULL,
  	`telephone` varchar(255) COLLATE utf8_bin NOT NULL,
	`minimum_salary` DECIMAL(10,2) NOT NULL,
  	`working_time` int(3) NOT NULL,
  	PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `degree` ( 
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`name` varchar(255) NOT NULL,
  	PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `skill` ( 
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`name` varchar(255) NOT NULL,
  	PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `offer_degree` (
	`offer_id` int(11) NOT NULL,
	`degree_id` int(11) NOT NULL,
  	PRIMARY KEY (`offer_id`,`degree_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `applicant_degree` (
	`applicant_id` int(11) NOT NULL,
	`degree_id` int(11) NOT NULL,
  	PRIMARY KEY (`applicant_id`,`degree_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `offer_skill` (
	`offer_id` int(11) NOT NULL,
	`skill_id` int(11) NOT NULL,
  	`min_level` int(3),
  	PRIMARY KEY (`offer_id`,`skill_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `applicant_skill` (
	`applicant_id` int(11) NOT NULL,
	`skill_id` int(11) NOT NULL,
  	`level` int(3),
  	PRIMARY KEY (`applicant_id`,`skill_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `applicant_offer` (
	`applicant_id` int(11) NOT NULL,
	`offer_id` int(11) NOT NULL,
  	PRIMARY KEY (`applicant_id`,`offer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

ALTER TABLE `applicant_degree`
	ADD CONSTRAINT `fk-applicant_degree-applicant` FOREIGN KEY (`applicant_id`) REFERENCES `applicant` (`id`),
	ADD CONSTRAINT `fk-applicant_degree-degree` FOREIGN KEY (`degree_id`) REFERENCES `degree` (`id`);

ALTER TABLE `offer_degree`
	ADD CONSTRAINT `fk-offer_degree-offer` FOREIGN KEY (`offer_id`) REFERENCES `offer` (`id`),
	ADD CONSTRAINT `fk-offer_degree-degree` FOREIGN KEY (`degree_id`) REFERENCES `degree` (`id`);

ALTER TABLE `applicant_skill`
	ADD CONSTRAINT `fk-applicant_skill-applicant` FOREIGN KEY (`applicant_id`) REFERENCES `applicant` (`id`),
	ADD CONSTRAINT `fk-applicant_skill-skill` FOREIGN KEY (`skill_id`) REFERENCES `skill` (`id`);

ALTER TABLE `offer_skill`
	ADD CONSTRAINT `fk-offer_skill-offer` FOREIGN KEY (`offer_id`) REFERENCES `offer` (`id`),
	ADD CONSTRAINT `fk-offer_skill-skill` FOREIGN KEY (`skill_id`) REFERENCES `skill` (`id`);

ALTER TABLE `applicant_offer`
	ADD CONSTRAINT `fk-applicant_offer-applicant` FOREIGN KEY (`applicant_id`) REFERENCES `applicant` (`id`),
	ADD CONSTRAINT `fk-applicant_offer-offer` FOREIGN KEY (`offer_id`) REFERENCES `offer` (`id`);