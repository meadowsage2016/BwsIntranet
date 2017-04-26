$(document).ready(function() {
    var table;
    var type;

    $("MaintBtn").click(function () {

        // Get value from selection
        var maintOption = $("maint").value;

        // Determine Table to Maintain
        if ((maintOption).charAt([0]).equal('e')) {
            table = "Employees";
        } else {
            if ((maintOption).charAt([0]).equal('r')) {
                table = "DELIVERY ROUTES";
            } else {
                if ((maintOption).charAt([0]).equal('s')) {
                    table = "SUB DEALERS";
                } else {
                    if ((maintOption).charAt([0]).equal('c')) {
                        table = "CYLINDER OPTIONS";
                    } else {
                        if ((maintOption).charAt([0]).equal('z')) {
                            table = "SUB DEALERS"
                        }
                    }
                }
            }
        }

        // Determine type of maintenance
        if ((maintOption).charAt([3]).equal('1')) {
            type = "add";
        } else {
            if ((maintOption).charAt([3]).equal('2')) {
                type = "update";
            } else {
                if ((maintOption).charAt([3]).equal('3')) {
                    type = "delete";
                }
            }
        }
        // Forward information to correct maintenace page
        pageToCall = "/" + table + type;
        alert(pageToCall);
        document.location.href = pageToCall;
    })
})
