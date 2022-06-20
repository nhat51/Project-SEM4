import { url } from "./config.js";
document.addEventListener('DOMContentLoaded', function (){
    var btnLogin =document.getElementById("btn-signin");
    var txtUserName =document.forms['login-form']['username'];
    var txtPassWord =document.forms['login-form']['password'];

    btnLogin.onclick= function (){
        var username = txtUserName.value;
        var password = txtPassWord.value;


        var dataToSend={
            username:username,
            password:password,
        };

        //alert(JSON.stringify(dataToSend));
        var method = 'post';
        var successStatus = 200;

        var xmlHttpRequest = new XMLHttpRequest();
        // sự kiện khi request thay đổi trạng thái
        xmlHttpRequest.onreadystatechange = function () {
            // kiểm tra khi trạng thái request đã hoàn thành (readyState = 1) và tạo thành công (status = 201) (thất bại = 500)
            if (xmlHttpRequest.status == successStatus && xmlHttpRequest.readyState == 4) {
                var data = JSON.parse(xmlHttpRequest.responseText);
                localStorage.setItem("access_token", data.body.access_token);
                localStorage.setItem("username", data.body.username);
                window.location.href = './index.html';
            }
        };

        xmlHttpRequest.open(method, url + "/api/v1/users/login", false);
        // sửa kiểu dữ liệu gửi lên có định dang json, phải đứng sau hàm open
        xmlHttpRequest.setRequestHeader('Content-Type', 'application/json');
        xmlHttpRequest.send(JSON.stringify(dataToSend)); // gửi dữ liệu ở định dạng json.
    }
})

