$(document).ready(function() {
    clicked_panel = 0;
    pp_clicked = 0;
    panel_powiekszony = 0;


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
            url: "ardEth",
            data: {
                wart: $("#ard_wyslij_wart").val(),
                typ: '1'
            },
            success: function(msg) {
                //ten fragment wykona się po POMYŚLNYM zakończeniu połączenia
                //msg zawiera dane zwrócone z serwera
                console.log(msg);
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

    $(window).bind("beforeunload", function() {
        return inFormOrLink || confirm("Wyjsc??");
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
});