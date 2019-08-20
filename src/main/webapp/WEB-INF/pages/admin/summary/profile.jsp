<%--
  Created by IntelliJ IDEA.
  User: Power
  Date: 2019/8/17
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" +
            request.getServerPort() + path;
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>丽星平台 | 经营概况</title>
    <link href="<%=basePath%>/static/admin/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=basePath%>/static/admin/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="<%=basePath%>/static/admin/css/plugins/morris/morris-0.4.3.min.css" rel="stylesheet">
    <link href="<%=basePath%>/static/admin/css/animate.css" rel="stylesheet">
    <link href="<%=basePath%>/static/admin/css/style.css" rel="stylesheet">
    <style type="text/css">
        .list_display{display: none}
    </style>
    <script src="<%=basePath%>/static/admin/js/jquery-2.1.1.js"></script>
</head>
<body>
<div id="wrapper">
    <%@include file="../navigation.jsp"%>
    <div id="page-wrapper" class="gray-bg">
        <%@include file="../header.jsp"%>
        <div class="wrapper wrapper-content">
            <div class="row">
                <div class="col-lg-3">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <span class="label label-success pull-right">近一周</span>
                            <h5>营业额</h5>
                        </div>
                        <div class="ibox-content">
                            <h1 class="no-margins">${ProfileDataBean.weekSellCount}</h1>
                            <c:if test="${ProfileDataBean.sellPrecent<0}">
                                <div class="stat-percent font-bold text-success">${-ProfileDataBean.sellPrecent} <i class="fa fa-level-down"></i></div>
                                <small>同比下跌</small>
                            </c:if>
                            <c:if test="${ProfileDataBean.sellPrecent>0}">
                                <div class="stat-percent font-bold text-success">${ProfileDataBean.sellPrecent} <i class="fa fa-level-up"></i></div>
                                <small>同比上涨</small>
                            </c:if>
                            <c:if test="${ProfileDataBean.sellPrecent==0}">
                                <div class="stat-percent font-bold text-success">0 <i class="fa fa-bolt"></i></div>
                                <small>相对持平</small>
                            </c:if>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <span class="label label-info pull-right">近一周</span>
                            <h5>订单量</h5>
                        </div>
                        <div class="ibox-content">
                            <h1 class="no-margins">${ProfileDataBean.weekOrderCount}</h1>
                            <c:if test="${ProfileDataBean.weekOrderCount<0}">
                                <div class="stat-percent font-bold text-success">${-ProfileDataBean.weekOrderCount} <i class="fa fa-level-down"></i></div>
                                <small>同比下跌</small>
                            </c:if>
                            <c:if test="${ProfileDataBean.weekOrderCount>0}">
                                <div class="stat-percent font-bold text-success">${ProfileDataBean.weekOrderCount} <i class="fa fa-level-up"></i></div>
                                <small>同比上涨</small>
                            </c:if>
                            <c:if test="${ProfileDataBean.weekOrderCount==0}">
                                <div class="stat-percent font-bold text-success">0 <i class="fa fa-bolt"></i></div>
                                <small>相对持平</small>
                            </c:if>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <span class="label label-primary pull-right">近一周</span>
                            <h5>新增商品</h5>
                        </div>
                        <div class="ibox-content">
                            <h1 class="no-margins">${ProfileDataBean.weekGoodsCount}</h1>
                            <c:if test="${ProfileDataBean.weekGoodsCount<0}">
                                <div class="stat-percent font-bold text-success">${-ProfileDataBean.weekGoodsCount} <i class="fa fa-level-down"></i></div>
                                <small>同比下跌</small>
                            </c:if>
                            <c:if test="${ProfileDataBean.weekGoodsCount>0}">
                                <div class="stat-percent font-bold text-success">${ProfileDataBean.weekGoodsCount} <i class="fa fa-level-up"></i></div>
                                <small>同比上涨</small>
                            </c:if>
                            <c:if test="${ProfileDataBean.weekGoodsCount==0}">
                                <div class="stat-percent font-bold text-success">0 <i class="fa fa-bolt"></i></div>
                                <small>相对持平</small>
                            </c:if>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <span class="label label-danger pull-right">近一周</span>
                            <h5>新增用户</h5>
                        </div>
                        <div class="ibox-content">
                            <h1 class="no-margins">${ProfileDataBean.weekUserCount}</h1>
                            <c:if test="${ProfileDataBean.weekUserCount<0}">
                                <div class="stat-percent font-bold text-success">${-ProfileDataBean.weekUserCount} <i class="fa fa-level-down"></i></div>
                                <small>同比下跌</small>
                            </c:if>
                            <c:if test="${ProfileDataBean.weekUserCount>0}">
                                <div class="stat-percent font-bold text-success">${ProfileDataBean.weekUserCount} <i class="fa fa-level-up"></i></div>
                                <small>同比上涨</small>
                            </c:if>
                            <c:if test="${ProfileDataBean.weekUserCount==0}">
                                <div class="stat-percent font-bold text-success">0 <i class="fa fa-bolt"></i></div>
                                <small>相对持平</small>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-3">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <span class="label label-danger pull-right">总量</span>
                            <h5>总营业额</h5>
                        </div>
                        <div class="ibox-content">
                            <h1 class="no-margins">${ProfileDataBean.allSellCount}</h1>
                            <small>上述营业额单位为(元)</small>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <span class="label label-primary pull-right">总量</span>
                            <h5>总订单量</h5>
                        </div>
                        <div class="ibox-content">
                            <h1 class="no-margins">${ProfileDataBean.allOrderCount}</h1>
                            <small>上述订单量单位(笔)</small>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <span class="label label-info pull-right">总量</span>
                            <h5>总商品量</h5>
                        </div>
                        <div class="ibox-content">
                            <h1 class="no-margins">${ProfileDataBean.allGoodsCount}</h1>
                            <small>上述商品数量单位(件)</small>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <span class="label label-success pull-right">总量</span>
                            <h5>总用户量</h5>
                        </div>
                        <div class="ibox-content">
                            <h1 class="no-margins">${ProfileDataBean.allUserCount}</h1>
                            <small>上述用户量单位(个)</small>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h5>订单 数量-销售额 统计表</h5>
                            <div class="pull-right">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-xs btn-white active"> 近一周 </button>
                                    <button type="button" class="btn btn-xs btn-white"> 近一月 </button>
                                    <button type="button" class="btn btn-xs btn-white"> 近一年 </button>
                                </div>
                            </div>
                        </div>
                        <div class="ibox-content">
                            <div class="row">
                                <div class="col-lg-9">
                                    <div class="flot-chart">
                                        <div class="flot-chart-content" id="flot-dashboard-chart"></div>
                                    </div>
                                </div>
                                <div class="col-lg-3">
                                    <ul class="stat-list">
                                        <li>
                                            <h2 class="no-margins">2,346</h2>
                                            <small>在该时期所有订单总量</small>
                                            <div class="stat-percent">48% <i class="fa fa-level-up text-navy"></i></div>
                                            <div class="progress progress-mini">
                                                <div style="width: 48%;" class="progress-bar"></div>
                                            </div>
                                        </li>
                                        <li>
                                            <h2 class="no-margins ">4,422</h2>
                                            <small>上一个相同时间段内订单总量</small>
                                            <div class="stat-percent">60% <i class="fa fa-level-down text-navy"></i></div>
                                            <div class="progress progress-mini">
                                                <div style="width: 60%;" class="progress-bar"></div>
                                            </div>
                                        </li>
                                        <li>
                                            <h2 class="no-margins ">9,180</h2>
                                            <small>在该时期所有销售额总量</small>
                                            <div class="stat-percent">22% <i class="fa fa-bolt text-navy"></i></div>
                                            <div class="progress progress-mini">
                                                <div style="width: 22%;" class="progress-bar"></div>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h5>销量前十五商品列表 </h5>
                            <div class="ibox-tools">
                                <a class="collapse-link">
                                    <i class="fa fa-chevron-up"></i>
                                </a>
                                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                                    <i class="fa fa-wrench"></i>
                                </a>
                                <ul class="dropdown-menu dropdown-user">
                                    <li><a href="#">刷新</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div class="ibox-content">
                            <div class="row">
                                <div class="col-sm-9 m-b-xs">
                                    <div class="btn-group">
                                        <button id="option1" type="button" class="btn btn-xs btn-white"> 近一周 </button>
                                        <button id="option2" type="button" class="btn btn-xs btn-white"> 近一月 </button>
                                        <button id="option3" type="button" class="btn btn-xs btn-white"> 近一年 </button>
                                    </div>
                                </div>
                            </div>
                            <div class="table-responsive">
                                <table class="table table-striped">
                                    <thead>
                                    <tr>
                                        <th>编号</th>
                                        <th>名称 </th>
                                        <th>种类 </th>
                                        <th>库存 </th>
                                        <th>销量</th>
                                        <th>访问次数</th>
                                        <th>状态</th>
                                    </tr>
                                    </thead>
                                    <tbody id="weekTopList">
                                    <c:forEach items="${WeekTop15Goods}" var="items">
                                        <tr>
                                            <td>${items.id}</td>
                                            <td>${items.title}</td>
                                            <td>${items.kindName}</td>
                                            <td>${items.inventory}</td>
                                            <td>${items.salesCount}</td>
                                            <td>${items.accessCount}</td>
                                            <c:if test="${items.isShelves==0}"><td><i class="fa fa-times text-navy"></i></td></c:if>
                                            <c:if test="${items.isShelves==1}"><td><i class="fa fa-check text-danger"></i></td></c:if>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                    <tbody id="monthTopList" class="list_display">
                                    <c:forEach items="${MonthTop15Goods}" var="items">
                                        <tr>
                                            <td>${items.id}</td>
                                            <td>${items.title}</td>
                                            <td>${items.kindName}</td>
                                            <td>${items.inventory}</td>
                                            <td>${items.salesCount}</td>
                                            <td>${items.accessCount}</td>
                                            <c:if test="${items.isShelves==0}"><td><i class="fa fa-times text-navy"></i></td></c:if>
                                            <c:if test="${items.isShelves==1}"><td><i class="fa fa-check text-navy"></i></td></c:if>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                    <tbody id="yearTopList" class="list_display">
                                    <c:forEach items="${YearTop15Goods}" var="items">
                                        <tr>
                                            <td>${items.id}</td>
                                            <td>${items.title}</td>
                                            <td>${items.kindName}</td>
                                            <td>${items.inventory}</td>
                                            <td>${items.salesCount}</td>
                                            <td>${items.accessCount}</td>
                                            <c:if test="${items.isShelves==0}"><td><i class="fa fa-times text-navy"></i></td></c:if>
                                            <c:if test="${items.isShelves==1}"><td><i class="fa fa-check text-danger"></i></td></c:if>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="../footer.jsp"%>
    </div>
