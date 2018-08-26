<%@page pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript">
    $('#albumId').combobox({
        url:'${pageContext.request.contextPath}/album/queryAllAlbum',
        valueField:'id',
        textField:'title'
    });
</script>
<form id="addChapterFrom" method="post" enctype="multipart/form-data">
    <div>
        <label for="title3">章节名:</label>
        <input id="title3" class="easyui-validatebox" type="text" name="title"
               data-options="required:true"/>
    </div>
    <div>
        <label for="albumId">选择章节:</label>
        <input id="albumId" name="albumId">
    </div>
    <div>
        <label for="audiofile">上传音频:</label>
        <input id="audiofile" class="easyui-filebox" type="text" name="audiofile"/>
    </div>
</form>
