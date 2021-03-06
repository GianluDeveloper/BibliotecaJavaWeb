<%@ page language="java" contentType="text/css; charset=UTF-8"
    pageEncoding="UTF-8"%>
@font-face{
    font-family: "Gidole";
    src:url("${pageContext.request.contextPath}/css/Gidole-Regular.ttf");
}

.container {
  display: grid;
  grid-template-columns: repeat(9, 1fr);
  grid-auto-rows: minmax(50px, auto);
  grid-template-areas:
    "hd hd hd hd   hd   hd   hd   hd   hd"
    "as . main main main main main main ."
    "ft ft ft ft   ft   ft   ft   ft   ft";
  row-gap: 1em;
  column-gap: 1em;
  font-family: "Gidole";
}
aside{
    display:none;
}
aside a:visited {
	color:rgb(0,0,255);
}
.containerNoSidebar {
  display: grid;
  grid-template-columns: repeat(9, 1fr);
  grid-auto-rows: minmax(50px, auto);
  grid-template-areas:
    "hd hd hd hd   hd   hd   hd   hd   hd"
    "main main main main main main main main main"
    "ft ft ft ft   ft   ft   ft   ft   ft";
  row-gap: 1em;
  column-gap: 1em;
}

header {
  grid-area: hd;
  display: grid;
  grid-column-gap: 1em;
  grid-auto-flow: column;
  justify-items: center;
  align-items: center;
  position: fixed;
  background-color: rgba(255, 255, 255, 0.8);
  margin: 5px;
  padding: 5px;
  border-radius:10px;
}
header > nav {
  margin-left: 2em;
  padding:10px;
  border-radius:10px;  
  background: linear-gradient(220deg,  rgba(144, 174, 255, 0.4) ,rgba(168, 181, 238, 0.5) 50%); 
  box-shadow: -3px 3px  rgba(16, 34, 68, 0.3);

}
header > nav>a:hover{
    color:blue;
}

header > nav:nth-child(3) {
  margin-left: 0px;
}

header > nav:nth-child(1) {
    letter-spacing: 2px;
}
header > nav > a {
  text-decoration: none;
  color: #5f6368;
  font-size: 1.2em;
}
aside {
  grid-area: as;
  min-height: 600px;
  text-align: center;
  padding:10px;
  border-radius: 10px;
  border:1px dashed ;
}
.azione{
    padding:5px;
}
.azione a{
    text-decoration:none;
}
.azione a:hover{
    font-style: italic;
}
main {
  grid-area: main;
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  grid-template-rows: auto 1fr; 
  padding:10px;
}
main a {
    font-size: 1.2em;
    color:#2c4563;
}

main a .fa {
    color:#4560E6;
}

main h2{
    color:#001061;
    padding-left: 20px;
}
main h2::first-letter{
    color:red;
}
footer {
  grid-area: ft;
  text-align: center;
  vertical-align: middle;
  margin-top:100px;
}
footer a {
    text-decoration: none;

}
 input, select, textarea {
    font-family: inherit;
    font-size: 100%;
    box-sizing: border-box;
    border-color: rgba(39, 38, 38, 0.5);
    border-radius: 10px;
    padding:10px;
    margin-top:5px;
    margin-bottom:10px;
    min-width: 100px;
    box-shadow: -2px 2px rgba(16, 20, 248, 0.2);
    background-color: rgb(255, 255, 255);
    transition: background-color 0.5s ease-out;

}



button{
    border-color: rgba(119, 119, 119,0.5);
    border-radius: 10px;
    padding:10px;
    font-family: inherit;
    font-size: 100%;
    font-weight: bold;
    box-shadow: -2px 2px rgba(16, 20, 248, 0.2);
    background-color: rgb(240, 240, 240)
}
button:hover{
    background-color: rgba(173, 150, 150,0.5)

}
label{
    color:rgb(15, 15, 15);
    margin-left: 10px;
    font-weight: bold;
    font-size: larger;
}
#customers {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

table th {
  border: 1px solid #ddd;
  padding: 8px;
  border-radius: 5px;

}
table td{
  padding:5px;
  border-radius: 5px;

}
table{
  text-align: center;
}

table tr:nth-child(even){background-color: #f2f2f2;}

table tr:hover {background-color: #ddd;}

table th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: center;
  background-color: rgba(16, 20, 248, 0.2);
  color: rgb(15, 15, 15);
}
input[type="radio"]{
	box-shadow: 0px 0px rgba(255, 255, 255, 0.2);
	
	min-width:0px;transform: scale(1);
	border-color: rgba(255,255,255,1);
	
}

.addEwallet:hover{
	transform: scale(1.5);
	transition:ease-in-out 0.2s;
}

@media (max-width: 700px) {
  .container {
    grid-template-columns: repeat(2, 1fr);

    grid-template-areas:
      " hd hd "
      " main main "
      " ft ft ";
  }
  header > nav {
    margin-left: 1px;
    padding:5px;
    background-color: rgba(255,255,255);
    border-radius:10px;  
  
  }
  aside {
    display: none;
  }
  header > * {
    margin-left: 0px;
  }
  header > nav:first-child {
    margin-right: 0px;
  }
  header > nav:nth-child(2) {
    margin-left: 0px;
  }
  main {
    margin-top: 20px;
    grid-area: main;
    display: grid;
    grid-template-columns: repeat(1, 1fr);
    grid-auto-rows: minmax(50px, auto);
    padding:10px;
    text-align: center;
  }
}


