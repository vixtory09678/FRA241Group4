<?php
	ob_start();
	session_start();
?>
<!DOCTYPE html>
<html>
<body>
      <?php
            if($_POST['username']){
                $username = $_POST['username'];
                $password = $_POST['password'];
                if($username == 'few2net' && $password == 'DekiS#69' ){
						$_SESSION['authen']=TRUE;
						echo "<center><h1 style=\"font-family: Arial, Helvetica, sans-serif;\">Welcome!!</h1></center>";
						header("Refresh: 1; url=dashboard.php");
						exit('</body></html>');
						ob_end_flush();
					}
				else
					{
						echo "<center><h1>Wrong password!!</h1></center>";
						header("Refresh: 1; url=index.php");
						exit('</body></html>');
						ob_end_flush();
					}
            }
        ?>
</body>
</html>
<?php ob_end_flush(); ?>