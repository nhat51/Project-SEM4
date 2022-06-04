document.addEventListener('DOMContentLoaded', function (){
    var username = document.getElementById("username")
    var usernameData = sessionStorage.getItem("username")
    username.innerHTML = `<a class="js-acc-btn" href="#">${usernameData}</a>`
})