<?php

	$objConnect = mysql_connect("localhost","root","");
	$objDB = mysql_select_db("southnationpark");
	$objQuery= mysql_query("SET NAMES UTF8");

	$topographyID = $_POST["topographyID"];
	$strSQL = "SELECT topography,general,park_name FROM data_southnationpark where 1 AND id = '".$topographyID."'";
	$objQuery = mysql_query($strSQL);
	$obResult = mysql_fetch_array($objQuery);
	if($obResult)
	{
		$arr["topography"] = $obResult["topography"];
		$arr["general"] = $obResult["general"];
		$arr["parkname"] = $obResult["park_name"];

	}
	mysql_close($objConnect);

	echo json_encode($arr);
?>