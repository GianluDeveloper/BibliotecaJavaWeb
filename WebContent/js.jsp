<%@ page language="java" contentType="application/javascript; charset=UTF-8"
    pageEncoding="UTF-8"%>

const asideClick = (e) => {
console.log(e)
  const href = e.href;
  console.log(href)
  if(href!=undefined){
  	  if(href.match(/remove/)){
  	    	  		e.preventDefault();
  	  
  	  		fetch(href).then(()=>{
  	  			updateMain(window.actionName)
  	  		});
  	  		return false;
  	  }
  }
  const elem = e.target.getAttribute("data-link");
  console.log(elem);
  document.querySelector("aside").style.display = "inline";
  updateMain(elem);
};

const remove= (e)=>{
  	  	const href = e.href.split("#")[1];
  	  	console.log("ok")
  		fetch(href).then(()=>{
  			updateMain(e.getAttribute("data-link"))
  		});
  		return false;
}
const notImplemented = () => {
  alert("Funzione non implementata");
  return false;
};
const updateLink =async (e)=>{
	console.log(e);console.log(this);
	const href= e.href;
	console.log("HREF",href);
	if(href!=undefined){
		const url = href.split("#")[1];
		const request = await fetch(url);
		const html = await request.text();
		  document.querySelector("main").innerHTML = html;
	}
	
};
const gestisciForm = (e)=>{
	console.log(e);
	const inputs = e.querySelectorAll("input");
	const action =  e.action;
	if(inputs!=undefined){
		const data = "";
		let isFirst = true;
		inputs.forEach((p)=>{
			console.log(p)
			const k = p.name;
			const v = p.value;
			if(k!=undefined && v!=undefined){
				if(isFirst){isFirst=false;data=+"&";}
				data+=encodeURIComponent(k)+"="+encodeURIComponent(v);
			}
			
		})
		return false;
		fetch(action, {
		    method: 'post',
		    headers: {
		        'Accept': 'application/json, text/plain, */*',
		        'Content-Type': 'application/json'
		    },
		    body: data
		}).then(p=>console.log(p))
	}
	return false;
};
window.ActionName = "";

const handleForm = (e)=>{
	console.log(e);
	
	const action = e.getAttribute("data-action");
	const inputs = e.querySelectorAll("input");
	
	
	let data = "";
	const dataObj={};
	let isFirst = true;
	if(action!=undefined&& inputs!=undefined){
		
		const [url,azione] = action.split(":");
		
		for(let i= 0; i<inputs.length;i++){
			const el = inputs[i];
			const k = el.name;
			const v = el.value;
			if(i>0){
				data+="&";
			}
			const toAppend=encodeURIComponent(k)+"="+encodeURIComponent(v);
			data+=toAppend;
			dataObj[k]=v;
		}
		console.log(data)
		if(azione=='findBykv'){
			const selectObj=document.querySelector("select");
			const value = selectObj.options[selectObj.selectedIndex].value;
			data+="&"+encodeURIComponent("k")+"="+encodeURIComponent(value);
			console.log(data)
		    fetch(url, {
			    method: 'post',
			    headers: {
			        'Accept': 'application/json, text/plain, */*',
	   				 'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
			    },
			    body: data
			}).then(t=>t.text()).then((resp)=>{
				document.querySelector("main").innerHTML = resp;
			})
		}else{
			fetch(url, {
			    method: 'post',
			    headers: {
			        'Accept': 'application/json, text/plain, */*',
	   				 'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
			    },
			    body: data
			}).then(()=>{
				let azioneFatta = "inserito";
				if(azione=="update")azioneFatta="aggiornato";
				document.querySelector("main").innerHTML = '<h2>'+url+" "+azioneFatta+' con successo</h2>';
			})
		}
	}
	return false;
};
const updateMain = async (actionName) => {
  document.querySelector("aside").style.display = "inline";

  let data;
  if(actionName=="Home"){
  		  document.querySelector("aside").style.display = "none";
  		
  }
  else if (actionName == "Dipendente") {
    data = await fetch("${pageContext.request.contextPath}/Dipendenti?azione=findAll&_="+new Date().getTime());
  }else if(actionName=="Cliente"){
      data = await fetch("${pageContext.request.contextPath}/insertCliente.html?_="+new Date().getTime());
  }else if(actionName=="ClienteFind"){
  	  data = await fetch("${pageContext.request.contextPath}/findBykv.html?_="+new Date().getTime());
  }
  else if(actionName=="ClienteAll"){
      data = await fetch("${pageContext.request.contextPath}/Cliente?azione=findAll&_="+new Date().getTime());
  } else {
    data = await fetch("${pageContext.request.contextPath}/insertDipendente.html?_="+new Date().getTime());
  }
  
  const html = await data.text();
  window.ActionName=actionName;
  //html=html.replace("{var}",actionName);
  document.querySelector("main").innerHTML = html;
  const state = { page_id: 1, user_id: 5 };
  const title = "";
  const url = "hello-world.html";
// document.querySelectorAll("main a").forEach((d) => {
//    d.addEventListener("click", asideClick);
//  });
  // history.pushState(state, title, url);
};

(() => {
  document.querySelectorAll("a").forEach((d) => {
    d.addEventListener("click", asideClick);
  });
  
})();