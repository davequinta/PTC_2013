create database EXPO_TECNICA_DEFENSA_FINAL
use EXPO_TECNICA_DEFENSA_FINAL
go

create table tipo_usuario(
id_tipo_usu int identity (1,1)primary key not null,
nombre_tipo_usu varchar(100),
descripcion_tipo_uso varchar(200))

create table usuarios(
codigo_usuario int identity(1,1)primary key not null,
nickname_usuario varchar(50),
contraseña  varbinary(500),
nombre_usuario varchar(100),
id_tipo_usu int,
apellido_usu varchar (100),
foreign key (id_tipo_usu) references tipo_usuario(id_tipo_usu) on delete cascade on update cascade)





select * from usuarios

create table tipo_visitante(
id_tipo_visitante int identity(1,1) primary key not null,
nombre_tipo_vis varchar(100),
detalle_tipo_visitantes varchar(200),
descuento numeric(5,2))


create table tipo_membresia(
id_tipo_membresia int identity(1,1)primary key not null,
nombre_membre varchar (100),
detalle_tipo_membresia varchar(200),
costo_membresia numeric(5,2))

select * from tipo_membresia

create table afiliado(
dui_socio varchar(9) primary key not null,
id_tipo_membresia int,
nombre_socio varchar(100),
apellidos_socio varchar(100),
telefono_socio varchar (9),
email_socio varchar (100),
direccion_socio varchar(100),
profesion_socio varchar(100),
estado_civil varchar(100),
num_membresia int identity (1,1),
fecha_inicio datetime,
fecha_fin datetime,

fecha_ingreso datetime,

foreign key(id_tipo_membresia) references tipo_membresia(id_tipo_membresia)on delete cascade on update cascade)


create table visitantes_particulares(
num_visita int identity(1,1)primary key not null,
monto numeric (5,2),
id_tipo_visitante int,
cantidad decimal(10,2),
ingreso datetime,

foreign key(id_tipo_visitante) references tipo_visitante(id_tipo_visitante) on delete cascade on update cascade)

create table visitantes_miembros(
id_tipo_membresia int,
cantidad_membre decimal (10,2)
foreign key(id_tipo_membresia) references tipo_membresia(id_tipo_membresia) on delete cascade on update cascade)






create table clasificacion_zona(
id_clasi int identity(1,1) primary key not null,
nombre_clasi_zonas varchar(100),
detalle_clasi_zonas varchar(200))

create table tipo_mantenimiento(
id_tipo_mante int identity(1,1) primary key not null,
nombre_mante varchar(100),
detalle_tipo_mante varchar(200))


create table tipo_mes(
id_tipo_mes int identity(1,1) primary key not null,
nombre varchar(100))

create table riego(
num_riego int identity(1,1) primary key not null,
duracion int,
num_zona int,
fecha datetime,
id_tipo_mes int,
foreign key (id_tipo_mes) references tipo_mes(id_tipo_mes)on delete cascade on update cascade
)



create table mantenimiento(
id_mantenimiento int identity(1,1) primary key not null,
Fecha datetime,
id_tipo_mante int,
num_riego int,
foreign key (id_tipo_mante) references tipo_mantenimiento(id_tipo_mante)on delete cascade on update cascade,
foreign key (num_riego) references riego(num_riego)on delete cascade on update cascade)

alter table mantenimiento
add nombre_mante varchar(100)

create table zonas(
Num_zona int identity (1,1) primary key not null, 
nombre_zona varchar (100),
id_clasi int, 
capacidad int,
foreign key (id_clasi) references clasificacion_zona(id_clasi)on delete cascade on update cascade)





create table mante_zonas(
Num_zona int,
id_mantenimiento int,
fecha datetime,
foreign key (id_mantenimiento) references mantenimiento(id_mantenimiento)on delete cascade on update cascade,
foreign key (Num_zona) references zonas(Num_zona)on delete cascade on update cascade)

create table cargo_empleado(
id_cargo  int identity (1,1) primary key not null, 
Nombre_cargo varchar(50),
Detalle_cargo varchar(300))

alter table cargo_empleado
add salario decimal(10,2);

create table Empleados(
DUI_empleado varchar(9) primary key not null,
id_cargo int,
nombres_empleado varchar(100),
apellidos_empleado varchar(100),
Telefono varchar(9),
fecha_ingreso datetime,
estado_civil varchar(30) not null check(estado_civil in ('soltero', 'casado', 'viudo', 'acompañado')),
foreign key (id_cargo) references cargo_empleado(id_cargo)on delete cascade on update cascade)



select * from Empleados

alter table Empleados
add email varchar(100);



