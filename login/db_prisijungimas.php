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


    // Prisijungimo kintamieji/duomenys
    $serveris = "localhost";
    $username = "root";
    $slaptazodis = "";
    $dbPavadinimas = "reg_puslapis_vartotojai";
    

    // Ivestos per html forma reiksmes
    $ivestasLogin = $_POST["log-name"];
    $ivestasPsw = uzkoduotiSlaptazodi($_POST["log-password"]);

     // Sukuriame jungti
    $jungtis = new mysqli($serveris, $username, $slaptazodis, $dbPavadinimas);

    // Patikriname jungti
    if ($jungtis -> connect_error)
    {
        die("Nepavyko prisijungti: " . $jungtis->connect_error);
    }
    else
    {
       // echo "Prisijungėme prie DB...";
    }

    // Susikuriame sql uzklausa
    $sqlVartotojoGavimas = "SELECT * FROM vartotojai WHERE login='$ivestasLogin'";

    // Paleidziame sql uzklausa ir gauname rezultatus
    $rezultatas = $jungtis->query($sqlVartotojoGavimas);

    // Ar gavome koki nors rezultata - ar tokio is vis nera
    if ($rezultatas->num_rows > 0)
    {
        while ($eilute = $rezultatas->fetch_assoc())
        {
            if ($ivestasPsw == $eilute["password"])
            {
                echo "Sveiki prisijungę,\n" . $eilute["login"];
            }
            else
            {
                echo "Neteisingas slaptažodis";
            }
        }
    }
    else
    {
        echo "Tokio vartotojo nėra, bandykite dar kartą...";
    }

?>