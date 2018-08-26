<%@page pageEncoding="utf-8" isELIgnored="false" %>
<script>
    audiojs.events.ready(function() {
        var as = audiojs.createAll();
    });

    $('#albumDetailDialog').dialog({
        title: '添加章节',
        width: 600,
        height: 400,
        closed: true,
        cache: false,
        modal: true,
        buttons:[{
            text:'关闭',
            handler:function(){
                $('#albumDetailDialog').dialog('close');
            }
        }]
    });
    $(function(){
        $('#albumAddDialog').dialog({
            title: '添加专辑',
            width: 600,
            height: 400,
            closed: true,
            cache: false,
            modal: true,
            href:"${pageContext.request.contextPath}/main/addAlbumFrom.jsp",
            buttons:[{
                text:'保存',
                handler:function(){
                    submitAlbum();
                }
            },{
                text:'关闭',
                handler:function(){
                    $('#albumAddDialog').dialog('close');
                }
            }]
        });
        $('#chapterAddDialog').dialog({
            title: '添加章节',
            width: 600,
            height: 400,
            closed: true,
            cache: false,
            modal: true,
            href:"${pageContext.request.contextPath}/main/addChapterFrom.jsp",
            buttons:[{
                text:'保存',
                handler:function(){
                    submitChapter();
                }
            },{
                text:'关闭',
                handler:function(){
                    $('#chapterAddDialog').dialog('close');
                }
            }]
        });
        var toolbar2 = [{
            iconCls: 'icon-add',
            text: "专辑详情",
            handler: function () {
                var treerow = $("#treegrid").treegrid("getSelected");
                if(treerow==null){
                    $.messager.alert('提示','请选择一个专辑','info');
                }
                if(treerow.children!=null){
                    $.get("${pageContext.request.contextPath}/album/queryAlbumById",
                          "id="+treerow.id,
                           function (treero) {
                               var detailTable='<table><tr>' +
                                   '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/banner/'+treero.coverImg+'/" style="height:50px;"></td>' +
                                   '<td style="border:0">' +
                                   '<p>发布日期: ' + treero.publishTime + '</p>' +
                                   '<p>作者: ' + treero.author + '</p>' +
                                   '<p>标题: ' + treero.title + '</p>' +
                                   '<p>下载次数: ' + treero.count + '</p>' +
                                   '<p>播音: ' + treero.brodercast + '</p>' +
                                   '<p>状态: ' + treero.status + '</p>' +
                                   '<p>描述: ' + treero.description + '</p>' +
                                   '</td>' +
                                   '</tr></table>';
                               $("#albumDetailDialog").empty();
                               $("#albumDetailDialog").append(detailTable);
                               $("#albumDetailDialog").dialog("open");
                           },
                         "json"
                    );
                }else{
                    $.messager.alert('提示','你所选的不是专辑','info');
                }
            }
        }, '-', {
            iconCls: 'icon-edit',
            text: "添加专辑",
            handler: function () {
                $("#albumAddDialog").dialog("open");
            }
        }, '-', {
            iconCls: 'icon-help',
            text: "添加章节",
            handler: function () {
                $("#chapterAddDialog").dialog("open");
            }
        }, '-', {
            iconCls: 'icon-back',
            text: '下载章节',
            handler: function () {
                var treerow = $("#treegrid").treegrid("getSelected");
                if(treerow==null){
                    $.messager.alert('提示','请选择一个章节','info');
                }
                if(treerow.url!=null){
                    location.href="${pageContext.request.contextPath}/download/downloadChapter?url="+treerow.url;
                }else{
                    $.messager.alert('提示','你所选的不是章节','info');
                }
            }
        }, '-', {
            iconCls: 'icon-back',
            text: '播放音频',
            handler: function () {
                var treerow = $('#treegrid').treegrid("getSelected");
                $("#myAudio").prop("src","${pageContext.request.contextPath}/audio/"+treerow.url);


            }
        }];

        $('#treegrid').treegrid({
            title:'专辑',
            url:'${pageContext.request.contextPath}/album/queryAlbumAndCha',
            idField:'id',
            treeField:'title',
            fitColumns:true,
            toolbar:toolbar2,
            animate:true,
            columns:[[
                {title:'名字',field:'title',width:2,align:'center'},
                {title:'下载路径',field:'url',width:2,align:'center'},
                {title:'章节大小',field:'size',width:1,align:'center'},
                {title:'章节时长',field:'length',width:1,align:'center'}
            ]]
        });
        function submitAlbum() {
            $("#addAlbumForm").form({
                url: "${pageContext.request.contextPath}/album/addAlbum",
                onSubmit: function () {
                    return $(this).form("validate")
                },
                success: function (data) {
                    $('#albumAddDialog').dialog('close');
                    $("#treegrid").treegrid("load");
                    $.messager.show({
                        title: "提示框",
                        msg: "添加成功"
                    });
                }
            });
            $("#addAlbumForm").submit();
        };
        function submitChapter() {
            $("#addChapterFrom").form({
                url: "${pageContext.request.contextPath}/chapter/addChapter",
                onSubmit: function () {
                    return $(this).form("validate")
                },
                success: function (data) {
                    $('#chapterAddDialog').dialog('close');
                    $("#treegrid").treegrid("load");
                    $.messager.show({
                        title: "提示框",
                        msg: "添加成功"
                    });
                }
            });
            $("#addChapterFrom").submit();
        };
    });
</script>

<table id="treegrid"></table>
 <div id="albumAddDialog"></div>
<div id="chapterAddDialog"></div>
<div id="albumDetailDialog"></div>
<span id="palyaudio"></span>
<audio preload='auto' id="myAudio"/>
