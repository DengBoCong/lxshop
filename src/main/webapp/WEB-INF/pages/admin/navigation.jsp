<%--
  Created by IntelliJ IDEA.
  User: Power
  Date: 2019/8/17
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<nav class="navbar-default navbar-static-side" role="navigation">
    <div class="sidebar-collapse">
        <ul class="nav metismenu" id="side-menu">
            <li class="nav-header">
                <div class="dropdown profile-element">
                    <span><img id="userImage" alt="image" class="img-circle" src="" style="width: 48px;height: 48px;" /></span>
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                        <span class="clear">
                            <span class="block m-t-xs"> <strong id="username" class="font-bold"></strong></span>
                            <span id="userRole" class="text-muted text-xs block"></span>
                        </span>
                    </a>
                    <ul class="dropdown-menu animated fadeInRight m-t-xs">
                        <li><a href="profile.html">个人资料</a></li>
                        <li><a href="contacts.html">联系录</a></li>
                        <li><a href="mailbox.html">消息通知</a></li>
                        <li class="divider"></li>
                        <li><a href="/Admin/Login">退出</a></li>
                    </ul>
                </div>
                <div class="logo-element">
                    丽星
                </div>
            </li>
            <li>
                <a id="summary" href="#"><i class="fa fa-bar-chart-o"></i> <span class="nav-label">企业信息</span> <span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li id="summaryProfile"><a href="/Admin/Summary/Profile">经营概况</a></li>
                    <li id="summaryFlow"><a href="/Admin/Summary/Flow">流量监控</a></li>
                    <li><a href="/Admin/Summary/User">用户总览</a></li>
                </ul>
            </li>
            <li>
                <a id="commodity" href="#"><i class="fa fa-th-large"></i> <span class="nav-label">商品管理</span><span class="fa arrow"></span></a>
                <ul class="nav nav-second-level collapse">
                    <li>
                        <a href="#">商品智配 <span class="fa arrow"></span></a>
                        <ul class="nav nav-third-level">
                            <li>
                                <a href="#">场景分类</a>
                            </li>
                            <li>
                                <a href="#">场景图上传</a>
                            </li>
                            <li>
                                <a href="#">商品图上传</a>
                            </li>
                        </ul>
                    </li>
                    <li id="commodityRecord"><a href="/Admin/Commodity/Record">商品档案</a></li>
                    <li id="commodityClassify"><a href="/Admin/Commodity/Classify">商品分类</a></li>
                </ul>
            </li>
            <li>
                <a href="mailbox.html"><i class="fa fa-book"></i> <span class="nav-label">订单管理 </span><span class="fa arrow"></span></a>
                <ul class="nav nav-second-level collapse">
                    <li>
                        <a href="#">订单管理 <span class="fa arrow"></span></a>
                        <ul class="nav nav-third-level">
                            <li><a href="#">全部订单</a></li>
                            <li><a href="#">待付款</a></li>
                            <li><a href="#">订单分配</a></li>
                            <li><a href="#">待发货</a></li>
                            <li><a href="#">待收货</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">退货管理 <span class="fa arrow"></span></a>
                        <ul class="nav nav-third-level">
                            <li><a href="#">退货历史</a></li>
                            <li><a href="#">待处理</a></li>
                            <li><a href="#">未通过</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">售后管理 <span class="fa arrow"></span></a>
                        <ul class="nav nav-third-level">
                            <li><a href="#">售后历史</a></li>
                            <li><a href="#">待处理</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">取消订单 <span class="fa arrow"></span></a>
                        <ul class="nav nav-third-level">
                            <li><a href="#">取消历史</a></li>
                            <li><a href="#">待处理</a></li>
                            <li><a href="#">异常订单</a></li>
                        </ul>
                    </li>
                </ul>
            </li>
            <li>
                <a href="#"><i class="fa fa-edit"></i> <span class="nav-label">营销管理</span><span class="fa arrow"></span></a>
                <ul class="nav nav-second-level collapse">
                    <li>
                        <a href="#">销售管理 <span class="fa arrow"></span></a>
                        <ul class="nav nav-third-level">
                            <li><a href="#">销售计划</a></li>
                            <li><a href="#">线上营销</a></li>
                            <li><a href="#">活动策划</a></li>
                            <li><a href="#">广告策划</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">经销商业绩 <span class="fa arrow"></span></a>
                        <ul class="nav nav-third-level">
                            <li><a href="#">数据看板</a></li>
                            <li><a href="#">下单情况</a></li>
                            <li><a href="#">历史订单</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">业务员业绩 <span class="fa arrow"></span></a>
                        <ul class="nav nav-third-level">
                            <li><a href="#">数据看板</a></li>
                            <li><a href="#">下单情况</a></li>
                            <li><a href="#">历史订单</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">厂商业绩 <span class="fa arrow"></span></a>
                        <ul class="nav nav-third-level">
                            <li><a href="#">数据看板</a></li>
                            <li><a href="#">下单情况</a></li>
                            <li><a href="#">历史订单</a></li>
                        </ul>
                    </li>
                    <li><a href="contacts.html">商品数据看板</a></li>
                    <li><a href="contacts.html">促销折扣</a></li>
                </ul>
            </li>
            <li>
                <a href="#"><i class="fa fa-desktop"></i> <span class="nav-label">非工作人员管理</span><span class="fa arrow"></span></a>
                <ul class="nav nav-second-level collapse">
                    <li><a href="contacts.html">经销商档案</a></li>
                    <li><a href="profile.html">厂商档案</a></li>
                </ul>
            </li>
            <li>
                <a id="area" href="#"><i class="fa fa-files-o"></i> <span class="nav-label">片区管理</span><span class="fa arrow"></span></a>
                <ul class="nav nav-second-level collapse">
                    <li id="areaDivide"><a href="/Admin/Area/Divide">片区划分</a></li>
                    <li><a href="lockscreen.html">数据看板</a></li>
                    <li id="areaPrincipal"><a href="/Admin/Area/Principal">片区负责人</a></li>
                    <li id="areaSalesman"><a href="/Admin/Area/Salesman">片区业务员</a></li>
                </ul>
            </li>
            <li>
                <a href="#"><i class="fa fa-globe"></i> <span class="nav-label">财务管理</span><span class="fa arrow"></span></a>
                <ul class="nav nav-second-level collapse">
                    <li><a href="toastr_notifications.html">核实订单</a></li>
                    <li><a href="nestable_list.html">厂家核算</a></li>
                    <li><a href="agile_board.html">经销商核算</a></li>
                    <li><a href="timeline_2.html">业务员核算</a></li>
                    <li><a href="diff.html">报表</a></li>
                </ul>
            </li>
            <li>
                <a href="#"><i class="fa fa-table"></i> <span class="nav-label">权限管理</span><span class="fa arrow"></span></a>
                <ul class="nav nav-second-level collapse">
                    <li><a href="table_basic.html">客服列表</a></li>
                    <li><a href="table_data_tables.html">人事列表</a></li>
                    <li><a href="table_foo_table.html">权限配置</a></li>
                    <li><a href="jq_grid.html">权限划分</a></li>
                </ul>
            </li>
            <li>
                <a href="#"><i class="fa fa-table"></i> <span class="nav-label">经销商APP</span><span class="fa arrow"></span></a>
                <ul class="nav nav-second-level collapse">
                    <li><a href="table_basic.html">基础配置</a></li>
                    <li><a href="table_data_tables.html">主页导播图</a></li>
                    <li><a href="table_foo_table.html">系统公告</a></li>
                </ul>
            </li>
            <li>
                <a href="#"><i class="fa fa-table"></i> <span class="nav-label">厂商终端</span><span class="fa arrow"></span></a>
                <ul class="nav nav-second-level collapse">
                    <li><a href="table_basic.html">基础配置</a></li>
                    <li><a href="table_foo_table.html">系统公告</a></li>
                </ul>
            </li>
            <li>
                <a href="#"><i class="fa fa-table"></i> <span class="nav-label">登录黑名单</span><span class="fa arrow"></span></a>
                <ul class="nav nav-second-level collapse">
                    <li><a href="table_basic.html">经销商黑名单</a></li>
                    <li><a href="table_data_tables.html">业务员黑名单</a></li>
                    <li><a href="table_foo_table.html">厂家黑名单</a></li>
                    <li><a href="jq_grid.html">工作人员黑名单</a></li>
                </ul>
            </li>
        </ul>
    </div>
</nav>
<script type="text/javascript">
    var adminInfo = JSON.parse(sessionStorage.getItem("adminInfo"));
    $("#userImage").attr('src', adminInfo.image);
    $("#username").html(adminInfo.name);
    if(adminInfo.roleId == "10") $("#userRole").html('超级管理员 <b class="caret"></b>');
    else if(adminInfo.roleId == "0") $("#userRole").html('客服 <b class="caret"></b>');
    else if(adminInfo.roleId == "1") $("#userRole").html('人事 <b class="caret"></b>');
    else $("#userRole").html('财务 <b class="caret"></b>');
</script>
