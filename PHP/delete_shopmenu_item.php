<?php
	if($_SERVER['REQUEST_METHOD']=='POST'){
	  //check if the order id was provided
      $menuId = $_POST['m_in_shop_id'];
      if (isset($menuId)) {
		   
		//connect to the database
		require_once('dbConnect.php');	
	 
		// Check connection
		if($con === false){
			die("ERROR: Could not connect. " . mysqli_connect_error());
		}

		//a query to delete an order
		$sql = "delete from tblmenu where menuID=$menuId";
		 
		if(mysqli_query($con, $sql)){
			echo "deleted";
		} else{
			echo "ERROR: Could not able to execute $sql. " . mysqli_error($con);
		}
		 
		// Close connection
		mysqli_close($con);
	  } else {
		  echo "All values not provided.";
	  }
	} else {
	   echo "POST Error.";
	}
?>
	