import {url, accessToken, nameAdmin} from "./config.js";
document.addEventListener('DOMContentLoaded', function () {
    if(accessToken == null){
        window.location.href = './login.html';
    }
    let username = document.getElementById("username");
    username.innerHTML = `<a class="js-acc-btn" href="#">${nameAdmin}</a>`;

    let username1 = document.getElementById("username1");
    username1.innerHTML = `<a class="js-acc-btn" href="#">${nameAdmin}</a>`;

    let userListTable = document.getElementById('user-list-data');
    let xmlHttpRequest = new XMLHttpRequest();

    xmlHttpRequest.onreadystatechange = function () {
        if(xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200){
            let data = JSON.parse(xmlHttpRequest.responseText);
            let dataUser = data.content;
            let numberUser = document.getElementById("number-user");
            numberUser.innerHTML = `<h2>${dataUser.length}</h2>
                                    <span>users</span>`;
            let newContent = '';
            for (let i = 0; i < dataUser.length; i++){
                newContent += `
                    <tr>
                        <td style="text-align: center">${dataUser[i].id}</td>
                        <td style="text-align: center">${dataUser[i].username}</td>
                        <td style="text-align: center">${dataUser[i].fullName}</td>
                        <td style="text-align: center">
                            <div class="table-data-feature">
                                <button class="item" data-toggle="tooltip" data-placement="top" title="List word">
                                    <a href="user-word.html?user-word=${dataUser[i].id}"><i class="zmdi zmdi-mail-send"></i></a>
                                </button>
                                <button class="item" data-toggle="tooltip" data-placement="top" title="User information">
                                    <a href="user-detail.html?user-detail=${dataUser[i].id}"><i class="zmdi zmdi-more"></i></a>
                                </button>
                            </div>
                        </td>
                    </tr>
                `
                userListTable.innerHTML = newContent;
            }
        }
    }
    xmlHttpRequest.open('get', url + "/api/v1/admin/user");
    xmlHttpRequest.setRequestHeader('Accept', 'application/json');
    xmlHttpRequest.setRequestHeader('Authorization', "Bearer " + accessToken);
    xmlHttpRequest.send();

    let numberWord = document.getElementById("number-word");
    let articleTitle = document.getElementById("article-data");
    let xmlHttpRequest1 = new XMLHttpRequest();

    xmlHttpRequest1.onreadystatechange = function () {
        if(xmlHttpRequest1.readyState == 4 & xmlHttpRequest1.status == 200){
            let data1 = JSON.parse(xmlHttpRequest1.responseText);
            let dataWord = data1.content;
            let newContent1 = ``;
            numberWord.innerHTML = `
                    <h2>${data1.totalElements}</h2>
                    <span>words</span>
            `;
            for(let j = 0; j < dataWord.length; j++){
                newContent1 += `
                <tr>
                    <td><a href="word-detail.html?word-id=${dataWord[j].id}" style="color: white">${dataWord[j].name}</a></td>
                    <td>${dataWord[j].content}</td>
                </tr>
                `;
                articleTitle.innerHTML = newContent1;
            }
        }
    }
    xmlHttpRequest1.open('get', url + "/api/v1/admin/words?page=5&size=11");
    xmlHttpRequest1.setRequestHeader('Accept', 'application/json');
    xmlHttpRequest1.setRequestHeader('Authorization', "Bearer " + accessToken);
    xmlHttpRequest1.send();
})