/*
	CREATE DATABASE pronostico_CA
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Spanish_Ecuador.1252'
    LC_CTYPE = 'Spanish_Ecuador.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;
*/

drop table if exists pronosticos;
drop table if exists usuarios;
drop table if exists partidos;
drop table if exists equipos;

create table equipos(
	equ_codigo  int not null,
	equ_iso varchar(3) not null,
	equ_nombre varchar(50) not null,
	constraint equipos_pk primary key (equ_codigo)
);

insert into equipos (equ_codigo, equ_iso, equ_nombre) values (004, 'ARG', 'Argentina');
insert into equipos (equ_codigo, equ_iso, equ_nombre) values (068, 'BOL', 'Bolivia');
insert into equipos (equ_codigo, equ_iso, equ_nombre) values (076, 'BRA', 'Brasil');
insert into equipos (equ_codigo, equ_iso, equ_nombre) values (124, 'CAN', 'Canadá');
insert into equipos (equ_codigo, equ_iso, equ_nombre) values (152, 'CHL', 'Chile');
insert into equipos (equ_codigo, equ_iso, equ_nombre) values (170, 'COL', 'Colombia');
insert into equipos (equ_codigo, equ_iso, equ_nombre) values (188, 'CRI', 'Costa Rica');
insert into equipos (equ_codigo, equ_iso, equ_nombre) values (218, 'ECU', 'Ecuador');
insert into equipos (equ_codigo, equ_iso, equ_nombre) values (840, 'USA', 'Estados Unidos');
insert into equipos (equ_codigo, equ_iso, equ_nombre) values (388, 'JAM', 'Jamaica');
insert into equipos (equ_codigo, equ_iso, equ_nombre) values (484, 'MEX', 'México');
insert into equipos (equ_codigo, equ_iso, equ_nombre) values (591, 'PAN', 'Panamá');
insert into equipos (equ_codigo, equ_iso, equ_nombre) values (600, 'PRY', 'Paraguay');
insert into equipos (equ_codigo, equ_iso, equ_nombre) values (604, 'PER', 'Perú');
insert into equipos (equ_codigo, equ_iso, equ_nombre) values (858, 'URY', 'Uruguay');
insert into equipos (equ_codigo, equ_iso, equ_nombre) values (862, 'VEN', 'Venezuela');

create table partidos(
	par_codigo serial not null,
	equ_codigo1 int not null,
	equ_codigo2 int not null,
	par_fecha date not null,
	par_hora time not null,
	constraint partidos_pk primary key (par_codigo),
	constraint equ_codigo1_fk foreign key (equ_codigo1) references equipos(equ_codigo),
	constraint equ_codigo2_fk foreign key (equ_codigo2) references equipos(equ_codigo)
);

insert into partidos (equ_codigo1, equ_codigo2, par_fecha, par_hora) values (004, 124, '20/6/2024', '18:00');
insert into partidos (equ_codigo1, equ_codigo2, par_fecha, par_hora) values (604, 152, '21/6/2024', '18:00');
insert into partidos (equ_codigo1, equ_codigo2, par_fecha, par_hora) values (218, 862, '22/6/2024', '18:00');
insert into partidos (equ_codigo1, equ_codigo2, par_fecha, par_hora) values (484, 388, '22/6/2024', '18:00');
insert into partidos (equ_codigo1, equ_codigo2, par_fecha, par_hora) values (840, 068, '23/6/2024', '18:00');
insert into partidos (equ_codigo1, equ_codigo2, par_fecha, par_hora) values (858, 591, '23/6/2024', '18:00');
insert into partidos (equ_codigo1, equ_codigo2, par_fecha, par_hora) values (170, 600, '24/6/2024', '18:00');
insert into partidos (equ_codigo1, equ_codigo2, par_fecha, par_hora) values (076, 188, '24/6/2024', '18:00');
insert into partidos (equ_codigo1, equ_codigo2, par_fecha, par_hora) values (604, 124, '25/6/2024', '18:00');
insert into partidos (equ_codigo1, equ_codigo2, par_fecha, par_hora) values (152, 004, '25/6/2024', '18:00');

