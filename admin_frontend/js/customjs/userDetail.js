import {url, accessToken, nameAdmin} from "./config.js";
document.addEventListener('DOMContentLoaded', function () {
    if(accessToken == null){
        window.location.href = './login.html';
    }

    const url_string = window.location.href.toLowerCase();
    const url_s = new URL(url_string);
    const uid = url_s.searchParams.get('user-detail');

    let username = document.getElementById("username");
    username.innerHTML = `<a class="js-acc-btn" href="#">${nameAdmin}</a>`;

    let username1 = document.getElementById("username1");
    username1.innerHTML = `<a class="js-acc-btn" href="#">${nameAdmin}</a>`;

    let userInfor = document.getElementById("user-infor");
    let xmlHttpRequest = new XMLHttpRequest();

    xmlHttpRequest.onreadystatechange = function () {
        if(xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200){
            let data = JSON.parse(xmlHttpRequest.responseText);
            let newContent = '';
            newContent += `
                <tr>
                    <td>ID</td>
                    <td>:</td>
                    <td>${data.id}</td>
                </tr>
                <tr>
                    <td>Username</td>
                    <td>:</td>
                    <td>${data.username}</td>
                </tr>
                <tr>
                    <td>Fullname</td>
                    <td>:</td>
                    <td>${data.fullName}</td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td>:</td>
                    <td><span class="block-email">${data.email}</span></td>
                </tr>
                <tr>
                    <td>Phone</td>
                    <td>:</td>
                    <td>${data.phone}</td>
                </tr>
                <tr>
                    <td>Role</td>
                    <td>:</td>
                    <td>${data.role}</td>
                </tr>
                <tr>
                    <td>Created At</td>
                    <td>:</td>
                    <td>${data.createdAt}</td>    
                </tr>
                <tr>
                    <td>Status</td>
                    <td>:</td>
                    <td>${data.status}</td>
                </tr>
                <tr>
                    <td>Action</td>
                    <td>:</td>
                    <td style="float: left">
                        <div class="table-data-feature">
                            <button class="item" data-toggle="tooltip" data-placement="top" title="List word">
                                <a href="user-word.html?user-word=${data.id}"><i class="zmdi zmdi-mail-send"></i></a>
                            </button>
                        </div>
                    </td>
                </tr>
            `;
            userInfor.innerHTML = newContent;
        }
    }
    xmlHttpRequest.open('get', url + "/api/v1/admin/user/user-detail?user-id=" + uid);
    xmlHttpRequest.setRequestHeader('Accept', 'application/json');
    xmlHttpRequest.setRequestHeader('Authorization', "Bearer " + accessToken);
    xmlHttpRequest.send();
})
