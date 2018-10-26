<?php
  if($_SERVER['REQUEST_METHOD']=='GET') {
	  
	require_once('dbConnect.php');
	
	// Check database connection
	if($con === false){
	   die("ERROR: Could not connect. ".mysqli_connect_error());
	}

	// subject, diploma, department
		  
	$sql = "select statusID,subject.subjCode, subjName, dip_name, department.description, status, status_icon_url " 
	."from subject, diploma, department, registration, student, staff, lecturer, faculty, tblAvailable "
	."where subject.fk_dipCode=diploma.dip_code "
	."and department.deptNo=diploma.fk_dept_id "
	."and subject.subjCode=registration.fk_subjCode "
	."and registration.fk_studentNo=student.studentNo "
	."and staff.staffNo=lecturer.fk_lecturer_no "
	."and subject.subjCode=lecturer.subjCode "
	."and faculty.facultyCode=department.fk_facultyNo "
	."and tblAvailable.fk_subjCode=lecturer.subjCode";
		
	if($r = mysqli_query($con, $sql)){
       if(mysqli_num_rows($r) > 0){
		$result = array();
		while ($res = mysqli_fetch_array($r)) {

			array_push($result, array(
			 "id"=>$res['statusID'],
			 "subject_code"=>$res['subjCode'],
			 "subject_name"=>$res['subjName'],
			 "course"=>$res['dip_name'],
			 "department"=>$res['description'],
			 "status"=>$res['status'],
			 "image_url"=>$res['status_icon_url']
			 )
			);
		}
		// Close result set
        mysqli_free_result($r);
		// display the result
		   echo json_encode(array("registration"=>$result));
	   } else {
		    echo "No records matching your query were found.";
	   }
	} else {
		
	  echo "ERROR: Could not able to execute $sql. " . mysqli_error($con);
	//    echo "ERROR: Could not be able to execute query";
	}
	// Close connection
	mysqli_close($con);
  }
?>