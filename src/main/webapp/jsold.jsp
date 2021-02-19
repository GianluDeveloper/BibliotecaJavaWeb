<%@ page language="java" contentType="application/javascript; charset=UTF-8"
    pageEncoding="UTF-8"%>


const asideClick = (e) => {
  console.log(e);
  const href = e.href;
  console.log(href);
  if (href != undefined) {
    if (href.match(/remove/)) {
      e.preventDefault();

      fetch(href).then(() => {
        updateMain(window.actionName);
      });
      return false;
    }
  }
  const elem = e.target.getAttribute("data-link");
  console.log(elem);
  document.querySelector("aside").style.display = "inline";
  updateMain(elem);
};

const remove = (e) => {
  const href = e.href.split("#")[1];
  console.log("ok");
  fetch(href).then(() => {
    updateMain(e.getAttribute("data-link"));
  });
  return false;
};
const notImplemented = () => {
  alert("Funzione non implementata");
  return false;
};
const updateLink = async (e) => {
  console.log(e);
  console.log(this);
  const href = e.href;
  console.log("HREF", href);
  if (href != undefined) {
    const url = href.split("#")[1];
    const request = await fetch(url);
    const html = await request.text();
    document.querySelector("main").innerHTML = html;
  }
};
const gestisciForm = (e) => {
  console.log(e);
  const inputs = e.querySelectorAll("input");
  const action = e.action;
  if (inputs != undefined) {
    const data = "";
    let isFirst = true;
    inputs.forEach((p) => {
      console.log(p);
      const k = p.name;
      const v = p.value;
      if (k != undefined && v != undefined) {
        if (isFirst) {
          isFirst = false;
          data = +"&";
        }
        if (k == "admin") {
          if (p.checked)
            data += encodeURIComponent(k) + "=" + encodeURIComponent(v);
        } else {
          data += encodeURIComponent(k) + "=" + encodeURIComponent(v);
        }
      }
    });
    return false;
  }
  return false;
};
window.ActionName = "";

