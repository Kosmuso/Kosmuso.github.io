function perjungtiTaba(taboId)
{
    var tabCont = document.getElementsByClassName("warehouse-content-div")
    var rodomasTab = document.getElementById(taboId)
    for (let i = 0; i < tabCont.length; i++)
    {
       tabCont[i].style.display = "none";
    }
    rodomasTab.style.display = "initial";
}

function ijungtiKainarasti(kainarascioId)
{
    var visiKainarasciai = document.getElementsByClassName("kainarastis");
    var rodomasKainarastis = document.getElementById(kainarascioId);
 
    var paslauguMygtukai = document.getElementsByClassName("paslaugos-pasirinkimas");
 
    var kainarascioIsjungimoMygtukas = document.getElementById("kainarascio-isjungimo-mygtukas");
    for (let i = 0; i < visiKainarasciai.length; i++)
    {
        visiKainarasciai[i].style.display = "none";
    }
    rodomasKainarastis.style.display = "initial";
 
 
 
    for (let i = 0; i < paslauguMygtukai.length; i++)
    {
        paslauguMygtukai[i].style.display = "none";
     //   paslauguMygtukai[2].style.display = "none";
    }   
 
    kainarascioIsjungimoMygtukas.style.display = "initial";
}
 
function isjungtiKainarasti()
{
    var visiKainarasciai = document.getElementsByClassName("kainarastis");
    var paslauguMygtukai = document.getElementsByClassName("paslaugos-pasirinkimas");
    var kainarascioIsjungimoMygtukas = document.getElementById("kainarascio-isjungimo-mygtukas");
 
 
    for (let i = 0; i < visiKainarasciai.length; i++)
    {
        visiKainarasciai[i].style.display = "none";
    }
    for (let i = 0; i < paslauguMygtukai.length; i++)
    {
        paslauguMygtukai[i].style.display = "initial";
    }
 
    kainarascioIsjungimoMygtukas.style.display = "none";
 
 
}