create table genero_plantas(
id_genero   int identity (1,1) primary key not null, 
Nombre_genero varchar(50),
Detalle_genero varchar(100))



select * from zona_empleados
select * from genero_plantas

create table tipo_plantas(
id_tipo  int identity (1,1) primary key not null, 
Nombre_tipo varchar(50),
 Detalle_tipo varchar(100))

create table uso_plantas(
id_uso  int identity (1,1) primary key not null, 
Nombre_uso varchar(50),
Detalle_uso varchar(100))

create table clase_plantas(
id_clase  int identity (1,1) primary key not null, 
Nombre_clase varchar(50),
Detalle_clase varchar(100))

create table region_plantas(
id_region  int identity (1,1) primary key not null, 
Nombre_region varchar(50),
Detalle_region varchar(100))

create table especie_plantas(
id_especie  int identity (1,1) primary key not null, 
Nombre_especie varchar(50),
Detalle_especie varchar(100))

create table familia_plantas(
id_familia  int identity (1,1) primary key not null, 
Nombre_familia varchar(50),
Detalle_familia varchar(100))

create table plantas(
correlativo_plantas  int identity (1,1) primary key not null, 
nombre_planta varchar (100),
id_genero int, 
id_tipo int, 
id_uso int,
id_clase int,
id_region int,
id_especie int, 
id_familia int,
cantidad int,

fecha_ingreso datetime,
foreign key (id_genero) references genero_plantas(id_genero)on delete cascade on update cascade,
foreign key (id_tipo) references tipo_plantas(id_tipo)on delete cascade on update cascade,
foreign key (id_uso) references uso_plantas(id_uso)on delete cascade on update cascade,
foreign key (id_clase) references clase_plantas(id_clase)on delete cascade on update cascade,
foreign key (id_region) references region_plantas(id_region)on delete cascade on update cascade,
foreign key (id_especie) references especie_plantas(id_especie)on delete cascade on update cascade,
foreign key (id_familia) references familia_plantas(id_familia)on delete cascade on update cascade,
)

create table zona_empleados(
DUI_empleado varchar(9),
Num_zona int,
fecha datetime,
foreign key (DUI_empleado) references Empleados(DUI_empleado)on delete cascade on update cascade,
foreign key (Num_zona) references zonas(Num_zona)on delete cascade on update cascade)


alter table zona_empleados
add horario varchar(10)

alter table zona_empleados
add horario_hasta varchar(10)

select * from zona_empleados
select cantidad from plantas


Select * from mante_zonas_emple


create table mante_emple(
DUI_empleado varchar(9),
id_mantenimiento int,
fecha datetime,
foreign key (DUI_empleado) references Empleados(DUI_empleado)on delete cascade on update cascade,
foreign key (id_mantenimiento) references mantenimiento(id_mantenimiento)on delete cascade on update cascade)


create table mante_zonas_emple(
DUI_empleado varchar(9),
id_mantenimiento int,
Num_zona int,
horario varchar(10),

foreign key (DUI_empleado) references Empleados(DUI_empleado)on delete cascade on update cascade,
foreign key (id_mantenimiento) references mantenimiento(id_mantenimiento)on delete cascade on update cascade,
foreign key (Num_zona) references zonas(Num_zona)on delete cascade on update cascade)


alter table mante_zonas_emple
add horario_hasta varchar(10)


select * from mante_zonas_emple




create table zona_plantas(
correlativo_plantas int,
Num_zona int,
fecha datetime,
foreign key (correlativo_plantas) references plantas(correlativo_plantas)on delete cascade on update cascade,
foreign key (Num_zona) references zonas(Num_zona)on delete cascade on update cascade)

create table tipo_producto(
id_tipo_producto int identity(1,1) primary key not null,
nombre_tipo varchar(100),
detalle_tipo_producto varchar(200))



create table productos(
codigo_producto varchar(100) primary key not null,
precio_producto numeric(5,2),
nombre_producto varchar(100),
detalle_producto varchar(200),
existencia_producto int,
id_tipo_producto int,

fecha datetime,
foreign key (id_tipo_producto) references tipo_producto(id_tipo_producto)on delete cascade on update cascade)


create table factura(
id_factura int identity (1,1) primary key not null,
fecha_facturacion datetime  not null,
total int not null,
--foreign key
DUI_empleado varchar(9) not null,
foreign key(DUI_empleado) references Empleados(DUI_empleado)on delete cascade on update cascade,
)



create table detalle_factura(
correlativo int identity(1,1) primary key not null,
cantidad int not null,
--foreig key
codigo_producto varchar(100) not null,
id_factura int not null,
precio_producto numeric (5,2) not null,
foreign key (codigo_producto) references productos(codigo_producto)on delete cascade on update cascade,
foreign key (id_factura) references factura(id_factura)on delete cascade on update cascade)
--end foreign key


