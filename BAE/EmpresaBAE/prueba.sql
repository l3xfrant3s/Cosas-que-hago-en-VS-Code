select nemp, nombre, D.ndep, Nombdep, ciudad, presupuesto
from empleado as E left join departamento as D on E.Ndep = D.Ndep;

mysqld --install-manual "MySQL80" --local-service --defaults-file="C:\ProgramData\MySQL\MySQL Server 8.0\my.ini"