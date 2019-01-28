<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title>用户列表</title>
<link rel="stylesheet" href="/layui-v2.4.5/css/layui.css">
</head>
<body>
<div class="row">
    <div>
        <table id="userTable" class="layui-table" lay-filter="userTable">
            <script type="text/html" id="topToolBar">
                <div class="layui-btn-container">
                    <a class="layui-btn layui-btn-xs" lay-event="userExport">Excel导出</a>
                    <a class="layui-btn layui-btn-xs" lay-event="userImport">Excel导入</a>
                </div>
            </script>
            <script type="text/html" id="colToolBar">
                <div class="layui-btn-container">
                    <a class="layui-btn layui-btn-xs" lay-event="qrCodeDownload">二维码下载</a>
                </div>
            </script>
        </table>
    </div>
</div>
<div id="addEditForm" style="display: none;"></div>
<script src="/layui-v2.4.5/layui.js"></script>
<script src="/jquery/jquery-1.8.3.js"></script>
<script type="text/javascript">
    layui.use(['table','layer','form','laydate'], function(){
        var layer = layui.layer;
        var form = layui.form;
        var table = layui.table;
        var laydate = layui.laydate;
        //渲染表格数据
        var tableObj1 = table.render({
            title:'用户信息',
            elem: '#userTable',
            url: '/user/userList',
            method:'post',
            contentType:'application/json',
            page: true ,//开启分页
            toolbar: "#topToolBar",
            cols: [[ //表头
                {field: 'serialNo', title: '',type:'numbers'},
                {field: 'name', title: '用户名',},
                {field: 'password', title: '密码'},
                {field: 'id', title: '操作',toolbar: '#colToolBar'}
            ]]
        });
        //监听工具栏
        table.on('toolbar(userTable)', function(obj){
            switch(obj.event){
                case 'userExport':
                    userExport();
                    break;
                case 'userImport':
                    userImport();
                    break;
            }
        });
        function userExport() {
            window.open("/user/userExport");
        }

        function userImport() {
            $.get("/user/uploadForm",function (resp) {
                $("#addEditForm").html(resp);
                var index=layer.open({
                    type: 1,
                    area: ['800px','450px'],
                    title:"上传模板",
                    content: $("#addEditForm")
                });
                //监听表单提交事件，通过验证时才会进入回调方法
               /* form.render();
                form.on("submit(uploadForm)",function(){
                    var param={
                        upload: new FormData($("#uploadForm #excelTemplate"))
                    }
                    $.ajax({
                        url:"/user/upload",
                        dataType:"json",
                        contentType:'application/json',
                        method:'post',
                        data:JSON.stringify(param),
                        success:function (resp) {
                            layer.msg(resp.msg);
                        },
                        complete:function () {
                            layer.close(index);
                            tableObj.reload();
                        }
                    })
                    return false;//不触发form提交，否则页面跳转
                })*/


            })
        }
    });
</script>
</body>
</html>
