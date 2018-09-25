
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
<div class="layui-inline" >
    <label class="layui-form-label">会员：</label>
    <input style="width: auto;" type="text" id="input_userid" name="select_user" lay-verify="required" placeholder="请输入会员ID" autocomplete="off" class="layui-input">
</div>
<button class="layui-btn" id="searchBtn" data-type="reload" >搜索</button>
<table class="layui-hide" id="test" lay-filter="test" ></table>
<div id="fenye"></div>

<%--<script type="text/html" id="toolbarDemo">--%>

<%--</script>--%>

<script type="text/html" id="typeTpl">
    {{#  if(d.type =="income"){  }}
        收支
    {{#  } }}
</script>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <%--<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>--%>
</script>
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
<script src="/JS/jquery-3.1.1.min.js"></script>
<script src="/layui/layui.all.js" charset="utf-8"></script>

<script>
    var table;
    layui.use('table', function() {
        table = layui.table
    });
    function initTable(key) {
        var url = 'getActiveRecord.do?keyword='+key;
        table.render({
            elem: '#test'
            ,url:url
            ,method:'post'
            //,toolbar: '#toolbarDemo'
            ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            ,cols: [[
                //{type: 'checkbox', fixed: 'left'},
                {field:'id', title: 'ID', sort: true}
                ,{field:'type',  title: '收支行为', templet: '#typeTpl'}
                ,{field:'user_id', title: '会员 (会员ID)', sort: true}
                ,{field:'kami', title: '使用卡密'} //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
                ,{field:'addtime',  title: '使用时间',templet:function (row) {
                        return createTime(row.addtime);
                    }}
                ,{field:'user_nicename', title: '代理昵称'}
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
    }
    initTable("");

    $("#searchBtn").click(function () {
        initTable($("#input_userid").val());
    });

</script>

</body>
</html>
