<?php

	$objConnect = mysql_connect("localhost","root","");
	$objDB = mysql_select_db("southnationpark");
	$objQuery= mysql_query("SET NAMES UTF8");

	$animalID = $_POST["animalID"];
	$strSQL = "SELECT animal,park_name FROM data_southnationpark where 1 AND id = '".$animalID."'";
	$objQuery = mysql_query($strSQL);
	$obResult = mysql_fetch_array($objQuery);
	if($obResult)
	{
		$arr["animal"] = $obResult["animal"];
		$arr["parkname"] = $obResult["park_name"];

	}
	mysql_close($objConnect);

	echo json_encode($arr);
?>