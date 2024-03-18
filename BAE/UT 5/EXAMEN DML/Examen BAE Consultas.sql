select Nombre, Apellido, FechaNac, max(year(curdate()) - year(FechaNac)) Edad
from alumnos
where year(curdate()) - year(FechaNac) = max(year(curdate()) - year(FechaNac)) or
year(curdate()) - year(FechaNac) = min(year(curdate()) - year(FechaNac))
order by FechaNac desc;



select Nombre, Apellido, FechaNac, year(curdate()) - year(FechaNac) Edad
from alumnos
where year(curdate()) - year(FechaNac) = max(year(curdate()) - year(FechaNac)) or
year(curdate()) - year(FechaNac) = min(year(curdate()) - year(FechaNac))
order by FechaNac desc;


select Nombre, Apellido, FechaNac, max(year(curdate()) - year(FechaNac)) Edad
from alumnos
union
select Nombre, Apellido, FechaNac, year(curdate()) - year(FechaNac) Edad
from alumnos
where FechaNac in (min(FechaNac), max(FechaNac);


select Nombre, Apellido, FechaNac, year(curdate()) - year(FechaNac) Edad
from alumnos
where FechaNac = max(FechaNac) or FechaNac = min(FechaNac)
order by FechaNac desc;





/*2)*/
select Municipio, count(Repetidor) 'Número de Repetidores'
from alumnos
where Repetidor = 'SI'
group by Municipio
having count(Repetidor) > 1
order by count(Repetidor) desc, Municipio desc;




/*3)*/ 
select substr(trim(DNI), 1, 8) NIF, substr(trim(DNI), 9, 1) 'Letra NIF',
concat(trim(Nombre), '-', trim(Apellido)) 'Nombre Completo', FechaNac 'Fecha de Nacimiento'
from alumnos
where substr(trim(Nombre), -1, 1) = 'S' and substr(trim(Apellido), -1, 1) = 'Z';


/*4)*/
select DNI, concat(trim(Nombre), ' ', trim(Apellido)) 'Nombre Completo', count(Nota)
from notas N join alumnos A on N.CodAlum = A.CodAlum
where Nota < 5
group by N.CodAlum
having count(Nota) >= 3
order by count(Nota) desc, DNI desc;



/*5)*/
select NombreDep, D.email email, concat(trim(nombre), ' ', substr(Apellido, 1, 1), '.') 'Jefe/a Departamento'
from departamento D left join profesor P on D.JefeDep = P.CodProfe;


/*6)*/



select CodAlum, Nota
from modulos M join notas N on M.CodMod = N.CodMod
where Siglas = 'BAE' and Nota < 5
union
select DNI, Nombre, Apellido
from alumnos A, modulos M, notas N
where A.CodAlum = N.CodAlum and M.CodMod = N.CodMod
and Siglas = 'PRO' and Nota < 5;

/*7)*/
select Siglas, Titulo, round(avg(nota), 2) 'Nota Media'
from modulos m join notas n on m.CodMod = n.CodMod
group by m.CodMod
order by round(avg(nota), 2) desc;

/*8)*/
select a.CodAlum, Nombre, Apellido, Municipio, round(avg(nota), 2) 'Nota Media'
from alumnos a join notas n on a.CodAlum = n.CodAlum
group by a.CodAlum
having round(avg(nota), 2) > (select avg(nota) from notas)
order by round(avg(nota), 2) desc;

/*9)*/
select P.email 'Correos de profes de Informática y departamentos'
from profesor P join departamento D on P.Dep = D.CodDep
where substr(trim(NombreDep), 1, 6) = 'Inform' and substr(trim(NombreDep), 8, 4) = 'tica'
union
select email from departamento;

/*10)*/
select Nombre, Apellido, Sueldo, year(curdate()) - year(FechaIngreso) Antigüedad
from profesor
where year(curdate()) - year(FechaIngreso) > 15;
