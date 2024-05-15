/*1*/
drop procedure if exists ListadoInicial;
delimiter $$
create procedure ListadoInicial(inicial varchar(1))
begin
    if((select count(Snombre) from suministrador where left(trim(Snombre), 1) like concat(inicial, '%')) = 0)  then
        select concat("Error: No existen suministradores con la inicial<", inicial, '>') 'Error 1';
    else
        select Snombre Nombre, Ciudad, Movil,
        year(curdate()) - year(FechaContacto) 'Años último contacto'
        from suministrador
        where left(trim(Snombre), 1) like inicial;
    end if;
end$$
delimiter ;

/*2*/


/*3*/
drop procedure if exists NoVenden;
delimiter $$
create procedure NoVenden()
begin
    select sNombre Nombre, ciudad Ciudad, movil Movil
    from ventas v right join suministrador s on v.snum = s.snum
    where pnum is null;
end$$
delimiter ;

/*4*/
