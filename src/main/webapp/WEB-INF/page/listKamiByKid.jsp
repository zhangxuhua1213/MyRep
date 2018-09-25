

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
</head>
<body>

<table class="layui-hide" id="test" lay-filter="test"></table>
<div id="fenye"></div>

<script src="/layui/layui.js" charset="utf-8"></script>

<script>
    layui.use(['laypage','table'], function(){
        var table = layui.table
        table.render({
            elem: '#test'
            ,url:'/listKamiByKid.do?kid='+${kid}
            ,method:'post'
           // ,toolbar: '#toolbarDemo'
            ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            ,cols: [[
                {field:'code',  title: '卡密'}
                ,{field:'type', title: '类型', sort: true}
                ,{field:'createtime',  title: '生成时间'}
                ,{field:'status', title: '卡密状态'}
            ]]
            // ,page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem）
            //     layout: ['prev', 'page', 'next', 'skip','limit', 'count'] //自定义分页布局
            //     //,curr: 5 //设定初始在第 5 页
            //     ,groups: 1 //只显示 1 个连续页码
            //     ,first: false //不显示首页
            //     ,last: false //不显示尾页
            //     ,limits: [3,5,10]
            //     ,limit: 10 //每页默认显示的数量
            // }
            ,response: {
                statusCode: 200 //重新规定成功的状态码为 200，table 组件默认为 0
            }
            ,parseData: function(res){ //将原始数据解析成 table 组件所规定的数据
                return {
                    "code": res.status, //解析接口状态
                    "msg": res.message, //解析提示文本
                   // "count":res.count,
                    "data": res.data //解析数据列表
                };
            }
        });



    });

</script>

</body>
</html>