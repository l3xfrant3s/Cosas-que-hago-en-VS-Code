select Snum, sum(Cantidad) as 'Total ventas'
from ventas
group by Snum
order by sum(Cantidad) asc;

select Snombre, sum(Cantidad) as 'Total ventas'
from ventas as V, suministrador as S
where V.Snum = S.Snum
group by V.Snum;

select sum(Cantidad) as 'Total ventas de París'
from ventas as V, suministrador as S
where V.Snum = S.Snum and Ciudad = 'Paris';

select sum(Cantidad) as 'Total ventas de artículos rojos'
from ventas as V, producto as P
where V.Pnum = P.Pnum and Color = 'Rojo';

/*select Pnum, count(Snum) as 'Número de vendedores'*/
select Pnum as 'Pnum con más de un vendedor'
from ventas
group by Pnum
having count(Snum) > 1;

select Snombre as 'Vendedores de P2'
from ventas as V, suministrador as S
where V.Snum = S.Snum and Pnum = 'P2';

select distinct Snombre as 'Vendedores de artículos rojos'
from ventas as V, suministrador as S, producto as P
where V.Snum = S.Snum and V.Pnum = P.Pnum and Color='Rojo';

select V.Snum, Snombre as 'Suministradores con ventas'
from ventas as V, suministrador as S
where V.Snum = S.Snum
group by V.Snum;

/*select Snombre as 'Suministradores que venden menos que S1'
from ventas as V, suministrador as S
where V.Snum = S.Snum
group by S.Snum
having sum(Cantidad) < (select sum(Cantidad) as 'suma de S1' from ventas where Snum = 'S1');*/

select Snombre
from suministrador
where Situacion < (select Situacion from suministrador where Snum = 'S1');

select distinct Snombre
from ventas as V, suministrador as S
where V.Snum = S.Snum and Ciudad = (select Ciudad from suministrador where Snum = 'S1') and not V.Snum = 'S1';

/*select V.Snum, Snombre
from ventas as V, suministrador as S
where V.Snum = S.Snum
group by S.Snum
having sum(Cantidad) < (select avg(Sumas) from (select sum(cantidad) as 'Sumas' from ventas group by Snum) as S);*/

select Snum, Snombre
from suministrador
where Situacion < (select avg(Situacion) from suministrador);

select max(cantidad), color, V.Pnum
from ventas as V, producto as P
where V.Pnum = P.Pnum and cantidad > 200 and Color in ('Rojo', 'Azul')
group by P.Pnum
having sum(cantidad) >= 350
order by max(cantidad) asc, P.Pnum desc;