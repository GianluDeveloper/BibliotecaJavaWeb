-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jan 30, 2021 at 02:58 PM
-- Server version: 8.0.23
-- PHP Version: 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ewallet`
--

-- --------------------------------------------------------

--
-- Table structure for table `contocorrente`
--

CREATE TABLE `contocorrente` (
  `iban` int NOT NULL,
  `idCliente` int NOT NULL,
  `saldo` float NOT NULL,
  `dataCreazione` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `contocorrente`
--

INSERT INTO `contocorrente` (`iban`, `idCliente`, `saldo`, `dataCreazione`) VALUES
(1, 10, 879.21, '2021-01-30');

-- --------------------------------------------------------

--
-- Table structure for table `movimenti`
--

CREATE TABLE `movimenti` (
  `id` int NOT NULL,
  `iban` int NOT NULL,
  `importo` float NOT NULL,
  `dataMovimento` date NOT NULL,
  `idTipoMovimento` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `movimenti`
--

INSERT INTO `movimenti` (`id`, `iban`, `importo`, `dataMovimento`, `idTipoMovimento`) VALUES
(1, 1, 999.99, '2021-01-30', 1);
INSERT INTO `movimenti` (`id`, `iban`, `importo`, `dataMovimento`, `idTipoMovimento`) VALUES
(2, 1, 130.21, '2021-01-31', 3);
INSERT INTO `movimenti` (`id`, `iban`, `importo`, `dataMovimento`, `idTipoMovimento`) VALUES
(3, 1, -250.99, '2021-01-31', 3);

-- --------------------------------------------------------

--
-- Table structure for table `tipomovimento`
--

CREATE TABLE `tipomovimento` (
  `idTipoMovimento` int NOT NULL,
  `descrizione` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tipomovimento`
--

INSERT INTO `tipomovimento` (`idTipoMovimento`, `descrizione`) VALUES
(1, 'Stipendio');
INSERT INTO `tipomovimento` (`idTipoMovimento`, `descrizione`) VALUES
(2, 'Conguaglio');
INSERT INTO `tipomovimento` (`idTipoMovimento`, `descrizione`) VALUES
(3, 'Risarcimento Danni');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `contocorrente`
--
ALTER TABLE `contocorrente`
  ADD PRIMARY KEY (`iban`);

--
-- Indexes for table `movimenti`
--
ALTER TABLE `movimenti`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idTipoMovimento` (`idTipoMovimento`),
  ADD KEY `fk_iban` (`iban`);

--
-- Indexes for table `tipomovimento`
--
ALTER TABLE `tipomovimento`
  ADD PRIMARY KEY (`idTipoMovimento`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `contocorrente`
--
ALTER TABLE `contocorrente`
  MODIFY `iban` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `movimenti`
--
ALTER TABLE `movimenti`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tipomovimento`
--
ALTER TABLE `tipomovimento`
  MODIFY `idTipoMovimento` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `movimenti`
--
ALTER TABLE `movimenti`
  ADD CONSTRAINT `fk_iban` FOREIGN KEY (`iban`) REFERENCES `contocorrente` (`iban`),
  ADD CONSTRAINT `fk_idTipoMovimento` FOREIGN KEY (`idTipoMovimento`) REFERENCES `tipomovimento` (`idTipoMovimento`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
