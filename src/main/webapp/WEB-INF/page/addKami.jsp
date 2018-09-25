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
<form class="layui-form"  action="addKami.do" method="post" lay-filter="example"><%--//--%>
    <div class="layui-form-item">
        <label class="layui-form-label" >卡密类型</label>
        <div class="layui-input-block" >
            <select name="pointsAndType" lay-filter="aihao" id="selectoption" lay-verify="selectoption">
                <option value="0">请选择</option>
                <c:forEach items="${strmap}" var="li">
                    <option value="${li.value}">${li.key}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label" style="width: 15%">数量</label>
        <div class="layui-input-block">
            <input type="text" name="nums" lay-verify="shuliang" placeholder="请输入数量" autocomplete="off" class="layui-input" style="width: auto">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
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

        //自定义验证规则
        form.verify({
            selectoption: function (value) {
                if (value==0) {
                    return '下拉框请选择';
                }
            }
            , pass: [/(.+){6,12}$/, '密码必须6到12位']
            , shuliang:function (value) {
                if (value<=0) {
                    return '请输入真整数';
                }
            }
            , content: function (value) {
                layedit.sync(editIndex);
            }
        });

          //select选中
          // form.on('select', function (data) {
          //     optionvalue=data.value;
          //     // var optionText=data.
          //     // alert(optionText)
          // });

        //监听提交
        form.on('submit(demo1)', function (data) {
            // layer.alert(JSON.stringify(data.field), {
            //     title: '最终的提交信息'
            // })
            // return false;
        });
    });

</script>
</body>
</html>
