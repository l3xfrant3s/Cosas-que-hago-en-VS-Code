insert into ventas values ('S5', 'P3', 100);

/*1*/
select snombre as Nombre, substring(snombre, 1, 1) as 'Inicial del nombre'
from suministrador;

/*2*/
select distinct ciudad from suministrador
union
select distinct ciudad from producto;

/*3*/
select S1.Snum, S2.Snum
from suministrador as S1, suministrador as S2
where S1.Snum < S2.Snum and S1.ciudad = S2.ciudad;

/*4*/
select *
from producto
where peso = (select min(peso) from producto);

/*5*/
select Snum, sum(cantidad)
from ventas
group by Snum
order by sum(cantidad) asc limit 1;

/*6*/
select S.* from suministrador S, ventas V
where S.Snum = V.Snum and Pnum in
(select Pnum from suministrador S, ventas V
where S.Snum = V.Snum and trim(Snombre) = 'Aldana')
and Snombre != 'Aldana';

/*7*/
select * from suministrador S
join ventas V on S.Snum = V.Snum
join producto P on P.Pnum = V.Pnum
where V.Pnum in
(select Pnum from suministrador as S, ventas as V
where S.Snum = V.Snum and trim(Snombre) = 'Aldana')
and Pnombre = 'Engrane' and Snombre != 'Aldana';

/*8*/
select snombre
from suministrador as S join ventas as V
on S.snum = V.snum
group by V.snum
having count(*) = (select count(*) from producto);

/*9*/
select snombre
from suministrador
where substring(snombre, -1, 1) in ('a', 'e', 'i', 'o', 'u');

/*10*/
select snombre, min(cantidad), max(cantidad)
from suministrador as S, ventas as V
where V.Snum = S.Snum
group by snombre;

/*11*/
select distinct snombre
from suministrador as S, ventas as V
where V.Snum = S.Snum and V.Snum not in
(select snum from ventas where Pnum = 'P2');


/*12*/
select snombre
from suministrador
where substring(snombre, 2, 1) in ('a');

/*13*/
insert into producto (Pnum, Pnombre, Color, Peso, Ciudad)
values ('P9', 'Tornillo', 'Rosa', '14', 'Madrid');

/*14*/
insert into producto (Pnum, Pnombre, Color, Peso, Ciudad)
values ('P10', 'Alicates', 'Negro', NULL, 'Madrid');

/*15*/
update producto
set color = 'Amarillo', peso = peso + 5, ciudad = NULL
where Pnum='P9';

/*16*/
update suministrador
set situacion = situacion * 2
where ciudad = 'Londres';

/*17*/
update ventas, suministrador
set cantidad = 0
where ventas.Snum = suministrador.Snum and ciudad = 'Londres';

/*18*/
delete from ventas
where cantidad > 300;

/*19*/
delete from ventas
where snum in (select snum
            from suministrador
            where ciudad = 'Londres');

/*20*/
delete from ventas;