create table usuarios(
	usu_cedula varchar(10) not null,
	usu_nombres varchar(50) not null,
	usu_apellidos varchar(50) not null,
	constraint usuarios_pk primary key (usu_cedula)
);

insert into usuarios (usu_cedula, usu_nombres, usu_apellidos) values ('0923138747', 'Adrian', 'Bacilio');
insert into usuarios (usu_cedula, usu_nombres, usu_apellidos) values ('0923135534', 'Victor', 'Tomala');
insert into usuarios (usu_cedula, usu_nombres, usu_apellidos) values ('0923112323', 'Darling', 'Cruz');

create table pronosticos(
	pro_codigo serial not null,
	usu_cedula varchar(10) not null,
	par_codigo int not null,
	pro_marcador1 int not null,
	pro_marcador2 int not null,
	constraint pronosticos_pk primary key (pro_codigo),
	constraint usu_cedula_fk foreign key (usu_cedula) references usuarios(usu_cedula),
	constraint pro_codigo_fk foreign key (par_codigo) references partidos(par_codigo)
);

insert into pronosticos (usu_cedula, par_codigo, pro_marcador1, pro_marcador2) values 
('0923138747', 3, 2, 0),
('0923138747', 1, 1, 0),
('0923138747', 2, 0, 0),
('0923135534', 3, 2, 0),
('0923135534', 1, 3, 0),
('0923135534', 2, 0, 0),
('0923112323', 3, 1, 1),
('0923112323', 1, 2, 0),
('0923112323', 2, 1, 0);

select * from equipos;
select * from partidos;
select * from usuarios;
select * from pronosticos;

select par.par_codigo, par.equ_codigo1, equ1.equ_iso as equ_iso1, equ1.equ_nombre as equ_nombre1, par.equ_codigo2, equ2.equ_iso as equ_iso2, equ2.equ_nombre as equ_nombre2, par.par_fecha, par.par_hora 
from partidos par
inner join equipos equ1 on par.equ_codigo1 = equ1.equ_codigo
inner join equipos equ2 on par.equ_codigo2 = equ2.equ_codigo
where par.par_fecha = '22/06/2024';

select pro.pro_codigo, usu.usu_cedula, usu.usu_nombres, usu.usu_apellidos, par.par_codigo, par.equ_codigo1, equ1.equ_iso as equ_iso1, equ1.equ_nombre as equ_nombre1, pro.pro_marcador1, par.equ_codigo2, equ2.equ_iso as equ_iso2, equ2.equ_nombre as equ_nombre2, pro.pro_marcador2, par.par_fecha, par.par_hora
from pronosticos pro
inner join usuarios usu on usu.usu_cedula = pro.usu_cedula
inner join partidos par on par.par_codigo = pro.par_codigo
inner join equipos equ1 on equ1.equ_codigo = par.equ_codigo1
inner join equipos equ2 on equ2.equ_codigo = par.equ_codigo2
where pro.usu_cedula = '0923138747' order by pro.pro_codigo asc;

select pro.pro_codigo, usu.usu_cedula, usu.usu_nombres, usu.usu_apellidos, par.par_codigo, par.equ_codigo1, equ1.equ_iso as equ_iso1, equ1.equ_nombre as equ_nombre1, pro.pro_marcador1, par.equ_codigo2, equ2.equ_iso as equ_iso2, equ2.equ_nombre as equ_nombre2, pro.pro_marcador2, par.par_fecha, par.par_hora
from pronosticos pro
inner join usuarios usu on usu.usu_cedula = pro.usu_cedula
inner join partidos par on par.par_codigo = pro.par_codigo
inner join equipos equ1 on equ1.equ_codigo = par.equ_codigo1
inner join equipos equ2 on equ2.equ_codigo = par.equ_codigo2
where pro.par_codigo = 3 order by pro.pro_codigo asc;