select * from zonas



--Funcion de encriptación
go
create function FU_ENCRIPTA
(
	@clave varchar(50)
)
RETURNS VarBinary(500)
AS
BEGIN

    DECLARE @contraseña AS VarBinary(500) 
    SET @contraseña = ENCRYPTBYPASSPHRASE('clave',@clave)
    --encripta la llave para cifrar el campo.       
    RETURN @contraseña
END

insert into usuarios values('Batman', dbo.FU_ENCRIPTA(1234), 'David',1, 'Quintanilla')

select * from usuarios


--Funcion de desencriptación


create function FU_DESENCRIPTA
(
    @clave VARBINARY(500)
)
RETURNS VARCHAR(50)
AS
BEGIN
    DECLARE @contraseña AS VARCHAR(50)    
    SET @contraseña = DECRYPTBYPASSPHRASE('clave',@clave)    
    RETURN @contraseña
END



--TRIGGERS :$

create trigger ELIMINAR_admin
 on usuarios
 for delete 
 as
 delete from usuarios where id_tipo_usu = 1
 begin
  raiserror('No está permitidio borrar o actualizar', 16, 1) ;
  rollback transaction 
end 

delete from usuarios where id_tipo_usu = 1;


--Trigger que resta :$
create trigger actualizar_inventario
on productos for insert
as
begin
declare @valor char(4)
declare @numero numeric(2)
declare @registros int
set @registros = (select count(*) from productos);
set @valor=(select from where);
if (@valor= ' ')
raiserror ('no se encontró datos', 10,1)
else
begin
set @numero=(select vacantes from curso where codigo=@valor);
set @numero1=(select matriculados from curso where codigo=@valor);
update curso set vacantes @numero-1, matriculados=@numero1+1
where codigo=@valor;
raiserror('datos modificados',10,1);
end
end -- HACE LAS ALITAS Y MODIFICA LO ANTERIOR,..










go
select codigo_usuario, nickname_usuario, dbo.FU_DESENCRIPTA(contraseña) as contraseña ,nombre_usuario, id_tipo_usu, apellido_usu from usuarios









 
select nombre_tipo_vis, num_visitante from tipo_visitante t, visitantes v where (t.id_tipo_visitante = v.id_tipo_visitante)


 select nombres_empleado, nombre_zona from zonas z, zona_empleados j ,Empleados e where (e.DUI_empleado = z.Num_zona) AND (ze.DUI_empleado = ze.Num_zona)
SELECT * FROM productos

SELECT * FROM usuarios

SELECT * FROM zonas

SELECT * FROM Empleados


SELECT * FROM zona_empleados

SELECT * FROM clasificacion_zona


SELECT * FROM cargo_empleado

select * from tipo_plantas

select * from especie_plantas

select * from clasificacion_zona

select * from region_plantas

SELECT * FROM afiliado


SELECT codigo_usuario, nickname_usuario, nombre_tipo_usu, nombre_usuario, apellido_usu, contraseña FROM usuarios u , tipo_usuario t WHERE (u.id_tipo_usu = t.id_tipo_usu)

SELECT correlativo_plantas, nombre_planta, nombre_genero, nombre_tipo, nombre_uso, nombre_clase, nombre_region, nombre_especie, nombre_familia, stock FROM plantas p, genero_plantas g, tipo_plantas t, uso_plantas u, clase_plantas c, region_plantas r, especie_plantas e, familia_plantas f WHERE (p.id_genero = g.id_genero) AND (p.id_tipo = t.id_tipo)  AND (p.id_uso = u.id_uso) AND (p.id_clase = c.id_clase) AND (p.id_region = r.id_region) AND (p.id_especie = e.id_especie)  AND (p.id_familia = f.id_familia)



--Reporte de zona_plantas
SELECT        dbo.plantas.nombre_planta, dbo.zonas.nombre_zona
FROM            dbo.plantas INNER JOIN
                         dbo.zona_plantas ON dbo.plantas.correlativo_plantas = dbo.zona_plantas.correlativo_plantas INNER JOIN
                         dbo.zonas ON dbo.zona_plantas.Num_zona = dbo.zonas.Num_zona



select * from zona_empleados

-- Zona empleados
SELECT        dbo.Empleados.nombres_empleado, dbo.zonas.nombre_zona
FROM            dbo.Empleados INNER JOIN
                         dbo.zona_empleados ON dbo.Empleados.DUI_empleado = dbo.zona_empleados.DUI_empleado INNER JOIN
                         dbo.zonas ON dbo.zona_empleados.Num_zona = dbo.zonas.Num_zona