const handleForm = (e) => {
  console.log(e);

  const action = e.getAttribute("data-action");
  const inputs = e.querySelectorAll("input");

  let data = "";
  const dataObj = {};
  let isFirst = true;
  if (action != undefined && inputs != undefined) {
    const [url, azione] = action.split(":");

    for (let i = 0; i < inputs.length; i++) {
      const el = inputs[i];
      const k = el.name;
      const v = el.value;

      const toAppend = encodeURIComponent(k) + "=" + encodeURIComponent(v);

      if (k == "admin") {
        if (el.checked) {
          if (i > 0) {
            data += "&";
          }
          data += toAppend;
        }
      } else {
        if (i > 0) {
          data += "&";
        }
        data += toAppend;
      }
      dataObj[k] = v;
    }
    console.log(data);
    if (azione == "findBykv") {
      const selectObj = document.querySelector("select");
      const value = selectObj.options[selectObj.selectedIndex].value;
      data += "&" + encodeURIComponent("k") + "=" + encodeURIComponent(value);
      console.log(data);
      fetch(url, {
        method: "post",
        headers: {
          Accept: "application/json, text/plain, */*",
          "Content-Type": "application/x-www-form-urlencoded;charset=UTF-8",
        },
        body: data,
      })
        .then((t) => t.text())
        .then((resp) => {
          document.querySelector("main").innerHTML = resp;
        });
    } else {
      fetch(url, {
        method: "post",
        headers: {
          Accept: "application/json, text/plain, */*",
          "Content-Type": "application/x-www-form-urlencoded;charset=UTF-8",
        },
        body: data,
      }).then(t=>t.text()).then((txt) => {
        let azioneFatta = "inserito";
        if (azione == "update") azioneFatta = "aggiornato";
        let msg="<h2>" + url + " " + azioneFatta + " con successo</h2>";
        msg="<h2>"+txt+"</h2>";
        document.querySelector("main").innerHTML = msg;
      });
    }
  }
  return false;
};
const updateMain = async (actionName) => {
  document.querySelector("aside").style.display = "inline";

  let data;
  if (actionName == "Home") {
    document.querySelector("aside").style.display = "none";
  } else if (actionName == "Dipendente") {
    data = await fetch(
      "${pageContext.request.contextPath}/insertDipendente.html?_=" +
        new Date().getTime()
    );
  } else if (actionName == "DipendenteFind") {
    data = await fetch(
      "${pageContext.request.contextPath}/findBykv.jsp?type=Dipendente&_=" +
        new Date().getTime()
    );
  } else if (actionName == "DipendenteAll") {
    data = await fetch(
      "${pageContext.request.contextPath}/Dipendenti?azione=findAll&_=" +
        new Date().getTime()
    );
  } else if (actionName == "Libri") {
    data = await fetch(
      "${pageContext.request.contextPath}/insertLibro.html?_=" +
        new Date().getTime()
    );
  } else if (actionName == "LibriFind") {
    data = await fetch(
      "${pageContext.request.contextPath}/findBykv.jsp?type=Libri&_=" +
        new Date().getTime()
    );
  } else if (actionName == "LibriAll") {
    data = await fetch(
      "${pageContext.request.contextPath}/Libri?azione=findAll&_=" +
        new Date().getTime()
    );
  } else if (actionName == "RegistroLibri") {
    data = await fetch(
      "${pageContext.request.contextPath}/insertRegistro.html?_=" +
        new Date().getTime()
    );
  } else if (actionName == "RegistroLibriFind") {
    data = await fetch(
      "${pageContext.request.contextPath}/findBykv.jsp?type=RegistroLibri&_=" +
        new Date().getTime()
    );
  } else if (actionName == "RegistroLibriAll") {
    data = await fetch(
      "${pageContext.request.contextPath}/RegistroLibri?azione=findAll&_=" +
        new Date().getTime()
    );
  } else if (actionName == "Turni") {
    data = await fetch(
      "${pageContext.request.contextPath}/insertTurno.html?_=" +
        new Date().getTime()
    );
  } else if (actionName == "TurniFind") {
    data = await fetch(
      "${pageContext.request.contextPath}/findBykv.jsp?type=Turni&_=" +
        new Date().getTime()
    );
  } else if (actionName == "TurniAll") {
    data = await fetch(
      "${pageContext.request.contextPath}/Turni?azione=findAll&_=" +
        new Date().getTime()
    );
  } else if (actionName == "Cliente") {
    data = await fetch(
      "${pageContext.request.contextPath}/insertCliente.html?_=" +
        new Date().getTime()
    );
  } else if (actionName == "ClienteFind") {
    data = await fetch(
      "${pageContext.request.contextPath}/findBykv.jsp?type=Cliente&_=" +
        new Date().getTime()
    );
  } else if (actionName == "ClienteAll") {
    data = await fetch(
      "${pageContext.request.contextPath}/Cliente?azione=findAll&_=" +
        new Date().getTime()
    );
  } else if (actionName == "ContoCorrente") {
    data = await fetch(
      "${pageContext.request.contextPath}/Dipendenti?azione=ewallet&azioneEwallet=findAll&tipo=TipoMovimento&_=" +
        new Date().getTime()
    );
  } else if (actionName == "ContoCorrenteFind") {
    data = await fetch(
      "${pageContext.request.contextPath}/Dipendenti?azione=ewallet&azioneEwallet=findAll&tipo=Movimenti&_=" +
        new Date().getTime()
    );
  } else if (actionName == "ContoCorrenteAll") {
    data = await fetch(
      "${pageContext.request.contextPath}/Dipendenti?azione=ewallet&azioneEwallet=findAll&tipo=ContoCorrente&_=" +
        new Date().getTime()
    );
  }  else if (actionName == "IscrizioniAll") {
    data = await fetch(
      "${pageContext.request.contextPath}/CorsiEJB?type=Iscrizioni&azione=findAll&_=" +
        new Date().getTime()
    );
  }
   else if (actionName == "DocentiAll") {
    data = await fetch(
      "${pageContext.request.contextPath}/CorsiEJB?type=Docenti&azione=findAll&_=" +
        new Date().getTime()
    );
  }
   else if (actionName == "CorsiAll") {
    data = await fetch(
      "${pageContext.request.contextPath}/CorsiEJB?type=Corsi&azione=findAll&_=" +
        new Date().getTime()
    );
  }
  else {
    return;
  }

  const html = await data.text();
  window.ActionName = actionName;
  //html=html.replace("{var}",actionName);
  document.querySelector("main").innerHTML = html;
};

(() => {
  document.querySelectorAll("a").forEach((d) => {
    d.addEventListener("click", asideClick);
  });
})();




