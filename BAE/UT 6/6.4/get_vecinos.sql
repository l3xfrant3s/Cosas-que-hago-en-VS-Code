drop function if exists get_vecinos;
delimiter $$
create function get_vecinos(elmunicipio varchar(50)) returns varchar(500) deterministic
begin
    declare suNombre varchar(50);
    declare suMovil varchar(20);
    declare fin boolean default false;
    declare retorno varchar(500) default concat("Vecinos de <", elmunicipio, ">: ");
    declare vecinos_del_municipio cursor for
                    select trim(Nombre), if(Telefono is null, "Sin movil", Telefono) elTelefono
                    from alumnos
                    where Municipio = elmunicipio;
    declare continue handler for not found set fin = true;
    if((select count(DNI) from alumnos where Municipio = elmunicipio) = 0) then
        return concat("Nadie vive en el municipio <", elmunicipio,">");
    else
        open vecinos_del_municipio;
        fetch vecinos_del_municipio into suNombre, suMovil;
        set retorno = concat(retorno, suNombre, ":", suMovil);
        fetch vecinos_del_municipio into suNombre, suMovil;
        while !fin do
            set retorno = concat(retorno, " - ", suNombre, ":", suMovil);
            fetch vecinos_del_municipio into suNombre, suMovil;
        end while;
        close vecinos_del_municipio;
    end if;
    return retorno;
end$$
delimiter ;