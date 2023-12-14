<?php

$conn = mysqli_connect("localhost","root","","android");

// replace -> with =
//$stmt -> $conn->prepare('SELECT * FROM medecins');
$stmt = $conn->prepare('SELECT nom, prenom, sexe, specialite,adresse, numtel FROM medecins');
$stmt->execute();

$medecins = [];

$stmt->bind_result($nom, $prenom, $sexe, $specialite, $adresse, $numtel);

while($stmt -> fetch()){
    $temp = [   'nom'       => $nom,
                'prenom'    => $prenom,
                'sexe'      => $sexe,
                'specialite'=> $specialite,
                'adresse'   => $adresse,
                'numtel'    => $numtel
            ];

    //dans chaque iteration $temp va contenir un medecin
    $medecins[] = $temp;
}

echo json_encode($medecins);

?> 