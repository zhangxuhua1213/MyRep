
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
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="chongzhi">充值</a>
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
    layui.use(['laypage','table'], function(){
        var table = layui.table
            ,laypage=layui.layPage;
        table.render({
            elem: '#test'
            ,url:'/userList.do'
            ,method:'post'
            ,toolbar: '#toolbarDemo'
            ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            ,cols: [[
                //{type: 'checkbox', fixed: 'left'},
                {field:'id', title: 'ID', sort: true}
                ,{field:'userLogin',  title: '用户名'}
                ,{field:'userNicename', title: '昵称'}
                ,{field:'huiyuanNum', title: '会员数'}
                ,{field:'monthcardNums', title: '积分'}
                ,{field:'userActivationKey',  title: '激活码'}
                ,{field:'dailiQq',  title: '客服qq'}
                ,{field:'createTime',  title: '注册时间',templet:function (row) {
                        return createTime(row.createTime);
                    }}
                ,{field:'lastLoginTime', title: '最后登录',templet:function (row) {
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
                    "count":res.count,
                    "data": res.data //解析数据列表
                };
            }
        });


        //监听行工具事件
        table.on('tool(test)', function(obj){
            var data = obj.data;
            //console.log(obj)
            if(obj.event === 'chongzhi'){
                layer.prompt({
                    formType: 2
                    ,title: '为ID  ['+ data.id +'] 代理商充值积分'
                    ,value: data.monthcardNums
                }, function(value, index){
                    if (isNaN(value)) {
                        layer.msg("请输入数字！");
                        return;
                    }
                    EidtMonthcardnums(data,value,index,obj)
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
        var $ = layui.$
        function  EidtMonthcardnums(data,value,index,obj) {
            $.ajax({
                url: "updateDailiMonthcardnums.do",
                type: "POST",
                data:{"id":data.id,"monthcardnums":value},
                dataType: "json",
                success: function(data){
                    if(data.value==1){//后台返回的json中需要有key为value
                        //关闭弹框
                        layer.close(index);
                        //同步更新表格和缓存对应的值
                        obj.update({
                            monthcardNums: value
                        });
                        layer.msg("修改成功", {icon: 6});
                    }else{
                        layer.msg(data.msg, {icon: 5});
                    }
                }

            });
        }




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