<%-- 
    Document   : index
    Created on : 2013-12-18, 09:51:18
    Author     : Salwa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <meta http-equiv="Content-Language" content="pl">
        <meta NAME="Description" CONTENT="" >
        <title>RSHome</title>
        <link href="style/style.css" rel="stylesheet" type="text/css" media="screen" >
        <script type="text/javascript" src="skrypty/jquery-1.10.2.js"></script>
        <script>

            $(document).ready(function() {
                clicked_panel = 0;
                pp_clicked = 0;
                panel_powiekszony = 0;



                setInterval(function() {
                    $.ajax({
                        type: "POST",
                        url: "TCPServlet",
                        data: {
                            typ: 1, // 1 – odczyt 2 – ustawienie wartości
                            czujnik: 1 // numer czujnika/podzespołu
                        },
                        success: function(msg) {
                            //ten fragment wykona się po POMYŚLNYM zakończeniu połączenia
                            //msg zawiera dane zwrócone z serwera
                            //alert(msg);
                            $("#tabela2_ust").html(msg);
                            console.log(msg);
                        },
                        complete: function(r) {
                            //ten fragment wykona się po ZAKONCZENIU połączenia
                            //alert("COMPLETE");
                        },
                        error: function(error) {
                            //ten fragment wykona się w przypadku BŁĘDU
                        }});
                }, 10000);





                $(".item_1").click(function() {
                    $(".prawy_panel").css("width", "0px");
                    $("#body_content").animate({
                        top: '-=' - $("#body_content").height(),
                        left: '-=' + $("#body_content").width(),
                        width: $("#body_content").width() * 2
                    });
                    clicked_panel = 1;
                    console.log('pp if== 0 after = ' + clicked_panel);
                    $("#body_content").promise().done(function() {
                        $("#prawy_prawy_panel").css("float", "right");
                        $("#prawy_prawy_panel").css("width", "45%");
                        $("#prawy_prawy_panel").css("right", "200px");
                        $("#prawy_prawy_panel").show(700, function() {
                            $("#prawy_prawy_panel").css("display", "block");

                        });//show
                        $("#naglowek").css("display", "none");

                    });


                });

                $("#id_graf_wroc").click(function() {
                    factor = 2;
                    console.log('click ppp =' + clicked_panel);
                    $("#naglowek").css("display", "block");

                    $("#body_content").animate({
                        top: '0',
                        left: '0',
                        width: $("#body_content").width() / 2
                    });
                    pp_clicked = 1;
                    $(".prawy_prawy_panel").css("display", "none");
                    $(".prawy_panel").css("display", "block");
                    $(".prawy_panel").css("width", "70%");

                });


                $(".current").slideUp();

                $("#next").click(function() {
                    if ($('.current').next('.slide').length > 0) {
                        $(".current").slideUp();
                        $('.current').removeClass('current').next('.slide').addClass('current');
                    }

                });

                $("#next2").click(function() {
                    if ($('.current').next('.slide').length > 0) {
                        $(".current").slideUp();
                        $('.current').removeClass('current').next('.slide').addClass('current');
                    }

                });





                $("#prev").click(function() {
                    if ($('.current').prev('.slide').length > 0) {
                        $('.current').removeClass('current').prev('.slide').addClass('current');
                        $(".current").slideDown();
                    }


                });

                $("#button_wart").click(function() {

                    $.ajax({
                        type: "POST",
                        url: "TCPServlet",
                        data: {wart: '11'
                        },
                        success: function(msg) {
                            console.log(msg);
                        },
                        complete: function(r) {},
                        error: function(error) {}
                    });
                });

                $(window).bind("beforeunload", function() {
                    confirm("Wyjsc??");
                });


                $(".item_4").click(function() {

                    $("#strona_glowna").css('display', 'none');
                    $("#ustawienia").css('display', 'none');
                    $("#dom").css('display', 'block');
                    $("#info").css('display', 'none');
                    $("#pomoc").css('display', 'none');

                    $("#lewy_panel").animate({
                        height: '0px'
                    });
                    $("#lewy_panel").css('display', 'none');

                    $(".dom").animate({
                        height: '100%',
                        width: '96%'
                    });
                });
                $(".item_2").click(function() {
                    $("#strona_glowna").css('display', 'block');
                    $("#ustawienia").css('display', 'none');
                    $("#dom").css('display', 'none');
                    $("#info").css('display', 'none');
                    $("#pomoc").css('display', 'none');
                });
                $(".item_3").click(function() {
                    $("#strona_glowna").css('display', 'none');
                    $("#ustawienia").css('display', 'block');
                    $("#dom").css('display', 'none');
                    $("#info").css('display', 'none');
                    $("#pomoc").css('display', 'none');
                });


                $(".item_5").click(function() {
                    $("#strona_glowna").css('display', 'none');
                    $("#ustawienia").css('display', 'none');
                    $("#dom").css('display', 'none');
                    $("#info").css('display', 'block');
                    $("#info").css('height', '80%');
                    $("#pomoc").css('display', 'none');
                });
                $(".item_6").click(function() {
                    $("#strona_glowna").css('display', 'none');
                    $("#ustawienia").css('display', 'none');
                    $("#dom").css('display', 'none');
                    $("#info").css('display', 'none');
                    $("#pomoc").css('display', 'block');
                });


                $("#kuch_inf").click(function() {
                    $(".slide_info1").slideToggle()
                });
                $("#zew_inf").click(function() {
                    $(".slide_info2").slideToggle()
                });
                
                
                $("#kom1").click(function() {
                    $.ajax({
                        type: "POST",
                        url: "TCPServlet",
                        data: {
                            wart: '11'
                        },
                        success: function(msg) {
                            alert(msg);
                            if ($("#ard_wyslij_wart").val().trim() == '20')
                                alert("Temperatura: " + msg + " C");
                            if ($("#ard_wyslij_wart").val().trim() == '21')
                                alert("Wilgotnosc: " + msg + " %");

                        },
                        complete: function(r) {
                            //ten fragment wykona się po ZAKONCZENIU połączenia
                            //"r" to przykładowa nazwa zmiennej, która zawiera dane zwrócone z serwera
                            //alert("COMPLETE");
                        },
                        error: function(error) {
                            //ten fragment wykona się w przypadku BŁĘDU
                            //alert("DUPA");
                        }
                    });
                });
                
                $("#kom2").click(function() {
                    alert(2);
                });
                $("#kom3").click(function() {
                    alert(3);
                });
                $("#kom4").click(function() {
                    alert(4);
                });
                $("#kom5").click(function() {
                    alert(5);
                });
                $("#kom6").click(function() {
                    alert(6);
                });
                $("#kom7").click(function() {
                    alert(7);
                });
                $("#kom8").click(function() {
                    alert(8);
                });
                $("#kom9").click(function() {
                    alert(9);
                });
                $("#kom10").click(function() {
                    alert(10);
                });
                $("#kom11").click(function() {
                    alert(11);
                });
                $("#kom12").click(function() {
                    alert(12);
                });
                $("#kom13").click(function() {
                    alert(13);
                });
                $("#kom14").click(function() {
                    alert(14);
                });
                $("#kom15").click(function() {
                    alert(15);
                });
                $("#kom16").click(function() {
                    alert(16);
                });
                $("#kom17").click(function() {
                    alert(17);
                });
                
                
            });




        </script>   
    </head>
    <body>

        <div id="body_content">

            <div id="naglowek">
                <div class="naglowek_logo">

                </div> 
                <div class="naglowek_obrazek">

                </div> 
            </div> 
            <div class="tresc">
                <div id="lewy_panel" class="lewy_panel">
                    <div id="lewe_menu" class="lewe_menu shadow">
                        <div id="lewe_menu_naglowek" class="lewe_menu_naglowek">
                            Menu:
                        </div>
                        <div id="lewe_menu_lista" class="lewe_menu_lista ">
                            <ul class="lewe_menu_item">
                                <li style="display:none;" class="item_1 l_m_l">
                                    <a href="#" class="slide_right" > Statystyki</a>
                                </li>
                                <li class="item_2 l_m_l">
                                    <a href="#" onclick=""> Strona główna</a>
                                </li>
                                <li class="item_3 l_m_l">
                                    <a href="#" onclick=""> Ustawienia</a>
                                </li>
                                <li class="item_4 l_m_l">
                                    <a href="#" onclick=""> Dom</a>
                                </li>
                                <li class="item_5 l_m_l">
                                    <a href="#" onclick=""> Informacje</a>
                                </li>
                                <li class="item_6 l_m_l">
                                    <a href="#" onclick=""> Pomoc</a>
                                </li>
                            </ul>
                        </div>
                    </div> 
                </div> 

                <div id="strona_glowna" class="prawy_prawy_panel_podpanel2">
                    Praca dyplomowa inżynierska na kierunku Informatyka
                    <br /><br /> <h2>System zarządzania budynkiem wykorzystujący 
                        Mikrokontroler Arduino oraz technologię Java .</h2>
                    <br /><br />
                    Autor: Rafał Salwa &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    Opiekun pracy: dr inż. Mariusz Bedla.
                </div>
                <div style="display:none;" id="ustawienia" class="prawy_prawy_panel_podpanel2">
                    Ustawienia
                    <br /><br /> <h2>Panel</h2>
                    <br /><br />

                </div>

                <div style="display:none;" id="dom" class="prawy_prawy_panel_podpanel2 dom_rys">
                    Inteligentny Dom
                    <br /><br /> 
                    <div>
                        <table class="tabela_dom">
                            <thead>
                                <tr>
                                    <td></td>
                                    <td> Kuchnia</td>
                                    <td style="width:50px;">Zew</td>

                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>Gł. zasilanie</td>
                                    <td id="kom1"><div class="tabela_dom_bad"></div></td>
                                    <td id="kom2"><div class="tabela_dom_bad"></div></td>
                                </tr>
                                <tr>
                                    <td>Oswietlenie</td>
                                    <td id="kom3"><div class="tabela_dom_bad"></div></td>
                                    <td id="kom4"><div class="tabela_dom_bad"></div></td>
                                </tr>
                                <tr>
                                    <td>Temp</td>
                                    <td id="kom5"><div class="tabela_dom_bad"></div></td>
                                    <td id="kom6"><div class="tabela_dom_bad"></div></td>
                                </tr>
                                <tr>
                                    <td>Wilgotność</td>
                                    <td id="kom7"><div class="tabela_dom_bad"></div></td>
                                    <td id="kom8"><div class="tabela_dom_bad"></div></td>
                                </tr>
                                <tr>
                                    <td>Zasilanie port 1</td>
                                    <td id="kom9"><div class="tabela_dom_bad"></div></td>
                                    <td id="kom10"><div class="tabela_dom_bad"></div></td>
                                </tr>
                                <tr>
                                    <td>Zasilanie port 2</td>
                                    <td id="kom11"><div class="tabela_dom_bad"></div></td>
                                    <td id="kom12"><div class="tabela_dom_bad"></div></td>
                                </tr>
                                <tr>
                                    <td>Zasilanie port 2</td>
                                    <td id="kom13"><div class="tabela_dom_bad"></div></td>
                                    <td id="kom14"><div class="tabela_dom_bad"></div></td>
                                </tr>
                                <tr>
                                    <td>List</td>
                                    <td> X</td>
                                    <td id="kom15"><div class="tabela_dom_bad"></div></td>
                                </tr>
                                
                                <tr>
                                    <td>DYM</td>
                                    <td id="kom16"><div class="tabela_dom_bad"></div></td>
                                    <td> X</td>
                                </tr>
                            </tbody>
                        </table>

                        <table style="width: 135px;">
                            <thead>
                                <tr>
                                    <td colspan="2">Legenda</td>

                                </tr>
                            </thead>
                            <tbody>
                                <tr>

                                    <td class="tabela_dom_ok"></td>
                                    <td> Wł</td>
                                </tr>

                                <tr>

                                    <td class="tabela_dom_bad"></td>
                                    <td> Wył</td>
                                </tr>
                                <tr>

                                    <td> X </td>
                                    <td> Nie dotyczy</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div style="display:none;" id="info" class="prawy_prawy_panel_podpanel2">
                    Info<br />
                    Jako obszar funkcjonalności inteligentnego budynku można wykazać 2 powierzchnie.
                    <ul>
                        <li>

                            <a href="#" id="kuch_inf">Kuchnia</a>
                            <div class="slide_info1">

                                <ul>
                                    <li> Automatyczne załączanie oświetlenia w przypadku wykrycia ruchu</li>
                                    <li> Pomiar temperatury</li>
                                    <li> Pomiar wilgotności</li>
                                    <li> Kontrola do 3 urządzeń zasilanych elektrycznie</li>
                                    <li> Główny wyłącznik zasilania w kuchni</li>
                                    <li> Czujnik dymu</li>
                                    <li> Alarm dziękowy</li>

                                </ul>

                            </div>
                        </li>
                        <li>

                            <a href="#" id="zew_inf">Powierzchnia na zewnątrz budynku.</a>
                            <div class="slide_info2">
                                Jako możliwości systemy mozemy wymienić:
                                <ul>
                                    <li> Kontrola poziomu karmy w karmnikuchu</li>
                                    <li> Odczyt wiglotności</li>
                                    <li> Odczyt temperatury</li>
                                    <li> Główny wyłącznik zasilania </li>
                                    <li> Sterowanie światłami dojazdowymi</li>
                                    <li> Sterowanie zewnętrznym światłem przed domem</li>
                                    <li> czujnik ruchu jako czujnik kontroli oświetlenia</li>
                                    <li> czujnik odległości jako czujnik parkowania</li>
                                    <li> Sprawdzanie skrzynki na listy</li>

                                </ul>
                            </div>
                        </li>
                    </ul>


                </div>
                <div style="display:none;" id="pomoc" class="prawy_prawy_panel_podpanel2">
                    <br />
                    <div id="prawy_panel" class="prawy_panel">
                        Intrukcja obsługi

                        <div id="grid-scroll">
                            <div class="slide0 slide current"></div>
                            <div class="slide1 slide ">W celu korzystania z systemu potrzebne są:<br />
                                <ul>
                                    <li>Komputer</li>
                                    <li>Zainstalowane oprogramowanie Java EE w wersji conajmniej 1.7.4</li>
                                    <li>serwer aplikacji Glassfish w wersji conajmniej 4.0</li>
                                    <li>w niektórych przypadkach Dostęp do Internetu</li>
                                </ul>

                            </div>
                            <div class="slide2 slide" style="">W celu kontroli systemu należy odwiedzić stronę "Dom"
                                a następnie poprzez kliknięcie na wybrana graikę po prawej stronie okna dokonać jakiejkolwiek akcji
                            </div>
                            <div class="slide3 slide" style="">W razie problemów technicznych prosze o kontakt<br />
                                E-mail: rafal.salwa@aiesec.net
                            </div>
                            <br clear="all">
                        </div>

                        <a href="#" id="prev">
                            Wstecz 
                        </a>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="#" id="next">
                            Dalej
                        </a>

                    </div> 
                </div>



                <div id="prawy_prawy_panel" class="prawy_prawy_panel">
                    <div id="id_graf_wroc">

                    </div>
                    <div id="prawy_prawy_panel_podpanel" class="prawy_prawy_panel_podpanel">
                        <a href="#">
                            <div id="flot-placeholder1" style="width:830px;height:450px;margin:0 auto" >
                                &nbsp;
                            </div>
                        </a>
                    </div>
                </div> 

            </div>
        </div>


        <script type="text/javascript" >


        </script>

    </body>
</html>