<%@page pageEncoding="utf-8" isELIgnored="false" %>
<form id="addAlbumForm" method="post" enctype="multipart/form-data">
    <div>
        <label for="title1">标题:</label>
        <input id="title1" class="easyui-validatebox" type="text" name="title"
               data-options="required:true"/>
    </div>
    <div>
        <label for="score">评分:</label>
        <input id="score" class="easyui-validatebox" type="text" name="score"
               data-options="required:true"/>
    </div>
    <div>
        <label for="brodercast">播音:</label>
        <input id="brodercast" class="easyui-validatebox" type="text" name="brodercast"
               data-options="required:true"/>
    </div>
    <div>
        <label for="author">作者:</label>
        <input id="author" class="easyui-validatebox" type="text" name="author"
               data-options="required:true"/>
    </div>
    <div>
        <label for="description">内容简介:</label>
        <input id="description" class="easyui-validatebox" type="text" name="description"
               data-options="required:true"/>
    </div>
    <div>
        <label for="publishTime">发布日期:</label>
        <input id="publishTime" class="easyui-datebox" type="text" name="publishTime"
               data-options="required:true"/>
    </div>
    <div>
        <label for="count">集数:</label>
        <input id="count" class="easyui-validatebox" type="text" name="count"
               data-options="required:true"/>
    </div>
    <div>
        <label for="file2">上传封面:</label>
        <input id="file2" class="easyui-filebox" type="text" name="img2"/>
    </div>
    <div>
        <label for="status2">状态:</label>
        <select id="status2" name="status" class="easyui-combobox" style="width:200px;">
            <option value="0">不展示</option>
            <option value="1">展示</option>
        </select>
    </div>
</form>
