<?php
    function uzkoduotiSlaptazodi($slaptazodis)
    {
        $papildomaDruska = "akjdjad*7^%$%$$^^*)MK";
        $slaptazodis = $papildomaDruska . $slaptazodis;
        $tempString = "";
        for ($i = 0; $i < strlen($slaptazodis); $i++)
        {
            $tempString = $tempString . $slaptazodis[$i];
            $tempString++;
        }
        return $tempString;
    }


    // Daomenu bazes kintamieji
    $serveris = "localhost";
    $username = "root";
    $slaptazodis = "";
    $dbPavadinimas = "reg_puslapis_vartotojai";
    
    $ivestasLogin = $_POST['name'];
    $ivestasPsw = uzkoduotiSlaptazodi($_POST['password']);
    $ivestasEmail = $_POST['email'];

    // Sukuriame jungti
    $jungtis = new mysqli($serveris, $username, $slaptazodis, $dbPavadinimas);

    // Patikriname jungti 
    if ($jungtis->connect_error)
    {
        die("Nepavyko prisijungti: " . $jungtis->connect_error);
    }
    else
    {
        echo "Prisijungėme prie DB...";
    }

    /*--- Susikuriame prepared statement SQL uzklausos----*/
    
    $paruostasSql = $jungtis->prepare("INSERT INTO vartotojai (login, password, email) VALUES (?, ?, ?)");
    $paruostasSql->bind_param("sss", $ivestasLogin, $ivestasPsw, $ivestasEmail); 

    // Paleidziame ta paruosta sakini
    if ($paruostasSql -> execute())
    {
        echo "<br> Registracija pavyko !";
    }
    else
    {
        echo mysqli_error($jungtis);
    }

    $jungtis->close();

?>