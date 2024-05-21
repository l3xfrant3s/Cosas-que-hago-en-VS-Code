/*1*/
drop procedure if exists VentaSumi;
delimiter $$
create procedure VentaSumi (nombre varchar(20))
begin
    if(nombre not in (select snombre from suministrador)) then
        select concat("El suminstrador <", nombre, "> No existe") "Error 2";
    elseif((select count(v.pnum)
    from ventas v join suministrador s on v.snum = s.snum
    where snombre = nombre) = 0) then
        select concat("El suminstrador <", nombre, "> No ha realizado ninguna venta") "Error 1";
    else
        select v.pnum, p.pnombre, cantidad
        from ventas v join producto p on v.pnum = p.pnum join suministrador s on v.snum = s.snum
        where snombre = nombre;
    end if;
end$$
delimiter ;

/*2*/
drop function if exists ListadoArticulos;
delimiter $$
create function ListadoArticulos (lugar varchar(20)) returns varchar(600) deterministic
begin
    declare fin boolean default false;
    declare retorno varchar(600) default concat("Ciudad:", lugar, ", Articulos: ");
    declare elnombre varchar(20);
    declare elprecio decimal(8,2);
    declare productos_de_ciudad cursor for select pnombre, precio from producto where ciudad = lugar;
    declare continue handler for not found set fin = true;
    if((select count(pnum) from producto where ciudad = lugar) = 0) then
        return concat("No hay ningun producto en <", lugar, ">");
    else
        open productos_de_ciudad;
        fetch productos_de_ciudad into elnombre, elprecio;
        set retorno = concat(retorno, "<", elnombre, " - ", elprecio, " Euros>");
        fetch productos_de_ciudad into elnombre, elprecio;
        while !fin do
            set retorno = concat(retorno, ", <", elnombre, " - ", elprecio, "Euros>");
            fetch productos_de_ciudad into elnombre, elprecio;
        end while;
        close productos_de_ciudad;
    end if;
    return retorno;
end$$
delimiter ;

/*3*/
drop trigger if exists trg_Ins_Ventas;
delimiter $$
create trigger trg_Ins_Ventas
before insert on ventas
for each row
begin
    if(new.Cantidad <= (select Unidades from producto where Pnum = new.Pnum)) then
        update producto set unidades = unidades - new.Cantidad where Pnum = new.Pnum;
    else
        signal sqlstate '45000'
        set message_text = 'Error. Numero de unidades insuficiente.';
    end if;
end$$
delimiter ;

select distinct snum, sum(cantidad) from ventas group by snum;

insert into ventas values ("S5", "P6", 100);
insert into ventas values ("S5", "P6", 1001);

drop trigger if exists trg_Upd_Producto;
delimiter $$
create trigger trg_Upd_Producto
after update on producto
for each row
begin
    if(new.Unidades < 100) then
        insert into productosbajostock values (new.pnum, new.pnombre, new.unidades, curdate());
    end if;
end$$
delimiter ;

