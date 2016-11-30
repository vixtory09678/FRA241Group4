<!DOCTYPE html>
<html>
<body>


<a href="<?= $_GET["links"]; ?>"> <img id="myImg" src="<?= $_GET["fileToUpload"]; ?>" alt="file";></a>


<?php
	$j=scandir("uploads");
	foreach( $j as $x){
		$x=  "uploads/".$x;
		echo $x;
		unlink($x) ;
	}

$target_dir = "uploads/";
$target_file = $target_dir . basename($_FILES["fileToUpload"]["name"]);
$uploadOk = 1;
$imageFileType = pathinfo($target_file,PATHINFO_EXTENSION);
// Check if image file is a actual image or fake imageu
if(isset($_POST["submit"])){
    $check = getimagesize($_FILES["fileToUpload"]["tmp_name"]);
    if($check !== false) {
        echo "File is an image - " . $check["mime"] . ".";
        $uploadOk = 1;
    } else {
        echo "File is not an image.";
        $uploadOk = 0;
    }
}
// Check if file already exists
if (file_exists($target_file)) {
    echo "Sorry, file already exists.";
    $uploadOk = 0;
}
// Check file size
if ($_FILES["fileToUpload"]["size"] > 500000) {
    echo "Sorry, your file is too large.";
    $uploadOk = 0;
}
// Allow certain file formats
if($imageFileType != "jpg" && $imageFileType != "png" && $imageFileType != "jpeg"
&& $imageFileType != "gif" ) {
    echo "Sorry, only JPG, JPEG, PNG & GIF files are allowed.";
    $uploadOk = 0;
}
// Check if $uploadOk is set to 0 by an error
if ($uploadOk == 0) {
    echo "Sorry, your file was not uploaded.";
// if everything is ok, try to upload file
} else {
    if (move_uploaded_file($_FILES["fileToUpload"]["tmp_name"], $target_file)) {
        echo "The file ". basename( $_FILES["fileToUpload"]["name"]). " has been uploaded.";
    } else {
        echo "Sorry, there was an error uploading your file.";
    }
}

$get_pic	 = scandir("uploads");
$url_picture = "http://178.62.101.217/uploads/".$get_pic[2];
$url_link = $_POST['url_link'];
$content = $_POST['content'];

$output = array('url_picture'=>$url_picture,'url_link'=>$url_link,'content'=>$content);
$fp = fopen('tables/adsOut.json', 'w');
fwrite($fp, json_encode($output,JSON_UNESCAPED_SLASHES));
fclose($fp);
		
?>


</body>
</html>
