-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 14-Maio-2021 às 17:26
-- Versão do servidor: 10.4.18-MariaDB
-- versão do PHP: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `db_cadastro_anuncios`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_anuncio`
--

CREATE TABLE `tb_anuncio` (
  `ID_ANUNC` int(5) NOT NULL,
  `NO_ANUNC` varchar(50) NOT NULL,
  `NO_CLIENTE` varchar(50) NOT NULL,
  `DT_INIC` date NOT NULL,
  `DT_TERM` date NOT NULL,
  `VL_INVST_DIA` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tb_anuncio`
--

INSERT INTO `tb_anuncio` (`ID_ANUNC`, `NO_ANUNC`, `NO_CLIENTE`, `DT_INIC`, `DT_TERM`, `VL_INVST_DIA`) VALUES
(1, 'Teste1', 'Railton Rames Sousa', '2020-04-05', '2020-12-02', '25.25'),
(2, 'Teste2', 'Maria', '2020-02-01', '2021-05-10', '8.50'),
(3, 'Teste3', 'Professor Pedro', '2020-08-01', '2020-12-13', '9.85'),
(4, 'Teste4', 'Fabio', '2020-10-08', '2020-11-11', '25.50'),
(5, 'Teste5', 'Joana', '2020-11-11', '2020-11-30', '98.00'),
(6, 'Teste6', 'Marcos', '2020-09-01', '2020-11-11', '22.00'),
(7, 'Teste7', 'Carla', '2020-06-08', '2020-09-05', '33.42'),
(8, 'Teste8', 'Jonathan', '2019-09-27', '2019-12-23', '50.20'),
(9, 'Teste9', 'Julia', '2018-11-05', '2020-01-01', '22.00'),
(10, 'Teste10', 'Vanessa', '2021-01-22', '2021-03-18', '5.79'),
(11, 'Teste11', 'Julio', '2018-04-12', '2018-06-12', '12.29'),
(12, 'Teste12', 'Taina', '2020-02-03', '2020-02-15', '153.21'),
(13, 'Teste13', 'Douglas', '2020-04-25', '2020-06-25', '18.00'),
(14, 'Teste14', 'Jefersson', '2021-05-02', '2021-05-15', '7.58'),
(15, 'Teste15', 'Ton', '2017-08-11', '2017-11-18', '62.25'),
(16, 'Desafio de Programação Capgemini é Show', 'Proway/Capgemini', '2021-05-03', '2021-05-16', '10.00'),
(17, 'Teste16', 'Henrique', '2021-05-13', '2022-05-13', '15.75');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `tb_anuncio`
--
ALTER TABLE `tb_anuncio`
  ADD PRIMARY KEY (`ID_ANUNC`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `tb_anuncio`
--
ALTER TABLE `tb_anuncio`
  MODIFY `ID_ANUNC` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
