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

function updateModalPracticeProgramme(programmeID){
	$.ajax({
		type:"POST",
		dataType:"json",
		url:"/ZYYJ/getPracticeProgramme",
		data:{"programme_id" : programmeID},
		success: function(data){
			$("#programme_id").val(data.programme_id);
			$("#name").val(data.name);
			$("#course").val(data.course);
			$("#score").val(data.score);
			$("#note").val(data.note);
		},
		error: function(data){
			alert("更新模态框出错");
		}
	});
}

function updateModalCheckpoint(checkpointID){
	$.ajax({
		type:"POST",
		dataType:"json",
		url:"/ZYYJ/getCheckpointJSON",
		data:{"checkpoint_id" : checkpointID},
		success: function(data){
			$("#checkpoint_id").val(data.checkpoint_id);
			$("#name").val(data.name);
			$("#creator").val(data.creator);
			$("#programme").val(data.programme);
			$("#limit_time").val(data.limit_time);
			$("#question_num").val(data.question_num);
			$("#total_score").val(data.total_score);
			$("#pass_score").val(data.pass_score);
			$("#comment").val(data.comment);
		},
		error: function(data){
			alert("更新修改框出错");
		}
	});
}

function updateModalExamProgramme(examID){
	$.ajax({
		type:"POST",
		dataType:"json",
		url:"/ZYYJ/getExamProgramme",
		data:{"exam_id" : examID},
		success: function(data){
			$("#exam_id").val(data.exam_id);
			$("#name").val(data.name);
			$("#total_question").val(data.total_question);
			$("#total_score").val(data.total_score);
			$("#pass_score").val(data.pass_score);
			$("#question_num").val(data.question_num);
			$("#limit_time").val(data.limit_time);
			$("#course").val(data.course);
		},
		error: function(data){
			alert("更新修改框出错");
		}
	});
}

function updateModalExchangeRule(ruleID){
	$.ajax({
		type:"POST",
		dataType:"json",
		url:"/ZYYJ/getExchangeRuleJSON",
		data:{"rule_id" : ruleID},
		success: function(data){
			$("#rule_id").val(data.rule_id);
			$("#name").val(data.name);
			$("#score").val(data.score);
			$("#integral").val(data.integral);
		},
		error: function(data){
			alert("更新修改框出错");
		}
	});
}