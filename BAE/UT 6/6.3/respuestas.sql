/*1*/
drop function if exists dia;
delimiter $$
create function dia(dia_semana int) returns varchar(15) deterministic
begin
    if(dia_semana >= 1 and dia_semana <= 7) then
        case dia_semana
                when 1 then return 'Lunes';
                when 2 then return 'Martes';
                when 3 then return 'Miércoles';
                when 4 then return 'Jueves';
                when 5 then return 'Viernes';
                when 6 then return 'Sabado';
                when 7 then return 'Domingo';
        end case;
    else return 'Día incorrecto';
    end if;
end$$
delimiter ;

drop function if exists mes;
delimiter $$
create function mes(numero_mes int) returns varchar(15) deterministic
begin
    if(numero_mes >= 1 and numero_mes <= 12) then
        case numero_mes
                when 1 then return 'Enero';
                when 2 then return 'Febrero';
                when 3 then return 'Marzo';
                when 4 then return 'Abril';
                when 5 then return 'Mayo';
                when 6 then return 'Junio';
                when 7 then return 'Julio';
                when 8 then return 'Agosto';
                when 9 then return 'Septiembre';
                when 10 then return 'Octubre';
                when 11 then return 'Noviembre';
                when 12 then return 'Diciembre';
        end case;
    else return 'Mes incorrecto';
    end if;
end$$
delimiter ;

drop function if exists Fecha_hora;
delimiter $$
create function Fecha_hora() returns varchar(60) deterministic
begin
    declare numero_dia int default substr(curdate(),9,2);
    declare numero_mes int default substr(curdate(),6,2);
    declare numero_anio int default substr(curdate(),1,4);
    declare nombre_dia varchar(15) default dia(weekday(curdate())+1);
    declare nombre_mes varchar(15) default mes(numero_mes);
    return concat('Hoy es ', nombre_dia, ', ', numero_dia, ' de ',
    nombre_mes, ' de ', numero_anio, ", Hora: ", curtime());
end$$
delimiter ;

/*2*/
drop function if exists Califica;
delimiter $$
create function Califica(nota int) returns varchar(16) deterministic
begin
    if(nota >= 0 and nota <= 10) then
        case
                when nota >= 0 and nota <= 2 then return 'MDEF';
                when nota = 3 or nota = 4 then return 'INS';
                when nota = 5 then return 'SUF';
                when nota = 6 then return 'BIEN';
                when nota = 7 or nota = 8 then return 'NOT';
                when nota = 9 or nota = 10 then return 'SOB';
        end case;
    else return 'Nota incorrecta';
    end if;
end$$
delimiter ;

/*3*/
drop procedure if exists get_boletin2;
delimiter $$
create procedure get_boletin2 (el_dni varchar(12))
begin
    if (el_dni in (select DNI from alumnos)) then
        select concat('Notas de: ', upper(concat(trim(Nombre), ' ', trim(Apellido)))) Boletin
        from alumnos a where a.DNI = el_dni;
        do sleep(2);
        select Siglas, Titulo 'Módulo', Nota, Califica(Nota) 'Calificación'
        from modulos m join notas n on m.CodMod = n.CodMod
        join alumnos a on a.CodAlum = n.CodAlum
        where a.DNI = el_dni;
    else 
        select concat('El alumno con DNI <', el_dni, '> NO EXISTE') Error;
    end if;
end$$
delimiter ;
