SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

CREATE TABLE `corsi` (
  `idCorso` int NOT NULL,
  `nomeCorso` varchar(100) NOT NULL,
  `dataInizio` date NOT NULL,
  `dataFine` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `docenti` (
  `idDocente` int NOT NULL,
  `idCorso` int NOT NULL,
  `nomeDocente` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `iscrizioni` (
  `idIscrizione` int NOT NULL,
  `idDipendente` int NOT NULL,
  `idDocente` int NOT NULL,
  `idCorso` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


ALTER TABLE `corsi`
  ADD PRIMARY KEY (`idCorso`);

ALTER TABLE `docenti`
  ADD PRIMARY KEY (`idDocente`),
  ADD KEY `fk_idCorso` (`idCorso`);

ALTER TABLE `iscrizioni`
  ADD PRIMARY KEY (`idIscrizione`),
  ADD KEY `fk_idDocente` (`idDocente`),
  ADD KEY `fk_idCorsoDipendente` (`idCorso`) USING BTREE,
  ADD KEY `idDipendente` (`idDipendente`);



ALTER TABLE `corsi`
  MODIFY `idCorso` int NOT NULL AUTO_INCREMENT;

ALTER TABLE `docenti`
  MODIFY `idDocente` int NOT NULL AUTO_INCREMENT;

ALTER TABLE `iscrizioni`
  MODIFY `idIscrizione` int NOT NULL AUTO_INCREMENT;


ALTER TABLE `docenti`
  ADD CONSTRAINT `fk_idCorso` FOREIGN KEY (`idCorso`) REFERENCES `corsi` (`idCorso`) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE `iscrizioni`
  ADD CONSTRAINT `fk_idCorsoDipendente` FOREIGN KEY (`idCorso`) REFERENCES `corsi` (`idCorso`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `fk_idDocente` FOREIGN KEY (`idDocente`) REFERENCES `docenti` (`idDocente`) ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;
