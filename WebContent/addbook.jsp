<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>添加书籍</title>

    <!-- Bootstrap core CSS -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="../../assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="starter-template.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

<SCRIPT language="javascript">  
function checkNum(obj) {    
     //检查是否是非数字值    
     if (isNaN(obj.value)) {    
         obj.value = "";    
     }    
     if (obj != null) {    
         //检查小数点后是否对于两位  
         if (obj.value.toString().split(".").length > 1 && obj.value.toString().split(".")[1].length > 2) {    
             alert("小数点后不能多于两位！");    
             obj.value = "";    
         }    
     }    
 }
function IsISBN(obj){
    var reg=/^(\d{3})-(\d)-(\d{3})-(\d{5})-(\d{1})$/;
    if (obj.value=='') {
    		alert("ISBN格式输出错误"); 
    }
    var arr=reg.exec(obj.value);

    if(!reg.test(obj.value)){
    		alert("ISBN格式输出错误"); 
        obj.value = ""; 
    }
}
function IsDate(obj){
    var reg=/^(\d{4})-(\d{2})-(\d{2})$/;
    if (obj.value=='') {
    		alert("日期格式输出错误"); 
    }
    var arr=reg.exec(obj.value);

    if(!reg.test(obj.value) || parseInt(RegExp.$2)>12 || parseInt(RegExp.$3)>31){
    		alert("日期格式输出错误"); 
        obj.value = ""; 
    }
}
</SCRIPT> 
</head>
<body>

	<div>
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <a class="navbar-brand" href="/lab2">图书管理系统</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
    </div>
    <br/><br/><br/><br/>
    <div class="container theme-showcase" role="main">

      <!-- Main jumbotron for a primary marketing message or call to action -->
      <div class="jumbotron">
        <h1>添加书籍</h1>
        <p>请您在此添加书籍信息</p>
      </div>


<div style="text-align: center">
      <div class="page-header">
        <h1>图书信息</h1>
      </div>
<form action="addbook" method="post">

          <div class="panel panel-default">
            <div class="panel-heading">
              <h3 class="panel-title">作者ID</h3>
            </div>
            <div class="panel-body">
              <input type="text" name="authorID" value=<s:property value="selectedAuthor"/> readonly="true"/>
            </div>
          </div>

          <div class="panel panel-default">
            <div class="panel-heading">
              <h3 class="panel-title">ISBN</h3>
            </div>
            <div class="panel-body">
			<input type="text" name="isbn" onblur="IsISBN(this)" placeholder="XXX-X-XXX-XXXXX-X"/>
            </div>
          </div>

          <div class="panel panel-default">
            <div class="panel-heading">
              <h3 class="panel-title">图书标题</h3>
            </div>
            <div class="panel-body">
			<input type="text" name="title"/>
            </div>
          </div>

          <div class="panel panel-default">
            <div class="panel-heading">
              <h3 class="panel-title">出版商</h3>
            </div>
            <div class="panel-body">
			<input type="text" name="publisher"/>
            </div>
          </div>

          <div class="panel panel-default">
            <div class="panel-heading">
              <h3 class="panel-title">出版日期</h3>
            </div>
            <div class="panel-body">
				<input type="text" name="publishDate" onblur="IsDate(this)" placeholder="YYYY-MM-DD"/>
            </div>
          </div>

          <div class="panel panel-default">
            <div class="panel-heading">
              <h3 class="panel-title">价格</h3>
            </div>
            <div class="panel-body">
				<input type="text" name="price" onkeyup="checkNum(this)"/>
            </div>
          </div>
          
<input type="submit" class="btn btn-success" value="确认"/>
</form>
</div>
    </div>
</body>
</html>

