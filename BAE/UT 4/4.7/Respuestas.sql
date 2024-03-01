select upper(concat(trim(Nombre), ' ',
substring(Apellido, 1, 3), '.')) as 'Nombre Alumno',
upper(Municipio) as 'Ciudad', Telefono
from alumnos
where Municipio in ('Arucas', 'Teror') and Telefono is not NULL;

select Municipio, count(Repetidor)
from alumnos
where Repetidor = 'Si'
group by Municipio
having count(Repetidor) > 1
order by Municipio asc;

select Siglas, Titulo, NHoras, Nombre, Apellido
from modulos as M left join profesor as P on M.Profe = P.CodProfe
where NHoras = (select min(NHoras) from modulos);

/*select Nombre, Apellido, Sueldo, floor(datediff(curdate(), FechaIngreso)/365.25) as Antiguedad
from profesor
where datediff(curdate(), FechaIngreso)/365.25 > 15;*/

select Nombre, Apellido, Sueldo,
year(curdate()) - year(FechaIngreso) as Antiguedad
from profesor
where year(curdate()) - year(FechaIngreso) > 15;

select Siglas, Titulo, Nota as 'Notas de Rosa Garcia'
from alumnos as A, notas as N, modulos as M
where A.CodAlum = N.CodAlum and M.CodMod = N.CodMod and
trim(A.Nombre) = 'Rosa' and trim(A.Apellido) = 'Garcia';

select Nombre, Apellido, FechaNac,
year(curdate()) - year (FechaNac)
as Edad, Municipio from alumnos
where month(FechaNac) = month(curdate());

select Siglas, Titulo,
round(avg(Nota), 2) as 'Nota Media'
from notas as N, modulos as M
where N.CodMod = M.CodMod
group by N.CodMod;

select Nif, Nombre, Apellido, Sueldo
from profesor
where Sueldo >= (select Sueldo from profesor where trim(Nombre) = 'Carlos' and trim(Apellido) = 'Ojeda')
and Sueldo <= (select Sueldo from profesor where trim(Nombre) = 'Aurora' and trim(Apellido) = 'Medina')
order by Sueldo desc;

select count(Nota) as 'Total de suspendidos'
from notas as N, modulos as M
where N.CodMod = M.CodMod and Titulo = 'Bases de Datos' and Nota < 5;

select Nota as 'Top 3 notas en BAE',
count(CodAlum) as 'Cuantos alumnos la sacaron'
from notas as N, modulos as M
where N.CodMod = M.CodMod and Siglas = 'BAE'
group by Nota order by Nota desc limit 3;