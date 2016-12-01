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
        <li><a href="statistics.php"><svg class="glyph stroked table"><use xlink:href="#stroked-table"></use></svg>Statistics</a></li>
        <li><a href="user_report.php"><svg class="glyph stroked pencil"><use xlink:href="#stroked-pencil"></use></svg>User report</a></li>
        <li class="active"><a href="advertise.php"><svg class="glyph stroked app-window"><use xlink:href="#stroked-app-window"></use></svg>Advertise</a></li>

    </ul>
</div><!--/.sidebar-->

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">


    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Advertisement </h1>
        </div>
    </div><!--/.row-->


    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">Form</div>
                <div class="panel-body">
                    <div class="col-md-6">

                        <form action="ads.php" method="POST" enctype="multipart/form-data" target="resultFrame">
                            <div class="form-group">
                                <label>Avertising</label>
                                <input class="form-control" placeholder="name" name="content" id="name-ads">
                            </div>

                            <div class="form-group">
                                <label>File input</label>
                                <input type="file" name="fileToUpload" id="fileToUpload" accept="image/*">
                                <p class="help-block">Size:300x300 pixel</p>
                            </div>

                            <label>Link</label>
                            <div class="form-group has-success">
                                <input class="form-control" placeholder="URL" type="text" name="url_link" id="links">
                            </div>

                            <div class="col-md-12 widget-right">
                                <button type="submit" name="submit" Value="Upload Image" class="btn btn-default btn-md pull-right">Submit</button>
                            </div>
                        </form>

                    </div>
                </div>
            </div>
        </div><!-- /.col-->
        <a class="col-md-6">

            <iframe name="resultFrame" width="500" height="350" src="<?php
						
							$get_pic	 = scandir("uploads");
							$url_pic = "uploads/".$get_pic[2];
							echo $url_pic;
						
						 ?>">                  
            </iframe>

    </div><!-- /.row -->

</div><!--/.main-->

<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/chart.min.js"></script>
<script src="js/chart-data.js"></script>
<script src="js/easypiechart.js"></script>
<script src="js/easypiechart-data.js"></script>
<script src="js/bootstrap-datepicker.js"></script>
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
    $(function () {
        $(":file").change(function () {
            if (this.files && this.files[0]) {
                var reader = new FileReader();
                reader.onload = imageIsLoaded;
                reader.readAsDataURL(this.files[0]);
            }
        });
    });

    function imageIsLoaded(e) {
        $('#myImg').attr('src', e.target.result);
    };
</script>

</body>

</html>
<?php ob_end_flush(); ?>
