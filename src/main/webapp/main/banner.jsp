<%@page pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript">
    var toolbar = [{
        iconCls: 'icon-add',
        text: "添加",
        handler: function () {
            $("#addDialog").dialog("open");
        }
    }, '-', {
        iconCls: 'icon-edit',
        text: "修改",
        handler: function () {
            var row =$('#tt1').datagrid("getSelected");
            if(row== null){
                $.messager.alert("提示","请选择一行","info");
            }else{
                var index = $('#tt1').edatagrid("getRowIndex",row);
                $('#tt1').edatagrid("editRow",index);
            }
        }
    }, '-', {
        iconCls: 'icon-help',
        text: "删除",
        handler: function () {
            var row =$('#tt1').edatagrid("getSelected");
            if(row==null){
                $.messager.alert("提示","请选择一行","info");
            }else{
                $.messager.confirm('确认对话框', '确认删除该行吗？', function(r){
                    if (r){
                        $.post('${pageContext.request.contextPath}/banner/dropOneBanner', 'id='+row.id, function(res){
                                $('#tt1').datagrid('reload');
                                $.messager.show({
                                    title:'提示',
                                    msg:'删除成功',
                                    showType:'show'
                                });
                            });
                    }
                });

            }
        }
    }, '-', {
        iconCls: 'icon-back',
        text: '保存',
        handler: function () {
            $('#tt1').edatagrid('saveRow');
        }
    }];

    $('#tt1').edatagrid({
        title: '轮播图',
        remoteSort: false,
        singleSelect: true,
        nowrap: false,
        fit: true,
        pagination:true,
        pageSize:2,
        pageList:[2,4,6,8],
        fitColumns: true,
        url: '${pageContext.request.contextPath}/banner/queryAllBanner',
        toolbar: toolbar,
        updateUrl:'${pageContext.request.contextPath}/banner/editBanner',
        columns: [[
            {field: 'id', title: 'ID', width: 80},
            {field: 'picName', title: '图片名', width: 100, sortable: true ,editor:{
                    type:'validatebox',
                    options:{
                        required:true
                    }
                }},
            {field: 'picPath', title: '图片路径', width: 80, align: 'right', sortable: true},
            {field: 'description', title: '描述', width: 80, align: 'right', sortable: true,editor:{
                    type:'validatebox',
                    options:{
                        required:true
                    }
                }},
            {field: 'status', title: '状态', width: 60, sortable: true,editor:{
                    type:'validatebox',
                    options:{
                        required:true
                    }
                }},
            {field: 'createTime', title: '创建时间', width: 150, align: 'center'},
            {field: 'url', title: '链接', width: 60, align: 'center',editor:{
                    type:'validatebox',
                    options:{
                        required:true
                    }
                }},
        ]],
        view: detailview,
        detailFormatter: function (rowIndex, rowData) {
            return '<table><tr>' +
                '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/banner/'+rowData.picName+'/" style="height:50px;"></td>' +
                '<td style="border:0">' +
                '<p>创建日期: ' + rowData.createTime + '</p>' +
                '<p>状态: ' + rowData.status + '</p>' +
                '<p>描述: ' + rowData.description + '</p>' +
                '</td>' +
                '</tr></table>';
        }
    });

    function submit() {
        $("#ff").form({
            url: "${pageContext.request.contextPath}/banner/upload",
            onSubmit: function () {
                return $(this).form("validate")
            },
            success: function (data) {
                $('#addDialog').dialog('close');
                $("#tt1").datagrid("load");
                $.messager.show({
                    title: "提示框",
                    msg: "添加成功"
                });
            }
        });
        $("#ff").submit();
    };

</script>
<table id="tt1"></table>
<div id="addDialog" class="easyui-dialog" title="添加轮播图" style="width:400px;height:200px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,buttons:[{
        text:'保存',
        handler:function(){
            submit();
        }
     },{
        text:'关闭',
        handler:function(){
            $('#addDialog').dialog('close');
        }
     }]">
    <form id="ff" method="post" enctype="multipart/form-data">
        <div>
            <label for="description">描述:</label>
            <input id="description" class="easyui-validatebox" type="text" name="description"
                   data-options="required:true"/>
        </div>
        <div>
            <label for="status">状态:</label>
            <select id="status" name="status" class="easyui-combobox" style="width:200px;">
                <option value="0">不展示</option>
                <option value="1">展示</option>
            </select>
        </div>
        <div>
            <label for="url">图片跳转路径:</label>
            <input id="url" class="easyui-validatebox" type="text" name="url"
                   data-options="required:true"/>
        </div>
        <div>
            <label for="file">上传:</label>
            <input id="file" class="easyui-filebox" type="text" name="img"/>
        </div>
    </form>

</div>