</div>
<script src="<%=basePath%>/static/admin/js/bootstrap.min.js"></script>
<script src="<%=basePath%>/static/admin/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="<%=basePath%>/static/admin/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

<script src="<%=basePath%>/static/admin/js/plugins/flot/jquery.flot.js"></script>
<script src="<%=basePath%>/static/admin/js/plugins/flot/jquery.flot.tooltip.min.js"></script>
<script src="<%=basePath%>/static/admin/js/plugins/flot/jquery.flot.spline.js"></script>
<script src="<%=basePath%>/static/admin/js/plugins/flot/jquery.flot.resize.js"></script>
<script src="<%=basePath%>/static/admin/js/plugins/flot/jquery.flot.pie.js"></script>
<script src="<%=basePath%>/static/admin/js/plugins/flot/jquery.flot.symbol.js"></script>
<script src="<%=basePath%>/static/admin/js/plugins/flot/jquery.flot.time.js"></script>
<script src="<%=basePath%>/static/admin/js/plugins/flot/curvedLines.js"></script>

<script src="<%=basePath%>/static/admin/js/plugins/peity/jquery.peity.min.js"></script>
<script src="<%=basePath%>/static/admin/js/demo/peity-demo.js"></script>

<script src="<%=basePath%>/static/admin/js/inspinia.js"></script>
<script src="<%=basePath%>/static/admin/js/plugins/pace/pace.min.js"></script>

<script src="<%=basePath%>/static/admin/js/plugins/jquery-ui/jquery-ui.min.js"></script>

<script src="<%=basePath%>/static/admin/js/plugins/jvectormap/jquery-jvectormap-2.0.2.min.js"></script>
<script src="<%=basePath%>/static/admin/js/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>

<script src="<%=basePath%>/static/admin/js/plugins/easypiechart/jquery.easypiechart.js"></script>

<script src="<%=basePath%>/static/admin/js/plugins/sparkline/jquery.sparkline.min.js"></script>

<script src="<%=basePath%>/static/admin/js/demo/sparkline-demo.js"></script>

<script src="<%=basePath%>/static/admin/js/plugins/chartJs/Chart.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/pages/adminJs/summaryProfile.js"></script>
</body>
</html>

