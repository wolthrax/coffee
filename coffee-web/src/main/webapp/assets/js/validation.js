$(document).ready(function() {

    var patternAddress = /^\S([a-zа-яё\d\s/.,-]+)$/i;
    var patternFullName = /^\S([a-z\sа-яё-]+)$/i;

    var address = $('#address');
    var fullName = $('#fullName');
    var button = $('#button2');

    var fullNameIsCorrect = false;
    var addressIsCorrect = false;

    var message = function (code, callback) {
        $.ajax({
            url: "/coffee/message?code="+code,
            success: callback
        });
    };

    fullName.blur(function() {
        if(fullName.val() != ''){
            if(fullName.val().search(patternFullName) == 0) {
                $('#valid1').text('')
                fullName.removeClass('error').addClass('ok');
                fullNameIsCorrect = true;
            } else {
                message("lang.error.incorrect.full_name", function (data){
                    $('#valid1').text(data);
                });
                fullName.addClass('error');
                fullNameIsCorrect = false;
            }
        } else {
            message("lang.error.empty.full_name", function (data){
                $('#valid1').text(data);
            });
            fullName.addClass('error');
            fullNameIsCorrect = false;
        }
        if(fullNameIsCorrect && addressIsCorrect){
            button.attr('disabled', false);
        } else {
            button.removeAttr('disabled').attr('disabled', true);
        }
    });

    address.blur(function() {
        if(address.val() != ''){
            if(address.val().search(patternAddress) == 0) {
                $('#valid2').text('')
                address.removeClass('error').addClass('ok');
                addressIsCorrect = true;
            } else {
                message("lang.error.incorrect.address", function (data){
                    $('#valid2').text(data);
                });
                address.addClass('error');
                addressIsCorrect = false;
            }
        } else {
            message("lang.error.empty.address", function (data){
                $('#valid2').text(data);
            });
            address.addClass('error');
            addressIsCorrect = false;
        }
        if(fullNameIsCorrect && addressIsCorrect){
            button.attr('disabled', false);
        } else {
            button.removeAttr('disabled').attr('disabled', true);
        }
    });
});
