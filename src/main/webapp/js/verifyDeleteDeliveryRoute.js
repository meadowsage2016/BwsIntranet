/**
 * Created by student on 4/30/17.
 */
jQuery(document).ready(function() {

    //
    $("#deleteBtn").click(function() {

        // Check for empty form
        if($('#city').val() == ''){
            // Send alert to user
            alert('City or Business can not be left blank');
        } else {
            $('form').append('<div> Verify that you want to delete: ' + $("#city").val() + '</div>');
            $('form').append('<input type="hidden" value="' + $("#city").val() + '" name="city">');
            $('form').append('<input type="button" id="deleteVerified" value="Verify">');
        }
    });


    //
    $("#deleteVerified").click(function() {
        $.ajax({
            type: 'POST',
            url: '/DeliveryRoutesDelete',
            data: {
                'city': '$("#city").val()'
            },
            success: function(msg){
            }
        });
    });
});