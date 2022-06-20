import {url, accessToken, nameAdmin} from "./config.js";
document.addEventListener('DOMContentLoaded', function () {
    if (accessToken == null){
        window.location.href = './login.html';
    }

    const url_string = window.location.href.toLowerCase();
    const url_s = new URL(url_string);
    let pid = url_s.searchParams.get('page');

    if(pid == null){
        pid = 1;
    }

    let username = document.getElementById("username");
    username.innerHTML = `<a class="js-acc-btn" href="#">${nameAdmin}</a>`;

    let username1 = document.getElementById("username1");
    username1.innerHTML = `<a class="js-acc-btn" href="#">${nameAdmin}</a>`;

    let userList = document.getElementById("list-user");
    let numberBtn = document.getElementById("number-btn");
    let prevBtn = document.getElementById("prev-btn");
    let nextBtn = document.getElementById("next-btn");
    let xmlHttpRequest = new XMLHttpRequest();

    xmlHttpRequest.onreadystatechange = function () {
        if(xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200){
            let data = JSON.parse(xmlHttpRequest.responseText);
            let dataUser = data.content;
            let totalPage = data.totalPages;

            let newContent = '';
            let newContent1 = '';
            let newContent2 = '';
            let newContent3 = '';

            for(let i = 0; i < dataUser.length; i++){
                newContent += `
                    <tr>
                        <td style="text-align: center">${dataUser[i].id}</td>
                        <td style="text-align: center">${dataUser[i].username}</td>
                        <td style="text-align: center">${dataUser[i].fullName}</td>
                        <td style="text-align: center; vertical-align: middle">
                            <span class="block-email">${dataUser[i].email}</span>
                        </td>
                        <td style="text-align: center">${dataUser[i].phone}</td>
                        <td style="text-align: center">${dataUser[i].role}</td>
                        <td style="text-align: center">${dataUser[i].status}</td>
                        <td style="text-align: center">
                            <div class="table-data-feature">
                                <button class="item" data-toggle="tooltip" data-placement="top" title="List word">
                                    <a href="user-word.html?user-word=${dataUser[i].id}"><i class="zmdi zmdi-mail-send"></i></a>
                                </button>
                                <button class="item" data-toggle="tooltip" data-placement="top" title="User information">
                                    <a href="user-detail.html?user-detail=${dataUser[i].id}"><i class="zmdi zmdi-more"></i></a>
                                </button>
                                <button class="item" data-toggle="tooltip" data-placement="top" title="Active user">
                                    <a href="users.html?active-id=${dataUser[i].id}"><i class="zmdi zmdi-edit"></i></a>
                                </button>
                            </div>
                        </td>
                    </tr>       
                `
                userList.innerHTML = newContent;
            }
            for (let j = 1; j <= totalPage; j++){
                newContent1 += `
                    <li class="page-item ${(pid == j)?'active':''}"><a class="page-link" href="users.html?page=${j}">${j}</a></li>
                `;
                numberBtn.innerHTML = newContent1;
            }

            if(pid > 1){
                let prevPage = pid - 1;
                newContent2 = `
                    <li class="page-item">
                        <a class="page-link" href="users.html?page=${prevPage}">Previous</a>
                    </li>
                `;
                prevBtn.innerHTML = newContent2;
            }

            if(pid < totalPage){
                let nextPage = parseInt(pid) + parseInt('1');
                newContent3 = `
                    <li class="page-item">
                        <a class="page-link" href="users.html?page=${nextPage}">Next</a>
                    </li>
                `;
                nextBtn.innerHTML = newContent3;
            }
        }
    };
    xmlHttpRequest.open('get', url + "/api/v1/admin/user?page=" + pid + "&size=10");
    xmlHttpRequest.setRequestHeader('Accept', 'application/json');
    xmlHttpRequest.setRequestHeader('Authorization', "Bearer " + accessToken);
    xmlHttpRequest.send();

    let xmlHttpRequest1 = new XMLHttpRequest();

    const url_string1 = window.location.href.toLowerCase();
    const url_s1 = new URL(url_string1);
    const uid = url_s1.searchParams.get('active-id');

    xmlHttpRequest1.onreadystatechange = function () {
        if(xmlHttpRequest1.readyState == 4 && xmlHttpRequest1.status == 200){
            alert('Active user successfully!!!');
            window.location.href = './users.html';
        }
    };
    xmlHttpRequest1.open('post', url + "/api/v1/admin/user/active?user-id=" + uid );
    xmlHttpRequest1.setRequestHeader('Accept', 'application/json');
    xmlHttpRequest1.setRequestHeader('Authorization', "Bearer " + accessToken);
    xmlHttpRequest1.send();
})