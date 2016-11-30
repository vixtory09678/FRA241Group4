function showLoginBox() {

    // Do whatever DOM operations you need to show the login/registration box.
    $("#loginButton").on("click", function() {
        authClient.login("password", {
            email: $("#email").val(),
            password: $("#password").val(),
            rememberMe: $("#rememberCheckbox").val()
        });
    });
}
var ref = new Firebase("https://ebus-81234.firebaseio.com"");
var authClient = new FirebaseAuthClient(ref, function(error, user) {
    if (error) {
        alert(error);
        return;
    }
    if (user) {
        // User is already logged in.
        doLogin(user);
    } else {
        // User is logged out.
        showLoginBox();
    }
});