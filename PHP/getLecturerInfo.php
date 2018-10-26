<?php

	if($_SERVER['REQUEST_METHOD']=='GET')
	{
	 // $_REQUEST variable contains the contents of both $_GET, $_POST, and $_COOKIE
	//	$shopID = $_REQUEST['fk_owner_id'];
		$shopID = $_GET['fk_owner_id'];
	
		require_once('dbConnect.php');
		
		// Check connection
		if($con === false){
			die("ERROR: Could not connect. " . mysqli_connect_error());
		}

		$sql = "select * from tblmenu where fk_owner_id = $shopID";
		
        $r = mysqli_query($con, $sql);
		$result = array();
		while ($res = mysqli_fetch_array($r)) {

			array_push($result, array(
			 "id"=>$res['menuID'],
			 "description"=>$res['menuDesc'],
			 "price"=>$res['price']
			 )
			);
				
		}
	    mysqli_close($con);
	    echo json_encode(array("menu"=>$result));
	}
?>
	