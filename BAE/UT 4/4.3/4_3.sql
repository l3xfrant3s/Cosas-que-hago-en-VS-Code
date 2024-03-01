select * from suministrador
where snum not in (select distinct snum from ventas);

select P.Pnum, Pnombre, Color, cantidad
from producto as P, ventas as V
where P.Pnum = V.Pnum and color = 'Rojo';

select sum(cantidad) from ventas
where Pnum in (select Pnum from producto where color = 'Azul');

select count(*) as 'Número de ventas' from ventas
where Snum = (select Snum from suministrador where Snombre = 'Salazar');

select * from producto
where peso > (select max(peso) from producto
			  where Pnombre = 'Tuerca');

select sum(cantidad*10) as 'Importe total (€)'
from ventas
where Pnum in (select Pnum
			   from producto
			   where Pnombre = 'Tuerca');

select max(V.cantidad) as 'Máximo vendidos', min(V.cantidad) as 'Mínimo vendidos'
from ventas as V, producto as P
where V.Pnum = P.Pnum  and P.Pnombre = 'Perno';


select V.Snum, Snombre, S.Ciudad, V.Pnum, Pnombre, cantidad
from suministrador as S, producto as P, ventas as V
where V.Snum = S.Snum and V.Pnum = P.Pnum
order by cantidad desc;

select distinct ciudad
from suministrador;

/*select Pnum
from ventas
where Snum in(select Snum
			  from suministrador
			  where Snombre='Corona');*/

select P.*
from producto as P, suministrador as S, ventas as V
where V.Snum = S.Snum and V.Pnum = P.Pnum and S.Snombre = 'Corona';