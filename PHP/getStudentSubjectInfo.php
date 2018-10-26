<?php
  if($_SERVER['REQUEST_METHOD']=='GET') {
	  
   if(isset($_GET['subjCode'])) {  
   
	require_once('dbConnect.php');
	
	// subject, diploma, department
		  
	$sql = "select subject.subjCode, subjName, dip_name, department.description,regDate,staff.surname,staff.initials,status,date_available,time_available " 
	."from subject, diploma, department, registration, student, staff, lecturer, faculty, tblAvailable "
	."where subject.fk_dipCode=diploma.dip_code "
	."and department.deptNo=diploma.fk_dept_id "
	."and subject.subjCode=registration.fk_subjCode "
	."and registration.fk_studentNo=student.studentNo "
	."and staff.staffNo=lecturer.fk_lecturer_no "
	."and subject.subjCode=lecturer.subjCode "
	."and faculty.facultyCode=department.fk_facultyNo "
	."and tblAvailable.fk_subjCode=lecturer.subjCode "
	."and subject.subjCode='".$_GET['subjCode']."' "
	."order by subject.subjCode LIMIT 0, 50";
		
	if($r = mysqli_query($con, $sql)){
       if(mysqli_num_rows($r) > 0){
		$result = array();
		while ($res = mysqli_fetch_array($r)) {

			array_push($result, array(
			 "subject_code"=>$res['subjCode'],
			 "subject_name"=>$res['subjName'],
			 "course"=>$res['dip_name'],
			 "department"=>$res['description'],
			 "reg_date"=>$res['regDate'],
			 "lecturer"=>$res['surname']." ".$res['initials'],
			 "availability"=>$res['status'],
			 "date_available"=>$res['date_available'],
			 "time_available"=>$res['time_available']
			 )
			);
		}
		// Close result set
        mysqli_free_result($r);
		// display the result
		   echo json_encode(array("availability"=>$result));
	   } else {
		    echo "No records matching your query were found.";
	   }
	} else {
		
	 // echo "ERROR: Could not able to execute $sql. " . mysqli_error($con);
	    echo "ERROR: Could not be able to execute query";
	}
	// Close connection
	mysqli_close($con);
   
   }
  }
?>