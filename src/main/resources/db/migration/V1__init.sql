CREATE TABLE IF NOT EXISTS `study`.`user` (
  `id` VARCHAR(36) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

INSERT INTO `study`.`user` (`id`, `name`, `password`) VALUES ('38d38f66-4b3d-548f-86d0-5c362f46b827', 'admin', 'admin');
INSERT INTO `study`.`user` (`id`, `name`, `password`) VALUES ('19f9ecb2-a8b5-5057-8ffb-fb7527c4f87d', 'wh', 'wh');

CREATE TABLE IF NOT EXISTS `study`.`role` (
  `id` VARCHAR(36) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

INSERT INTO `study`.`role` (`id`, `name`) VALUES ('09e4cb78-b639-5328-a372-19847ed7abdd', '超级管理员');
INSERT INTO `study`.`role` (`id`, `name`) VALUES ('f916b268-8399-58e9-b328-ca128a25afb6', '游客');

CREATE TABLE IF NOT EXISTS `study`.`user_role` (
  `userid` VARCHAR(36) NOT NULL,
  `roleid` VARCHAR(36) NOT NULL,
  PRIMARY KEY (`userid`, `roleid`))
ENGINE = InnoDB;

INSERT INTO `study`.`user_role` (`userid`, `roleid`) VALUES ('38d38f66-4b3d-548f-86d0-5c362f46b827', '09e4cb78-b639-5328-a372-19847ed7abdd');
INSERT INTO `study`.`user_role` (`userid`, `roleid`) VALUES ('19f9ecb2-a8b5-5057-8ffb-fb7527c4f87d', 'f916b268-8399-58e9-b328-ca128a25afb6');

CREATE TABLE IF NOT EXISTS `study`.`authority` (
  `id` VARCHAR(36) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `code` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

INSERT INTO `study`.`authority` (`id`, `name`, `code`) VALUES ('d413e2bb-68f2-5cb0-a44c-980dabb3958e', '添加用户', 'user_add');
INSERT INTO `study`.`authority` (`id`, `name`, `code`) VALUES ('aacc2fc8-d3db-54c0-ac51-4a0296049114', '查询用户', 'user_view');
INSERT INTO `study`.`authority` (`id`, `name`, `code`) VALUES ('fbe4459d-d514-5bd3-843c-b0bc2f3dd1c6', '修改用户', 'user_modify');

CREATE TABLE IF NOT EXISTS `study`.`role_authority` (
  `roleid` VARCHAR(36) NOT NULL,
  `authorityid` VARCHAR(36) NOT NULL,
  PRIMARY KEY (`roleid`, `authorityid`))
ENGINE = InnoDB;

INSERT INTO `study`.`role_authority` (`roleid`, `authorityid`) VALUES ('09e4cb78-b639-5328-a372-19847ed7abdd', 'd413e2bb-68f2-5cb0-a44c-980dabb3958e');
INSERT INTO `study`.`role_authority` (`roleid`, `authorityid`) VALUES ('09e4cb78-b639-5328-a372-19847ed7abdd', 'aacc2fc8-d3db-54c0-ac51-4a0296049114');
INSERT INTO `study`.`role_authority` (`roleid`, `authorityid`) VALUES ('09e4cb78-b639-5328-a372-19847ed7abdd', 'fbe4459d-d514-5bd3-843c-b0bc2f3dd1c6');
INSERT INTO `study`.`role_authority` (`roleid`, `authorityid`) VALUES ('f916b268-8399-58e9-b328-ca128a25afb6', 'aacc2fc8-d3db-54c0-ac51-4a0296049114');




