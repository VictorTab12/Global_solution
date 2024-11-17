/* --Inova-X membros--
RM550790 - Lucas dos Santos Lopes(2TDSPJ), RM550718 – Murilo Machado(2TDSPJ), RM 97900 – Victor Taborda(2TDSPJ)
RM 551823 - Gustavo Marques Catelan(2TDSPJ),RM97901 - Gabriel Bacelar Valetim*/
DROP TABLE alerta_otimizacao CASCADE CONSTRAINTS;
DROP TABLE dispositivo CASCADE CONSTRAINTS;
DROP TABLE endereco CASCADE CONSTRAINTS;
DROP TABLE incetivo_pontuacao CASCADE CONSTRAINTS;
DROP TABLE leitura_energia CASCADE CONSTRAINTS;
DROP TABLE obter CASCADE CONSTRAINTS;
DROP TABLE telefone CASCADE CONSTRAINTS;
DROP TABLE usuario CASCADE CONSTRAINTS;
 
create table leitura_energia(idleit number(10) constraint leit_id_pk primary key
                                               constraint leit_id_nn not null,
                            dataleitura date,
                            consumo varchar2(40),
                            producaoenergia varchar2(40)
);
 
create table incetivo_pontuacao (
    idpont           NUMBER(10) NOT NULL,
    pontosadquiridos number(4),
    metaalcancada    number(4),
    datapontuacao    DATE
);
ALTER TABLE incetivo_pontuacao ADD CONSTRAINT incetivo_pontuacao_pk PRIMARY KEY ( idpont );
 
 
create table usuario(idusua number(10) constraint usua_id_pk primary key
                                       constraint usua_id_nn not null,
                     nomeUsua varchar2(50),
                     emailUsua varchar2(70),
                     senhaUsua varchar2(50),
                     incetivo_pontuacao_idpont NUMBER(10) NOT NULL
);
CREATE UNIQUE INDEX usuario__idx ON
    usuario (
        incetivo_pontuacao_idpont
    ASC );
 
create table dispositivo (iddisp number(10) constraint disp_id_pk primary key
                                            constraint disp_id_nn not null,
                         tipodispositivo varchar2(50),
                         nomedispositivo varchar2(50),
                         statusdispositivo varchar2(50),
                         usuario_idusua    NUMBER(10) NOT NULL
);
 
create table endereco (
    idende         NUMBER(10) NOT NULL,
    logradouro     VARCHAR2(200),
    cep            VARCHAR2(10),
    numero         VARCHAR2(5),
    complemento    VARCHAR2(50),
    bairro         VARCHAR2(50),
    cidade         VARCHAR2(50),
    estado         VARCHAR2(50),
    usuario_idusua NUMBER(10) NOT NULL
);
 
ALTER TABLE endereco ADD CONSTRAINT endereco_pk PRIMARY KEY ( idende );
 
create table obter (
    dispositivo_iddisp     NUMBER(10) NOT NULL,
    leitura_energia_idleit NUMBER(10) NOT NULL
);
 
ALTER TABLE obter ADD CONSTRAINT obter_pk PRIMARY KEY ( dispositivo_iddisp,
                                                        leitura_energia_idleit );
 
create table telefone(idtelef number(10) constraint telef_id_pk primary key
                                         constraint telef_id_nn not null,
                      codigopais varchar2(3),
                      ddd varchar2(3),
                      numerotelefone number(9),
                      usuario_idusua NUMBER(10) NOT NULL
);
 
 
create table alerta_otimizacao (
    idaler           NUMBER(10) NOT NULL,
    tipoalerta       VARCHAR2(100),
    dataalerta       DATE,
    descricao        VARCHAR2(200),
    telefone_idtelef NUMBER(10) NOT NULL
);
 
ALTER TABLE alerta_otimizacao ADD CONSTRAINT alerta_otimizacao_pk PRIMARY KEY ( idaler );
 
 
/*ALTER TABLES DAS CHAVES ESTRANGEIRAS ABAIXO*/
ALTER TABLE alerta_otimizacao
    ADD CONSTRAINT alerta_otimizacao_telefone_fk FOREIGN KEY ( telefone_idtelef )
        REFERENCES telefone ( idtelef );
 
ALTER TABLE dispositivo
    ADD CONSTRAINT dispositivo_usuario_fk FOREIGN KEY ( usuario_idusua )
        REFERENCES usuario ( idusua );
 
ALTER TABLE endereco
    ADD CONSTRAINT endereco_usuario_fk FOREIGN KEY ( usuario_idusua )
        REFERENCES usuario ( idusua );
 
ALTER TABLE obter
    ADD CONSTRAINT obter_dispositivo_fk FOREIGN KEY ( dispositivo_iddisp )
        REFERENCES dispositivo ( iddisp );
 
ALTER TABLE obter
    ADD CONSTRAINT obter_leitura_energia_fk FOREIGN KEY ( leitura_energia_idleit )
        REFERENCES leitura_energia ( idleit );
 
ALTER TABLE telefone
    ADD CONSTRAINT telefone_usuario_fk FOREIGN KEY ( usuario_idusua )
        REFERENCES usuario ( idusua );
 
ALTER TABLE usuario
    ADD CONSTRAINT usuario_incetivo_pontuacao_fk FOREIGN KEY ( incetivo_pontuacao_idpont )
        REFERENCES incetivo_pontuacao ( idpont );
