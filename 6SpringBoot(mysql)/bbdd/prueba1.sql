INSERT INTO `empleado` (`cod_emp`, `ape_emp`, `carg_emp`, `dir_emp`, `dni_emp`, `fe_naci_emp`, `nom_emp`, `sala_emp`) VALUES
(1, 'Pérez', 'Gerente', 'Av. Abancay 382', '12345678', '1990-05-15', 'Juan', 5000),
(2, 'Garcia', 'Empleado', 'Av. Perú 123', '84762712', '1995-05-15', 'Amir', 2000),
(3, 'López', 'Vendedor', 'Av. Andahuaylas 761', '23456789', '1993-08-25', 'María', 3000),
(4, 'González', 'Vendedor', 'Av. San Martín 789', '34567890', '1992-06-20', 'Pedro', 3000),
(5, 'Martínez', 'Cajero', 'Jr. Tupac Amaru 101', '45678901', '1994-02-10', 'Ana', 2500),
(6, 'Ramírez', 'Analista', 'Calle Los Olivos 234', '56789012', '1988-11-30', 'Carlos', 4000),
(7, 'Fernández', 'Vendedor', 'Av. Huancayo 567', '67890123', '1991-07-18', 'Luisa', 4500),
(8, 'Silva', 'Contador', 'Jr. Cusco 890', '78901234', '1985-04-22', 'Roberto', 4800),
(9, 'Díaz', 'Recepcionista', 'Calle Lima 345', '89012345', '1996-03-12', 'Elena', 3000),
(10, 'Peralta', 'Analista', 'Av. Arequipa 678', '90123456', '1990-09-05', 'Hugo', 4200);

INSERT INTO `producto` (`cod_pro`, `cat_pro`, `nom_pro`, `pre_pro`, `stock`, `url_pro`) VALUES
('P001', 'Fungicidas', 'Mancozeb', 200, 50, NULL),
('P002', 'Fungicidas', 'Azoxistrobina', 100, 70, NULL),
('P003', 'Fungicidas', 'Tebuconazol', 50, 30, NULL),
('P004', 'Fungicidas', 'Propiconazol', 50, 30, NULL),
('P005', 'Fungicidas', 'Ciproconazol', 50, 30, NULL),
('P006', 'Insecticidas', 'Clorpirifos', 20, 50, NULL),
('P007', 'Insecticidas', 'Imidacloprid', 54, 70, NULL),
('P008', 'Insecticidas', 'Glifosato', 25, 30, NULL),
('P009', 'Insecticidas', 'Acefato', 550, 60, NULL),
('P010', 'Insecticidas', 'Piretrinas', 450, 30, NULL),
('P011', 'Fertilizantes', 'Nitrato de Amonio', 230, 59, NULL),
('P012', 'Fertilizantes', 'Fosfato Diamónico', 112, 74, NULL),
('P013', 'Fertilizantes', 'Potasa', 153, 35, NULL),
('P014', 'Fertilizantes', 'Urea', 120, 33, NULL),
('P015', 'Fertilizantes', 'Sulfato de Amonio', 130, 41, NULL),
('P016', 'Reguladores de Crecimiento', 'Ácido Giberélico', 230, 59, NULL),
('P017', 'Reguladores de Crecimiento', 'Citoquininas', 412, 74, NULL),
('P018', 'Reguladores de Crecimiento', 'Ácido Abscísico', 554, 35, NULL),
('P019', 'Reguladores de Crecimiento', 'Etileno', 229, 53, NULL),
('P020', 'Reguladores de Crecimiento', 'Ácido Indolacético', 434, 31, NULL),
('P021', 'Desinfectantes', 'Hipoclorito de Sodio', 220, 29, NULL),
('P022', 'Desinfectantes', 'Peróxido de Hidrógeno', 552, 64, NULL),
('P023', 'Desinfectantes', 'Quaternarios de Amonio', 243, 35, NULL),
('P024', 'Desinfectantes', 'Ácido Peracético', 170, 63, NULL),
('P025', 'Desinfectantes', 'Glutaraldehído', 680, 81, NULL),
('P026', 'Fungicidas', 'Ácido Peracético', 230, 49, NULL),
('P027', 'Fungicidas', 'Ácido Láctico', 252, 34, NULL),
('P028', 'Fungicidas', 'Amonio Cuaternario', 133, 55, NULL),
('P029', 'Fungicidas', 'Peróxido de Hidrógeno', 460, 23, NULL),
('P030', 'Fungicidas', 'Cloruro de Benzalconio', 250, 71, NULL),
('P031', 'Repelentes', 'DEET', 340, 62, NULL),
('P032', 'Repelentes', 'Picaridina', 322, 74, NULL),
('P033', 'Repelentes', 'Eucalipto de Limón', 243, 64, NULL),
('P034', 'Repelentes', 'IR3535', 120, 72, NULL),
('P035', 'Repelentes', 'Aceite de Neem', 130, 44, NULL),
('P036', 'Otros', 'Ácido Caproico', 240, 39, NULL),
('P037', 'Otros', 'Methyl Anthranilate', 152, 37, NULL),
('P038', 'Otros', 'Capsaicina', 143, 53, NULL),
('P039', 'Otros', 'Azadiractina', 130, 74, NULL),
('P040', 'Otros', 'Extracto de Ajo', 120, 56, NULL);

