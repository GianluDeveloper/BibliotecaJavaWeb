-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Gen 19, 2021 alle 19:49
-- Versione del server: 10.4.17-MariaDB
-- Versione PHP: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `java`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `cliente`
--

CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL DEFAULT '0',
  `cognome` varchar(50) NOT NULL DEFAULT '0',
  `telefono` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `cliente`
--

INSERT INTO `cliente` (`idCliente`, `nome`, `cognome`, `telefono`) VALUES
(1, 'CAMBIATOCONCTR', 'SONOCTR', '0000000'),
(4, 'Cliente', 'Studente', '1234675737'),
(5, 'Cliente', 'Studente', '1234675737'),
(6, 'Cliente', 'Studente', '1234675737'),
(7, 'Cliente', 'Studente', '1234675737'),
(8, 'Cliente', 'Studente', '1234675737'),
(9, 'Cliente', 'Studente', '1234675737'),
(10, 'Cliente', 'Studente', '1234675737'),
(11, 'Cliente', 'Studente', '1234675737'),
(12, 'Cliente', 'Studente', '1234675737'),
(13, 'Cliente', 'Studente', '1234675737'),
(14, 'Cliente', 'Studente', '1234675737'),
(15, 'Cliente', 'Studente', '1234675737'),
(16, 'Cliente', 'Studente', '1234675737'),
(17, 'Cliente', 'Studente', '1234675737'),
(18, 'Cliente', 'Studente', '1234675737'),
(19, 'Cliente', 'Studente', '1234675737'),
(20, 'Cliente', 'Studente', '1234675737'),
(21, 'Cliente', 'Studente', '1234675737'),
(22, 'Cliente', 'Studente', '1234675737'),
(23, 'Cliente', 'Studente', '1234675737'),
(24, 'Cliente', 'Studente', '1234675737'),
(25, 'Cliente', 'Studente', '1234675737'),
(26, 'Cliente', 'Studente', '1234675737'),
(27, 'Cliente', 'Studente', '1234675737'),
(28, 'Cliente', 'Studente', '1234675737'),
(29, 'ProvaCTR', 'SONOCTR', '0000000'),
(30, 'ProvaCTR', 'SONOCTR', '0000000'),
(31, 'ProvaCTR', 'SONOCTR', '0000000'),
(32, 'ProvaCTR', 'SONOCTR', '0000000'),
(33, 'ProvaCTR', 'SONOCTR', '0000000'),
(34, 'ProvaCTR', 'SONOCTR', '0000000'),
(35, 'ProvaCTR', 'SONOCTR', '0000000'),
(36, 'ProvaCTR', 'SONOCTR', '0000000');

-- --------------------------------------------------------

--
-- Struttura della tabella `dipendente`
--

