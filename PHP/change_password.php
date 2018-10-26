<?php
 if($_SERVER['REQUEST_METHOD']=='POST')
 {
	
	$custID = $_POST['custID'];
	$new_password = $_POST['new_password'];
		
	if (isset($custID) && isset($new_password)) {
		
		require_once('dbConnect.php');
		
		// Check connection
		if($con === false){
			die("ERROR: Could not connect. " . mysqli_connect_error());
		}
		
		$sql = "update tblcustomer "
		      ."set password ='$new_password' "
			  ."where custID ='$custID'";
			  
		if (mysqli_query($con, $sql)){
			
			echo "Password updated successfully.";
			
		} else {
			
			echo "ERROR: Could not able to execute $sql. " . mysqli_error($con);
			
		}
     // Close connection
        mysqli_close($con);	
		
	} else {
		echo "Please provide all the values";
	}
 }
 else
 {
	echo "POST error";
 }

?>
	