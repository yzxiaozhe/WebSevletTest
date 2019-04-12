<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<!-- 引入jQuery文件 -->
<script type="text/javascript" src="js/jquery.js"></script>
<!-- 声明代码域 -->
<script type="text/javascript">
	$(function(){
	
		$("#fm").submit(function(){
			
			if($("#wid").val()==""){//校验
				alert("病人id不能为空");
				return false;
			}else if($("#wname").val()==""){//校验
				alert("病人姓名不能为空");
				return false;
			}else if($("#wsex").val()==""){//校验
				alert("病人性别不能为空");
				return false;
			}else if($("#wage").val()==""){//校验
				alert("病人年龄不能为空");
				return false;
			}else if($("#wdis").val()==""){//校验
				alert("病人病情不能为空");
				return false;
			}else{
				return true;
			}
		})
	
	})
</script>

</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">糖尿病</a></li>
    <li><a href="#">增加信息</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>增加信息</span></div>
    <form action="user" method="post" id="fm">
    	<input name="oper" type="hidden" value="tangAdd" />
		<ul class="forminfo">
		    <li><label>病人ID</label><input name="tid" id="tid" type="text" class="dfinput" /><i></i></li>
		    <li><label>病人姓名</label><input name="tname" id="tname" type="text" class="dfinput" /><i></i></li>
		    <li><label>性别(男/女)</label><input name="tsex" id="tsex" type="text" class="dfinput" /><i></i></li>
		    <li><label>年龄</label><input name="tage" id="tage" type="text" class="dfinput" /><i></i></li>
		    <li><label>病情描述</label><input name="tdis" id="tdis" type="text" class="dfinput" /><i></i></li>
		    <li><label>病情建议</label><input name="tadv" id="tadv" type="text" class="dfinput" /><i></i></li>
		    <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存"/></li>
		   
	    </ul>
    </form>
    
    </div>


</body>

</html>

