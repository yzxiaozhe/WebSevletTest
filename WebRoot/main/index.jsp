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
<script type="text/javascript" src="js/jquery.js"></script>

</head>


<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    </ul>
    </div>
    
    <div class="mainindex">
    
    
    <div class="welinfo">
    <span><img src="images/sun.png" alt="天气" /></span>
    <b>Admin早上好，欢迎使用医疗信息管理系统</b>(admin@uimaker.com)
    <a href="#">帐号设置</a>
    </div>
    
    <div class="welinfo">
    <span><img src="images/time.png" alt="时间" /></span>
    <i>您上次登录的时间：2013-10-09 15:22</i> （不是您登录的？<a href="#">请点这里</a>）
    </div>
    
    <div class="xline"></div>
    
    <ul class="iconlist">
    
    <li><img src="images/ico01.png" /><p><a href="#">管理设置</a></p></li>
    <li><img src="images/ico02.png" /><p><a href="#">发布文章</a></p></li>
    <li><img src="images/ico03.png" /><p><a href="#">数据统计</a></p></li>
    <li><img src="images/ico04.png" /><p><a href="#">文件上传</a></p></li>
    <li><img src="images/ico05.png" /><p><a href="#">目录管理</a></p></li>
    <li><img src="images/ico06.png" /><p><a href="#">查询</a></p></li> 
            
    </ul>
    
    <div class="ibox"><a class="ibtn"><img src="images/iadd.png" />添加新的快捷功能</a></div>
    
    <div class="xline"></div>
    <div class="box"></div>
    
    <div class="welinfo">
    <span><img src="images/dp.png" alt="提醒" /></span>
    <b>医疗信息管理系统使用指南</b>
    </div>
    
    <ul class="infolist">
    <li><span>您可以快速进行文章发布管理操作</span><a class="ibtn">发布或管理文章</a></li>
    <li><span>您可以快速发布诊断</span><a class="ibtn">查看病人信息数据</a></li>
    <li><span>您可以进行密码修改、账户设置等操作</span><a class="ibtn">账户管理</a></li>
    </ul>
    
    <div class="xline"></div>
    
    <div class="uimakerinfo"><b>通过此医疗管理系统，您还可以了解更多功能并联系我们进行新的定制</b>(<a href="http://www.njucm.edu.cn/" target="_blank">http://www.njucm.edu.cn/</a>)</div>
    
    <ul class="umlist">
    <li><a href="#">如何定制功能</a></li>
    <li><a href="#">如何联系合作</a></li>
    <li><a href="#">如何深度优化</a></li>
    <li><a href="#">系统设置</a></li>
    </ul>
    
    
    </div>
    
    

</body>

</html>
