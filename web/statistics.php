<?php 
	ob_start(); 
	session_start();
?>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>E-BUS ADMIN</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/datepicker3.css" rel="stylesheet">
    <link href="css/bootstrap-table.css" rel="stylesheet">
    <link href="css/styles.css" rel="stylesheet">

    <!--Icons-->
    <script src="js/lumino.glyphs.js"></script>

    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->

</head>

<body>
<?php
if(!isset($_SESSION['authen'])){
	
	header("Location:index.php");
	exit('</body></html>');
	ob_end_flush();
}

?>

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#sidebar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#"><span>E-BUS</span>Admin</a>
            <ul class="user-menu">
                <li class=" pull-right">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><svg class="glyph stroked male-user"><use xlink:href="#stroked-male-user"></use></svg> User <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="logout.php"><svg class="glyph stroked cancel"><use xlink:href="#stroked-cancel"></use></svg> Logout</a></li>
                    </ul>
                </li>
            </ul>
        </div>

    </div><!-- /.container-fluid -->
</nav>

<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
    <ul class="nav menu">
        <BR>
        <li><div align="center"><img src = "AWT-Bus.png" width="100" height="90" border="0"></div></li>
        <li role="presentation" class="divider"></li>

        <li><a href="dashboard.php"><svg class="glyph stroked dashboard-dial"><use xlink:href="#stroked-dashboard-dial"></use></svg> Dashboard</a></li>
        <li><a href="charts.php"><svg class="glyph stroked line-graph"><use xlink:href="#stroked-line-graph"></use></svg>Charts</a></li>
        <li  class="active"><a href="statistics.php"><svg class="glyph stroked table"><use xlink:href="#stroked-table"></use></svg>Stastistics</a></li>
        <li><a href="user_report.php"><svg class="glyph stroked pencil"><use xlink:href="#stroked-pencil"></use></svg>User report</a></li>
        <li><a href="advertise.php"><svg class="glyph stroked app-window"><use xlink:href="#stroked-app-window"></use></svg>Advertise</a></li>


</div><!--/.sidebar-->

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">

    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Statistics</h1>
        </div>
    </div><!--/.row-->

<script>
	function clearData(){
		var r = confirm("Clear Database?");
		if(r == true){
			window.location="clearData.php";
		}		
	}

</script>


    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">การให้บริการรถไฟฟ้า
                 <div class="pull-right"><a href="##" onClick="clearData()"><svg class="glyph stroked trash"><use xlink:href="#stroked-trash"></svg></a></div>
                    <div class="pull-right"><a href="##" onclick="window.print()"><svg class="glyph stroked printer"><use xlink:href="#stroked-printer"></svg></a></div>
                    </div>
                <div class="panel-body">
                    <table data-toggle="table" data-url="tables/data1.json"  data-show-refresh="true" data-show-toggle="true" data-show-columns="true" data-search="true" data-select-item-name="toolbar1" data-pagination="true" data-sort-name="name" data-sort-order="desc" id="refresh">
                        <thead>
                        <tr>
                         <th data-field="id" data-sortable="true">id</th>
                            <th data-field="date" data-sortable="true">DD/MM/YY</th>
                            <th data-field="car_num"  data-sortable="true">Bus</th>
                            <th data-field="mile_start" data-sortable="true">Start-mile</th>
                            <th data-field="mile_end" data-sortable="true">End-mile</th>
                            <th data-field="meter_start" data-sortable="true">Start-Meter</th>
                            <th data-field="meter_end" data-sortable="true">End-Meter</th>
                            <th data-field="total_user" data-sortable="true">Total user</th>
                        </tr>
                        </thead>
                    </table>
                </div>
            </div>
        </div>
    </div><!--/.row-->


    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">จำนวนผู้ใช้บริการรถไฟฟ้า

                </div>
                <div class="panel-body">
                    <table data-toggle="table" data-url="tables/data2.json"  data-show-refresh="true" data-show-toggle="true" data-show-columns="true" data-search="true" data-select-item-name="toolbar1" data-pagination="true" data-sort-name="name" data-sort-order="desc">
                        <thead>
                        <tr>

                            <th data-field="round" data-sortable="true">Round</th>
                            <th data-field="station"  data-sortable="true">Bus stop</th>
                            <th data-field="time" data-sortable="true">Time</th>
                            <th data-field="amount_user" data-sortable="true">Count</th>
                        </tr>
                        </thead>
                    </table>
                </div>
            </div>
        </div>
    </div><!--/.row-->




</div><!--/.main-->

<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/chart.min.js"></script>
<script src="js/chart-data.js"></script>
<script src="js/easypiechart.js"></script>
<script src="js/easypiechart-data.js"></script>
<script src="js/bootstrap-datepicker.js"></script>
<script src="js/bootstrap-table.js"></script>
<script>
    !function ($) {
        $(document).on("click","ul.nav li.parent > a > span.icon", function(){
            $(this).find('em:first').toggleClass("glyphicon-minus");
        });
        $(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
    }(window.jQuery);

    $(window).on('resize', function () {
        if ($(window).width() > 768) $('#sidebar-collapse').collapse('show')
    })
    $(window).on('resize', function () {
        if ($(window).width() <= 767) $('#sidebar-collapse').collapse('hide')
    })
</script>
</body>

</html>

<?php ob_end_flush(); ?>
