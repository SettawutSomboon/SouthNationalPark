<?php

	$objConnect = mysql_connect("localhost","root","");
	$objDB = mysql_select_db("southnationpark");
	$objQuery= mysql_query("SET NAMES UTF8");

	$plantID = $_POST["plantID"];
	$strSQL = "SELECT plant,park_name FROM data_southnationpark where 1 AND id = '".$plantID."'";
	$objQuery = mysql_query($strSQL);
	$obResult = mysql_fetch_array($objQuery);
	if($obResult)
	{
		$arr["plant"] = $obResult["plant"];
		$arr["parkname"] = $obResult["park_name"];

	}
	mysql_close($objConnect);

	echo json_encode($arr);
?>