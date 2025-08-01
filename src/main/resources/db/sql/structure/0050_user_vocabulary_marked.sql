--liquibase formatted sql

--changeset includeAll:create_table_user_vocabulary_marked
CREATE TABLE dbo.user_vocabulary_marked (
    user_id       INT,
    vocabulary_id INT,
    marked_date   DATE CONSTRAINT DF_marked_day DEFAULT (getdate()) NOT NULL,
    CONSTRAINT PK_user_vocab_marked PRIMARY KEY (user_id, vocabulary_id),
    CONSTRAINT FK_user_there FOREIGN KEY (user_id) REFERENCES userinfo (user_id),
    CONSTRAINT FK_vocabulary_prime FOREIGN KEY (vocabulary_id) REFERENCES vocabulary (vocabulary_id)
);
