DROP SCHEMA IF exists fgts ;
CREATE SCHEMA fgts DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE fgts;
GRANT ALL PRIVILEGES ON fgts To 'fgts'@'%' IDENTIFIED BY 'thinkmore';
GRANT ALL ON fgts.* TO 'fgts'@'%';