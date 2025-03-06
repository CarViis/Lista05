drop database if exists lista05;
create database lista05;

use lista05;

create table paciente (
    id int primary key not null auto_increment,
    nome varchar(150) not null,
    cpf char(14) unique not null,
    doenca varchar(50) not null,
    index(nome)
);

create table medico (
    id int primary key not null auto_increment,
    nome varchar(150) not null,
    matricula int unique not null,
    especialidade varchar(50) not null,
    salario decimal(6,2) not null,
    index(nome)
);


create table consulta (
    id_paciente int not null,
    id_medico int not null,
    horario datetime not null,
    valor decimal(5,2) not null,
    primary key(id_paciente, id_medico, horario),
    foreign key(id_paciente) references paciente(id) on update cascade on delete restrict,
    foreign key(id_medico) references medico(id) on update cascade on delete restrict,
    unique index(id_paciente, horario),
    unique index(id_medico, horario)
);
