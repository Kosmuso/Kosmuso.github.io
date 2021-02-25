
var langeliai = document.querySelectorAll(".flex-container div");
var mygtukas = document.getElementById("mygtukas");
var figuruMygtukas = document.getElementById("figuros");
var tekstoLaukelis = document.getElementById("pasirinktas-langelis");

figuruMygtukas.addEventListener("click", pestininkoFiguros(langeliai));
mygtukas.addEventListener("click", paspaudusMygtukui(tekstoLaukelis, langeliai));

for (let i = 0; i < langeliai.length; i++)
{
    langeliai[i].addEventListener("click", paspaudusLangeli(i));
}

function paspaudusLangeli(index)
{
    return function()
    {
        var skaiciaiRaidem = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'];
        var sveikaDalis = parseInt(index / 8);
        var liekana = index % 8;
        var isvestiSpan = document.querySelector("#isvedamas-langelis span");
        liekana++;
        var langelis = skaiciaiRaidem[sveikaDalis] + liekana;
        isvestiSpan.innerHTML = langelis.toUpperCase();
    }
}

function paspaudusMygtukui(tekstoLaukelis, langeliai)
{
    return function()
    {
        var ivestasLangelis =  tekstoLaukelis.value;
        var raidesSkaiciais = {a: 0, b: 1, c: 2, d: 3, e: 4, f: 5, g: 6, h: 7};
        var raide = ivestasLangelis[0].toLowerCase();
        var skaicius = parseInt(ivestasLangelis[1]);
        var paverstasSkaicius = (raidesSkaiciais[raide] * 8) + skaicius;

        langeliai[paverstasSkaicius - 1].style.backgroundColor = "green";
    }
}

function pestininkoFiguros()
{
    return function()
    {
        $(".flex-container div#pestininkas").prepend('<img id="theImg" src="img/pawn.png" width=75 height=75 />')
    }
}

