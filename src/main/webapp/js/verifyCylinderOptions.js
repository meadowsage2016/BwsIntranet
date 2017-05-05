/**
 * Created by student on 4/30/17.
 */
jQuery(document).ready(function() {

        // Initialize form validation on the registration form.
        // It has the name attribute "registration"
        $("form[name='newCylOptForm']").validate({
            // Specify validation rules
            rules: {
                // The key name on the left side is the name attribute
                // of an input field. Validation rules are defined
                // on the right side
                gasNumber: {
                    required: true,
                    minlength: 1,
                    maxlength: 20,
                    messages: {
                        required: "Please enter a valid Gas Number"
                    }
                },
                gasDescription: {
                    required: true,
                    minlength: 1,
                    maxlength: 40,
                    messages: {
                        required: "Please enter a valid Gas Description"
                    }
                },
                cylinderCode: {
                    required: true,
                    minlength: 1,
                    maxlength: 10,
                    messages: {
                        required: "Please enter a valid Cylinder Code"
                    }
                },
                cylinderRent: {
                    required: true,
                    number: true,
                   range: [.01,100.00],
                    messages: {
                        required: "Please enter the Daily Cylinder Rental Amount (10,2)"
                    }
                },
                cylinderOnePPRent: {
                    required: true,
                    number: true,
                    range: [10.00,99999.00],
                    messages: {
                        required: "Please enter the One Year PrePaid Rent Amount (10,2)"
                    }
                },
                cylinderFiveYearLease:{
                    required: true,
                    number: true,
                    range: [10.00,99999.00],
                    messages: {
                        required: "Please enter the Five Year Lease Amount (10,2)"
                    }
                },
                cylinderPurchase: {
                    number: true,
                    range: [10.00,99999.00],
                    messages: {
                        optional: "Please enter the Purchase Price (10,2)"
                    }
                }
            },
            // Make sure the form is submitted to the destination defined
            // in the "action" attribute of the form when valid
            submitHandler: function(form) {
                form.submit();
            }
        });
    });