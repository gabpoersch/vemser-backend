CREATE USER HOMEWORK1 IDENTIFIED BY oracle;
GRANT CONNECT TO HOMEWORK1;
GRANT CONNECT, RESOURCE, DBA TO HOMEWORK1;
GRANT CREATE SESSION TO HOMEWORK1;
GRANT DBA TO HOMEWORK1;
GRANT CREATE VIEW, CREATE PROCEDURE, CREATE SEQUENCE to HOMEWORK1;
GRANT UNLIMITED TABLESPACE TO HOMEWORK1;
GRANT CREATE MATERIALIZED VIEW TO HOMEWORK1;
GRANT CREATE TABLE TO HOMEWORK1;
GRANT GLOBAL QUERY REWRITE TO HOMEWORK1;
GRANT SELECT ANY TABLE TO HOMEWORK1;

CREATE TABLE HOMEWORK1.ESTUDANTE (
    id NUMBER NOT NULL, 
    nome VARCHAR2(200) NOT NULL,
    data_nascimento DATE NOT NULL,
    num_matricula NUMBER(10) UNIQUE NOT NULL,
    ativo CHAR, -- ('S' = ATIVO, 'N' = INATIVO)
    PRIMARY KEY(id)
);

CREATE SEQUENCE HOMEWORK1.seq_estudante
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;

DROP TABLE HOMEWORK1.ESTUDANTE ;


SELECT * FROM HOMEWORK1.ESTUDANTE ;

INSERT INTO 
HOMEWORK1.ESTUDANTE (id, nome, data_nascimento, num_matricula, ativo)
VALUES
(seq_estudante.nextval, 'Luiz', TO_DATE('01-01-1991', 'dd-mm-yyyy'), 0000000001, 'S');
INSERT INTO 
HOMEWORK1.ESTUDANTE (id, nome, data_nascimento, num_matricula, ativo)
VALUES
(seq_estudante.nextval, 'Guilherme', TO_DATE('02-02-1992', 'dd-mm-yyyy'), 0000000002, 'N');
INSERT INTO 
HOMEWORK1.ESTUDANTE (id, nome, data_nascimento, num_matricula, ativo)
VALUES
(seq_estudante.nextval, 'Tábata', TO_DATE('03-03-1993', 'dd-mm-yyyy'), 0000000003, 'N');
INSERT INTO 
HOMEWORK1.ESTUDANTE (id, nome, data_nascimento, num_matricula, ativo)
VALUES
(seq_estudante.nextval, 'Michele', TO_DATE('04-04-1994', 'dd-mm-yyyy'), 0000000004, 'S');
INSERT INTO 
HOMEWORK1.ESTUDANTE (id, nome, data_nascimento, num_matricula, ativo)
VALUES
(seq_estudante.nextval, 'Joana', TO_DATE('05-05-1995', 'dd-mm-yyyy'), 0000000005, 'N');
INSERT INTO 
HOMEWORK1.ESTUDANTE (id, nome, data_nascimento, num_matricula, ativo)
VALUES
(seq_estudante.nextval, 'Romeu', TO_DATE('06-06-1996', 'dd-mm-yyyy'), 0000000006, 'S');
INSERT INTO 
HOMEWORK1.ESTUDANTE (id, nome, data_nascimento, num_matricula, ativo)
VALUES
(seq_estudante.nextval, 'Marina', TO_DATE('07-07-1997', 'dd-mm-yyyy'), 0000000007, 'S');
INSERT INTO 
HOMEWORK1.ESTUDANTE (id, nome, data_nascimento, num_matricula, ativo)
VALUES
(seq_estudante.nextval, 'Mirna', TO_DATE('08-08-1998', 'dd-mm-yyyy'), 0000000008, 'N');
INSERT INTO 
HOMEWORK1.ESTUDANTE (id, nome, data_nascimento, num_matricula, ativo)
VALUES
(seq_estudante.nextval, 'Jeferson', TO_DATE('09-09-1999', 'dd-mm-yyyy'), 0000000009, 'N');
INSERT INTO 
HOMEWORK1.ESTUDANTE (id, nome, data_nascimento, num_matricula, ativo)
VALUES
(seq_estudante.nextval, 'Gabriel', TO_DATE('23-09-1996', 'dd-mm-yyyy'), 0000000010, 'S');

