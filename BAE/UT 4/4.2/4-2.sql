select *
from suministrador
where Ciudad = 'Paris';

select *
from producto
where (Color = 'Azul' or Peso > 15) and Ciudad = 'Londres';

select (Pnum)
from producto
where Color = 'Rojo';

select distinct Ciudad
from suministrador;

select Snombre, char_length(Snombre)
from suministrador
order by char_length(Snombre) desc;

select Snombre, reverse(Snombre) as SnombreAlReves
from suministrador;

select Snombre
from suministrador
where substr(Snombre, -1, 1) = 'a';

select Pnombre
from producto
where substr(Pnombre, 2, 1) = 'e';

select current_user, getdate();

select count(*) as "Nº de ventas de Salazar", max(Cantidad) as "Venta máxima", avg(Cantidad) as Media, sum(Cantidad) as Total
from ventas
where Snum = 'S1';