<?php
	if($_SERVER['REQUEST_METHOD']=='POST') {
		//Check if the username was provided
		if (isset($_POST['username'])) {
			
		   // Connect to the database
		    require_once('dbConnect.php');
			
			// Check connection
			if($con === false){
				die("ERROR: Could not connect. " . mysqli_connect_error());
			}
				
		$sql = 'select username from login where username ='.$_POST['username'];
				  			
		if($result = mysqli_query($con, $sql)){
          if(mysqli_num_rows($result) > 0){
			  echo "successful";
		  } else {
		      echo "The student number/Staff number does not exist."
		  }
		// Close result set
        mysqli_free_result($result);
	   } else {
		    echo "No_records";
	   }
	   mysqli_close($con);
	} else {
		
  // echo "ERROR: Could not able to execute $sql. " . mysqli_error($con);
	    echo "ERROR: Could not be able to execute query";
	}
   }  
?>
	