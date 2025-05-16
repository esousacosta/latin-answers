-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;
INSERT INTO T_QUESTION (id, text, answer, lesson, number, lesson_type) VALUES (1001, 'Translate: rosa', 'rose', '1', 1, 'questionario');
INSERT INTO T_QUESTION (id, text, answer, lesson, number, lesson_type) VALUES (1002, 'Translate: agricola', 'farmer', '1', 2, 'questionario');
INSERT INTO T_QUESTION (id, text, answer, lesson, number, lesson_type) VALUES (1003, 'Translate: puella', 'girl', '2', 3, 'questionario');
INSERT INTO T_QUESTION (id, text, answer, lesson, number, lesson_type) VALUES (1004, 'Translate: nauta', 'sailor', '2', 4, 'questionario');