console.log("Control here")
let showLoginContainer = document.getElementById("login-container")
function showContainer() {
    console.log("Executing function started");
    if (showLoginContainer) {
        showLoginContainer.classList.add("show-login-container");
        console.log("Class added to login container");
    } else {
        console.error("Login container element not found!");
    }
}