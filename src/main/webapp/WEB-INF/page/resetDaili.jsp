<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>增加卡密</title>
    <link rel="stylesheet" href="/layui/css/layui.css">
    <%-- <script src="/JS/jquery-3.1.1.min.js"/>--%>
    <script src="/layui/layui.js"></script>
</head>
<body>
<form class="layui-form"  action="" method="post" lay-filter="example"><%--//--%>
    <div class="layui-form-item">
        <label class="layui-form-label" style="width: 15%" >联系方式</label>
        <div class="layui-input-block" >
            <input type="text" id="mobile" name="mobile" lay-verify=""  autocomplete="off" class="layui-input" style="width: auto">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label" style="width: 15%">月卡发卡链接</label>
        <div class="layui-input-block">
            <input type="text" id="yuekaUrl" name="yuekaUrl" lay-verify=""  autocomplete="off" class="layui-input" style="width: auto">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label" style="width: 15%">季卡发卡链接</label>
        <div class="layui-input-block">
            <input type="text" id="jikaUrl"  name="jikaUrl" lay-verify=""  autocomplete="off" class="layui-input" style="width: auto">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label" style="width: 15%">年卡发卡链接</label>
        <div class="layui-input-block">
            <input type="text" id="niankaUrl"  name="niankaUrl" lay-verify=""  autocomplete="off" class="layui-input" style="width: auto">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label" style="width: 15%">终身卡发卡链接</label>
        <div class="layui-input-block">
            <input type="text" id="zhongshenkaUrl" name="zhongshenkaUrl" lay-verify=""  autocomplete="off" class="layui-input" style="width: auto">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn"  lay-filter="demo1">立即提交</button>
        </div>
    </div>
</form>



<script>
    var form;
    var optionvalue;
    layui.use(['form', 'layedit', 'laydate','jquery'], function() {
        var form = layui.form
            , layer = layui.layer
            , layedit = layui.layedit
            , laydate = layui.laydate;
        //日期
        laydate.render({
            elem: '#date'
        });
        laydate.render({
            elem: '#date1'
        });
        var $ = layui.$
        $('.layui-btn').click(function (data) {
            reset();
        })
        function  reset() {
            $.ajax({
                url: "resetDaili.do",
                type: "POST",
                data:{"mobile":$("#mobile").val(),"yuekaUrl":$("#yuekaUrl").val(),"jikaUrl":$("#jikaUrl").val(),"niankaUrl":$("#niankaUrl").val(),"zhongshenkaUrl":$("#zhongshenkaUrl").val()},
                dataType: "json",
                success: function(data){

                    if(data.value==1){//后台返回的json中需要有key为value
                        alert("修改成功");
                        //layer.msg("修改成功", {icon: 6});
                    }else{
                        alert("修改失败");
                        //layer.msg("修改失败", {icon: 5});
                    }
                }

            });
        }


    });

</script>
</body>
</html>