CREATE TABLE `dipendente` (
  `id` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL DEFAULT '0',
  `cognome` varchar(50) NOT NULL DEFAULT '0',
  `telefono` varchar(50) DEFAULT NULL,
  `admin` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `dipendente`
--

INSERT INTO `dipendente` (`id`, `nome`, `cognome`, `telefono`, `admin`) VALUES
(1, 'CAMBIATO', 'Rossi', '0123456789', 1),
(3, 'Boss', 'Rossi', '0123456789', 1),
(4, 'Boss', 'Rossi', '0123456789', 1),
(5, 'Boss', 'Rossi', '0123456789', 1),
(6, 'Boss', 'Rossi', '0123456789', 1),
(7, 'Boss', 'Rossi', '0123456789', 1),
(8, 'Boss', 'Rossi', '0123456789', 1),
(9, 'Boss', 'Rossi', '0123456789', 1),
(10, 'Boss', 'Rossi', '0123456789', 1),
(11, 'Boss', 'Rossi', '0123456789', 1),
(12, 'Boss', 'Rossi', '0123456789', 1),
(13, 'Boss', 'Rossi', '0123456789', 1),
(14, 'Boss', 'Rossi', '0123456789', 1),
(15, 'Boss', 'Rossi', '0123456789', 1),
(16, 'Boss', 'Rossi', '0123456789', 1),
(17, 'Boss', 'Rossi', '0123456789', 1),
(18, 'Boss', 'Rossi', '0123456789', 1),
(19, 'Boss', 'Rossi', '0123456789', 1),
(20, 'Boss', 'Rossi', '0123456789', 1),
(21, 'Boss', 'Rossi', '0123456789', 1),
(22, 'Boss', 'Rossi', '0123456789', 1),
(23, 'Boss', 'Rossi', '0123456789', 1),
(24, 'Boss', 'Rossi', '0123456789', 1),
(25, 'Boss', 'Rossi', '0123456789', 1),
(26, 'Boss', 'Rossi', '0123456789', 1),
(27, 'Boss', 'Rossi', '0123456789', 1),
(28, 'Boss', 'Rossi', '0123456789', 1);

-- --------------------------------------------------------

--
-- Struttura della tabella `libri`
--

CREATE TABLE `libri` (
  `idLibro` int(11) NOT NULL,
  `numPagine` int(11) DEFAULT NULL,
  `anno` int(11) DEFAULT NULL,
  `posizione` int(11) DEFAULT NULL,
  `titolo` varchar(50) NOT NULL DEFAULT '0',
  `genere` varchar(50) NOT NULL DEFAULT '0',
  `autore` varchar(50) DEFAULT NULL,
  `isbn` varchar(50) DEFAULT NULL,
  `casaEditrice` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `libri`
--

INSERT INTO `libri` (`idLibro`, `numPagine`, `anno`, `posizione`, `titolo`, `genere`, `autore`, `isbn`, `casaEditrice`) VALUES
(1, 1, 2001, 9, 'provalibro', 'nuovogenere', 'Eco', 'asodfkaod', 'casa'),
(2, 1, 2001, 9, 'provalibro', 'nuovogenere', 'Eco', 'asodfkaod', 'casa'),
(3, 1, 2001, 9, 'provalibro', 'nuovogenere', 'Eco', 'asodfkaod', 'casa'),
(4, 1, 2001, 9, 'provalibro', 'nuovogenere', 'Eco', 'asodfkaod', 'casa'),
(5, 1, 2001, 9, 'provalibro', 'nuovogenere', 'Eco', 'asodfkaod', 'casa'),
(6, 1, 2001, 9, 'provalibro', 'nuovogenere', 'Eco', 'asodfkaod', 'casa'),
(7, 1, 2001, 9, 'provalibro', 'nuovogenere', 'Eco', 'asodfkaod', 'casa'),
(8, 1, 2001, 9, 'provalibro', 'nuovogenere', 'Eco', 'asodfkaod', 'casa'),
(9, 1, 2001, 9, 'provalibro', 'nuovogenere', 'Eco', 'asodfkaod', 'casa'),
(10, 1, 2001, 9, 'provalibro', 'nuovogenere', 'Eco', 'asodfkaod', 'casa'),
(11, 1, 2001, 9, 'provalibro', 'nuovogenere', 'Eco', 'asodfkaod', 'casa'),
(12, 1, 2001, 9, 'provalibro', 'nuovogenere', 'Eco', 'asodfkaod', 'casa'),
(13, 1, 2001, 9, 'provalibro', 'nuovogenere', 'Eco', 'asodfkaod', 'casa'),
(14, 1, 2001, 9, 'provalibro', 'nuovogenere', 'Eco', 'asodfkaod', 'casa'),
(15, 1, 2001, 9, 'provalibro', 'nuovogenere', 'Eco', 'asodfkaod', 'casa'),
(16, 1, 2001, 9, 'provalibro', 'nuovogenere', 'Eco', 'asodfkaod', 'casa'),
(17, 1, 2001, 9, 'provalibro', 'nuovogenere', 'Eco', 'asodfkaod', 'casa'),
(18, 1, 2001, 9, 'provalibro', 'nuovogenere', 'Eco', 'asodfkaod', 'casa'),
(19, 1, 2001, 9, 'provalibro', 'nuovogenere', 'Eco', 'asodfkaod', 'casa'),
(20, 1, 2001, 9, 'provalibro', 'nuovogenere', 'Eco', 'asodfkaod', 'casa'),
(21, 1, 2001, 9, 'provalibro', 'nuovogenere', 'Eco', 'asodfkaod', 'casa'),
(22, 1, 2001, 9, 'provalibro', 'nuovogenere', 'Eco', 'asodfkaod', 'casa'),
(23, 1, 2001, 9, 'provalibro', 'nuovogenere', 'Eco', 'asodfkaod', 'casa'),
(24, 1, 2001, 9, 'provalibro', 'nuovogenere', 'Eco', 'asodfkaod', 'casa'),
(25, 1, 2001, 9, 'provalibro', 'nuovogenere', 'Eco', 'asodfkaod', 'casa'),
(26, 1, 2001, 9, 'provalibro', 'nuovogenere', 'Eco', 'asodfkaod', 'casa'),
(27, 1, 2001, 9, 'provalibro', 'nuovogenere', 'Eco', 'asodfkaod', 'casa'),
(28, 1, 2001, 9, 'provalibro', 'nuovogenere', 'Eco', 'asodfkaod', 'casa');

-- --------------------------------------------------------

--
-- Struttura della tabella `registro`
--

CREATE TABLE `registro` (
  `id` int(11) NOT NULL,
  `idLibro` int(11) DEFAULT NULL,
  `idCliente` int(11) DEFAULT NULL,
  `idDipendente` int(11) DEFAULT NULL,
  `data_prestito` date DEFAULT NULL,
  `data_scadenza` date DEFAULT NULL,
  `data_rientro` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `registro`
--

INSERT INTO `registro` (`id`, `idLibro`, `idCliente`, `idDipendente`, `data_prestito`, `data_scadenza`, `data_rientro`) VALUES
(1, 1, 1, 1, '2012-12-12', '2012-12-22', '2012-12-15'),
(2, 1, 1, 1, '2012-12-12', '2012-12-22', '2012-12-15'),
(3, 1, 1, 1, '2012-12-12', '2012-12-22', '2012-12-15'),
(4, 1, 1, 1, '2012-12-12', '2012-12-22', '2012-12-15'),
(5, 1, 1, 1, '2012-12-12', '2012-12-22', '2012-12-15'),
(6, 1, 1, 1, '2012-12-12', '2012-12-22', '2012-12-15'),
(7, 1, 1, 1, '2012-12-12', '2012-12-22', '2012-12-15'),
(8, 1, 1, 1, '2012-12-12', '2012-12-22', '2012-12-15'),
(9, 1, 1, 1, '2012-12-12', '2012-12-22', '2012-12-15'),
(10, 1, 1, 1, '2012-12-12', '2012-12-22', '2012-12-15'),
(11, 1, 1, 1, '2012-12-12', '2012-12-22', '2012-12-15'),
(12, 1, 1, 1, '2012-12-12', '2012-12-22', '2012-12-15'),
(13, 1, 1, 1, '2012-12-12', '2012-12-22', '2012-12-15'),
(14, 1, 1, 1, '2012-12-12', '2012-12-22', '2012-12-15'),
(15, 1, 1, 1, '2012-12-12', '2012-12-22', '2012-12-15'),
(16, 1, 1, 1, '2012-12-12', '2012-12-22', '2012-12-15'),
(17, 1, 1, 1, '2012-12-12', '2012-12-22', '2012-12-15'),
(18, 1, 1, 1, '2012-12-12', '2012-12-22', '2012-12-15'),
(19, 1, 1, 1, '2012-12-12', '2012-12-22', '2012-12-15'),
(20, 1, 1, 1, '2012-12-12', '2012-12-22', '2012-12-15'),
(21, 1, 1, 1, '2012-12-12', '2012-12-22', '2012-12-15'),
(22, 1, 1, 1, '2012-12-12', '2012-12-22', '2012-12-15'),
(23, 1, 1, 1, '2012-12-12', '2012-12-22', '2012-12-15'),
(24, 1, 1, 1, '2012-12-12', '2012-12-22', '2012-12-15'),
(25, 1, 1, 1, '2012-12-12', '2012-12-22', '2012-12-15'),
(26, 1, 1, 1, '2012-12-12', '2012-12-22', '2012-12-15'),
(27, 1, 1, 1, '2012-12-12', '2012-12-22', '2012-12-15'),
(28, 1, 1, 1, '2012-12-12', '2012-12-22', '2012-12-15');

-- --------------------------------------------------------

--
-- Struttura della tabella `turni`
--

CREATE TABLE `turni` (
  `idTurni` int(11) NOT NULL,
  `idDipendente` int(11) DEFAULT NULL,
  `data_inizio` date DEFAULT NULL,
  `data_fine` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `turni`
--

INSERT INTO `turni` (`idTurni`, `idDipendente`, `data_inizio`, `data_fine`) VALUES
(1, 1, '2012-12-02', '2013-01-07'),
(2, 1, '2012-12-02', '2013-01-07'),
(4, 1, '2012-12-02', '2013-01-07'),
(5, 1, '2012-12-02', '2013-01-07'),
(6, 1, '2012-12-02', '2013-01-07'),
(7, 1, '2012-12-02', '2013-01-07'),
(8, 1, '2012-12-02', '2013-01-07'),
(9, 1, '2012-12-02', '2013-01-07'),
(10, 1, '2012-12-02', '2013-01-07'),
(11, 1, '2012-12-02', '2013-01-07'),
(12, 1, '2012-12-02', '2013-01-07'),
(13, 1, '2012-12-02', '2013-01-07'),
(14, 1, '2012-12-02', '2013-01-07'),
(15, 1, '2012-12-02', '2013-01-07'),
(16, 1, '2012-12-02', '2013-01-07'),
(17, 1, '2012-12-02', '2013-01-07'),
(19, 1, '2012-12-02', '2013-01-07'),
(20, 1, '2012-12-02', '2013-01-07'),
(22, 1, '2012-12-02', '2013-01-07'),
(24, 1, '2012-12-02', '2013-01-07'),
(26, 1, '2012-12-02', '2013-01-07'),
(28, 1, '2012-12-02', '2013-01-07'),
(30, 1, '2012-12-02', '2013-01-07'),
(32, 1, '2012-12-02', '2013-01-07'),
(34, 1, '2012-12-02', '2013-01-07'),
(36, 1, '2012-12-02', '2013-01-07'),
(38, 1, '2012-12-02', '2013-01-07');

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`idCliente`);

--
-- Indici per le tabelle `dipendente`
--
ALTER TABLE `dipendente`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `libri`
--
ALTER TABLE `libri`
  ADD PRIMARY KEY (`idLibro`);

--
-- Indici per le tabelle `registro`
--
ALTER TABLE `registro`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idLibro` (`idLibro`),
  ADD KEY `idCliente` (`idCliente`),
  ADD KEY `idDipendente` (`idDipendente`);

--
-- Indici per le tabelle `turni`
--
ALTER TABLE `turni`
  ADD PRIMARY KEY (`idTurni`),
  ADD KEY `idDipendente` (`idDipendente`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `cliente`
--
ALTER TABLE `cliente`
  MODIFY `idCliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT per la tabella `dipendente`
--
ALTER TABLE `dipendente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT per la tabella `libri`
--
ALTER TABLE `libri`
  MODIFY `idLibro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT per la tabella `registro`
--
ALTER TABLE `registro`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT per la tabella `turni`
--
ALTER TABLE `turni`
  MODIFY `idTurni` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `registro`
--
ALTER TABLE `registro`
  ADD CONSTRAINT `registro_ibfk_1` FOREIGN KEY (`idLibro`) REFERENCES `libri` (`idLibro`),
  ADD CONSTRAINT `registro_ibfk_2` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`),
  ADD CONSTRAINT `registro_ibfk_3` FOREIGN KEY (`idDipendente`) REFERENCES `dipendente` (`id`);

--
-- Limiti per la tabella `turni`
--
ALTER TABLE `turni`
  ADD CONSTRAINT `turni_ibfk_1` FOREIGN KEY (`idDipendente`) REFERENCES `dipendente` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
