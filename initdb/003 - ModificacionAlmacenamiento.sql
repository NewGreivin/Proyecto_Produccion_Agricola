USE `ProduccionAgricola`;

TRUNCATE TABLE `almacenamiento`;

ALTER TABLE `almacenamiento`
  DROP COLUMN `producto`;

ALTER TABLE `almacenamiento`
  ADD COLUMN `id_cultivo` int(11) NOT NULL AFTER `id`;

ALTER TABLE `almacenamiento`
  ADD KEY `fk_almacenamiento_cultivo` (`id_cultivo`);

ALTER TABLE `almacenamiento`
  ADD CONSTRAINT `fk_almacenamiento_cultivo` 
  FOREIGN KEY (`id_cultivo`) REFERENCES `cultivos` (`id`)
  ON DELETE RESTRICT
  ON UPDATE CASCADE;

COMMIT;
