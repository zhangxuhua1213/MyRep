
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <!-- Set render engine for 360 browser -->
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">


    <link href="/CSS/index.css"  rel="stylesheet" type="text/css">

</head>
<body>
<div class="admin_index">
    <div class="layer">
        <div class="modular">
            <span class="title"><a>会员统计</a></span>
            <span class="info"><a>注册总量：</a><a class="data">${indexMode.totalRegister}</a></span>
            <span class="info"><a>今日注册数量：</a><a class="data">${indexMode.todayRegisterNums}</a></span>
            <span class="info"><a>今日充值用户数量：</a><a class="data">${indexMode.todayChargNums}</a></span>
            <span class="info"><a>昨天注册数量：</a><a class="data">${indexMode.yestodayRegisterNums}</a></span>
            <span class="info"><a>昨天充值用户数量：</a><a class="data">${indexMode.yestodayChargNums}</a></span>
            <span class="info"><a>本周注册数量：</a><a class="data">${indexMode.weekRegisterNums}</a></span>
            <span class="info"><a>本月注册数量：</a><a class="data">${indexMode.monthRegisterNums}</a></span>
            <span class="info"></span>
        </div>
    </div>
</div>
</body>
</html>
