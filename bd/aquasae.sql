-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-02-2019 a las 20:50:24
-- Versión del servidor: 5.6.24
-- Versión de PHP: 5.6.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `aquasae`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `category`
--

CREATE TABLE IF NOT EXISTS `category` (
  `id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `client`
--

CREATE TABLE IF NOT EXISTS `client` (
  `id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `surname` varchar(30) NOT NULL,
  `dir` varchar(30) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `client_phone`
--

CREATE TABLE IF NOT EXISTS `client_phone` (
  `id` int(11) NOT NULL,
  `id_client` int(11) NOT NULL,
  `phone` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `client_prod`
--

CREATE TABLE IF NOT EXISTS `client_prod` (
  `id` int(11) NOT NULL,
  `id_client` int(11) NOT NULL,
  `id_prod` int(11) NOT NULL,
  `fecha_pedido` timestamp NULL DEFAULT NULL,
  `quantity` int(10) NOT NULL,
  `total` double NOT NULL,
  `delivered` tinyint(1) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `client_zone`
--

CREATE TABLE IF NOT EXISTS `client_zone` (
  `id` int(11) NOT NULL,
  `id_client` int(11) NOT NULL,
  `id_zone` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `product`
--

CREATE TABLE IF NOT EXISTS `product` (
  `id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `desc` varchar(30) NOT NULL,
  `price` double NOT NULL,
  `stock` int(11) NOT NULL,
  `fecha_expiracion` date NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prod_cat`
--

CREATE TABLE IF NOT EXISTS `prod_cat` (
  `id` int(11) NOT NULL,
  `id_prod` int(11) NOT NULL,
  `id_cat` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `zone`
--

CREATE TABLE IF NOT EXISTS `zone` (
  `id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `client_phone`
--
ALTER TABLE `client_phone`
  ADD PRIMARY KEY (`id`), ADD KEY `id_client` (`id_client`), ADD KEY `id_phone` (`phone`);

--
-- Indices de la tabla `client_prod`
--
ALTER TABLE `client_prod`
  ADD PRIMARY KEY (`id`), ADD KEY `id_client` (`id_client`), ADD KEY `id_prod` (`id_prod`);

--
-- Indices de la tabla `client_zone`
--
ALTER TABLE `client_zone`
  ADD PRIMARY KEY (`id`), ADD KEY `id_client` (`id_client`), ADD KEY `id_zone` (`id_zone`);

--
-- Indices de la tabla `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `prod_cat`
--
ALTER TABLE `prod_cat`
  ADD PRIMARY KEY (`id`), ADD KEY `id_prod` (`id_prod`), ADD KEY `id_cat` (`id_cat`), ADD KEY `id_cat_2` (`id_cat`);

--
-- Indices de la tabla `zone`
--
ALTER TABLE `zone`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `client`
--
ALTER TABLE `client`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `client_phone`
--
ALTER TABLE `client_phone`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `client_prod`
--
ALTER TABLE `client_prod`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=41;
--
-- AUTO_INCREMENT de la tabla `client_zone`
--
ALTER TABLE `client_zone`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `product`
--
ALTER TABLE `product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT de la tabla `prod_cat`
--
ALTER TABLE `prod_cat`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `zone`
--
ALTER TABLE `zone`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=31;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `client_phone`
--
ALTER TABLE `client_phone`
ADD CONSTRAINT `client_phone_ibfk_2` FOREIGN KEY (`id_client`) REFERENCES `client` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `client_prod`
--
ALTER TABLE `client_prod`
ADD CONSTRAINT `client_prod_ibfk_1` FOREIGN KEY (`id_client`) REFERENCES `client` (`id`) ON UPDATE CASCADE,
ADD CONSTRAINT `client_prod_ibfk_2` FOREIGN KEY (`id_prod`) REFERENCES `product` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `client_zone`
--
ALTER TABLE `client_zone`
ADD CONSTRAINT `client_zone_ibfk_1` FOREIGN KEY (`id_zone`) REFERENCES `zone` (`id`) ON UPDATE CASCADE,
ADD CONSTRAINT `client_zone_ibfk_2` FOREIGN KEY (`id_client`) REFERENCES `client` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `prod_cat`
--
ALTER TABLE `prod_cat`
ADD CONSTRAINT `prod_cat_ibfk_1` FOREIGN KEY (`id_cat`) REFERENCES `category` (`id`) ON UPDATE CASCADE,
ADD CONSTRAINT `prod_cat_ibfk_2` FOREIGN KEY (`id_prod`) REFERENCES `product` (`id`) ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
