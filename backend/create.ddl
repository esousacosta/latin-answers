create sequence T_QUESTION_SEQ start with 1 increment by 50;
create table T_QUESTION (id bigint not null, answer varchar(255), lesson varchar(255), text varchar(255), primary key (id));
INSERT INTO T_QUESTION (id, text, answer, lesson) VALUES (1001, 'Translate: rosa', 'rose', '1');
INSERT INTO T_QUESTION (id, text, answer, lesson) VALUES (1002, 'Translate: agricola', 'farmer', '1');
INSERT INTO T_QUESTION (id, text, answer, lesson) VALUES (1003, 'Translate: puella', 'girl', '2');
INSERT INTO T_QUESTION (id, text, answer, lesson) VALUES (1004, 'Translate: nauta', 'sailor', '2');
