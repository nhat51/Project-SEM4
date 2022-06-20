import {url, accessToken, nameAdmin} from "./config.js";
document.addEventListener('DOMContentLoaded', function () {
    if(accessToken == null){
        window.location.href = './login.html';
    }

    const url_string = window.location.href.toLowerCase();
    const url_s = new URL(url_string);
    const uid = url_s.searchParams.get('user-word');

    let username = document.getElementById("username");
    username.innerHTML = `<a class="js-acc-btn" href="#">${nameAdmin}</a>`;

    let username1 = document.getElementById("username1");
    username1.innerHTML = `<a class="js-acc-btn" href="#">${nameAdmin}</a>`;

    let userWordTable = document.getElementById('user-word-list');
    let xmlHttpRequest = new XMLHttpRequest();

    let userListName = document.getElementById("user-list-name");

    xmlHttpRequest.onreadystatechange = function () {
        if(xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200){
            let data = JSON.parse(xmlHttpRequest.responseText);

            userListName.innerHTML = `<h3 class="title-3 m-b-30">
                                <i class="zmdi zmdi-account-calendar"></i>${data.fullName}
                            </h3>`;

            let dataWord = data.words;
            let newContent = '';

            for (let i = 0; i < dataWord.length; i++){
                newContent += `
                    <tr>
                        <td style="text-align: center; vertical-align: middle">${dataWord[i].id}</td>
                        <td style="text-align: center; vertical-align: middle">${dataWord[i].name}</td>
                        <td style="text-align: center; vertical-align: middle">${dataWord[i].content}</td>
                        <td style="text-align: center; vertical-align: middle">${dataWord[i].partOfSpeech}</td>
                        <td style="text-align: center; vertical-align: middle">${dataWord[i].pronounce}</td>
                        <td style="text-align: center; vertical-align: middle">${dataWord[i].createdAt}</td>
                        <td style="text-align: center; vertical-align: middle">
                            <button class="item" data-toggle="tooltip" data-placement="top" title="Word detail">
                                    <a href="word-detail.html?word-id=${dataWord[i].id}"><i class="zmdi zmdi-mail-send"></i></a>
                            </button>
                        </td>
                    </tr>
                        `
                userWordTable.innerHTML = newContent;
            }
        }
    }
    xmlHttpRequest.open('get', url + "/api/v1/admin/user/user-detail?user-id=" + uid);
    xmlHttpRequest.setRequestHeader('Accept', 'application/json');
    xmlHttpRequest.setRequestHeader('Authorization', "Bearer " + accessToken);
    xmlHttpRequest.send();
})