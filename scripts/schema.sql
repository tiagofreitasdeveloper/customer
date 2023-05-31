CREATE TABLE endereco
(
    endereco_id bigint NOT NULL AUTO_INCREMENT,
    cep varchar (255),
    rua varchar(255),
    numero varchar(255),
    bairro varchar(255),
    complemento varchar(255),
    cidade varchar(255),
    estado varchar(255),
    CONSTRAINT endereco_pk PRIMARY KEY (endereco_id)
);

CREATE TABLE contato
(
    contato_id bigint NOT NULL AUTO_INCREMENT,
    telefone varchar(255),
    CONSTRAINT contato_pk PRIMARY KEY (contato_id)
);

CREATE TABLE cliente
(
    cliente_id bigint NOT NULL AUTO_INCREMENT,
    nome varchar(255),
    cpf varchar (11),
    data_nascimento date,
    endereco_id bigint,
    contato_id bigint,
    CONSTRAINT cliente_pk PRIMARY KEY (cliente_id),
    UNIQUE (cpf)
);

alter table cliente add  foreign key(endereco_id) references endereco(endereco_id);
alter table cliente add  foreign key(contato_id) references contato(contato_id);
