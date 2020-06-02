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

// 用搜索结果更改页面
function search_state_change(externalPage){
	if(xmlhttp.readyState == 4){
		if(xmlhttp.status == 200){
			document.getElementById('add-button').innerHTML = "<a href='#' onclick=\"loadExternalPage('" + externalPage + "')\">显示全部</a>";
			document.getElementById('table-tbody').innerHTML = xmlhttp.responseText;
		}
		else{
			alert("搜索出错: " + xmlhttp.statusText);
		}
	}
}

// 获取搜索结果
function search(url, externalPage){
	var input = document.getElementById("search-input").value;
	var option = document.getElementById("search-option").value;
	if(input != ""){
		if(xmlhttp!=null){
			var post_data = "input=" + input + "&option=" + option;
			
			xmlhttp.onreadystatechange = function(){search_state_change(externalPage);}
			xmlhttp.open('post', url, true);
			xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded;charset=utf-8");
			xmlhttp.send(post_data);
		}
	}
	else{
		alert("请输入搜索内容");
	}
}