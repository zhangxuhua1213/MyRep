
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>代理后台</title>
    <link rel="stylesheet" href="/layui/css/layui.css">
</head>
<body>
<form class="layui-form" action="insertUser.do" method="post" lay-filter="example">
    <div class="layui-form-item">
        <label class="layui-form-label" style="width: 15%">代理账号</label>
        <div class="layui-input-block">
            <input type="text" name="userLogin" lay-verify="title" autocomplete="off" placeholder="请输入标题" class="layui-input" style="width: auto">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label" style="width: 15%">代理密码</label>
        <div class="layui-input-block">
            <input type="password" name="userPass" lay-verify="pass" placeholder="请输入密码" autocomplete="off" class="layui-input" style="width: auto">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label" style="width: 15%">昵称</label>
        <div class="layui-input-block">
            <input type="text" name="userNicename" lay-verify="title" placeholder="请输入昵称" autocomplete="off" class="layui-input" style="width: auto">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label" style="width: 15%">邀请码</label>
        <div class="layui-input-block">
            <input type="text" name="invitationCode" placeholder="请输入邀请码" autocomplete="off" class="layui-input" style="width: auto">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label" style="width: 15%">月卡发卡链接</label>
        <div class="layui-input-block" >
            <input type="text" name="yuekaUrl"  autocomplete="off" class="layui-input" style="width: auto">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label" style="width: 15%">季卡发卡链接</label>
        <div class="layui-input-block">
            <input type="text" name="jikaUrl"  autocomplete="off" class="layui-input" style="width: auto">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label" style="width: 15%">年卡发卡链接</label>
        <div class="layui-input-block">
            <input type="text" name="niankaUrl"  autocomplete="off" class="layui-input" style="width: auto">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label" style="width: 15%">终身卡发卡链接</label>
        <div class="layui-input-block">
            <input type="text" name="zhongshenkaUrl"  autocomplete="off" class="layui-input" style="width: auto">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label" style="width: 15%">联系方式</label>
        <div class="layui-input-block">
            <input type="text" name="mobile"  autocomplete="off" class="layui-input" style="width: auto">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-input-block" style="align-content: left">同意开通代理，并从我的积分扣除0积分</label>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
        </div>
    </div>
</form>





<script src="/layui/layui.js"></script>
<script>
    layui.use(['form', 'layedit', 'laydate'], function() {
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

        //创建一个编辑器
        var editIndex = layedit.build('LAY_demo_editor');

        //自定义验证规则
        form.verify({
            title: function (value) {
                if (value.length < 1) {
                    return '请输入代理账号和昵称';
                }
            }
            , pass: [/(.+){1,}$/, '请输入密码']
            , content: function (value) {
                layedit.sync(editIndex);
            }
        });

      /*  //监听指定开关
        form.on('switch(switchTest)', function (data) {
            layer.msg('开关checked：' + (this.checked ? 'true' : 'false'), {
                offset: '6px'
            });
            layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
        });*/

        // //监听提交
        // form.on('submit(demo1)', function (data) {
        //     layer.alert(JSON.stringify(data.field), {
        //         title: '最终的提交信息'
        //     })
        //    // return false;
        // });
    });

</script>
</body>
</html>
