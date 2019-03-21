$(document).ready(function(){
//событие при нажатии на кнопку check my ip
$('#check_button').click(function(){
    //code smth...
    $.ajax({
        url:"validate.php",
        success:function(isValidIP){
            if(!isValidIP){
                $("#IPinfo").append('<h3>Ваш IP адрес нежелателен. Покиньте, пожалуйста, страницу.</h3>').addClass("responseIP");
                $(".responseIP").css({
                    "color":"red",
                    "font-family":"courier"
                });
            }
            else{
                $("#IPinfo").append('<h3>sldkfjkj.</h3>').addClass("responseIP");
            }
        }
    });
    // var request = new XMLHttpRequest();
    // request.open('GET','validate.php');
    // request.addEventListener('readystatechange', function(){
    //     console.log(request.);
    // });
    // request.send();
});

});