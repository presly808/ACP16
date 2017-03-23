$(document).ready(function () {
        $("#showAjax").click(function () {
            $("#myModal").show();
        });
    }
);

$(document).ready(function () {
    $("#registration").click(function () {
        var fields = $("#region");

        if ($('input:text').is(":empty")) {
            confirmation();
        }
    })
})

function confirmation() {
    if (confirm("You have empty fields. Are You want to continue?")) {
        return false;
    }
}


