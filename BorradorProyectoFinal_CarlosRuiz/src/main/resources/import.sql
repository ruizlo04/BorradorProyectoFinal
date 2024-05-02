INSERT INTO Trabajador (cod_trabajador, nombre, apellidos, dni, sueldo) VALUES (1, 'Juan', 'Pérez López', '12345678A', 2500.0);
INSERT INTO Trabajador (cod_trabajador, nombre, apellidos, dni, sueldo) VALUES (2, 'María', 'García Martínez', '98765432B', 2800.0);
INSERT INTO Trabajador (cod_trabajador, nombre, apellidos, dni, sueldo) VALUES (3, 'Carlos', 'Ruiz Fernández', '56789012C', 3000.0);
INSERT INTO Trabajador (cod_trabajador, nombre, apellidos, dni, sueldo) VALUES (4, 'Laura', 'Sánchez Gómez', '34567890D', 2700.0);
INSERT INTO Trabajador (cod_trabajador, nombre, apellidos, dni, sueldo) VALUES (5, 'Javier', 'Rodríguez González', '21098765E', 2600.0);
INSERT INTO Trabajador (cod_trabajador, nombre, apellidos, dni, sueldo) VALUES (6, 'Ana', 'López García', '87654321F', 2900.0);
INSERT INTO Trabajador (cod_trabajador, nombre, apellidos, dni, sueldo) VALUES (7, 'David', 'Martín Pérez', '54321678G', 3100.0);
INSERT INTO Trabajador (cod_trabajador, nombre, apellidos, dni, sueldo) VALUES (8, 'Marta', 'Hernández Ruiz', '09876543H', 3200.0);
INSERT INTO Trabajador (cod_trabajador, nombre, apellidos, dni, sueldo) VALUES (9, 'Daniel', 'Gómez Sánchez', '65432187I', 2700.0);
INSERT INTO Trabajador (cod_trabajador, nombre, apellidos, dni, sueldo) VALUES (10, 'Patricia', 'Fernández Martínez', '32187654J', 2800.0);

ALTER SEQUENCE Trabajador_seq RESTART WITH 60;


INSERT INTO Tren (id, horario, tipo_tren) VALUES (1, '2024-04-27T10:00:00', 'Regional');
INSERT INTO Tren (id, horario, tipo_tren) VALUES (2, '2024-04-28T14:30:00', 'Ave');
INSERT INTO Tren (id, horario, tipo_tren) VALUES (3, '2024-04-29T08:45:00', 'Media Distancia');

ALTER SEQUENCE Tren_seq RESTART WITH 53;

INSERT INTO Estacion (id, nombre) VALUES (1, 'Estación Central');
INSERT INTO Estacion (id, nombre) VALUES (2, 'Estación Norte');
INSERT INTO Estacion (id, nombre) VALUES (3, 'Estación Sur');

