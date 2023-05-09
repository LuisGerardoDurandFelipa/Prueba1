CREATE DATABASE proyecto1;
USE proyecto1;

CREATE TABLE datosUsuario(
idUsuario int primary key,
codigo varchar(100),
nombre varchar(100),
apellido varchar(100),
documento varchar (50),
fecha_nacimiento date, 
idDireccion int,
rol int,
foreign key(rol) references rolUsuario(idRol)
);


INSERT INTO datosUsuario (idUsuario , codigo, nombre , apellido,documento,fecha_nacimiento,idDireccion,rol) VALUES 
(1,'A0001','Luis Gerardo','Durand Felipa','70312569','1995-09-27',1,2),
(2,'A0002','Renzo Mario','Durand Felipa','70398521','1989-09-27',1,1);

CREATE TABLE rolUsuario(
idRol int primary key ,
codigoRol varchar(100),
descripcionRol varchar(100)
);

INSERT INTO rolUsuario (idRol , codigoRol, descripcionRol ) VALUES 
(1,'R0001','Administrador'),
(2,'R0002','Empleado');

select * from datosUsuario where documento = '70312568';
select * from datosUsuario as a inner join rolUsuario as c on a.rol = c.idRol where documento = '70312569';

SELECT * FROM proyecto1.datosusuario;