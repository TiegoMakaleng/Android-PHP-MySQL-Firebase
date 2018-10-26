<?php
	if($_SERVER['REQUEST_METHOD']=='POST')
	{

		$menuID = $_POST['menuID'];
		$menuDesc = $_POST['menu_desc'];
		$price = $_POST['price'];
		
	 if (isset($menuID) && isset($menuDesc) && isset($price)) {
			require_once('dbConnect.php');
			
			// Check connection
			if($con === false){
				die("ERROR: Could not connect. " . mysqli_connect_error());
			}
			
			$sql = "update tblmenu set menuDesc='$menuDesc', price=$price where menuID=$menuID";
				  
			if (mysqli_query($con, $sql)){
				echo "Menu updated";
			} else {
				echo "ERROR: Could not able to execute $sql. " . mysqli_error($con);
			}
     // Close connection
        mysqli_close($con);	  
		 
	 } else {
 		echo "Please provide all the values.";  
	 }
  }   
  else
  {
		echo "POST Request Error.";
  }
?>
	