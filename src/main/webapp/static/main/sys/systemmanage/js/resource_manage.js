/**
 * Created by ZQ on 2018/3/22.
 */

$(function () {
    /**
     * 初始化资源列表
     */
    pageOps.initResourceTable();
    /**
     * 添加资源
     */
    $("#add").bind('click', pageOps.addResource);
    /**
     * 删除资源
     */
    $("#del").bind('click', pageOps.deleteResource);
    /**
     * 编辑资源
     */
    $("#edit").bind('click', pageOps.editResource);
    $("#parentresourceid").bind('focus', function () {
        $('#tree').treeview({data: tree});
        layer.open({
            type:1,
            content:$("#tree")
        })
    });

    var tree = [
        {
            text: "Parent 1",
            nodes: [
                {
                    text: "Child 1",
                    nodes: [
                        {
                            text: "Grandchild 1"
                        },
                        {
                            text: "Grandchild 2"
                        }
                    ]
                },
                {
                    text: "Child 2"
                }
            ]
        },
        {
            text: "Parent 2"
        },
        {
            text: "Parent 3"
        },
        {
            text: "Parent 4"
        },
        {
            text: "Parent 5"
        }
    ];
});

var pageOps = {
    addResource: function () {
        layer.open({
            type: 1,
            title: "资源新增",
            content: $("#addForm"),
            skin: 'demo-class',
            area: ['550px'],
            btn: ['保存', '取消'],
            btnAlign: "c",
            yes: function (index, layero) {
                $.ajax({
                    url: "/resources/add",
                    type: "POST",
                    dataType: "json",
                    data: $("#resourceadd").serialize(),
                    success: function (data) {
                        if (data.code > 0) {
                            layer.msg("保存成功！");
                            $('#resourceTable').bootstrapTable('refresh', {});
                        } else {
                            layer.msg("保存失败！");
                        }
                        layer.close(index);
                    },
                    error: function () {
                        layer.msg("保存失败！");
                    }
                });
            }, btn2: function (index, layero) {
                layer.close(index);
            }, cancel: function () {
                layer.closeAll();
            }, end: function () {
                $("#addForm").find("input").val("");
            }
        });
    },
    deleteResource: function () {
        var dataArry = $('#resourceTable').bootstrapTable("getSelections");
        if (dataArry.length < 1) {
            layer.msg("至少选中一条数据进行删除！");
            return;
        }
        var jsonObj = {};
        jsonObj.resourceids = new Array();
        for (var i = 0; i < dataArry.length; i++) {
            jsonObj.resourceids.push(dataArry[i].resourceid);
        }
        $.ajax({
            url: "/resources/delete",
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify(jsonObj),
            success: function (data) {
                if (data.code > 0) {
                    layer.msg("删除成功！");
                    $('#resourceTable').bootstrapTable('refresh', {});
                } else {
                    layer.msg("删除失败！");
                }
            }
        })
    },
    editResource: function () {
        var dataArry = $('#resourceTable').bootstrapTable("getSelections");
        if (dataArry.length != 1) {
            layer.msg("只能选择一条数据进行编辑！");
            return;
        } else {
            $("#resourceid").val(dataArry[0].resourceid);
            $("#resourcename").val(dataArry[0].resourcename);
            $("#resourcepath").val(dataArry[0].resourcepath);
            $("#resourcecode").val(dataArry[0].resourcecode);
            $("#resourcesybol").val(dataArry[0].resourcesybol);
            $("#resourcetype").val(dataArry[0].resourcetype);
            $("#resourceicon").val(dataArry[0].resourceicon);
            $("#parentresourceid").val(dataArry[0].parentresourceid);
        }
        layer.open({
            type: 1,
            title: "资源编辑",
            content: $("#addForm"),
            skin: 'demo-class',
            area: ['550px'],
            btn: ['保存', '取消'],
            btnAlign: "c",
            yes: function (index, layero) {
                $.ajax({
                    url: "/resources/update",
                    type: "POST",
                    dataType: "json",
                    data: $("#resourceadd").serialize(),
                    success: function (data) {
                        if (data.code > 0) {
                            layer.msg("保存成功！");
                            $('#resourceTable').bootstrapTable('refresh', {});
                        } else {
                            layer.msg("保存失败！");
                        }
                        layer.close(index);
                    },
                    error: function () {
                        layer.msg("保存失败！");
                    }
                });
            }, btn2: function (index, layero) {
                layer.close(index);
            }, cancel: function () {
                layer.closeAll();
            }, end: function () {
                $("#addForm").find("input").val("");
            }
        });
    },
    initResourceTable: function () {
        $('#resourceTable').bootstrapTable({
            url: '/resources/list',         //请求后台的URL（*）
            method: 'get',                      //请求方式（*）
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: true,                     //是否启用排序
            silentSort: true,
            sortName: "resourcecode",
            sortOrder: "asc",                   //排序方式
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber: 1,                       //初始化加载第一页，默认第一页
            pageSize: 10,                       //每页的记录行数（*）
            pageList: [5, 10, 25, 50, 100],        //可供选择的每页的行数（*）
            onlyInfoPagination: false,
            contentType: "application/x-www-form-urlencoded",
            showColumns: true,                  //是否显示所有的列
            showRefresh: true,                  //是否显示刷新按钮
            minimumCountColumns: 2,             //最少允许的列数
            clickToSelect: true,                //是否启用点击选中行
            uniqueId: "resourceid",                     //每一行的唯一标识，一般为主键列
            showToggle: true,                    //是否显示详细视图和列表视图的切换按钮
            singleSelect: false,
            toolbar: $("#toolbar"),
            selectItemName: "resourceSel",
            columns: [
                {
                    checkbox: true
                },
                {
                    field: 'resourceid',
                    title: '资源编码',
                    visible: false
                },
                {
                    field: 'resourcename',
                    sortable: true,
                    title: '资源名称'
                }, {
                    field: 'resourcepath',
                    title: '资源路径',
                    sortable: true,
                    align: "right"
                }, {
                    field: 'resourcesybol',
                    title: '资源权限',
                    sortable: true,
                    halign: "right"
                }, {
                    field: 'resourcecode',
                    sortable: true,
                    title: '资源编码'
                }, {
                    field: 'resourcetype',
                    sortable: true,
                    title: '资源类型'
                }, {
                    field: 'resourceicon',
                    title: '资源图标'
                }, {
                    field: 'remark',
                    sortable: true,
                    title: '备注'
                }, {
                    field: 'parentresourceid',
                    title: '上级资源'
                }]
        })
    }
}

