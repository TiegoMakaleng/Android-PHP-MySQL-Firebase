<?php
  if($_SERVER['REQUEST_METHOD']=='GET') {
	  
  // if(isset($_GET['studentNo'])) {  
   
	require_once('dbConnect.php');
	
	// Check connection
		if($con === false){
			die("ERROR: Could not connect. " . mysqli_connect_error());
		}
		  
	$sql = "select surname,initials,gender,birthdate from student where studentNo='100'";
		
	if($r = mysqli_query($con, $sql)){
       if(mysqli_num_rows($r) > 0){
		$result = array();
		while ($res = mysqli_fetch_array($r)) {

			array_push($result, array(
			 "student"=>$res['surname'],
			 "initials"=>$res['initials'],
			 "gender"=>$res['gender'],
			 "dob"=>$res['birthdate']
			 )
			);
		}
		// Close result set
        mysqli_free_result($r);
		// display the result
		   echo json_encode(array("student"=>$result));
	   } else {
		    echo "No records matching your query were found.";
	   }
	} else {
		
	 // echo "ERROR: Could not able to execute $sql. " . mysqli_error($con);
	    echo "ERROR: Could not be able to execute query";
	}
	// Close connection
	mysqli_close($con);
   
   //}
  }
?>