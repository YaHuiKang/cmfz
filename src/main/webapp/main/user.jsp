<%@page pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript">
    var toolbar = [{
        iconCls: 'icon-add',
        text: "添加用户",
        handler: function () {
            $("#addUserDialog").dialog("open");
        }
    }, '-', {
        iconCls: 'icon-edit',
        text: "全部导出",
        handler: function () {
            location.href = "${pageContext.request.contextPath}/user/downloadExcel"
        }
    }, '-', {
        iconCls: 'icon-help',
        text: "自定义导出",
        handler: function () {
            $("#exportDialog").dialog("open");
        }
    }, '-', {
        iconCls: 'icon-back',
        text: '导入',
        handler: function () {
            $("#importDialog").dialog("open");
        }
    }];

    $('#user').datagrid({
        title: '用户',
        remoteSort: false,
        singleSelect: true,
        fit: true,
        fitColumns: true,
        url: '${pageContext.request.contextPath}/user/queryAllUser',
        toolbar: toolbar,
        columns: [[
            {field: 'name', title: '用户名', width: 80},
            {
                field: 'dharmaName', title: '法号', width: 80, sortable: true, editor: {
                    type: 'validatebox',
                    options: {
                        required: true
                    }
                }
            },
            {field: 'province', title: '省份', width: 80, align: 'right', sortable: true},
            {field: 'city', title: '城市', width: 80, align: 'right', sortable: true},
            {field: 'createTime', title: '创建时间', width: 100, align: 'right', sortable: true}
        ]],
    });

    function submitUser() {

        $("#addUserForm").form("submit", {
            url: "${pageContext.request.contextPath}/user/addUser",
            onSubmit: function () {
                return $(this).form("validate")
            },
            success: function () {
                $('#addUserDialog').dialog('close');
                $("#user").datagrid("load");
                $.messager.show({
                    title: "提示框",
                    msg: "添加成功"
                });
            }
        });
    };
    function submitExport() {
        var texts= $("#optionPara").combotree("getText");
        var fields = $("#optionPara").combotree("getValues");
        var a="";
        $.each(fields,function(index,field){
            if(index==fields.length-1){
                a+=field;
            }else{
                a+=field+",";
            }
        })

        $("#exportForm").form("submit", {
            url: "${pageContext.request.contextPath}/user/customer",
            onSubmit: function () {
                return $(this).form("validate")
            },
            success: function () {
                $('#exportForm').dialog('close');
                $("#user").datagrid("load");
                $.messager.show({
                    title: "提示框",
                    msg: "添加成功"
                });
            },
            queryParams:{
                "texts":texts,
                "fields":a
            }
        });
    };
    function submitImport() {
        $("#importExcel").form("submit", {
            url: "${pageContext.request.contextPath}/user/importExcel",
            onSubmit: function () {
                return $(this).form("validate")
            },
            success: function () {
                $('#importDialog').dialog('close');
                $("#user").datagrid("load");
                $.messager.show({
                    title: "提示框",
                    msg: "导入成功"
                });
            }
        });
    };
</script>
<table id="user"></table>
<div id="addUserDialog" class="easyui-dialog" title="添加用户" style="width:300px;height:400px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,buttons:[{
        text:'保存',
        handler:function(){
            submitUser();
        }
     },{
        text:'关闭',
        handler:function(){
            $('#addUserDialog').dialog('close');
        }
     }]">
    <form id="addUserForm" method="post" enctype="multipart/form-data" style="width:600px;height:1000px">
        <div>
            <label for="username">用户名:</label>
            <input id="username" class="easyui-validatebox" type="text" name="username"
                   data-options="required:true"/>
        </div>
        <div>
            <label for="password">密码:</label>
            <input id="password" class="easyui-validatebox" type="text" name="password"
                   data-options="required:true"/>
        </div>
        <div>
            <label for="dharmaname">法名:</label>
            <input id="dharmaname" class="easyui-validatebox" type="text" name="dharmaName"
                   data-options="required:true"/>
        </div>
        <div>
            <label for="province">省份:</label>
            <input id="province" class="easyui-validatebox" type="text" name="province"
                   data-options="required:true"/>
        </div>
        <div>
            <label for="city">城市:</label>
            <input id="city" class="easyui-validatebox" type="text" name="city"
                   data-options="required:true"/>
        </div>
        <div>
            <label for="sign">署名:</label>
            <input id="sign" class="easyui-validatebox" type="text" name="sign"
                   data-options="required:true"/>
        </div>
        <div>
            <label for="phone">电话:</label>
            <input id="phone" class="easyui-validatebox" type="text" name="phoneNum"
                   data-options="required:true"/>
        </div>
        <div>
            <label for="name4">用户名:</label>
            <input id="name4" class="easyui-validatebox" type="text" name="name"
                   data-options="required:true"/>
        </div>
        <div>
            <label for="sex">性别:</label>
            <select id="sex" name="sex" class="easyui-combobox" style="width:200px;">
                <option value="0">男</option>
                <option value="1">女</option>
            </select>
        </div>
        <div>
            <label for="status2">用户状态:</label>
            <select id="status2" name="status" class="easyui-combobox" style="width:200px;">
                <option value="0">不展示</option>
                <option value="1">展示</option>
            </select>
        </div>
        <div>
            <label for="file4">上传头像:</label>
            <input id="file4" class="easyui-filebox" type="text" name="photoww"/>
        </div>
    </form>
</div>
<div id="exportDialog" class="easyui-dialog" title="导出" style="width:400px;height:200px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,buttons:[{
        text:'保存',
        handler:function(){
            submitExport();
        }
     },{
        text:'关闭',
        handler:function(){
            $('#exportDialog').dialog('close');
        }
     }]">
    <select id="optionPara" class="easyui-combotree" style="width:200px;"
                data-options="multiple:true,required:true,data:[{
                                    'id':'custom',
                                    'state':'closed',
                                    'text': '自定义选择',
                                    'children': [{
                                                'id': 'name',
                                                'text': '用户名'
                                                },{
                                                'id': 'dharmaName',
                                                'text': '法号'
                                                },{
                                                'id': 'province',
                                                'text': '省份'
                                                },{
                                                'id': 'city',
                                                'text': '城市'
                                                },{
                                                'id': 'createTime',
                                                'text': '创建时间'
                                    }]
                }]"></select>
    <form id="exportForm"></form>
</div>


<div id="importDialog" class="easyui-dialog" title="导出" style="width:400px;height:200px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,buttons:[{
        text:'保存',
        handler:function(){
            submitImport();
        }
     },{
        text:'关闭',
        handler:function(){
            $('#importDialog').dialog('close');
        }
     }]">



    <form id="importExcel" method="post" enctype="multipart/form-data">
        <input id="excel" class="easyui-filebox" type="text" name="excel"/>
    </form>
</div>