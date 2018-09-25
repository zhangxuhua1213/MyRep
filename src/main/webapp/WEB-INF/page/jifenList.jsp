
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

<%--<script type="text/html" id="toolbarDemo">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="getCheckData">获取选中行数据</button>
        <button class="layui-btn layui-btn-sm" lay-event="getCheckLength">获取选中数目</button>
        <button class="layui-btn layui-btn-sm" lay-event="isAll">验证是否全选</button>
    </div>
</script>--%>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <%--<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>--%>
</script>

<script src="/layui/layui.js" charset="utf-8"></script>
<%--<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">--%>

<%--</fieldset>--%>

<%--<div id="demo20"></div>--%>
<script>
    layui.use(['laypage','table'], function(){
        var table = layui.table
        table.render({
            elem: '#test'
            ,url:'/jifenList.do'
            ,method:'post'
            ,toolbar: '#toolbarDemo'
            ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            ,cols: [[
                //{type: 'checkbox', fixed: 'left'},
                {field:'id', title: 'ID', sort: true}
                ,{field:'userNicename',  title: '用户昵称'}
                ,{field:'jifen', title: '积分', sort: true}
                ,{field:'addtime',  title: '充值时间'}

            ]]
            ,page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem）
                layout: ['prev', 'page', 'next', 'skip','limit', 'count'] //自定义分页布局
                //,curr: 5 //设定初始在第 5 页
                ,groups: 1 //只显示 1 个连续页码
                ,first: false //不显示首页
                ,last: false //不显示尾页
                ,limits: [3,5,10]
                ,limit: 10 //每页默认显示的数量
            }
            ,response: {
                statusCode: 200 //重新规定成功的状态码为 200，table 组件默认为 0
            }
            ,parseData: function(res){ //将原始数据解析成 table 组件所规定的数据
                return {
                    "code": res.status, //解析接口状态
                    "msg": res.message, //解析提示文本
                    "count":res.count,
                    "data": res.data //解析数据列表
                };
            }
        });

        //头工具栏事件
        table.on('toolbar(test)', function(obj){
            var checkStatus = table.checkStatus(obj.config.id);
            switch(obj.event){
                case 'getCheckData':
                    var data = checkStatus.data;
                    layer.alert(JSON.stringify(data));
                    break;
                case 'getCheckLength':
                    var data = checkStatus.data;
                    layer.msg('选中了：'+ data.length + ' 个');
                    break;
                case 'isAll':
                    layer.msg(checkStatus.isAll ? '全选': '未全选');
                    break;
            };
        });

        //监听行工具事件
        table.on('tool(test)', function(obj){
            var data = obj.data;
            //console.log(obj)
            if(obj.event === 'del'){
                layer.confirm('真的删除行么', function(index){
                    obj.del();
                    layer.close(index);
                });
            } else if(obj.event === 'edit'){
                layer.prompt({
                    formType: 2
                    ,value: data.email
                }, function(value, index){
                    obj.update({
                        email: value
                    });
                    layer.close(index);
                });
            }
        });

    });

    /*  layui.use(['laypage', 'layer'], function() {
          var laypage = layui.laypage
              , layer = layui.layer;
          //总页数大于页码总数
          laypage.render({
              elem: 'demo20'
              ,count: 70 //数据总数
              ,jump: function(obj){
                  console.log(obj)
              }
          });
      });*/
</script>

</body>
</html>
