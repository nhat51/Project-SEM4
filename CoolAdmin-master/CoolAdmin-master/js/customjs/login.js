document.addEventListener('DOMContentLoaded', function (){
    var btnLogin =document.getElementById("btn-signin");
    var txtuserName =document.forms['login-form']['username'];
    var txtpassWord =document.forms['login-form']['password'];

    btnLogin.onclick= function (){
        var username = txtuserName.value;
        var password = txtpassWord.value;


        var dataToSend={
            username:username,
            password:password,
        };

        //alert(JSON.stringify(dataToSend));
        var method = 'post';
        var url = 'http://localhost:8080/api/v1/users/login';
        var successStatus = 200;

        var xmlHttpRequest = new XMLHttpRequest();
        // sự kiện khi request thay đổi trạng thái
        xmlHttpRequest.onreadystatechange = function () {
            // kiểm tra khi trạng thái request đã hoàn thành (readyState = 1) và tạo thành công (status = 201) (thất bại = 500)
            if (
                xmlHttpRequest.status == successStatus || xmlHttpRequest.onreadystatechange == 4
            ) {
                // alert('Login success!');
                window.location.href = './index.html';
                var data = JSON.parse(xmlHttpRequest.responseText);
                console.log(data.body.username)
                sessionStorage.setItem("username", data.body.username);
            }
        };

        xmlHttpRequest.open(method, url, false);
        // sửa kiểu dữ liệu gửi lên có định dang json, phải đứng sau hàm open
        xmlHttpRequest.setRequestHeader('Content-Type', 'application/json');
        xmlHttpRequest.send(JSON.stringify(dataToSend)); // gửi dữ liệu ở định dạng json.
    }
})

