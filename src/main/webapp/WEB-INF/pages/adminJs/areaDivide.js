"use struct"
$(document).ready(function () {
    $("#area").trigger("click");
    $("#areaDivide").addClass("active");

    var $addAreaInfo = $("#addAreaInfo").ladda();
    $addAreaInfo.click(function () {
        var $areaName = $("#areaName").val();
        var $areaDescription = $("#areaDescription").val();
        var $areaSalesman = $("#areaSalesman").val();

        if($areaName == "" || $areaDescription == "" || $areaSalesman == "0"){
            swal({
                title: "警告！",
                text: "输入项各项不能为空",
                type: "warning",
                confirmButtonText: "确定",
            });
        }else{
            $addAreaInfo.ladda( 'start' );
            $.ajax({
                method: "POST",
                url: "/Admin/Commodity/AddAreaInfo",
                dataType: "json",
                data: {"areaName":$areaName, "areaDescription":$areaDescription, "areaSalesman":$areaSalesman},
                success: function (data) {
                    $addAreaInfo.ladda( 'stop' );
                    if(data.flag != "1"){
                        swal({
                            title: "添加失败！",
                            text: "片区已存在",
                            type: "error",
                            confirmButtonText: "确定",
                        });
                    }else{
                        swal({
                            title: "添加成功！",
                            text: "已为您同步至片区信息列表",
                            type: "success",
                            confirmButtonText: "确定",
                        },function () {
                            $("#addCloseButton").click();
                            $("#areaName").val("");
                            $("#areaDescription").val("");
                            $("#areaSalesman").find("option[text='请选择片区负责人']").attr("selected",true);
                            $("#areaListContent").append('<div id="areaBox'+data.manInfo.id+'" class="ibox"><div class="ibox-title">' +
                                '<button data-id="'+data.manInfo.id+'" type="button" class="btn btn-primary pull-right modifyAreaInfo" data-toggle="modal" data-target="#myModal">修改</button>' +
                                '<button data-id="'+data.manInfo.id+'" type="button" class="btn btn-primary pull-right deleteAreaInfo">删除</button>' +
                                '<h5>IT-'+data.manInfo.id+' - Team</h5></div><div class="ibox-content"><div class="team-members">' +
                                '<a href="#">'+data.manInfo.ownerName+'<img alt="member" class="img-circle" src="'+data.manInfo.ownerImage+'"></a></div><h4>'+data.manInfo.name+'</h4>' +
                                '<p>'+data.manInfo.description+'</p><div><span>占总业务员人数百分比</span><div class="stat-percent">'+data.manInfo.countPrecent+' %</div>' +
                                '<div class="progress progress-mini"><div style="width: 48%;" class="progress-bar"></div>' +
                                '</div></div><div class="row  m-t-sm"><div class="col-sm-4"><div class="font-bold">业务员人数</div>' +
                                + data.manInfo.salesmanCount+'</div><div class="col-sm-4"><div class="font-bold">经销商人数</div>'+data.manInfo.userCount+'</div>' +
                                '<div class="col-sm-4 text-right"><div class="font-bold">创建时间</div>'+data.manInfo.addTime.toLocaleString()+' <i class="fa fa-level-up text-navy"></i>' +
                                '</div></div></div></div>');
                            deleteEdit();
                        });
                    }
                },
                error:function () {
                    swal({
                        title: "出现错误!",
                        text: "网络参数出现错误!",
                        type: "error",
                        confirmButtonText: "确定",
                    },function(){});
                }
            });
        }
    });

    function deleteEdit() {
        $("#areaListContent").on('click', '.deleteAreaInfo', function () {
            var $areaId = $(this).attr('data-id');
            swal({
                title: "确定删除?",
                text: "你将永久性删除该片区信息！",
                type: "warning",
                showCancelButton: true,
                confirmButtonColor: "#DD6B55",
                confirmButtonText: "继续删除",
                cancelButtonText: "取消",
                closeOnConfirm: false
            }, function () {
                $.ajax({
                    method: "POST",
                    url: "/Admin/Area/DeleteArea",
                    dataType: "json",
                    data: {"areaId" : $areaId},
                    success: function (data) {
                        if(data.flag == "1"){
                            swal({
                                title: "删除成功!",
                                text: "已经成功将该片区信息删除！",
                                type: "success",
                                confirmButtonText: "确定",
                            },function(){
                                //window.location.reload();
                                $("#areaBox"+$areaId).remove();
                            });
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
        }).on('click', '.measureColorEdit', function () {
            var $areaId = $(this).attr('data-id');
            var $areaName = $("#modifyAreaName").val();
            var $areaDescription = $("#modifyAreaDescription").val();
            var $areaSalesman = $("#modiffyAreaSalesman").val();

            if($areaName == "" || $areaDescription == "" || $areaSalesman == ""){
                swal({
                    title: "警告！",
                    text: "输入项各项不能为空",
                    type: "warning",
                    confirmButtonText: "确定",
                });
                return;
            }

            $.ajax({
                method: "POST",
                url: "/Admin/Commodity/UpdateArea",
                dataType: "json",
                data: {"areaId":$areaId, "areaName":$areaName, "areaDescription":$areaDescription, "areaSalesman":$areaSalesman},
                success: function (data) {
                    if(data.flag != "1"){
                        swal({
                            title: "修改失败！",
                            text: "片区已存在",
                            type: "error",
                            confirmButtonText: "确定",
                        });
                    }else{
                        swal({
                            title: "修改成功！",
                            text: "已为您同步至片区信息列表",
                            type: "success",
                            confirmButtonText: "确定",
                        },function () {
                            window.location.reload();
                        });
                    }
                },
                error:function () {
                    swal({
                        title: "出现错误!",
                        text: "网络参数出现错误!",
                        type: "error",
                        confirmButtonText: "确定",
                    },function(){});
                }
            });
        });
    }

    deleteEdit();
});