INSERT INTO `cliente` (`cod_cli`, `ape_cli`, `dni_cli`, `nom_cli`) VALUES
(1, 'Gomez', '12345678', 'Carlos'),
(2, 'Martinez', '87654321', 'Ana'),
(3, 'Lopez', '23456789', 'Pedro'),
(4, 'Hernandez', '98765432', 'Luis'),
(5, 'Perez', '34567890', 'Laura'),
(6, 'Garcia', '45678901', 'Marta'),
(7, 'Ramirez', '10987654', 'Eduardo'),
(8, 'Diaz', '21098765', 'Sofia'),
(9, 'Fernandez', '56789012', 'Alejandro'),
(10, 'Sanchez', '54321098', 'Javier');

INSERT INTO `boleta` (`cod_bol`, `fec_ven`, `cod_cli`, `cod_emp`) VALUES
('B001', '2023-10-11', 1, 1),
('B002', '2023-11-22', 1, 1),
('B003', '2023-03-11', 1, 2),
('B004', '2023-01-24', 2, 2),
('B005', '2023-08-12', 3, 3),
('B006', '2023-05-01', 4, 3),
('B007', '2023-02-24', 5, 4),
('B008', '2023-01-17', 5, 4),
('B009', '2023-12-04', 5, 5),
('B010', '2023-10-12', 6, 5),
('B011', '2023-09-15', 6, 6),
('B012', '2023-11-28', 7, 6),
('B013', '2023-04-18', 7, 7),
('B014', '2023-02-03', 8, 7),
('B015', '2023-09-22', 8, 8),
('B016', '2023-06-10', 9, 8),
('B017', '2023-03-05', 9, 9),
('B018', '2023-02-18', 9, 9),
('B019', '2023-11-09', 9, 10),
('B020', '2023-09-15', 10, 10);


INSERT INTO `boleta_informacion` (`id_b_i`, `cant`, `cod_bol`, `cod_pro`) VALUES
(1, 2, 'B001', 'P001'),
(2, 1, 'B001', 'P003'),
(3, 1, 'B001', 'P004'),
(4, 1, 'B001', 'P009'),
(5, 2, 'B001', 'P013'),
(6, 4, 'B001', 'P023'),
(7, 1, 'B002', 'P008'),
(8, 2, 'B002', 'P034'),
(9, 3, 'B002', 'P024'),
(10, 4, 'B002', 'P009'),
(11, 1, 'B002', 'P033'),
(12, 1, 'B002', 'P013'),
(13, 1, 'B003', 'P011'),
(14, 1, 'B003', 'P013'),
(15, 1, 'B003', 'P020'),
(16, 1, 'B003', 'P019'),
(17, 1, 'B003', 'P003'),
(18, 2, 'B004', 'P039'),
(19, 2, 'B004', 'P023'),
(20, 2, 'B004', 'P033'),
(21, 2, 'B005', 'P030'),
(22, 3, 'B005', 'P003'),
(23, 1, 'B005', 'P013'),
(24, 1, 'B006', 'P023'),
(25, 1, 'B006', 'P013'),
(26, 2, 'B007', 'P033'),
(27, 6, 'B007', 'P003'),
(28, 4, 'B007', 'P023'),
(29, 5, 'B007', 'P033'),
(30, 4, 'B008', 'P014'),
(31, 2, 'B008', 'P015'),
(32, 1, 'B008', 'P016'),
(33, 2, 'B008', 'P022'),
(34, 1, 'B009', 'P027'),
(35, 2, 'B010', 'P015'),
(36, 6, 'B010', 'P020'),
(37, 5, 'B011', 'P034'),
(38, 6, 'B011', 'P024'),
(39, 1, 'B011', 'P009'),
(40, 2, 'B011', 'P033'),
(41, 5, 'B011', 'P013'),
(42, 4, 'B011', 'P023'),
(43, 3, 'B012', 'P008'),
(44, 1, 'B012', 'P034'),
(45, 1, 'B012', 'P024'),
(46, 2, 'B012', 'P009'),
(47, 3, 'B012', 'P033'),
(48, 7, 'B012', 'P013'),
(49, 6, 'B013', 'P011'),
(50, 2, 'B013', 'P013'),
(51, 1, 'B013', 'P020'),
(52, 1, 'B013', 'P019'),
(53, 1, 'B013', 'P003'),
(54, 1, 'B014', 'P039'),
(55, 1, 'B014', 'P023'),
(56, 1, 'B014', 'P033'),
(57, 2, 'B015', 'P030'),
(58, 3, 'B015', 'P003'),
(59, 1, 'B015', 'P013'),
(60, 1, 'B016', 'P023'),
(61, 1, 'B016', 'P013'),
(62, 2, 'B017', 'P033'),
(63, 3, 'B017', 'P003'),
(64, 3, 'B017', 'P023'),
(65, 1, 'B017', 'P033'),
(66, 2, 'B018', 'P014'),
(67, 2, 'B018', 'P015'),
(68, 1, 'B018', 'P016'),
(69, 2, 'B018', 'P022'),
(70, 2, 'B019', 'P027'),
(71, 1, 'B020', 'P015'),
(72, 2, 'B020', 'P020');
