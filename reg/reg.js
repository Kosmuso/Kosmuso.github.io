window.onload = function ()
{
    var pagrAntraste = document.getElementById("pagr-antraste");
    var pagrAntrasteTekstas = pagrAntraste.innerHTML;
    console.log(pagrAntrasteTekstas);

    //var regforma = document.getElementById("reg-forma"); //pagal id
    var regForma = document.forms["reg-forma"]; //pagal name ir id
    var vardoLaukas = regForma.name;
    var vardoLaukotekstas = vardoLaukas.value;

    console.log(vardoLaukotekstas);

    // su papildomu mygtuku
    var testbtn = document.getElementById("testbtn")
    
}

function paspaudusTest()
    {
        var regForma = document.forms["reg-forma"];

        var vardoLaukas = regForma.name;
        var vardoLaukoTekstas = vardoLaukas.value;

        var passwordLaukas = regForma.password;
        var passwordLaukoTekstas = passwordLaukas.value;


        var esamasUN = "Vardas";
        var esamaPav = "Pavarde";

        if ( esamasUN == vardoLaukoTekstas)
        {
            alert("toks vartotojas jau yra")
        }

        if ( passwordLaukoTekstas == "")
        {
            alert("turit ivesti Pavarde")
        }

        console.log("Vardas: " + vardoLaukoTekstas);
        console.log("Pavarde: " + passwordLaukoTekstas);
    }