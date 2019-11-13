$(document).ready(function() {
    // Send the data using post
    var posting = $.post( '/nav');

    // Put the results in a div
    posting.done(function(data) {
        $('#nav-placeholder').html(data);

        $('#signUpButton').click(function(e){
            e.preventDefault();
            $('#exampleModalCenter').modal('show');
            $('.nav a[href="#sign-up-tab"]').tab('show');
        });

        $('#logInButton').click(function(e){
            e.preventDefault();
            $('#exampleModalCenter').modal('show');
            $('.nav a[href="#sign-in-tab"]').tab('show');
        });
    });
});