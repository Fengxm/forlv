<%--
  Created by IntelliJ IDEA.
  User: xiaoming
  Date: 2017/1/4
  Time: 9:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title><spring:message code="activity_list"></spring:message></title>
    <!-- Bootstrap Styles-->
    <link href="/resources/css/bootstrap.css" rel="stylesheet" />
    <!-- Google Fonts-->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
    <!-- TABLE STYLES-->
    <link href="/resources/js/dataTables/dataTables.bootstrap.css" rel="stylesheet" />

    <!-- JS Scripts-->
    <!-- jQuery Js -->
    <script src="/resources/js/jquery-1.10.2.js"></script>
    <!-- Bootstrap Js -->
    <script src="/resources/js/bootstrap.min.js"></script>
    <!-- Custom Styles-->
    <link href="/resources/css/custom-styles.css" rel="stylesheet" />
</head>
<body>
<div id="wrapper">
    <div id="page-wrapper" >
        <div id="page-inner">
            <div class="row">
                <div class="col-md-12">
                    <h1 class="page-header">
                        <spring:message code="activity_list"></spring:message>
                    </h1>
                </div>
            </div>
            <!-- /. ROW  -->

            <div class="row">
                <div class="col-md-12">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="table-responsive">

                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                    <tr>
                                        <th><spring:message code="title"></spring:message></th>
                                        <th><spring:message code="travel_time"></spring:message></th>
                                        <th><spring:message code="cost"></spring:message></th>
                                        <th><spring:message code="gather_address"></spring:message></th>
                                        <th><spring:message code="join_num"></spring:message></th>
                                    </tr>
                                    </thead>
                                </table>

                            </div>
                            <!-- end of row table-responsive -->
                        </div>
                        <!-- end of row panel-body -->
                    </div>
                    <!-- end of panel panel-default -->
                </div>
                <!-- end of panel col-md-12 -->
            </div>
            <!-- end of row -->
        </div>
        <!-- end of page-inner -->
    </div>
    <!-- end of page-wrapper -->
</div>
<!-- end of wrapper -->


<!-- DATA TABLE SCRIPTS -->
<script src="/resources/js/dataTables/jquery.dataTables.js"></script>
<script src="/resources/js/dataTables/dataTables.bootstrap.js"></script>
<script>
    $(document).ready(function () {

        var i18nUrl = "/resources/i18n/English.json";
        $.ajax({
            type: 'HEAD', // 获取头信息，type=HEAD即可
            async: false,
            url : window.location.href,
            complete: function( xhr,data ){
                var lang = xhr.getResponseHeader('Content-Language');
                //取得浏览器语言的前两个字母
                var lang = lang.substr(0, 2);
                // 英语
                if (lang == "en") {
                    i18nUrl = "/resources/i18n/English.json";
                }
                // 中文 - 不分繁体和简体
                else if (lang == "zh") {
                    i18nUrl = "/resources/i18n/Chinese.json";
                }
            }
        });

        $('#dataTables-example').dataTable({
            ajax: {
                url:"activities/all",
                type:"POST",
                dataSrc:function(data){
                    for(var i=0;i<data.length;i++){
                        data[i].titleUrl="<a href=\"" + data[i].url + "\" target=\"_blank\">" + data[i].title + "</a>";
                    }
                    return data;
                }
            },
            columns: [
                {data: "titleUrl"},
                {data: "travel_time"},
                {data: "cost"},
                {data: "gather_address"},
                {data: "join_num"}
            ],
            lengthMenu: [5, 10, 25, 50, 100],
            language: {
                url: i18nUrl
            }
        })
    });

</script>
</body>
</html>
