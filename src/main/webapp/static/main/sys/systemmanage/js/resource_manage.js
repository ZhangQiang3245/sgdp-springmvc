/**
 * Created by ZQ on 2018/3/22.
 */

$(function () {

$('#exampleTableToolbar').bootstrapTable({
    url: '/resouces/list',         //请求后台的URL（*）
    method: 'get',                      //请求方式（*）
    striped: true,                      //是否显示行间隔色
    cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
    pagination: true,                   //是否显示分页（*）
    sortable: true,                     //是否启用排序
    sortName:"resourcename",
    sortOrder: "asc",                   //排序方式
    sidePagination: "client",           //分页方式：client客户端分页，server服务端分页（*）
    pageNumber: 1,                       //初始化加载第一页，默认第一页
     pageSize: 5,                       //每页的记录行数（*）
     pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
    onlyInfoPagination:false,
    search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
    contentType: "application/x-www-form-urlencoded",
    showColumns: true,                  //是否显示所有的列
    showRefresh: true,                  //是否显示刷新按钮
    minimumCountColumns: 2,             //最少允许的列数
    clickToSelect: true,                //是否启用点击选中行
    uniqueId: "no",                     //每一行的唯一标识，一般为主键列
    showToggle: true,                    //是否显示详细视图和列表视图的切换按钮
    showFooter:true,
    searchAlign:"left",
    singleSelect:true,
    columns: [
        {
            radio: true,
            title: '序号'
        },
        {
        field: 'resourcename',
            titleTooltip:"sdfsdf",
        title: '资源名称'
    }, {
        field: 'resourcepath',
        title: '资源路径',
            align:"right",sortable:true,
            footerFormatter:function () {
                return "sdfsdf";
            }
    }, {
        field: 'resourcesybol',
        title: '资源权限',halign:"right"
    }, {
        field: 'resourcecode',
        title: '资源编码',
            footerFormatter:function () {
                return "1213";
            }
    }, {
        field: 'resourcetype',
        title: '资源类型'
    }, {
        field: 'resourceicon',
        title: '资源图标'
    }]
})
});
