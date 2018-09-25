
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

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

<%--<script type="text/html" id="toolbarDemo">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="getCheckData">获取选中行数据</button>
        <button class="layui-btn layui-btn-sm" lay-event="getCheckLength">获取选中数目</button>
        <button class="layui-btn layui-btn-sm" lay-event="isAll">验证是否全选</button>
    </div>
</script>--%>

<script type="text/html" id="barDemo">
    <%--<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>--%>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script src="/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript">
    function createTime(v){
        var date = new Date(v);
        var y = date.getFullYear();
        var m = date.getMonth()+1;
        m = m<10?'0'+m:m;
        var d = date.getDate();
        d = d<10?("0"+d):d;
        var h = date.getHours();
        h = h<10?("0"+h):h;
        var M = date.getMinutes();
        M = M<10?("0"+M):M;
        var str = y+"-"+m+"-"+d+" "+h+":"+M;
        return str;
    }
</script>
<script>
    layui.use('table', function(){
        var table = layui.table;

        table.render({
            elem: '#test'
            ,url:'/myExtend.do?id='+${id}
            ,toolbar: '#toolbarDemo'
            ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            ,cols: [[
                //{type: 'checkbox', fixed: 'left'},
                {field:'id', title: 'ID', sort: true}
                ,{field:'userNicename',  title: '用户昵称'}
                ,{field:'userLogin', title: '用户账号'}
                ,{field:'memberValidity',  title: '会员到期时间',templet:function (row) {
                        return createTime(row.memberValidity);
                    }}
                // ,{field:'inviter', title: '激活卡密'}
                ,{field:'createTime', title: '注册时间',templet:function (row) {
                        return createTime(row.lastLoginTime);
                    }}
                ,{field:'lastLoginTime', title: '最近登录',templet:function (row) {
                        return createTime(row.lastLoginTime);
                    }}
                ,{fixed: 'right', title:'操作', toolbar: '#barDemo'}
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
                    "data": res.data ,//解析数据列表
                    "count":res.count
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
</body>
</html>
