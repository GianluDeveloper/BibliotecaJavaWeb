<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/resources/css/all.min.css" var="coreCss" />
<spring:url value="/my.css" var="myCss" />
<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Gestionale Biblioteca</title>
<link rel="stylesheet" href="${coreCss}" />
<link rel="stylesheet" href="${myCss}" />

</head>
<body>
	<div class="container" id="container">
		<header>
			<nav aria-label="Gestionale Biblioteca">
				<a href="${pageContext.request.contextPath}"> <em
					class="fa fa-book"></em>&nbsp;Gestionale Biblioteca
				</a>
			</nav>
			<nav aria-label="Home" data-link="Home">
				<a href="${pageContext.request.contextPath}"><em
					class="fa fa-home"></em>&nbsp;Home </a>
			</nav>
			<nav aria-label="Logout">
				<a href="#" onclick="return notImplemented()"><em
					class="fa fa-sign-in-alt"></em>&nbsp;Logout</a>
			</nav>
		</header>
		<aside>
			<h3>Menu Azioni</h3>
			<div class="oggettoAside">
				<h4>Clienti</h4>
				<div class="azione">
					<a href="#" data-link="Cliente">Inserisci cliente</a>
				</div>
				<div class="azione">
					<a href="#" data-link="ClienteFind">Trova clienti</a>
				</div>
				<div class="azione">
					<a href="#" data-link="ClienteAll">Lista clienti</a>
				</div>
			</div>
			<div class="oggettoAside">
				<h4>Dipendenti</h4>
				<div class="azione">
					<a href="#" data-link="Dipendente">Inserisci Dipendente</a>
				</div>
				<!--           <div class="azione"><a href="#">Aggiorna Dipendente</a></div> -->
				<div class="azione">
					<a href="#" data-link="DipendenteFind">Trova Dipendenti</a>
				</div>
				<div class="azione">
					<a href="#" data-link="DipendenteAll">Lista Dipendenti</a>
				</div>
			</div>
			<div class="oggettoAside">
				<h4>Libri</h4>
				<div class="azione">
					<a href="#" data-link="Libri">Inserisci Libro</a>
				</div>
				<!--           <div class="azione"><a href="#">Aggiorna Libro</a></div> -->
				<div class="azione">
					<a href="#" data-link="LibriFind">Trova Libri</a>
				</div>
				<div class="azione">
					<a href="#" data-link="LibriAll">Lista Libri</a>
				</div>
			</div>
			<div class="oggettoAside">
				<h4>Registro Libri</h4>
				<div class="azione">
					<a href="#" data-link="RegistroLibri">Inserisci Registro Libri</a>
				</div>
				<!--           <div class="azione"><a href="#">Aggiorna Registro Libri</a></div> -->
				<div class="azione">
					<a href="#" data-link="RegistroLibriFind">Trova Registri Libri</a>
				</div>
				<div class="azione">
					<a href="#" data-link="RegistroLibriAll">Lista Registri Libri</a>
				</div>
			</div>
			<div class="oggettoAside">
				<h4>Turni</h4>
				<div class="azione">
					<a href="#" data-link="Turni">Inserisci Turno</a>
				</div>
				<!--           <div class="azione"><a href="#">Aggiorna Turno</a></div> -->
				<div class="azione">
					<a href="#" data-link="TurniFind">Trova Turni</a>
				</div>
				<div class="azione">
					<a href="#" data-link="TurniAll">Lista Turni</a>
				</div>
			</div>
			<div class="oggettoAside">
				<h4>Conti Correnti</h4>
				<div class="azione">
					<a href="#" data-link="ContoCorrente">Tutti i Tipi Movimento</a>
				</div>
				<div class="azione">
					<a href="#" data-link="ContoCorrenteFind">Lista Movimenti</a>
				</div>
				<div class="azione">
					<a href="#" data-link="ContoCorrenteAll">Lista Conti Correnti</a>
				</div>
			</div>





			<div class="oggettoAside">
				<h4>Corsi</h4>
				<div class="azione">
					<a href="#" data-link="CorsiAll">Lista Corsi</a>
				</div>
				<div class="azione">
					<a href="#" data-link="DocentiAll">Lista Docenti</a>
				</div>
				<div class="azione">
					<a href="#" data-link="IscrizioniAll">Lista Iscrizioni</a>
				</div>
			</div>



		</aside>
		<main>
			<section>
				<h2>Clienti</h2>
				<div class="azione">
					<a href="#" data-link="Cliente"><em
						class="fa fa-plus fa-fw"></em>&nbsp;Inserisci cliente</a>
				</div>
				<!--           <div class="azione"> -->
				<!--             <a href="#" -->
				<!--               ><em class="fa fa-edit fa-fw"></em>&nbsp;Aggiorna cliente</a -->
				<!--             > -->
				<!--           </div> -->
				<div class="azione">
					<a href="#" data-link="ClienteFind"><em
						class="fa fa-search fa-fw"></em>&nbsp;Trova clienti</a>
				</div>
				<div class="azione">
					<a href="#" data-link="ClienteAll"><em
						class="fa fa-list fa-fw"></em>&nbsp;Lista clienti</a>
				</div>
			</section>
			<section>
				<h2>Dipendenti</h2>
				<div class="azione">
					<a href="#" data-link="Dipendente"><em
						class="fa fa-plus fa-fw"></em>&nbsp;Inserisci dipendente</a>
				</div>
				<!--           <div class="azione"> -->
				<!--             <a href="#" -->
				<!--               ><em class="fa fa-edit fa-fw"></em>&nbsp;Aggiorna dipendente</a -->
				<!--             > -->
				<!--           </div> -->
				<div class="azione">
					<a href="#" data-link="DipendenteFind"><em
						class="fa fa-search fa-fw"></em>&nbsp;Trova dipendenti</a>
				</div>
				<div class="azione">
					<a href="#" data-link="DipendenteAll"><em
						class="fa fa-list fa-fw"></em>&nbsp;Lista dipendenti</a>
				</div>
			</section>
			<section>
				<h2>Turni</h2>
				<div class="azione">
					<a href="#" data-link="Turni"><em
						class="fa fa-plus fa-fw"></em>&nbsp;Inserisci turno</a>
				</div>
				<!--           <div class="azione"> -->
				<!--             <a href="#" -->
				<!--               ><em class="fa fa-edit fa-fw"></em>&nbsp;Aggiorna turno</a -->
				<!--             > -->
				<!--           </div> -->
				<div class="azione">
					<a href="#" data-link="TurniFind"><em
						class="fa fa-search fa-fw"></em>&nbsp;Trova turni</a>
				</div>
				<div class="azione">
					<a href="#" data-link="TurniAll"><em class="fa fa-list fa-fw"></em>&nbsp;Lista
						turni</a>
				</div>
			</section>
			<section>
				<h2>Libri</h2>
				<div class="azione">
					<a href="#" data-link="Libri"><em
						class="fa fa-plus fa-fw"></em>&nbsp;Inserisci libro</a>
				</div>
				<!--           <div class="azione"> -->
				<!--             <a href="#" -->
				<!--               ><em class="fa fa-edit fa-fw"></em>&nbsp;Aggiorna libro</a -->
				<!--             > -->
				<!--           </div> -->
				<div class="azione">
					<a href="#" data-link="LibriFind"><em
						class="fa fa-search fa-fw"></em>&nbsp;Trova libri</a>
				</div>
				<div class="azione">
					<a href="#" data-link="LibriAll"><em class="fa fa-list fa-fw"></em>&nbsp;Lista
						libri</a>
				</div>
			</section>
			<section>
				<h2>Registro Libri</h2>
				<div class="azione">
					<a href="#" data-link="RegistroLibri"><em
						class="fa fa-plus fa-fw"></em>&nbsp;Inserisci Registro Libri</a>
				</div>
				<!--           <div class="azione"> -->
				<!--             <a href="#" -->
				<!--               ><em class="fa fa-edit fa-fw"></em>&nbsp;Aggiorna Registro -->
				<!--               Libri</a -->
				<!--             > -->
				<!--           </div> -->
				<div class="azione">
					<a href="#" data-link="RegistroLibriFind"><em
						class="fa fa-search fa-fw"></em>&nbsp;Trova Registri Libri</a>
				</div>
				<div class="azione">
					<a href="#" data-link="RegistroLibriAll"><em
						class="fa fa-list fa-fw"></em>&nbsp;Lista Registri Libri</a>
				</div>
			</section>
			<section>
				<h2>Conti Correnti</h2>
				<div class="azione">
					<a href="#" data-link="ContoCorrente"><em
						class="fa fa-dollar-sign fa-fw"></em>&nbsp;Tutti i Tipi Movimento</a>
				</div>
				<div class="azione">
					<a href="#" data-link="ContoCorrenteFind"><em
						class="fa fa-money-check-alt fa-fw"></em>&nbsp;Lista Movimenti</a>
				</div>
				<div class="azione">
					<a href="#" data-link="ContoCorrenteAll"><em
						class="fa fa-search-dollar fa-fw"></em>&nbsp;Lista Conti Correnti</a>
				</div>
			</section>


			<section>
				<h2>Corsi</h2>
				<div class="azione">
					<a href="#" data-link="CorsiAll"><em
						class="fa fa-graduation-cap fa-fw"></em>&nbsp;Lista Corsi</a>
				</div>
				<div class="azione">
					<a href="#" data-link="DocentiAll"><em
						class="fa fa-chalkboard-teacher fa-fw"></em>&nbsp;Lista Docenti</a>
				</div>
				<div class="azione">
					<a href="#" data-link="IscrizioniAll"><em
						class="fa fa-clipboard-list fa-fw"></em>&nbsp;Lista Iscrizioni</a>
				</div>
			</section>

		</main>
		<footer>
			&copy; 2021 <a href="https://gianlu.dev/">Gianlu.dev</a> - Tutti i
			diritti sono riservati.
		</footer>
	</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js.jsp"></script>
</body>
</html>
