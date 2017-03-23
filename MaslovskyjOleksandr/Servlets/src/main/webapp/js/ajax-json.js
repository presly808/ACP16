$(document).ready(function () {
    $("#register").click(function () {
        $.ajax({
            type: "POST",
            url: "ajax-json",
            data: JSON.stringify({
                name: getName(),
                age: getAge(),
                clan: {name: getClan(), rate: generateRate()},
                region: {regionType: getRegion()} ,
                interests: {type: getInterests()}
            }),
            contentType: "application/json",
            success: function(candidateInfo) {
                alert(JSON.stringify(candidateInfo));
            },
            dataType: "json"
        });
    })
})

function getName() {
    return $("#name").val();
}

function getAge() {
    return $("#age").val();
}

function getClan() {
    return $("#clan").val();
}

function getRegion() {
    return $("#region").val();
}

function getInterests() {
    return $("#hobbi").val();
}

function generateRate() {
    return Math.floor((Math.random() * 100) + 1);
}

$(document).ready(function () {
        $("#showAjax").click(function () {
            $("#registrationForm").show();
        });
    }
);

$(document).ready(function () {
    $("#showAllInfo").click(function () {
        $.ajax({
            type: "POST",
            url: "ajax-json",
            data: {type: "allCandidates"},
            contentType: "application/json",
            success: function(candidateInfo) {
                $("#candidateList").html($.parent(candidateInfo));
            },
            dataType: "json"
        })
    })
})
