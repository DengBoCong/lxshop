"use struct"
$(document).ready(function () {
    $("#nonStaff").trigger("click");
    $("#nonStaffFactoryRecord").addClass("active");

    //**************************综合评估
    var infoSubmit = $('#modifyAnayInfoSubmit').ladda();
    infoSubmit.click(function () {
        var $factoryId = $(this).attr('data-id');
        var $factoryCapacity = $("#factoryCapacity").val();
        var $factoryQuality = $("#factoryQuality").val();
        var $factoryStability = $("#factoryStability").val();
        var $factoryCircumstance = $("#factoryCircumstance").val();
        var $factoryReport = $("#factoryReport").val();

        if($factoryCapacity == "" || $factoryQuality == "" ||
            $factoryStability == "" || $factoryCircumstance == "" || $factoryReport == ""){
            swal({
                title: "警告！",
                text: "输入项各项不能为空",
                type: "warning",
                confirmButtonText: "确定",
            });
        }else{
            infoSubmit.ladda( 'start' );
            $.ajax({
                method: "POST",
                url: "/Admin/NonStaff/UpdateFactoryUserAnay",
                dataType: "json",
                data: {"factoryId":$factoryId, "capacity": $factoryCapacity, "quality":$factoryQuality, "stability":$factoryStability, "circumstance":$factoryCircumstance,
                    "report":$factoryReport},
                success: function (data) {
                    infoSubmit.ladda( 'stop' );
                    if(data.flag != "1"){
                        swal({
                            title: "修改失败！",
                            text: data.error,
                            type: "error",
                            confirmButtonText: "确定",
                        });
                    }else{
                        swal({
                            title: "添加成功！",
                            text: "已为您同步至经销商信息",
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
        }
    });


    //****************************财务数据
    var modifyFinacialInfoSubmit = $('#modifyFinacialInfoSubmit').ladda();
    modifyFinacialInfoSubmit.click(function () {
        var $factoryId = $(this).attr('data-id');
        var $agencyAlipayAcount = $("#agencyAlipayAcount").val();
        var $agencyBankAccount = $("#agencyBankAccount").val();
        var $agencyBankName = $("#agencyBankName").val();

        if($agencyAlipayAcount == "" || $agencyBankAccount == "" ||
            $agencyBankName == ""){
            swal({
                title: "警告！",
                text: "输入项各项不能为空",
                type: "warning",
                confirmButtonText: "确定",
            });
        }else{
            modifyFinacialInfoSubmit.ladda( 'start' );
            $.ajax({
                method: "POST",
                url: "/Admin/NonStaff/UpdateFactoryUserFinal",
                dataType: "json",
                data: {"factoryId":$factoryId, "agencyAlipayAcount": $agencyAlipayAcount, "agencyBankAccount":$agencyBankAccount, "agencyBankName":$agencyBankName},
                success: function (data) {
                    modifyFinacialInfoSubmit.ladda( 'stop' );
                    if(data.flag != "1"){
                        swal({
                            title: "修改失败！",
                            text: data.error,
                            type: "error",
                            confirmButtonText: "确定",
                        });
                    }else{
                        swal({
                            title: "添加成功！",
                            text: "已为您同步至经销商信息",
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
        }
    });

    var $wechatCodeImage = $("#wechatCodeImage > img");
    $($wechatCodeImage).cropper({
        aspectRatio: 1.618,
        preview: "#wechatCodePreviewImg",
        done: function(data) {
            // Output the result data for cropping image.
        }
    });

    var $wechatCodeInputImage = $("#wechatCodeInputImage");
    var $imgSrc;
    if (window.FileReader) {
        $wechatCodeInputImage.change(function() {
            $("#wechatCodeUpload").attr("disabled",false);
            var fileReader = new FileReader(),
                files = this.files,
                file;

            if (!files.length) {
                return;
            }

            file = files[0];
            $imgSrc = file;

            if (/^image\/\w+$/.test(file.type)) {
                fileReader.readAsDataURL(file);
                fileReader.onload = function () {
                    $wechatCodeInputImage.val("");
                    $wechatCodeImage.cropper("reset", true).cropper("replace", this.result);
                };
            } else {
                showMessage("Please choose an image file.");
            }
        });
    } else {
        $wechatCodeInputImage.addClass("hide");
    }

    $("#wechatCodeZoomIn").click(function() {
        $wechatCodeImage.cropper("zoom", 0.1);
    });

    $("#wechatCodeZoomOut").click(function() {
        $wechatCodeImage.cropper("zoom", -0.1);
    });

    $("#wechatCodeUpload").click(function () {
        var imgSrc = $wechatCodeImage.attr("src");
        if (imgSrc == "") {
            alert("没有选择上传的图片");
            return false;
        }
        var data = $("#wechatCodeImage > img").cropper('getData');
        var formData = new FormData();
        formData.append("tag", "1");
        formData.append("imgFile", $imgSrc);
        formData.append("imgData", JSON.stringify(data));
        formData.append("agencyUserId", $(this).attr('data-id'));
        $.ajax({
            method: "POST",
            url: "/Admin/NonStaff/UploadFactoryUserImage",
            dataType: "json",
            contentType:false,// 告诉jQuery不要去设置Content-Type请求头
            processData:false,// 告诉jQuery不要去处理发送的数据
            data: formData,
            success: function (data) {
                $("#coverUpload").attr("disabled",true);
                if(data.flag == "1" || data.tag == "1"){
                    swal({
                        title: "上传成功成功!",
                        text: "已经成功将该微信二维码图片同步！",
                        type: "success",
                        confirmButtonText: "确定",
                    },function(){
                        //window.location.reload();
                    });
                }else{
                    swal({
                        title: "上传失败!",
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
            },
        });
    });

    //**************************省市选择框
    $("#agencyProvince").change(function () {
        $.ajax({
            method: "POST",
            url: "/Admin/Area/ListCity",
            dataType: "json",
            data: {"pid" : $(this).val()},
            success: function (data) {
                var html = '<option value="0" selected="selected">请选择市</option>';
                for(i=0;i<data.flag.length;i++){
                    html += '<option value="'+data.flag[i].id+'">'+data.flag[i].name+'</option>';
                }
                $("#agencyCity").html(html);
            },
            error: function(){}
        });
    });

    //**************************片区级联
    $("#agencyArea").change(function () {
        $.ajax({
            method: "POST",
            url: "/Admin/Area/ListSalesmanByAreaIdKind",
            dataType: "json",
            data: {"kind":"2", "areaId":$(this).val()},
            success: function (data) {
                var html = '<option value="0" selected="selected">请选择上级业务员,可不选</option>';
                for(i=0;i<data.flag.length;i++){
                    if(data.flag.pid == 0)
                        html += '<option value="'+data.flag[i].id+'">'+data.flag[i].uName+'(顶级业务员)</option>';
                    else
                        html += '<option value="'+data.flag[i].id+'">'+data.flag[i].uName+'</option>';
                }
                $("#agencyPid").html(html);
            },
            error: function(){}
        });
    });


    //**************************详情数据
    var infoSubmit = $('#modifyAgencyInfoSubmit').ladda();
    infoSubmit.click(function () {
        var $factoryId = $(this).attr('data-id');
        var $agencyName = $("#agencyName").val();
        var $agencyMobile = $("#agencyMobile").val();
        var $agencyEmail = $("#agencyEmail").val();
        var $agencyAdress = $("#agencyAdress").val();
        var $agencyProvince = $("#agencyProvince option:selected").html();
        var $agencyCity = $("#agencyCity option:selected").html();
        var $agencyArea = $("#agencyArea").val();
        var $agencyPid = $("#agencyPid").val();
        var $agencyStatus = $("#agencyStatus").val();

        if($agencyName == "" || $agencyMobile == "" ||
            $agencyProvince == "" || $agencyCity == "" || $agencyArea == "0"){
            swal({
                title: "警告！",
                text: "输入项各项不能为空",
                type: "warning",
                confirmButtonText: "确定",
            });
        }else if($agencyMobile.length != 11){
            swal({
                title: "警告！",
                text: "手机号必须为11位",
                type: "warning",
                confirmButtonText: "确定",
            });
        }else{
            infoSubmit.ladda( 'start' );
            $.ajax({
                method: "POST",
                url: "/Admin/NonStaff/UpdateFactoryUser",
                dataType: "json",
                data: {"factoryId":$factoryId, "name": $agencyName, "mobile":$agencyMobile, "email":$agencyEmail, "address":$agencyAdress,
                    "province":$agencyProvince, "city":$agencyCity, "areaId":$agencyArea, "pid":$agencyPid, "status":$agencyStatus},
                success: function (data) {
                    infoSubmit.ladda( 'stop' );
                    if(data.flag != "1"){
                        swal({
                            title: "修改失败！",
                            text: data.error,
                            type: "error",
                            confirmButtonText: "确定",
                        });
                    }else{
                        swal({
                            title: "添加成功！",
                            text: "已为您同步至经销商信息",
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
        }
    });

    $("#modifyAgencyResetPwd").click(function () {
        var $agencyId = $(this).attr('data-id');
        $.ajax({
            method: "POST",
            url: "/Admin/NonStaff/UpdateFactoryPwd",
            dataType: "json",
            data: {"agencyId":$agencyId},
            success: function (data) {
                if(data.flag != "1"){
                    swal({
                        title: "重置失败！",
                        text: "可能存在网络问题，请重试！",
                        type: "error",
                        confirmButtonText: "确定",
                    });
                }else{
                    swal({
                        title: "重置成功！",
                        text: "已为您重置该经销商账号密码，重置密码为123456",
                        type: "success",
                        confirmButtonText: "确定",
                    },function () {
                        window.location.reload();
                    });
                }
            },
            error: function(){}
        });
    });

    //**************************头像
    var $coverImage = $("#coverImage > img");
    $($coverImage).cropper({
        aspectRatio: 1.618,
        preview: "#coverPreviewImg",
        done: function(data) {
            // Output the result data for cropping image.
        }
    });

    var $coverInputImage = $("#coverInputImage");
    if (window.FileReader) {
        $coverInputImage.change(function() {
            $("#coverUpload").attr("disabled",false);
            var fileReader = new FileReader(),
                files = this.files,
                file;

            if (!files.length) {
                return;
            }

            file = files[0];
            $imgSrc = file;

            if (/^image\/\w+$/.test(file.type)) {
                fileReader.readAsDataURL(file);
                fileReader.onload = function () {
                    $coverInputImage.val("");
                    $coverImage.cropper("reset", true).cropper("replace", this.result);
                };
            } else {
                showMessage("Please choose an image file.");
            }
        });
    } else {
        $coverInputImage.addClass("hide");
    }

    $("#coverZoomIn").click(function() {
        $coverImage.cropper("zoom", 0.1);
    });

    $("#coverZoomOut").click(function() {
        $coverImage.cropper("zoom", -0.1);
    });

    $("#coverUpload").click(function () {
        var imgSrc = $coverImage.attr("src");
        if (imgSrc == "") {
            alert("没有选择上传的图片");
            return false;
        }
        var data = $("#coverImage > img").cropper('getData');
        var formData = new FormData();
        formData.append("tag", "2");
        formData.append("imgFile", $imgSrc);
        formData.append("imgData", JSON.stringify(data));
        formData.append("agencyUserId", $(this).attr('data-id'));
        $.ajax({
            method: "POST",
            url: "/Admin/NonStaff/UploadFactoryUserImage",
            dataType: "json",
            contentType:false,// 告诉jQuery不要去设置Content-Type请求头
            processData:false,// 告诉jQuery不要去处理发送的数据
            data: formData,
            success: function (data) {
                $("#coverUpload").attr("disabled",true);
                if(data.flag == "1" || data.tag == "1"){
                    swal({
                        title: "上传成功成功!",
                        text: "已经成功将该商品封面图片同步！",
                        type: "success",
                        confirmButtonText: "确定",
                    },function(){
                        //window.location.reload();
                    });
                }else{
                    swal({
                        title: "上传失败!",
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
            },
        });
    });

    //****************************营业执照信息
    var $modifyLicenceInfoSubmit = $( '#modifyLicenceInfoSubmit' ).ladda();
    $modifyLicenceInfoSubmit.click(function () {
        var $licenceId = $(this).attr('data-id');
        var $agencyLicenceNumber = $("#agencyLicenceNumber").val();
        var $agencyLicenceName = $("#agencyLicenceName").val();
        var $agencyLegalPerson = $("#agencyLegalPerson").val();
        var $agencyLegalPersonTel = $("#agencyLegalPersonTel").val();
        var $agencyLegalPersonIdCard = $("#agencyLegalPersonIdCard").val();

        if($agencyLicenceNumber == "" || $agencyLicenceName == "" || $agencyLegalPerson == ""||
            $agencyLegalPersonTel == "" || $agencyLegalPersonIdCard == ""){
            swal({
                title: "警告！",
                text: "输入项各项不能为空",
                type: "warning",
                confirmButtonText: "确定",
            });
        }else{
            $modifyLicenceInfoSubmit.ladda( 'start' );
            $.ajax({
                method: "POST",
                url: "/Admin/NonStaff/UploadFactoryLicenceInfo",
                dataType: "json",
                data: {"licenceId":$licenceId, "licenceNumber": $agencyLicenceNumber,"licenceName":$agencyLicenceName, "legalPerson":$agencyLegalPerson,
                    "legalPersonTel":$agencyLegalPersonTel, "legalPersonIdCard":$agencyLegalPersonIdCard},
                success: function (data) {
                    $modifyLicenceInfoSubmit.ladda( 'stop' );
                    if(data.flag == "1"){
                        swal({
                            title: "修改成功!",
                            text: "已经成功将该营业执照信息同步！",
                            type: "success",
                            confirmButtonText: "确定",
                        },function(){
                            window.location.reload();
                        });
                    }else{
                        swal({
                            title: "修改失败!",
                            text: "正在为您重新刷新进行重试!",
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
                },
            });
        }
    });

    //***************************身份证正面图
    var $recommendImage = $("#recommendImage > img")
    $($recommendImage).cropper({
        aspectRatio: 1.618,
        preview: "#recommendPreviewImg",
        done: function(data) {
            // Output the result data for cropping image.
        }
    });

    var $recommendInputImage = $("#recommendInputImage");
    if (window.FileReader) {
        $recommendInputImage.change(function() {
            $("#recommendUpload").attr("disabled",false);
            var fileReader = new FileReader(),
                files = this.files,
                file;

            if (!files.length) {
                return;
            }

            file = files[0];
            $imgSrc = file;

            if (/^image\/\w+$/.test(file.type)) {
                fileReader.readAsDataURL(file);
                fileReader.onload = function () {
                    $recommendInputImage.val("");
                    $recommendImage.cropper("reset", true).cropper("replace", this.result);
                };
            } else {
                showMessage("Please choose an image file.");
            }
        });
    } else {
        $recommendInputImage.addClass("hide");
    }

    $("#recommendZoomIn").click(function() {
        $recommendImage.cropper("zoom", 0.1);
    });

    $("#recommendZoomOut").click(function() {
        $recommendImage.cropper("zoom", -0.1);
    });

    $("#recommendUpload").click(function () {
        var imgSrc = $recommendImage.attr("src");
        if (imgSrc == "") {
            alert("没有选择上传的图片");
            return false;
        }
        var data = $("#recommendImage > img").cropper('getData');
        var formData = new FormData();
        formData.append("tag", "3");
        formData.append("imgFile", $imgSrc);
        formData.append("imgData", JSON.stringify(data));
        formData.append("agencyUserId", $(this).attr('data-id'));
        $.ajax({
            method: "POST",
            url: "/Admin/NonStaff/UploadFactoryUserImage",
            dataType: "json",
            contentType:false,// 告诉jQuery不要去设置Content-Type请求头
            processData:false,// 告诉jQuery不要去处理发送的数据
            data: formData,
            success: function (data) {
                $("#recommendUpload").attr("disabled",true);
                if(data.flag == "1" || data.tag == "1"){
                    swal({
                        title: "上传成功成功!",
                        text: "已经成功将该商品首页推荐图片同步！",
                        type: "success",
                        confirmButtonText: "确定",
                    },function(){
                        //window.location.reload();
                    });
                }else{
                    swal({
                        title: "上传失败!",
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
            },
        });
    });

    //***************************身份证反面图
    var $personBphotoImage = $("#personBphotoImage > img")
    $($personBphotoImage).cropper({
        aspectRatio: 1.618,
        preview: "#personBphotoPreviewImg",
        done: function(data) {
            // Output the result data for cropping image.
        }
    });

    var $personBphotoInputImage = $("#personBphotoInputImage");
    if (window.FileReader) {
        $personBphotoInputImage.change(function() {
            $("#personBphotoUpload").attr("disabled",false);
            var fileReader = new FileReader(),
                files = this.files,
                file;

            if (!files.length) {
                return;
            }

            file = files[0];
            $imgSrc = file;

            if (/^image\/\w+$/.test(file.type)) {
                fileReader.readAsDataURL(file);
                fileReader.onload = function () {
                    $personBphotoInputImage.val("");
                    $personBphotoImage.cropper("reset", true).cropper("replace", this.result);
                };
            } else {
                showMessage("Please choose an image file.");
            }
        });
    } else {
        $personBphotoInputImage.addClass("hide");
    }

    $("#personBphotoZoomIn").click(function() {
        $personBphotoImage.cropper("zoom", 0.1);
    });

    $("#personBphotoZoomOut").click(function() {
        $personBphotoImage.cropper("zoom", -0.1);
    });

    $("#personBphotoUpload").click(function () {
        var imgSrc = $personBphotoImage.attr("src");
        if (imgSrc == "") {
            alert("没有选择上传的图片");
            return false;
        }
        var data = $("#personBphotoImage > img").cropper('getData');
        var formData = new FormData();
        formData.append("tag", "4");
        formData.append("imgFile", $imgSrc);
        formData.append("imgData", JSON.stringify(data));
        formData.append("agencyUserId", $(this).attr('data-id'));
        $.ajax({
            method: "POST",
            url: "/Admin/NonStaff/UploadFactoryUserImage",
            dataType: "json",
            contentType:false,// 告诉jQuery不要去设置Content-Type请求头
            processData:false,// 告诉jQuery不要去处理发送的数据
            data: formData,
            success: function (data) {
                $("#personBphotoUpload").attr("disabled",true);
                if(data.flag == "1" || data.tag == "1"){
                    swal({
                        title: "上传成功成功!",
                        text: "已经成功将该商品首页推荐图片同步！",
                        type: "success",
                        confirmButtonText: "确定",
                    },function(){
                        //window.location.reload();
                    });
                }else{
                    swal({
                        title: "上传失败!",
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
            },
        });
    });

    //***************************营业执照图
    var $licencePhotoImage = $("#licencePhotoImage > img")
    $($licencePhotoImage).cropper({
        aspectRatio: 1.618,
        preview: "#licencePhotoPreviewImg",
        done: function(data) {
            // Output the result data for cropping image.
        }
    });

    var $licencePhotoInputImage = $("#licencePhotoInputImage");
    if (window.FileReader) {
        $licencePhotoInputImage.change(function() {
            $("#licencePhotoUpload").attr("disabled",false);
            var fileReader = new FileReader(),
                files = this.files,
                file;

            if (!files.length) {
                return;
            }

            file = files[0];
            $imgSrc = file;

            if (/^image\/\w+$/.test(file.type)) {
                fileReader.readAsDataURL(file);
                fileReader.onload = function () {
                    $licencePhotoInputImage.val("");
                    $licencePhotoImage.cropper("reset", true).cropper("replace", this.result);
                };
            } else {
                showMessage("Please choose an image file.");
            }
        });
    } else {
        $licencePhotoInputImage.addClass("hide");
    }

    $("#licencePhotoZoomIn").click(function() {
        $licencePhotoImage.cropper("zoom", 0.1);
    });

    $("#licencePhotoZoomOut").click(function() {
        $licencePhotoImage.cropper("zoom", -0.1);
    });

    $("#licencePhotoUpload").click(function () {
        var imgSrc = $licencePhotoImage.attr("src");
        if (imgSrc == "") {
            alert("没有选择上传的图片");
            return false;
        }
        var data = $("#licencePhotoImage > img").cropper('getData');
        var formData = new FormData();
        formData.append("tag", "5");
        formData.append("imgFile", $imgSrc);
        formData.append("imgData", JSON.stringify(data));
        formData.append("agencyUserId", $(this).attr('data-id'));
        $.ajax({
            method: "POST",
            url: "/Admin/NonStaff/UploadFactoryUserImage",
            dataType: "json",
            contentType:false,// 告诉jQuery不要去设置Content-Type请求头
            processData:false,// 告诉jQuery不要去处理发送的数据
            data: formData,
            success: function (data) {
                $("#licencePhotoUpload").attr("disabled",true);
                if(data.flag == "1" || data.tag == "1"){
                    swal({
                        title: "上传成功成功!",
                        text: "已经成功将该商品首页推荐图片同步！",
                        type: "success",
                        confirmButtonText: "确定",
                    },function(){
                        //window.location.reload();
                    });
                }else{
                    swal({
                        title: "上传失败!",
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
            },
        });
    });

    //**********************************实景图片
    var $goodPhotoInputImage = $("#goodPhotoInputImage");
    if (window.FileReader) {
        $goodPhotoInputImage.change(function() {
            $("#goodPhotoSubmit").attr("disabled",false);
            var fileReader = new FileReader(),
                files = this.files,
                file;

            if (!files.length) {
                return;
            }

            file = files[0];
            $imgSrc = file;

            if (/^image\/\w+$/.test(file.type)) {
                fileReader.readAsDataURL(file);
                fileReader.onload = function () {
                    $goodPhotoInputImage.val("");
                };
            } else {
                showMessage("Please choose an image file.");
            }
        });
    } else {
        $goodPhotoInputImage.addClass("hide");
    }

    var $goodPhotoSubmit = $( '#goodPhotoSubmit' ).ladda();
    $goodPhotoSubmit.click(function () {
        var $goodsId = $(this).attr('data-id');
        var $goodPhotoSort = $("#goodPhotoSort").val();
        var formData = new FormData();
        formData.append("tag", "6");
        formData.append("agencyUserId", $goodsId);
        formData.append("imgFile", $imgSrc);
        formData.append("imgData", "");

        /*formData.append("tag", "5");
        formData.append("imgFile", $imgSrc);
        formData.append("imgData", JSON.stringify(data));
        formData.append("agencyUserId", $(this).attr('data-id'));*/

        $.ajax({
            method: "POST",
            url: "/Admin/NonStaff/UploadFactoryUserImage",
            dataType: "json",
            contentType:false,// 告诉jQuery不要去设置Content-Type请求头
            processData:false,// 告诉jQuery不要去处理发送的数据
            data: formData,
            success: function (data) {
                $("#goodPhotoSubmit").attr("disabled",true);
                if(data.flag == "1"){
                    swal({
                        title: "上传成功成功!",
                        text: "已经成功将该商品图片同步！",
                        type: "success",
                        confirmButtonText: "确定",
                    },function(){
                        //window.location.reload();
                        $("#photoAddCloseButton").click();
                        $("#goodPhotoSort").val("1");
                        $("#tableCommodityPhoto").append('<tr id="commodityPhotoTr'+data.tag+'">' +
                            '<td><img width="100px" height="100px" src="'+data.image+'"></td>' +
                            '<td><input type="text" class="form-control" disabled value="'+data.image+'"></td>' +
                            '<td><input id="commodityPhotoSort'+data.tag+'" type="text" class="form-control" value="'+$goodPhotoSort+'"></td><td>' +
                            '<button data-id="'+data.tag+'" class="btn btn-white commodityPhotoDelete"><i class="fa fa-trash"></i> </button>' +
                            '<button data-id="'+data.tag+'" class="btn btn-white commodityPhotoEdit"><i class="fa fa-edit"></i> </button></td></tr>');

                        deleteEditCommodityPhoto();
                    });
                }else{
                    swal({
                        title: "上传失败!",
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
            },
        });
    });

    function deleteEditCommodityPhoto(){
        $("#tableCommodityPhoto").on('click', '.commodityPhotoDelete', function () {
            var $photoId = $(this).attr('data-id');
            swal({
                title: "确定删除?",
                text: "你将永久性删除该实景图片！",
                type: "warning",
                showCancelButton: true,
                confirmButtonColor: "#DD6B55",
                confirmButtonText: "继续删除",
                cancelButtonText: "取消",
                closeOnConfirm: false
            }, function () {
                $.ajax({
                    method: "POST",
                    url: "/Admin/NonStaff/DeleteAgencyPhoto",
                    dataType: "json",
                    data: {"photoId" : $photoId},
                    success: function (data) {
                        if(data.flag == "1"){
                            swal({
                                title: "删除成功!",
                                text: "已经成功将该实景图片！",
                                type: "success",
                                confirmButtonText: "确定",
                            },function(){
                                //window.location.reload();
                                $("#commodityPhotoTr"+$photoId).remove();
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
        }).on('click', '.commodityPhotoEdit', function () {
            var $photoId = $(this).attr('data-id');
            var $goodSort = $("#commodityPhotoSort"+$photoId).val();

            if($goodSort == ""){
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
                url: "/Admin/NonStaff/UpdateAgencyPhoto",
                dataType: "json",
                data: {"photoId":$photoId, "sort":$goodSort},
                success: function (data) {
                    if(data.flag != "1"){
                        swal({
                            title: "修改失败！",
                            text: "商品图片修改出现异常",
                            type: "error",
                            confirmButtonText: "确定",
                        });
                    }else{
                        swal({
                            title: "修改成功！",
                            text: "已为您同步至实景图片列表",
                            type: "success",
                            confirmButtonText: "确定",
                        },function () {});
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

    deleteEditCommodityPhoto()
});