# Create books table

# --- !Ups
CREATE TABLE `books` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(500) DEFAULT NULL,
  `sratedAt` datetime DEFAULT NULL,
  `finishedAt` datetime DEFAULT NULL,
  `createdAt` datetime DEFAULT NULL,
  `updatedAt` datetime DEFAULT NULL,
  `review_full` varchar(5000) DEFAULT NULL,
  `review_brief` varchar(500) DEFAULT NULL,
  `author` varchar(200) DEFAULT NULL,
  `stars` float(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

# --- !Downs
DROP TABLE books;