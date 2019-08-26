"use struct"
$(document).ready(function () {
    $("#area").trigger("click");
    $("#areaSalesman").addClass("active");

    //**************************省市选择框
    $("#salesmanProvince").change(function () {
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
                $("#salesmanCity").html(html);
            },
            error: function(){}
        });
    });

    //**************************片区级联
    $("#salesmanArea").change(function () {
        $.ajax({
            method: "POST",
            url: "/Admin/Area/ListSalesmanByAreaId",
            dataType: "json",
            data: {"areaId" : $(this).val()},
            success: function (data) {
                var html = '<option value="0" selected="selected">请选择上级业务员,若为顶级业务员可不选</option>';
                for(i=0;i<data.flag.length;i++){
                    if(data.flag.pid == 0)
                        html += '<option value="'+data.flag[i].id+'">'+data.flag[i].uName+'(顶级业务员)</option>';
                    else
                        html += '<option value="'+data.flag[i].id+'">'+data.flag[i].uName+'</option>';
                }
                $("#salesmanPid").html(html);
            },
            error: function(){}
        });
    });

    //**************************业务员详情数据
    var infoSubmit = $('#modifySalesmanInfo').ladda();
    infoSubmit.click(function () {
        var $salesmanId = $(this).attr('data-id');
        var $salesmanName = $("#salesmanName").val();
        var $salesmanMobile = $("#salesmanMobile").val();
        var $salesmanIdCard = $("#salesmanIdCard").val();
        var $salesmanProvince = $("#salesmanProvince option:selected").html();
        var $salesmanCity = $("#salesmanCity option:selected").html();
        var $salesmanArea = $("#salesmanArea").val();
        var $salesmanPid = $("#salesmanPid").val();
        var $salesmanKind = $("#salesmanKind").val();
        var $salesmanStatus = $("#salesmanStatus").val();

        if($salesmanName == "" || $salesmanMobile == "" || $salesmanIdCard == "" || $salesmanProvince == "" || $salesmanCity == "" ||
            $salesmanArea == "0"){
            swal({
                title: "警告！",
                text: "输入项各项不能为空",
                type: "warning",
                confirmButtonText: "确定",
            });
        }else if($salesmanMobile.length != 11){
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
                url: "/Admin/Area/UpdateSalesman",
                dataType: "json",
                data: {"salesmanId":$salesmanId, "name": $salesmanName, "mobile":$salesmanMobile, "idCard":$salesmanIdCard, "province":$salesmanProvince,
                    "city":$salesmanCity, "areaId":$salesmanArea, "pid":$salesmanPid, "kind":$salesmanKind, "status":$salesmanStatus},
                success: function (data) {
                    infoSubmit.ladda( 'stop' );
                    if(data.flag != "1"){
                        swal({
                            title: "添加失败！",
                            text: data.error,
                            type: "error",
                            confirmButtonText: "确定",
                        });
                    }else{
                        swal({
                            title: "添加成功！",
                            text: "已为您同步至业务员信息列表，初始化密码为：123456",
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

    //**************************头像上传
    var $imageImage = $("#imageImage > img");
    $($imageImage).cropper({
        aspectRatio: 1.618,
        preview: "#imagePreviewImg",
        done: function(data) {
            // Output the result data for cropping image.
        }
    });

    var $imageInputImage = $("#imageInputImage");
    var $imgSrc;
    if (window.FileReader) {
        $imageInputImage.change(function() {
            $("#imageUpload").attr("disabled",false);
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
                    $imageInputImage.val("");
                    $imageImage.cropper("reset", true).cropper("replace", this.result);
                };
            } else {
                showMessage("Please choose an image file.");
            }
        });
    } else {
        $imageInputImage.addClass("hide");
    }

    $("#imageZoomIn").click(function() {
        $imageImage.cropper("zoom", 0.1);
    });

    $("#imageZoomOut").click(function() {
        $imageImage.cropper("zoom", -0.1);
    });

    $("#imageUpload").click(function () {
        var imgSrc = $imageImage.attr("src");
        if (imgSrc == "") {
            alert("没有选择上传的图片");
            return false;
        }
        var data = $("#imageImage > img").cropper('getData');
        var formData = new FormData();
        formData.append("tag", "3");
        formData.append("imgFile", $imgSrc);
        formData.append("imgData", JSON.stringify(data));
        formData.append("salesmanId", $(this).attr('data-id'));
        $.ajax({
            method: "POST",
            url: "/Admin/Area/UploadSalesmanIdCard",
            dataType: "json",
            contentType:false,// 告诉jQuery不要去设置Content-Type请求头
            processData:false,// 告诉jQuery不要去处理发送的数据
            data: formData,
            success: function (data) {
                $("#imageUpload").attr("disabled",true);
                if(data.flag == "1" || data.tag == "1"){
                    swal({
                        title: "上传成功成功!",
                        text: "已经成功将该身份证正面图片同步！",
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

    //**************************身份证正面
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
        formData.append("tag", "1");
        formData.append("imgFile", $imgSrc);
        formData.append("imgData", JSON.stringify(data));
        formData.append("salesmanId", $(this).attr('data-id'));
        $.ajax({
            method: "POST",
            url: "/Admin/Area/UploadSalesmanIdCard",
            dataType: "json",
            contentType:false,// 告诉jQuery不要去设置Content-Type请求头
            processData:false,// 告诉jQuery不要去处理发送的数据
            data: formData,
            success: function (data) {
                $("#coverUpload").attr("disabled",true);
                if(data.flag == "1" || data.tag == "1"){
                    swal({
                        title: "上传成功成功!",
                        text: "已经成功将该身份证正面图片同步！",
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

    //***************************身份证反面
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
        formData.append("tag", "2");
        formData.append("imgFile", $imgSrc);
        formData.append("imgData", JSON.stringify(data));
        formData.append("salesmanId", $(this).attr('data-id'));
        $.ajax({
            method: "POST",
            url: "/Admin/Area/UploadSalesmanIdCard",
            dataType: "json",
            contentType:false,// 告诉jQuery不要去设置Content-Type请求头
            processData:false,// 告诉jQuery不要去处理发送的数据
            data: formData,
            success: function (data) {
                $("#recommendUpload").attr("disabled",true);
                if(data.flag == "1" || data.tag == "1"){
                    swal({
                        title: "上传成功成功!",
                        text: "已经成功将该身份证反面图片同步！",
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

});