create sequence T_QUESTION_SEQ start with 1 increment by 50;
create table T_QUESTION (id bigint not null, answer varchar(255), text varchar(255), primary key (id));
INSERT INTO T_QUESTION (id, text, answer) VALUES (1001, 'Translate: rosa', 'rose');
INSERT INTO T_QUESTION (id, text, answer) VALUES (1002, 'Translate: agricola', 'farmer');
INSERT INTO T_QUESTION (id, text, answer) VALUES (1003, 'Translate: puella', 'girl');
INSERT INTO T_QUESTION (id, text, answer) VALUES (1004, 'Translate: nauta', 'sailor');
