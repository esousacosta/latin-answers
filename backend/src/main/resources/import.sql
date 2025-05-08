-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;
INSERT INTO T_QUESTION (id, text, answer, lesson) VALUES (1001, 'Translate: rosa', 'rose', '1');
INSERT INTO T_QUESTION (id, text, answer, lesson) VALUES (1002, 'Translate: agricola', 'farmer', '1');
INSERT INTO T_QUESTION (id, text, answer, lesson) VALUES (1003, 'Translate: puella', 'girl', '2');
INSERT INTO T_QUESTION (id, text, answer, lesson) VALUES (1004, 'Translate: nauta', 'sailor', '2');