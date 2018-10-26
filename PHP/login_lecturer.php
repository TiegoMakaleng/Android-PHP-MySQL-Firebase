<?php

  if ($_SERVER['REQUEST_METHOD']=='POST') {
	 
       $username = $_POST['username_lecturer'];
       $password = $_POST['password_lecturer'];
	     	 
		// Verify if the correct username and password have been supplied
		if (isset ($username) && isset($password))
		{
			//Connect to the database
			require_once('dbConnect.php');
			
			// Check database connection
			if($con === false){
				die("ERROR: Could not connect. " . mysqli_connect_error());
			}
             						
			//Query the login table
			$sql = "select * from login,staff,lecturer where lecturer.fk_lecturer_no=staff.staffNo and login.username=staff.staffNo and login.username=$username and login.password = '$password'";
			
			$result = mysqli_query($con, $sql);
			
	        //user record
		    $record = array();		
			while ($row = mysqli_fetch_array($result)) {
					array_push($record, array(
						"id"=>$row["id"],
						"staffNo"=>$row["staffNo"],
						"surname"=>$row["surname"],
						"initials"=>$row["initials"],
						"officeNo"=>$row["officeNo"],
						"salary"=>$row["salary"],
						"profile_pic_url"=>$row["profile_pic_url"])
					 );
				} 
				//Close database connection
				 mysqli_close($con);
				 if ($record) {
					//display the user record in json format
					echo json_encode(array("staff_login"=>$record));
				} else {
					 //displaying failed login message
					 echo 'Login failed'; 
				 }
		}
    }
?>