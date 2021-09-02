# Before running, mapped_id column should be filled manually with corresponding values from TMS db.
# Engine ids for staging 4, 7, 11 respectively.

INSERT INTO engine ( id, path, name, url, domain, mapped_id, public) VALUES ( 1, 'dummy', 'FG_Medical', 'http://34.83.139.75:8181/mt/pipeline/line', 'MEDICAL', 4 , b'1');

INSERT INTO engine ( id, path, name, url, domain, mapped_id, public) VALUES ( 2, 'dummy', 'FG_CONSUMER', 'http://34.83.139.75:8181/mt/pipeline/line', 'CONSUMER_ELECTRONICS', 7 , b'1');

INSERT INTO engine ( id, path, name, url, domain, mapped_id, public) VALUES ( 3, 'dummy', 'FG_AUTOMOTIVE', 'http://34.83.139.75:8181/mt/pipeline/line', 'AUTOMOTIVE', 11 , b'1');

# Creating Alpha user
INSERT INTO `mt`.`user_data` (`userid`, `email`, `firstname`, `user_password`, `username`) VALUES ('1', '', 'user', '$2a$10$154r.VlA3kqil0N52f3f3.rHIFgiPfHjHltL2xcdpXPn3fI65bIvO', 'test');

# Assigning public engines to alpha user
INSERT INTO `mt`.`user_engine` (`id`, `engine`, `user`) VALUES ('1', '1', '1');
INSERT INTO `mt`.`user_engine` (`id`, `engine`, `user`) VALUES ('2', '2', '1');
INSERT INTO `mt`.`user_engine` (`id`, `engine`, `user`) VALUES ('3', '3', '1');
