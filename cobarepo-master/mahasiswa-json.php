<?php
include("config.php");

$sql = "SELECT * FROM   data_mahasiswa";
$result = array();
$query = mysqli_query($db, $sql);

while($row = mysqli_fetch_array($query)){
	array_push($result, array('nama_mahasiswa' => $row['nama_mahasiswa'],
    'nim_mahasiswa' => $row['nim_mahasiswa'],
    'alamat_mahasiswa' => $row['alamat_mahasiswa']

));
}
echo json_encode(array("result" => $result));
?>