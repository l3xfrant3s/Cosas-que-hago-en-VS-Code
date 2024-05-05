/*1*/
drop function if exists ListadoColor;
delimiter $$
create function ListadoColor(colorin varchar(20)) returns varchar(500) deterministic
begin
    declare numerop char(5);
    declare nombrep varchar(20);
    declare importe decimal(8,2);
    declare retorno varchar(500) default concat('Articulos de color <', colorin, '>: ');
    declare fin boolean default false;
    declare productos_de_color cursor for
                    select pnum, pnombre, precio 
                    from producto
                    where color = colorin;
    declare continue handler for not found set fin = true;
    if (colorin not in (select Color from producto)) then
        return concat('No hay ningun producto de color <', colorin, '>');
    else
        open productos_de_color;
        fetch productos_de_color into numerop, nombrep, importe;
        while !fin do
            set retorno = concat(retorno, numerop, '-', nombrep, '-', importe, ' Euros, ');
            fetch productos_de_color into numerop, nombrep, importe;
        end while;
        close productos_de_color;
    end if;
    return retorno;
end$$
delimiter ;

/*2*/
drop function if exists ListadoVendedores;
delimiter $$
create function ListadoVendedores(laciudad varchar(20)) returns varchar(500) deterministic
begin
    declare nombreS varchar(20);
    declare numeroS char(9);
    declare retorno varchar(500) default concat('Ciudad: ', laciudad, '>: Vendedores: ');
    declare fin boolean default false;
    declare vendores_de_ciudad cursor for
                    select snombre, movil 
                    from suministrador
                    where ciudad = laciudad;
    declare continue handler for not found set fin = true;
    if (laciudad not in (select ciudad from suministrador)) then
        return concat('No hay ningun vendedor en <', laciudad, '>');
    else
        open vendores_de_ciudad;
        fetch vendores_de_ciudad into nombreS, numeroS;
        while !fin do
            set retorno = concat(retorno, '<', nombreS, '-', numeroS, '>');
            fetch vendores_de_ciudad into nombreS, numeroS;
        end while;
        close vendores_de_ciudad;
    end if;
    return retorno;
end$$
delimiter ;

/*3*/
drop function if exists CumpleMes;
delimiter $$
create function CumpleMes() returns varchar(500) deterministic
begin
    declare nombreA varchar(50);
    declare diaA varchar(3);
    declare edadA varchar(3);
    declare retorno varchar(500) default concat('Cumples de ', mes(substr(curdate(), 6, 2)), ': ');
    declare fin boolean default false;
    declare cumplen_este_mes cursor for
                    select trim(nombre), right(FechaNac, 2) dia, (year(curdate()) - year(FechaNac)) Edad
                    from alumnos
                    where substr(curdate(), 6, 2) = substr(FechaNac, 6, 2);
    declare continue handler for not found set fin = true;
    if ((select count(FechaNac) from alumnos where substr(curdate(), 6, 2) = substr(FechaNac, 6, 2)) = 0) then
        return concat('Nadie cumple los anios en ', colorin, '>');
    else
        open cumplen_este_mes;
        fetch cumplen_este_mes into nombreA, diaA, edadA;
        while !fin do
            set retorno = concat(retorno, ' <', nombreA, '-Dia:', diaA, '-Anios:', edadA, '>');
            fetch cumplen_este_mes into nombreA, diaA, edadA;
        end while;
        close cumplen_este_mes;
    end if;
    return retorno;
end$$
delimiter ;

/*4*/
drop function if exists ListadoSupervisores;
delimiter $$
create function ListadoSupervisores(nombredepartamento varchar(20)) returns varchar(500) deterministic
begin
    declare numdep int default (select ndep from departamento where nombdep = nombredepartamento);
    declare fin boolean default false;
    declare retorno varchar(600) default "Jefes:";
    declare jefes varchar(200) default "[";
    declare puestos varchar(200) default "] - Puestos:[";
    declare salarios varchar(200) default "] - Salarios:[";
    declare eljefe varchar(20);
    declare elpuesto varchar(20);
    declare elsalario decimal(8,2);
    declare supervisores_del_departamento cursor for
                    select distinct trim(e2.nombre) Jefe, trim(e2.Empleo) Puesto, e2.Salario Salario
                    from empleado e1 join empleado e2 on e1.Supervs = e2.Nemp
                    where e2.ndep = numdep;
    declare continue handler for not found set fin = true;
    if(numdep is null) then
        return concat("El departamento <", nombredepartamento, "> no existe.");
    elseif(numdep not in (select distinct e2.ndep from empleado e1 join empleado e2 on e1.Supervs = e2.Nemp)) then
        return concat("No hay ningun supervisor del departamento <", nombredepartamento, ">.");
    else
        open supervisores_del_departamento;
        fetch supervisores_del_departamento into eljefe, elpuesto, elsalario;
        set jefes = concat(jefes, eljefe);
        set puestos = concat(puestos, elpuesto);
        set salarios = concat(salarios, elsalario);
        fetch supervisores_del_departamento into eljefe, elpuesto, elsalario;
        while !fin do
            set jefes = concat(jefes, ", ", eljefe);
            set puestos = concat(puestos, ", ", elpuesto);
            set salarios = concat(salarios, ", ", elsalario);
            fetch supervisores_del_departamento into eljefe, elpuesto, elsalario;
        end while;
        close supervisores_del_departamento;
        set retorno = concat(retorno, jefes, puestos, salarios, "]");
    end if;
    return retorno;
end$$
delimiter ;

select ListadoSupervisores("Investigacion");