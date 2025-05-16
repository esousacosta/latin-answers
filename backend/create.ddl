create sequence T_QUESTION_SEQ start with 1 increment by 50;
create table T_QUESTION (number integer not null, id bigint not null, answer varchar(255), lesson varchar(255), lesson_type varchar(255), text varchar(255), primary key (id));
INSERT INTO T_QUESTION (id, text, answer, lesson, number, lesson_type) VALUES (1001, 'Translate: rosa', 'rose', '1', 1, 'questionario');
INSERT INTO T_QUESTION (id, text, answer, lesson, number, lesson_type) VALUES (1002, 'Translate: agricola', 'farmer', '1', 2, 'questionario');
INSERT INTO T_QUESTION (id, text, answer, lesson, number, lesson_type) VALUES (1003, 'Translate: puella', 'girl', '2', 3, 'questionario');
INSERT INTO T_QUESTION (id, text, answer, lesson, number, lesson_type) VALUES (1004, 'Translate: nauta', 'sailor', '2', 4, 'questionario');
