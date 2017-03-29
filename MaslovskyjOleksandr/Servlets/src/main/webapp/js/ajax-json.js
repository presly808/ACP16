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

$("#showAllInfo").click(function () {
    $.ajax({
        type: "POST",
        url: "ajax-json",
        data: {type: "allCandidates"},
        contentType: "application/json",
        success: function(candidateInfo) {
            $("#candidateList").text(JSON.stringify(candidateInfo));
        },
        error: function () {
            $("#candidateList").text("failed to load result from server");
        },
        dataType: "application/json"
    })
});

$("#showAjax").click(function () {
    $("#registrationForm").show();
});

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



