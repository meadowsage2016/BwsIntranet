/**
 * Created by student on 4/30/17.
 */
jQuery(document).ready(function() {

    //
    $("#deleteBtn").click(function() {

        // Check for empty form
        if($('#gasNumber').val() == ''){
            // Send alert to user
            alert('Gas Number can not be left blank');
        } else {
           $('form').append('<div> Verify that you want to delete gas number: ' + $("#gasNumber").val() + '</div>');
           $('form').append('<input type="hidden" value="' + $("gasNumber").val() + '" name="gasNumber">');
           $('form').append('<input type="button" id="deleteVerified" value="Verify">');
        }
    });


    //
    $("#deleteVerified").click(function() {
        $.ajax({
            type: 'POST',
            url: '/CylinderOptionsDelete',
            data: {
                'gasNumber': '$("#gasNumber").val()'
            },
            success: function(msg){
                alert('wow' + msg);
            }
        });
    });
});