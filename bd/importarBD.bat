@echo off
C:\xampp\mysql\bin\mysql -u root -h localhost -e "create database aquasae CHARACTER SET 'utf8' COLLATE utf8_spanish_ci"
	C:\xampp\mysql\bin\mysql -u root -h localhost   aquasae < aquasae.sql
	echo la baase de datos se instalo correctamente
exit