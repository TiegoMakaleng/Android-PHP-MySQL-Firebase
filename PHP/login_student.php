<?php

  if ($_SERVER['REQUEST_METHOD']=='POST') {
	 
       $username = $_POST['username_student'];
       $password = $_POST['password_student'];
	     	 
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
			$sql = "select id,studentNo,surname,initials,gender,birthdate,profile_pic_url "
			      ."from login, student "
				  ."where student.studentNo=login.username "
				  ."and login.username=$username "
				  ."and password='$password'";
			
			$result = mysqli_query($con, $sql);
			
	        //user record
		    $record = array();		
			while ($row = mysqli_fetch_array($result)) {
					array_push($record, array(
						"id"=>$row["id"],
						"studentNo"=>$row["studentNo"],
						"surname"=>$row["surname"],
						"initials"=>$row["initials"],
						"gender"=>$row["gender"],
						"birthdate"=>$row["birthdate"],
						"profile_pic_url"=>$row["profile_pic_url"])
					 );
				} 
				//Close database connection
				 mysqli_close($con);
				 if ($record) {
					//display the user record in json format
					echo json_encode(array("student_login"=>$record));
				} else {
					 //displaying failed login message
					 echo 'Login failed'; 
				 }
		}
    }
?>