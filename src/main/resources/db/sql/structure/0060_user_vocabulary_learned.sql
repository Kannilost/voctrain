--liquibase formatted sql

--changeset includeAll:create_table_user_vocabulary_learned
CREATE TABLE dbo.user_vocabulary_learned (
    user_id       INT,
    vocabulary_id INT,
    learned_date  DATE CONSTRAINT DF_marked_time DEFAULT (getdate()) NOT NULL,
    CONSTRAINT PK_user_vocab_learned PRIMARY KEY (user_id, vocabulary_id),
    CONSTRAINT FK_user_here FOREIGN KEY (user_id) REFERENCES userinfo (user_id),
    CONSTRAINT FK_vocabulary_lime FOREIGN KEY (vocabulary_id) REFERENCES vocabulary (vocabulary_id)
);
