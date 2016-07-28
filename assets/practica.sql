-- phpMyAdmin SQL Dump
-- version 4.4.10
-- http://www.phpmyadmin.net
--
-- Servidor: localhost:8889
-- Tiempo de generación: 25-07-2016 a las 22:45:25
-- Versión del servidor: 5.5.42
-- Versión de PHP: 5.6.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Base de datos: `usersAdm_Proyects`
--

USE Adm_Proyects;
-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--
DROP TABLE IF EXISTS users;

CREATE TABLE IF NOT EXISTS`users` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `pass` int(11) DEFAULT NULL,
  `rol` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS`proyectos` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  `usuarioResp` varchar(50) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
--
-- Volcado de datos para la tabla `users`
--


INSERT INTO `users` (`id`, `nombre`, `email`, `pass`, `rol`) VALUES
(1, 'Veronica', 'vero@xmail', 1212, 'Administrador'),
(2, 'Branny', 'branny@gmail', 1337, 'Administrador'),
(3, 'Juan Perez', 'jperez@example.com', 1111, 'Desarrollador'),
(4, 'Rodrigo Castro', 'rcastro@example.com', 1111, 'Diseñador');

INSERT INTO `proyectos` (`id`, `nombre`, `descripcion`, `usuarioResp`) VALUES
(1, 'proy1', 'proyecto finalizado', 'Veronica'),
(2, 'proy2', 'proyecto zzz', 'Juan Perez');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
