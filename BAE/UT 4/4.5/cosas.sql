describe aviones;
describe reservas;
describe vuelos;

/*2*/
alter table aviones add FechaConstruccion date not null
                    default (curdate());

/*3*/
alter table aviones add constraint pk_aviones primary key(Tipo);

alter table vuelos
add constraint pk_vuelos primary key(Numvuelo),
add constraint fk_vuelos foreign key(TipoAvion)
            references aviones(Tipo)
            on update cascade,
modify HoraSalida time;


alter table reservas
add constraint pk_reservas primary key(Numvuelo,FechaSalida),
add constraint fk_reservas foreign key(NumVuelo)
            references vuelos(NumVuelo) on update cascade,
modify FechaSalida date;

/*4*/
update aviones set FechaConstruccion = '1985-12-15' where Tipo = '320';
update aviones set FechaConstruccion = '1992-10-15' where Tipo = '72S'; 
update aviones set FechaConstruccion = '1985-01-10' where Tipo = '737';
update aviones set FechaConstruccion = '1979-05-12' where Tipo = '73S';
update aviones set FechaConstruccion = '2001-09-11' where Tipo = 'D9S';


insert into Aviones (Tipo, Nombre, Capacidad, Longitud, Envergadura, Velocidad, FechaConstruccion)
values ('320', 'B-320 Boeing', 187, 42.15, 32.6, 853, '1985-12-15'),
('72S', 'Super Boeing Stratojet', 160, 36.2, 25.2, 820, '1992-10-15'),
('737', 'Boeing 737', 172, 38.9, 29, 793, '1985-01-10'),
('73S', 'Super Jumbo 73', 185, 44.1, 30.35, 815, '1979-05-12'),
('D9S', 'Div 9 SuperStar', 110, 35.3, 28.5, 815, '2001-09-11')
on duplicate key update
FechaConstruccion = values(FechaConstruccion);


/*5*/
insert into aviones values ('340', 'AirBus 340', 250, 59.4, 60.3, 871, '1992-12-22');

/*6*/
select distinct origen as Ciudades from vuelos
union
select distinct destino from vuelos
order by 1 desc;

/*7*/
select * from vuelos
where destino = 'Londres' and origen != 'Madrid';

/*8*/
select * from aviones
where Nombre like '%Boeing%';

/*9*/
select * from vuelos where destino = 'Madrid' and origen = 'Sevilla'
union select * from vuelos where destino = 'Sevilla' and origen = 'Madrid';

/*10*/
select Tipo, Nombre, Capacidad, Longitud, Envergadura, Velocidad,
FechaConstruccion, (year(curdate())-year(FechaConstruccion)) as Antigüedad
from aviones
where year(curdate())-year(FechaConstruccion) > 10;

/*11*/
select sum(PlazasLibres) as 'Total plazas libres'
from reservas where NumVuelo like "IB%";

/*12*/
select Origen, count(Origen)
from vuelos group by Origen;

/*13*/
select count(NumVuelo) as 'Vuelos a Barcelona'
from vuelos where Destino = 'Barcelona';

/*14*/
insert into vuelos values ('NT440', 'Tenerife', 'Lanzarote', '14:00:00','D9S');
select * from vuelos where destino = 'Lanzarote';
update vuelos set Destino = 'Gran Canaria' where Destino = 'Lanzarote';
select * from vuelos where destino = 'Gran Canaria';

/*15*/
select Origen, min(HoraSalida) as 'Primer vuelo de Madrid'
from vuelos where Origen = 'Madrid';

/*16*/
select * from vuelos
where origen = 'Madrid' and
(destino = 'Barcelona' or destino = 'Sevilla');

/*17*/
select * from vuelos
where origen = 'Madrid'
and NumVuelo like "IB%";

/*18*/
select * from vuelos
where origen != 'Madrid'
and destino != 'Madrid';

/*19*/
select sum(PlazasLibres)
from vuelos, reservas
where vuelos.NumVuelo = reservas.NumVuelo
and (destino = 'Londres' or destino = 'Barcelona');

/*20*/
select count(NumVuelo)
from vuelos;

/*21*/
select V.NumVuelo, PlazasLibres, HoraSalida, (Capacidad - PlazasLibres) as 'Plazas ocupadas'
from vuelos as V, reservas as R, aviones as A
where V.NumVuelo = R.NumVuelo and V.TipoAvion = A.Tipo
and Origen = 'Madrid' and Destino = 'Londres' and FechaSalida = '2006-02-20';