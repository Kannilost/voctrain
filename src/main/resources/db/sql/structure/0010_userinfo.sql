--liquibase formatted sql

--changeset includeAll:create_table_userinfo
CREATE TABLE dbo.userinfo
(
    user_id       int identity (1,1) PRIMARY KEY,
    username      varchar(50)                   NOT NULL,
    password      varchar(50)                   NOT NULL,
    email         varchar(100)                  ,
    signup_date   date CONSTRAINT DF_user_date DEFAULT (getdate()) NOT NULL
);

CREATE UNIQUE NONCLUSTERED INDEX NonClusteredIndex_username ON userinfo (username);

INSERT INTO userinfo (username, password, email)
VALUES
 ('Kanni' , 'Kanni5826', 'Kanni.zhu@hotmail.com'),
 ('Papa' , 'Papa5826', 'Papa.zhu@hotmail.com'),
 ('Mama' , 'Mama5826', 'Mama.liu@hotmail.com');

--changeset includeAll:add_user_testtest
INSERT INTO dbo.userinfo (username, password, email)
VALUES ('TestUser', 'abc123', Null);