"use struct"
$(document).ready(function () {
    $("#commodity").trigger("click");
    $("#commodityRecord").addClass("active");

    //****************************修改尺寸库存
    function setTouchSpin() {
        $(".inventory").TouchSpin({
            min: 0,
            max: 1000000,
            step: 1,
            buttondown_class: 'btn btn-white',
            buttonup_class: 'btn btn-white'
        });

        $(".factoryPrice").TouchSpin({
            min: 0,
            max: 1000000,
            step: 0.1,
            decimals: 2,
            buttondown_class: 'btn btn-white',
            buttonup_class: 'btn btn-white'
        });

        $(".originPrice").TouchSpin({
            min: 0,
            max: 1000000,
            step: 0.1,
            decimals: 2,
            buttondown_class: 'btn btn-white',
            buttonup_class: 'btn btn-white'
        });

        $(".guidePrice").TouchSpin({
            min: 0,
            max: 1000000,
            step: 0.1,
            decimals: 2,
            buttondown_class: 'btn btn-white',
            buttonup_class: 'btn btn-white'
        });
    }

    //**************************封面图
    var $coverImage = $("#coverImage > img");
    $($coverImage).cropper({
        aspectRatio: 1.618,
        preview: "#coverPreviewImg",
        done: function(data) {
            // Output the result data for cropping image.
        }
    });

    var $coverInputImage = $("#coverInputImage");
    var $imgSrc;
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

    $("#zoocoverZoomOutmOut").click(function() {
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
        formData.append("goodId", $(this).attr('data-id'));
        $.ajax({
            method: "POST",
            url: "/Admin/Commodity/UploadCR",
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

    //***************************首页推荐图
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
        formData.append("goodId", $(this).attr('data-id'));
        $.ajax({
            method: "POST",
            url: "/Admin/Commodity/UploadCR",
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

    //****************************新增尺寸库存
    $("#goodInventory").TouchSpin({
        min: 0,
        max: 1000000,
        step: 1,
        buttondown_class: 'btn btn-white',
        buttonup_class: 'btn btn-white'
    });

    $("#goodFactoryPrice").TouchSpin({
        min: 0,
        max: 1000000,
        step: 0.1,
        decimals: 2,
        buttondown_class: 'btn btn-white',
        buttonup_class: 'btn btn-white'
    });

    $("#goodOriginPrice").TouchSpin({
        min: 0,
        max: 1000000,
        step: 0.1,
        decimals: 2,
        buttondown_class: 'btn btn-white',
        buttonup_class: 'btn btn-white'
    });

    $("#goodGuidePrice").TouchSpin({
        min: 0,
        max: 1000000,
        step: 0.1,
        decimals: 2,
        buttondown_class: 'btn btn-white',
        buttonup_class: 'btn btn-white'
    });

    //**********************************商品属性
    var $goodMeasureColorSubmit = $( '#goodMeasureColorSubmit' ).ladda();
    $goodMeasureColorSubmit.click(function () {
        var $goodMeasure = $("#goodMeasure").val();
        var $goodColor = $("#goodColor").val();
        var $goodInventory = $("#goodInventory").val();
        var $goodFactoryPrice = $("#goodFactoryPrice").val();
        var $goodOriginPrice = $("#goodOriginPrice").val();
        var $goodGuidePrice = $("#goodGuidePrice").val();
        var $goodId = $(this).attr('data-id');

        if($goodMeasure == "" || $goodColor == "" || $goodInventory == "" || $goodFactoryPrice == "" ||
            $goodOriginPrice == "" || $goodGuidePrice == ""){
            swal({
                title: "警告！",
                text: "输入项各项不能为空",
                type: "warning",
                confirmButtonText: "确定",
            });
        }else{
            $goodMeasureColorSubmit.ladda( 'start' );
            $.ajax({
                method: "POST",
                url: "/Admin/Commodity/AddGoodsStandrad",
                dataType: "json",
                data: {"goodId":$goodId, "measure":$goodMeasure, "color":$goodColor, "inventory":$goodInventory, "factoryPrice":$goodFactoryPrice,
                    "originPrice":$goodOriginPrice, "guidePrice":$goodGuidePrice},
                success: function (data) {
                    $goodMeasureColorSubmit.ladda( 'stop' );
                    if(data.flag != "1"){
                        swal({
                            title: "添加失败！",
                            text: "商品属性已存在",
                            type: "error",
                            confirmButtonText: "确定",
                        });
                    }else{
                        swal({
                            title: "添加成功！",
                            text: "已为您同步至商品属性列表",
                            type: "success",
                            confirmButtonText: "确定",
                        },function () {
                            $("#addCloseButton").click();
                            $("#goodMeasure").val("");
                            $("#goodColor").val("");
                            $("#goodInventory").val("");
                            $("#goodFactoryPrice").val("");
                            $("#goodOriginPrice").val("");
                            $("#goodGuidePrice").val("");
                            $("#tableMeasureColor").append('<tr id="mesaureColorTr'+data.measureId+'"><td><input id="measure'+data.measureId+'" type="text" class="form-control" value="'+$goodMeasure+'" name="measure"></td>' +
                                '<td><input id="color'+data.measureId+'" type="text" class="form-control" value="'+$goodColor+'" name="color"></td>' +
                                '<td><input class="inventory" id="inventory'+data.measureId+'" type="text" value="'+$goodInventory+'" name="inventory"></td>' +
                                '<td><input class="factoryPrice" id="factoryPrice'+data.measureId+'" type="text" value="'+$goodFactoryPrice+'" name="factoryPrice"></td>' +
                                '<td><input class="originPrice" id="originPrice'+data.measureId+'" type="text" value="'+$goodOriginPrice+'" name="originPrice"></td>' +
                                '<td><input class="guidePrice" id="guidePrice'+data.measureId+'" type="text" value="'+$goodGuidePrice+'" name="guidePrice"></td><td>' +
                                '<button data-id="'+data.measureId+'" class="btn btn-white measureColorDelete"><i class="fa fa-trash"></i> </button>' +
                                '<button data-id="'+data.measureId+'" class="btn btn-white measureColorEdit"><i class="fa fa-edit"></i> </button></td></tr>');
                            setTouchSpin();
                            deleteEditMeasureColor();
                            /*window.location.reload();*/
                            /*$('#editable').dataTable().fnAddData( [
                                $goodTile,
                                $goodKindName,
                                $goodModel,
                                $goodMaterial,
                                $goodStruct,
                                $goodStyle,
                                $goodUse,
                                $goodSaleMethod,
                                data.shelves,
                                '<span class="btn btn-primary btn-xs ml-5 js-edit" data-id="'+data.id+'">编辑</span> <span class="btn btn-danger btn-xs ml-5 js-delete" data-id="'+data.id+'">删除</span>',
                            ] );*/
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
    //**********************************商品分类
    $("#commodityCategoryFirst").change(function () {
        var value = $(this).val();
        $.ajax({
            method: "POST",
            url: "/Admin/Commodity/ListCommodityCategorySecond",
            dataType: "json",
            data: {"pid":value},
            success: function (data) {
                var html = "";
                for(i = 0; i < data.value.length; i++){
                    html += '<option value="'+data.value[i].id+'">'+data.value[i].name+'</option>'
                }
                $("#commodityCategorySecond").html(html);
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

    $("#addCommodityCatetory").click(function () {
        var $second = $("#commodityCategorySecond").val();
        var $goodsId = $(this).attr('data-id');

        $.ajax({
            method: "POST",
            url: "/Admin/Commodity/AddCommodityCategoryJoin",
            dataType: "json",
            data: {"goodsId":$goodsId, "categoryId":$second},
            success: function (data) {
                if(data.flag != "1"){
                    swal({
                        title: "添加失败！",
                        text: "该商品分类已存在",
                        type: "error",
                        confirmButtonText: "确定",
                    });
                }else{
                    swal({
                        title: "添加成功！",
                        text: "已为您同步至商品分类列表",
                        type: "success",
                        confirmButtonText: "确定",
                    },function () {
                        $("#tableCommodityCategory").append('<tr id="commodityCategoryTr'+data.tag+'">' +
                            '<td>'+data.tagName+'</td><td>' +
                            '<button data-id="'+data.tag+'" class="btn btn-white commodityCategoryDelete"><i class="fa fa-trash"></i> </button></td></tr>');

                        deleteEditCommodityCategory();
                    });
                }
            },
            error:function () {
                swal({
                    title: "出现错误!",
                    text: "网络参数出现错误!",
                    type: "error",
                    confirmButtonText: "确定",
                },function(){window.location.reload();});
            }

        });
    });

    //**********************************商品图片
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
        formData.append("goodsId", $goodsId);
        formData.append("imgFile", $imgSrc);
        formData.append("sort", $goodPhotoSort);

        $.ajax({
            method: "POST",
            url: "/Admin/Commodity/AddCommodityPhoto",
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

    //**********************************商品详情
    var $modifyCommodityInfoSubmit = $( '#modifyCommodityInfoSubmit' ).ladda();
    $modifyCommodityInfoSubmit.click(function () {
        var $goodId = $(this).attr('data-id');
        var $goodTitle = $("#goodTitle").val();
        var $goodAfterSale = $("#goodAfterSale").val();
        var $goodKindName = $("#goodKindName").val();
        var $goodModel = $("#goodModel").val();
        var $goodMaterial = $("#goodMaterial").val();
        var $goodStructure = $("#goodStructure").val();
        var $goodStyle = $("#goodStyle").val();
        var $goodUse = $("#goodUse").val();
        var $goodSaleMethod = $("#goodSaleMethod").val();
        var $goodUnit = $("#goodUnit").val();
        var $goodShelves = $("#goodShelves").val();
        var $goodHome = $("#goodHome").val();

        if($goodAfterSale == "" || $goodKindName == "" || $goodModel == "" || $goodMaterial == "" ||
            $goodStructure == "" || $goodStyle == "" || $goodUse == "" || $goodSaleMethod == ""){
            swal({
                title: "警告！",
                text: "输入项各项不能为空",
                type: "warning",
                confirmButtonText: "确定",
            });
        }else{
            $modifyCommodityInfoSubmit.ladda( 'start' );
            $.ajax({
                method: "POST",
                url: "/Admin/Commodity/UpdateCommodityInfo",
                dataType: "json",
                data: {"goodId": $goodId,"title":$goodTitle, "afterSale":$goodAfterSale, "kindName":$goodKindName, "model":$goodModel, "material":$goodMaterial,
                    "struct":$goodStructure, "style":$goodStyle, "use":$goodUse, "saleMethod":$goodSaleMethod, "unit":$goodUnit, "shelves":$goodShelves, "home":$goodHome},
                success: function (data) {
                    $modifyCommodityInfoSubmit.ladda( 'stop' );
                    if(data.flag == "1"){
                        swal({
                            title: "修改成功!",
                            text: "已经成功将该商品基本信息同步！",
                            type: "success",
                            confirmButtonText: "确定",
                        },function(){
                            //window.location.reload();
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

    //**********************************商品电脑端详情
    var $textSummernote = $("#summernote").html();
    $("#summernote").html(window.decodeURIComponent(window.atob($textSummernote)));

    $("#modifyCommodityDetailsEditSubmit").click(function () {
        var $goodId = $(this).attr('data-id');
        $('#summernote').summernote({
            focus: true,
            lang:'zh-CN',
            placeholder: '请输入商品电脑端详情内容...',
            onImageUpload: function(files, editor, $editable) {
                sendImage(files[0],editor,$editable,$goodId);
            }
        });
    });

    function sendImage(file, editor, $editable, $goodId) {
        var filename = false;
        try{
            filename = file['name'];
        } catch(e){
            filename = false;
        }
        if(!filename){
            $(".note-alarm").remove();
        }
        //以上防止在图片在编辑器内拖拽引发第二次上传导致的提示错误
        var $formData = new FormData();
        $formData.append("imgFile", file);
        $formData.append("key",filename); //唯一性参数
        $formData.append("goodId", $goodId);

        $.ajax({
            data: $formData,
            type: "POST",
            url: "/Admin/UploadImage",
            cache: false,
            contentType: false,
            processData: false,
            success: function(data) {
                if(data.flag == "1"){
                    swal({
                        title: "图片上传失败!",
                        text: "请进行重试!",
                        type: "error",
                        confirmButtonText: "确定",
                    },function(){});
                }else{
                    editor.insertImage($editable, data.flag);
                }
            },
            error:function(){
                alert("上传失败！");
                return;
            }
        });
    }

    var $modifyCommodityDetailsSaveSubmit = $( '#modifyCommodityDetailsSaveSubmit' ).ladda();
    $modifyCommodityDetailsSaveSubmit.click(function () {
        /*alert($('#summernote').code());
        alert(window.btoa(window.encodeURIComponent($('#summernote').code())));
        var text = window.btoa(window.encodeURIComponent($('#summernote').code()));
        alert(window.decodeURIComponent(window.atob(text)));
        return;*/
        var $goodId = $(this).attr('data-id');
        $modifyCommodityDetailsSaveSubmit.ladda( 'start' );
        $.ajax({
            method: "POST",
            url: "/Admin/Commodity/UpdateCommodityContent",
            dataType: "json",
            data: {"goodId": $goodId,"content":window.btoa(window.encodeURIComponent($('#summernote').code()))},
            success: function (data) {
                $modifyCommodityDetailsSaveSubmit.ladda( 'stop' );
                if(data.flag == "1"){
                    swal({
                        title: "保存成功!",
                        text: "已经成功将该商品电脑端详情同步！",
                        type: "success",
                        confirmButtonText: "确定",
                    },function(){
                        //window.location.reload();
                    });
                }else{
                    swal({
                        title: "保存失败!",
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
    });
    

    function deleteEditMeasureColor(){
        $("#tableMeasureColor").on('click', '.measureColorDelete', function () {
            var $measureId = $(this).attr('data-id');
            swal({
                title: "确定删除?",
                text: "你将永久性删除该商品属性！",
                type: "warning",
                showCancelButton: true,
                confirmButtonColor: "#DD6B55",
                confirmButtonText: "继续删除",
                cancelButtonText: "取消",
                closeOnConfirm: false
            }, function () {
                $.ajax({
                    method: "POST",
                    url: "/Admin/Commodity/DeleteGoodsStandrad",
                    dataType: "json",
                    data: {"id" : $measureId},
                    success: function (data) {
                        if(data.flag == "1"){
                            swal({
                                title: "删除成功!",
                                text: "已经成功将该商品属性！",
                                type: "success",
                                confirmButtonText: "确定",
                            },function(){
                                //window.location.reload();
                                $("#mesaureColorTr"+$measureId).remove();
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
            var $measureId = $(this).attr('data-id');
            var $goodMeasure = $("#measure"+$measureId).val();
            var $goodColor = $("#color"+$measureId).val();
            var $goodInventory = $("#inventory"+$measureId).val();
            var $goodFactoryPrice = $("#factoryPrice"+$measureId).val();
            var $goodOriginPrice = $("#originPrice"+$measureId).val();
            var $goodGuidePrice = $("#guidePrice"+$measureId).val();

            if($goodMeasure == "" || $goodColor == "" || $goodInventory == "" || $goodFactoryPrice == "" ||
                $goodOriginPrice == "" || $goodGuidePrice == ""){
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
                url: "/Admin/Commodity/UpdateGoodsStandrad",
                dataType: "json",
                data: {"id":$measureId, "measure":$goodMeasure, "color":$goodColor, "inventory":$goodInventory, "factoryPrice":$goodFactoryPrice,
                    "originPrice":$goodOriginPrice, "guidePrice":$goodGuidePrice},
                success: function (data) {
                    if(data.flag != "1"){
                        swal({
                            title: "修改失败！",
                            text: "商品属性已存在",
                            type: "error",
                            confirmButtonText: "确定",
                        });
                    }else{
                        swal({
                            title: "修改成功！",
                            text: "已为您同步至商品属性列表",
                            type: "success",
                            confirmButtonText: "确定",
                        },function () {
                            /*$("#goodMeasure"+$measureId).val($goodMeasure);
                            $("#goodColor"+$measureId).val($goodColor);
                            $("#goodInventory"+$measureId).val($goodInventory);
                            $("#goodFactoryPrice"+$measureId).val($goodFactoryPrice);
                            $("#goodOriginPrice"+$measureId).val($goodOriginPrice);
                            $("#goodGuidePrice"+$measureId).val($goodGuidePrice);*/
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

    function deleteEditCommodityPhoto(){
        $("#tableCommodityPhoto").on('click', '.commodityPhotoDelete', function () {
            var $photoId = $(this).attr('data-id');
            swal({
                title: "确定删除?",
                text: "你将永久性删除该商品图片！",
                type: "warning",
                showCancelButton: true,
                confirmButtonColor: "#DD6B55",
                confirmButtonText: "继续删除",
                cancelButtonText: "取消",
                closeOnConfirm: false
            }, function () {
                $.ajax({
                    method: "POST",
                    url: "/Admin/Commodity/DeleteCommodityPhoto",
                    dataType: "json",
                    data: {"photoId" : $photoId},
                    success: function (data) {
                        if(data.flag == "1"){
                            swal({
                                title: "删除成功!",
                                text: "已经成功将该商品图片！",
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
                url: "/Admin/Commodity/UpdateCommodityPhoto",
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
                            text: "已为您同步至商品图片列表",
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

    function deleteEditCommodityCategory(){
        $("#tableCommodityCategory").on('click', '.commodityCategoryDelete', function () {
            var $id = $(this).attr('data-id');
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
                    url: "/Admin/Commodity/DeleteCommodityCategoryJoin",
                    dataType: "json",
                    data: {"id" : $id},
                    success: function (data) {
                        if(data.flag == "1"){
                            swal({
                                title: "删除成功!",
                                text: "已经成功将该商品移除分类！",
                                type: "success",
                                confirmButtonText: "确定",
                            },function(){
                                //window.location.reload();
                                $("#commodityCategoryTr"+$id).remove();
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
        });
    }

    setTouchSpin();
    deleteEditMeasureColor();
    deleteEditCommodityPhoto()
    deleteEditCommodityCategory();
});