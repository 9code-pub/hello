CREATE TABLE `guest` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nick_name` char(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_assigned` tinyint(1) DEFAULT '1',
  `visit_time` int(11) NOT NULL DEFAULT '0',
  `nick_name_used` smallint(6) NOT NULL DEFAULT '1',
  `feature` int(11) DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nick_name` (`nick_name`),
  KEY `FK_enpb7100spqewdik6xr11uh2q` (`feature`),
  CONSTRAINT `FK_enpb7100spqewdik6xr11uh2q` FOREIGN KEY (`feature`) REFERENCES `feature` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1615 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `vocabulary` (
  `word` char(16) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `emotion_joy` smallint(6) DEFAULT '0',
  `emotion_sad` smallint(6) DEFAULT '0',
  `emotion_anger` smallint(6) DEFAULT '0',
  `emotion_fear` smallint(6) DEFAULT '0',
  `emotion_trust` smallint(6) DEFAULT '0',
  `emotion_suspect` smallint(6) DEFAULT '0',
  `emotion_expect` smallint(6) DEFAULT '0',
  `emotion_surprised` smallint(6) DEFAULT '0',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`word`),
  UNIQUE KEY `word` (`word`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
