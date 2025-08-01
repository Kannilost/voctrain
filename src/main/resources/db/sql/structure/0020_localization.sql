--liquibase formatted sql

--changeset includeAll:create_table_localization
CREATE TABLE dbo.localization
(
    localization_id       int identity (1,1) PRIMARY KEY,
    level_name            varchar(20)           NOT NULL,
    unit_name             varchar(20)           NOT NULL
);

CREATE UNIQUE NONCLUSTERED INDEX NonClusteredIndex_localization ON localization (level_name,unit_name);

INSERT INTO localization (level_name, unit_name)
VALUES
  ('Level 1', 'Unit 1'), ('Level 1', 'Unit 2'), ('Level 1', 'Unit 3'), ('Level 1', 'Unit 4'), ('Level 1', 'Unit 5'), ('Level 1', 'Unit 6'),
  ('Level 2', 'Unit 1'), ('Level 2', 'Unit 2'), ('Level 2', 'Unit 3'), ('Level 2', 'Unit 4'), ('Level 2', 'Unit 5'), ('Level 2', 'Unit 6'),
  ('Level 3', 'Unit 1'), ('Level 3', 'Unit 2'), ('Level 3', 'Unit 3'), ('Level 3', 'Unit 4'), ('Level 3', 'Unit 5'), ('Level 3', 'Unit 6'),
  ('Level 4', 'Unit 1'), ('Level 4', 'Unit 2'), ('Level 4', 'Unit 3'), ('Level 4', 'Unit 4'), ('Level 4', 'Unit 5'), ('Level 4', 'Unit 6'),
  ('Level 5', 'Unit 1'), ('Level 5', 'Unit 2'), ('Level 5', 'Unit 3'), ('Level 5', 'Unit 4'), ('Level 5', 'Unit 5'), ('Level 5', 'Unit 6'),
  ('Level 6', 'Unit 1'), ('Level 6', 'Unit 2'), ('Level 6', 'Unit 3'), ('Level 6', 'Unit 4'), ('Level 6', 'Unit 5'), ('Level 6', 'Unit 6'),
  ('Level 7', 'Unit 1'), ('Level 7', 'Unit 2'), ('Level 7', 'Unit 3'), ('Level 7', 'Unit 4'), ('Level 7', 'Unit 5'), ('Level 7', 'Unit 6'),
  ('Level 8', 'Unit 1'), ('Level 8', 'Unit 2'), ('Level 8', 'Unit 3'), ('Level 8', 'Unit 4'), ('Level 8', 'Unit 5'), ('Level 8', 'Unit 6'),
  ('Level 9', 'Unit 1'), ('Level 9', 'Unit 2'), ('Level 9', 'Unit 3'), ('Level 9', 'Unit 4'), ('Level 9', 'Unit 5'), ('Level 9', 'Unit 6'),
  ('Level 10', 'Unit 1'), ('Level 10', 'Unit 2'), ('Level 10', 'Unit 3'), ('Level 10', 'Unit 4'), ('Level 10', 'Unit 5'), ('Level 10', 'Unit 6'),
  ('Level 11', 'Unit 1'), ('Level 11', 'Unit 2'), ('Level 11', 'Unit 3'), ('Level 11', 'Unit 4'), ('Level 11', 'Unit 5'), ('Level 11', 'Unit 6'),
  ('Level 12', 'Unit 1'), ('Level 12', 'Unit 2'), ('Level 12', 'Unit 3'), ('Level 12', 'Unit 4'), ('Level 12', 'Unit 5'), ('Level 12', 'Unit 6'),
  ('Level 13', 'Unit 1'), ('Level 13', 'Unit 2'), ('Level 13', 'Unit 3'), ('Level 13', 'Unit 4'), ('Level 13', 'Unit 5'), ('Level 13', 'Unit 6'),
  ('Level 14', 'Unit 1'), ('Level 14', 'Unit 2'), ('Level 14', 'Unit 3'), ('Level 14', 'Unit 4'), ('Level 14', 'Unit 5'), ('Level 14', 'Unit 6'),
  ('Level 15', 'Unit 1'), ('Level 15', 'Unit 2'), ('Level 15', 'Unit 3'), ('Level 15', 'Unit 4'), ('Level 15', 'Unit 5'), ('Level 15', 'Unit 6'),
  ('Level 16', 'Unit 1'), ('Level 16', 'Unit 2'), ('Level 16', 'Unit 3'), ('Level 16', 'Unit 4'), ('Level 16', 'Unit 5'), ('Level 16', 'Unit 6');



