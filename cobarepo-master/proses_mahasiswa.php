<?php
include("config.php");

$nama_mahasiswa= $_POST['nama_mahasiswa'];
$nim_mahasiswa= $_POST['nim_mahasiswa'];
$alamat_mahasiswa= $_POST['alamat_mahasiswa'];

$sql = "INSERT INTO data_mahasiswa (nama_mahasiswa, nim_mahasiswa, alamat_mahasiswa) values ('$nama_mahasiswa','$nim_mahasiswa','$alamat_mahasiswa')";
$query = mysqli_query($db, $sql);

if ($query){
}else{
	die("gagal menyimpan perubahan.....");
}

?>
