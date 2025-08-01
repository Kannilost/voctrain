--liquibase formatted sql

--changeset includeAll:create_table_user_vocabulary_answers
CREATE TABLE dbo.create_table_user_vocabulary_answers
(
    answer_id           int identity (1,1)  PRIMARY KEY,
    user_id             int                 NOT NULL,
    vocabulary_id       int                 NOT NULL,
    is_correct          int                       ,
    attempts            int                    ,
    CONSTRAINT FK_vocabulary_number FOREIGN KEY (vocabulary_id)   REFERENCES vocabulary (vocabulary_id),
    CONSTRAINT FK_user_where FOREIGN KEY (user_id)   REFERENCES userinfo (user_id),
    answer_date   date CONSTRAINT DF_answer_day DEFAULT (getdate()) NOT NULL
);
