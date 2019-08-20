"use strict";
$(document).ready(function () {
    sessionStorage.setItem("adminInfo", "");
    var login = $( '.ladda-button-demo' ).ladda();
    login.click(function(){
        var $mobile = $("#mobile").val();
        var $password = $("#password").val();

        if($mobile == "" || $password == ""){
            swal({
                title: "警告！",
                text: "账号或者密码不能为空",
                type: "warning",
                confirmButtonText: "确定",
            });
        }else if($mobile.length != 11){
            swal({
                title: "警告！",
                text: "账号应为11位手机号",
                type: "warning",
                confirmButtonText: "确定",
            });
        }else if($password.length < 6){
            swal({
                title: "警告！",
                text: "密码不得低于六位",
                type: "warning",
                confirmButtonText: "确定",
            });
        }else{
            login.ladda( 'start' );
            $.ajax({
                method: "POST",
                url: "LoginCheck",
                dataType: "json",
                data: {"mobile": $mobile, "password":$password},
                success: function (data) {
                    login.ladda( 'stop' );
                    if(data.flag != "1"){
                        swal({
                            title: "登录失败！",
                            text: "账号或密码输入错误",
                            type: "error",
                            confirmButtonText: "确定",
                        });
                    }else{
                        swal({
                            title: "登录成功！",
                            text: "正在为你跳转主界面",
                            type: "success",
                            confirmButtonText: "确定",
                        },function () {
                            sessionStorage.setItem("adminInfo", JSON.stringify(data));
                            window.location.href = "Summary/Profile";
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

    $("#create").click(function () {
        swal({
            title: "全系统公告提醒",
            text: "本系统不允许自行注册账号，若需要登录账号，请联系管理员进行沟通创建。"
        });
    });

    $("#forget").click(function () {
        swal({
            title: "全系统公告提醒",
            text: "为安全起见，本系统不提供自行找回密码权限，请联系管理员或上级进行密码的重置。"
        });
    });
});