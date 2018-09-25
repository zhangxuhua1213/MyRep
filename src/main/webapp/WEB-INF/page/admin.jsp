
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>代理后台</title>
    <link rel="stylesheet" href="/layui/css/layui.css">
    <script>
        function changeSrc(srcStr)
        {
            document.getElementById("demoAdmin").src=srcStr;
        }
    </script>

</head>
<body class="layui-layout-body" >
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">代理后台</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a style="cursor:pointer;" onclick="changeSrc('page.do?uri=index')">首页</a></li>
           <%-- <li class="layui-nav-item"><a href="">商品管理</a></li>
            <li class="layui-nav-item"><a href="">用户</a></li>
            <li class="layui-nav-item">
                <a href="javascript:;">其它系统</a>
                <dl class="layui-nav-child">
                    <dd><a href="">邮件管理</a></dd>
                    <dd><a href="">消息管理</a></dd>
                    <dd><a href="">授权管理</a></dd>
                </dl>
            </li>--%>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                    ${username}
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="/login.html">退出</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">财务管理</a>
                    <dl class="layui-nav-child">
                        <dd><a style="cursor:pointer;" onclick="changeSrc('page.do?uri=active')">激活记录</a></dd>
                        <dd><a style="cursor:pointer;" onclick="changeSrc('page.do?uri=kamiList')">卡密列表</a></dd>
                        <dd><a style="cursor:pointer;" onclick="changeSrc('page.do?uri=addKami')">新增卡密</a></dd>
                        <dd><a style="cursor:pointer;" onclick="changeSrc('page.do?uri=jifenList')">充值积分记录</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">代理商管理</a>
                    <dl class="layui-nav-child">
                        <dd><a style="cursor:pointer;" onclick="changeSrc('page.do?uri=myExtend')">我的推广</a></dd>
                        <dd><a  style="cursor:pointer;" onclick="changeSrc('page.do?uri=listDaili')">代理列表</a></dd>
                        <dd><a style="cursor:pointer;" onclick="changeSrc('page.do?uri=addUser')">新增代理</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">系统设置</a>
                    <dl class="layui-nav-child">
                        <dd><a style="cursor:pointer;" onclick="changeSrc('page.do?uri=resetDaili')">代理设置</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body" style="margin-top: 20px;">
        <iframe src="page.do?uri=index" frameborder="0" id="demoAdmin" style="width: 101%;height: 98%" scrolling="auto"></iframe>
    </div>

</div>
<script src="/layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });
</script>
</body>
</html>