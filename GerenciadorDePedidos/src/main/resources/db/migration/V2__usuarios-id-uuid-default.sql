-- V2: o banco passa a gerar o UUID de usuarios automaticamente.
--
-- Por que nao trocar para BIGINT/LONG?
--   O PostgreSQL 13+ tem gen_random_uuid() nativo, entao gerar UUID no banco e possivel.
--   Trocar o tipo exigiria reescrever PK, FKs e dados existentes sem ganho real.
--
-- Por que CREATE TABLE IF NOT EXISTS?
--   Hoje o schema e criado pelo Hibernate (ddl-auto=update), que roda DEPOIS do Flyway.
--   Em um banco novo, a tabela ainda nao existiria e o ALTER abaixo falharia.
--   Com o IF NOT EXISTS, a migration funciona tanto em banco novo quanto no existente.
--
-- Se o PostgreSQL for < 13, habilite antes: CREATE EXTENSION IF NOT EXISTS pgcrypto;

CREATE TABLE IF NOT EXISTS usuarios (
    id    UUID         NOT NULL DEFAULT gen_random_uuid(),
    login VARCHAR(255),
    senha VARCHAR(255),
    CONSTRAINT usuarios_pkey PRIMARY KEY (id)
);

-- Banco existente: a tabela ja existe sem DEFAULT, entao aplicamos aqui.
ALTER TABLE usuarios
    ALTER COLUMN id SET DEFAULT gen_random_uuid();
