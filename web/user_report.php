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
    <link href="css/styles.css" rel="stylesheet">

    <!--Icons-->
    <script src="js/lumino.glyphs.js"></script>
    <script src="js/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
    <script src="js/chart.min.js"></script>
    <script src="js/easypiechart.js"></script>
    <script src="js/easypiechart-data.js"></script>
    <script src="js/bootstrap-datepicker.js"></script>

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
        <div align="center">
            <img src = "AWT-Bus.png" width="100" height="90" border="0">
        </div>

        <li role="presentation" class="divider"></li>

        <li><a href="dashboard.php"><svg class="glyph stroked dashboard-dial"><use xlink:href="#stroked-dashboard-dial"></use></svg> Dashboard</a></li>
        <li><a href="charts.php"><svg class="glyph stroked line-graph"><use xlink:href="#stroked-line-graph"></use></svg>Charts</a></li>
        <li><a href="statistics.php"><svg class="glyph stroked table"><use xlink:href="#stroked-table"></use></svg>Statistics</a></li>
        <li class="active"><a href="user_report.php"><svg class="glyph stroked pencil"><use xlink:href="#stroked-pencil"></use></svg>User report</a></li>
        <li><a href="advertise.php"><svg class="glyph stroked app-window"><use xlink:href="#stroked-app-window"></use></svg>Advertise</a></li>




</div><!--/.sidebar-->

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">User Report</h1>
        </div>
        
    </div><!--/.row-->
	<script>
		function clearReport(){
			var r = confirm("Clear Database?");
			if(r == true){
				window.location="clearReport.php";
			}		
		}
		
	</script>
	



            <div class="panel panel-default chat">
                <div class="panel-heading" id="accordion"><svg class="glyph stroked clipboard with paper"><use xlink:href="#stroked-clipboard-with-paper"/></svg>  Report!
                <div class="pull-right"><a href="##" onClick="clearReport()" ><svg class="glyph stroked trash"><use xlink:href="#stroked-trash"></svg></a></div>
                </div>
				
                <div class="panel-body" id="showComment" style="height:500px">
                    <ul>
                        <script type="text/javascript">
                            var number = [];
                            var date = [];
                            var comment = [];
							console.log("pass1");
                            $.getJSON("tables/report.json",function(data){
                                console.log(data);
								
                                $.each(data,function(index,field){
                                    $.each(field,function(id2,field2){
                                        if(id2 === "number"){
                                            console.log("is date");
											number.push(field2);
                                        }else if(id2 === "date"){
                                            console.log("is time");
                                            date.push(field2);
                                        }else if(id2 ==="comment") {
                                            console.log("is content");
                                            comment.push(field2);
                                        }
                                    });
                                });
								var showHtml="";
							for(var i=0;i<number.length;i++){
								var code = 
								"<li class=\"left clearfix\"><span class=\"chat-img pull-left\">"+
								"<img src=\"http://placehold.it/80/30a5ff/fff\" alt=\"User Avatar\" class=\"img-circle\" /></span>"+
								"<div class=\"chat-body clearfix\"><div class=\"header\"><strong class=\"primary-font\">&nbsp&nbsp people"+number[i]+
								"</strong> <small class=\"text-muted\">"+date[i]+"</small> </div><p>&nbsp&nbsp"+comment[i]+"</p></div></li><BR><BR>";
								
								showHtml=showHtml+code;	
							}
							document.getElementById("showComment").innerHTML=showHtml;
								console.log("yeahh");
                            });
								
                        </script>


                    </ul>
                </div>


            </div>

        </div><!--/.col-->



    </div><!--/.row-->
</div>	<!--/.main-->



<script>
    $('#calendar').datepicker({
    });

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
