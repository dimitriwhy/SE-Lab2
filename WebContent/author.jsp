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

    <title>添加作者</title>

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
        <h1>添加作者</h1>
        <p>您可以在这里添加新的作者</p>
      </div>
    </div>
    



<div class="container theme-showcase" role="main" style="text-align: center">
<form class="form-horizontal" action="addauthor" method="post">
      <div class="page-header">
        <h1>作者信息</h1>
      </div>
      
<div class="control-group">
    <label class="control-label" for="inputName">作者姓名</label>
    <div class="controls">
      <input type="text" name="name" placeholder="小明" />
    </div>
</div>

<div class="control-group">
    <label class="control-label" for="inputAge">作者年龄</label>
    <div class="controls">
<input onkeyup="this.value=this.value.replace(/\D/g,'')"
onafterpaste="this.value=this.value.replace(/\D/g,'')" 
name="age" placeholder=20 />
    </div>
</div>

<div class="control-group">
    <label class="control-label" for="inputCountry">作者国籍</label>
    <div class="controls">
      <input type="text" name="country" placeholder="中国" />
    </div>
</div>

  <div class="control-group">
    <div class="controls">
      <br/><input type="submit" class="btn btn-success" value="确认添加"/>
    </div>
  </div>

</form>
</div>




</body>
</html>

