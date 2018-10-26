<?php
if($_SERVER['REQUEST_METHOD']=='POST')
{
		$name = $_POST['name'];
		$lastname = $_POST['lastname'];
		$phone = $_POST['phone'];
		$email = $_POST['email'];
		$username = $_POST['username'];
		$password = $_POST['password'];
	    $idNum = $_POST['idNum'];
		
		require_once('dbConnect.php');
		
		$sql = "select * from tblcustomer where email='$email'";
		echo 'connected';
		$check = mysqli_fetch_array(mysqli_query($con,$sql));
			
		if(isset($check))
		{
			echo 'Email address already exists. Please provide another email address';
		}
		else
		{				
			$sql = "insert into tblcustomer (name,lastname,phone,email,username,password,role,id_num) values('$name','$lastname','$phone','$email','$username','$password', '$idNum')";
			
			
			if(mysqli_query($con,$sql))
			{
				
				echo 'Successfully registered';
				
			}
			else
			{
				echo 'Registration Failed. Please try again!';
			}
		}
		mysqli_close($con);
		
}
else
{
  echo 'POST Error!';
}
?>