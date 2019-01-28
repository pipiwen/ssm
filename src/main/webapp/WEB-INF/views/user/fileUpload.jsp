<%@ page contentType="text/html;charset=UTF-8" %>

<div style="padding:5px;">
    <form class="layui-form" action="/user/upload" lay-filter="uploadForm" id="uploadForm" method="post" enctype="multipart/form-data">
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">用户名</label>
                <div class="layui-input-inline">
                    <input  id="userName" name="name"  class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">上传模板</label>
                <div class="layui-input-inline">
                    <input type="file" id="excelTemplate" name="file"  class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" type="submit" lay-filter="demo1">上传</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>