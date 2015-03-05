<?php

	$objConnect = mysql_connect("localhost","root","");
	$objDB = mysql_select_db("southnationpark");
	$objQuery= mysql_query("SET NAMES UTF8");

	$climateID = $_POST["climateID"];
	$strSQL = "SELECT climate,park_name FROM data_southnationpark where 1 AND id = '".$climateID."'";
	$objQuery = mysql_query($strSQL);
	$obResult = mysql_fetch_array($objQuery);
	if($obResult)
	{
		$arr["climate"] = $obResult["climate"];
		$arr["parkname"] = $obResult["park_name"];

	}
	mysql_close($objConnect);

	echo json_encode($arr);
?>