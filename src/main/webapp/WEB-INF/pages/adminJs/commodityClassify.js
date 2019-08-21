"use struct"

$(document).ready(function(){
    $("#commodity").trigger("click");
    $("#commodityClassify").addClass("active");

    // activate Nestable for list 2
    $('#nestable2').nestable({
        group: 0,
        maxDepth: 2,
        onDragStart: function(l,e){return false;},
    });

    var recordNumber = "";
    var recordContent = "";
    var recordSort = "";
    var recordIsHome = "";
    function clickEvent(){
        $('#nestable2').on('click','.js-delete',function(){
            var number =  $(this).attr('data-id');
            swal({
                title: "确定删除?",
                text: "你将永久性删除该商品分类！",
                type: "warning",
                showCancelButton: true,
                confirmButtonColor: "#DD6B55",
                confirmButtonText: "继续删除",
                cancelButtonText: "取消",
                closeOnConfirm: false
            }, function () {
                $.ajax({
                    method: "POST",
                    url: "/Admin/Commodity/DeleteClassify",
                    dataType: "json",
                    data: {"id" : number},
                    success: function (data) {
                        if(data.flag == "1"){
                            swal({
                                title: "删除成功!",
                                text: "已经成功将该商品分类！",
                                type: "success",
                                confirmButtonText: "确定",
                            },function(){window.location.reload();});
                        }else{
                            swal({
                                title: "删除失败!",
                                text: "请重新刷新进行重试!",
                                type: "error",
                                confirmButtonText: "确定",
                            },function(){window.location.reload();});
                        }
                    },
                    error: function(){
                        swal({
                            title: "出现错误!",
                            text: "网络参数出现错误!",
                            type: "error",
                            confirmButtonText: "确定",
                        },function(){window.location.reload();});
                    }
                });
            });
        }).on('click','.js-edit',function(){
            /*var id = $(this).attr('data-id');
            location.href = '/edit?id='+id+'';*/
            $("#titleModify").html("修改 " + $(this).attr('data-name'));
            $("#editLabel").val($(this).attr('data-name'));
            $("#editLabelSort").val($(this).attr('data-sort'));
            recordNumber = $(this).attr('data-id');
            recordContent = $(this).attr('data-name');
            recordSort = $(this).attr('data-sort');
            recordIsHome = $(this).attr('data-isHome');
            $("#edit").click();
        }).on('click', '.js-add', function(){
            $("#newSubLabel").html($(this).attr('data-name'));
            recordNumber = $(this).attr('data-id');
            $("#new").click();
        });
    }

    clickEvent();

    $("#submitModify").click(function () {
        $.ajax({
            method: "POST",
            url: "/Admin/Commodity/AddClassify",
            dataType: "json",
            data: {"name": $("#FirstName").val(), "pid":"0", "isHome":$("#isHome").val(), "sort":$("#FirstSort").val()},
            beforeSend: function(){},
            success: function(data){
                if(data.flag == "1"){
                    swal({
                        title: "添加成功!",
                        text: "已经成功添加该商品分类！",
                        type: "success",
                        confirmButtonText: "确定",
                    },function(){window.location.reload();});
                }else{
                    swal({
                        title: "添加失败!",
                        text: "已存在相同标签，请更改后进行重试!",
                        type: "error",
                        confirmButtonText: "确定",
                    },function(){});
                }
            },
            error: function(){
                swal({
                    title: "出现错误!",
                    text: "网络参数出现错误!",
                    type: "error",
                    confirmButtonText: "确定",
                },function(){});
            },
        });
    });

    $("#SecondAdd").click(function () {
        $.ajax({
            method: "POST",
            url: "/Admin/Commodity/AddClassify",
            dataType: "json",
            data: {"name": $("#SecondName").val(), "pid":recordNumber, "isHome":$("#isHomeSecond").val(), "sort":$("#SecondSort").val()},
            beforeSend: function(){},
            success: function(data){
                if(data.flag == "1"){
                    swal({
                        title: "添加成功!",
                        text: "已经成功添加该商品分类！",
                        type: "success",
                        confirmButtonText: "确定",
                    },function(){window.location.reload();});
                }else{
                    swal({
                        title: "添加失败!",
                        text: "已存在相同标签，请更改后进行重试!",
                        type: "error",
                        confirmButtonText: "确定",
                    },function(){});
                }
            },
            error: function(){
                swal({
                    title: "出现错误!",
                    text: "网络参数出现错误!",
                    type: "error",
                    confirmButtonText: "确定",
                },function(){});
            },
        });
    });

    $("#modifySecond").click(function () {
        if(recordContent == $("#editLabel").val()){
            swal({
                title: "提交失败!",
                text: "提交内容与原内容相同！",
                type: "warning",
                confirmButtonText: "确定",
            },function(){});
            return;
        }
        $.ajax({
            method: "POST",
            url: "/Admin/Commodity/UpdateClassify",
            dataType: "json",
            data: {"id":recordNumber,"name": $("#editLabel").val(), "sort":$("#editLabelSort").val(), "isHome":$("#editLabelIsHome").val()},
            beforeSend: function(){},
            success: function(data){
                if(data.flag == "1"){
                    swal({
                        title: "修改成功!",
                        text: "已经成功修改该商品分类！",
                        type: "success",
                        confirmButtonText: "确定",
                    },function(){window.location.reload();});
                }else{
                    swal({
                        title: "修改失败!",
                        text: "已存在相同标签，请更改后进行重试!",
                        type: "error",
                        confirmButtonText: "确定",
                    },function(){});
                }
            },
            error: function(){
                swal({
                    title: "出现错误!",
                    text: "网络参数出现错误!",
                    type: "error",
                    confirmButtonText: "确定",
                },function(){});
            },
        });
    });

});