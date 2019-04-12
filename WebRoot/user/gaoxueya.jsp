<%@ page language="java" import="java.util.*,com.zhe.pojo.*" pageEncoding="utf-8"%>
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
<script type="text/javascript" src="js/jquery.js"></script>

<script type="text/javascript">
$(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

});
</script>


</head>


<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">高血压</a></li>
    <li><a href="#">查看病人信息</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    
    
    <table class="tablelist">
    	<thead>
    	<tr>
        <th>病人ID<i class="sort"><img src="images/px.gif" /></i></th>
      	<th>病人姓名</th>
        <th>性别</th>
        <th>年龄</th>
     	<th>病情描述</th>
     	<th>病情建议</th>
     	<th>操作</th>
        </tr>
        </thead>
       <tbody>
        <%
        	List<Sick> gao=(ArrayList<Sick>)request.getAttribute("gao");
        	for(Sick s:gao){
        %>
        <tr>
        <td><%=s.getUid() %></td>
        <td><%=s.getUname() %></td>
    	<td><%=s.getSex() %></td>
    	<td><%=s.getAge() %></td>
    	<td><%=s.getSickroom() %></td>
    	<td><%=s.getAdvice() %></td>
    	
    	<td><a href="#" class="tablelink">查看</a>     <a href="user?oper=delete&id=<%=s.getUid()%>" onclick='return confirm("是否要删除<%=s.getUname()%>?")'> 删除</a></td>
        </tr> 
        <%} %>
        </tbody>
       
    </table>
    
   
  
    
    
    
    
    
    
    
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>

</body>

</html>