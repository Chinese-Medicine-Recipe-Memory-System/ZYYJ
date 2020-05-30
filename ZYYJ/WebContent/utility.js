var xmlhttp;

function loadExternalPage(url){
	xmlhttp = null;
	if(window.XMLHttpRequest){
		xmlhttp = new XMLHttpRequest();
	}
	else if(window.ActiveXObject){
		xmlhttp = new ActiveXObject();
	}
	
	if(xmlhttp != null){
		xmlhttp.onreadystatechange = state_change;
		xmlhttp.open('GET', url, true);
		xmlhttp.send(null);
	}
}

function state_change(){
	if(xmlhttp.readyState == 4){
		if(xmlhttp.status == 200){
			document.getElementById('main').innerHTML = xmlhttp.responseText;
		}
		else{
			alert("加载错误: " + xmlhttp.statusText);
		}
	}
}