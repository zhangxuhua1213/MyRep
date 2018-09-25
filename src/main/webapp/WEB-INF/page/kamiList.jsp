
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
    <a class="layui-btn layui-btn-xs" lay-event="read">读取</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="checkout">导出</a>
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
            id:"id",
            elem: '#test'
            ,url:'/kamiuserList.do'
            ,method:'post'
            ,toolbar: '#toolbarDemo'
            ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            ,cols: [[
                {field:'nicename', title: '代理昵称'}
                ,{field:'addtime',  title: '日期',templet:function (row) {
                        return createTime(row.addtime);
                    }}
                ,{field:'nums', title: '卡密', sort: true}
                ,{fixed: 'right', title:'操作', toolbar: '#barDemo'}
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
            var id=data['id'];  //获取属性uid的值
            //alert(id)
            if(obj.event === 'read'){//读取
                layer.open({
                    type:2,//默认0
                    title:false,
                    content: 'page.do?uri=listKamiByKid&kid='+id,
                    area: ['80%', '80%'],
                    scrollbar: false,
                    yes: function(index, layero){
                        //do something
                        layer.close(index); //如果设定了yes回调，需进行手工关闭
                    }
                })
            } else if(obj.event === 'checkout'){//导出
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
