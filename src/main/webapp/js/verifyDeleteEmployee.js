/**
 * Created by student on 4/30/17.
 */
jQuery(document).ready(function() {

    //
    $("#deleteBtn").click(function() {

        // Check for empty form
        if($('#name').val() == ''){
            // Send alert to user
            alert('Name can not be left blank');
        } else {
            $('form').append('<div> Verify that you want to delete: ' + $("#name").val() + '</div>');
            $('form').append('<input type="hidden" value="' + $("#name").val() + '" name="name">');
            $('form').append('<input type="button" id="deleteVerified" value="Verify">');
        }
    });


    //
    $("#deleteVerified").click(function() {
        $.ajax({
            type: 'POST',
            url: '/EmployeesDelete',
            data: {
                'name': '$("#name").val()'
            },
            success: function(msg){

            }
        });
    });
});