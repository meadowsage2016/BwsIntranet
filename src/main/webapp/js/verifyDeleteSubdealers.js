/**
 * Created by student on 4/30/17.
 */
jQuery(document).ready(function() {

    //
    $("#deleteBtn").click(function() {

        // Check for empty form
        if($('#customerNumber').val() == ''){
            // Send alert to user
            alert('Subdealer Customer Number can not be left blank');
        } else {
            $('form').append('<div> Verify that you want to delete Subdealer with Customer number: ' + $("#customerNumber").val() + '</div>');
            $('form').append('<input type="hidden" value="' + $("#customerNumber").val() + '" name="customerNumber">');
            $('form').append('<input type="button" id="deleteVerified" value="Verify">');
        }
    });


    //
    $("#deleteVerified").click(function() {
        $.ajax({
            type: 'POST',
            url: '/SubdealersDelete',
            data: {
                'customerNumber': '$("#customerNumber").val()'
            },
            success: function(msg){
            }
        });
    });
});