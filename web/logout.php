<?php
	ob_start();
	session_start();
?>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Untitled Document</title>
</head>

<body>
	<?php
		echo "<center><h1>Logout!</h1></center>";
		session_destroy();
		header("Refresh: 1; url=index.php");
		exit('</body></html>');
		ob_end_flush();	
	?>
</body>
</html>