import {url, accessToken, nameAdmin} from "./config.js";
document.addEventListener('DOMContentLoaded', function () {
    if(accessToken == null){
        window.location.href = './login.html';
    }

    const url_string = window.location.href.toLowerCase();
    const url_s = new URL(url_string);
    const wid = url_s.searchParams.get('word-id');

    let username = document.getElementById("username");
    username.innerHTML = `<a class="js-acc-btn" href="#">${nameAdmin}</a>`;

    let username1 = document.getElementById("username1");
    username1.innerHTML = `<a class="js-acc-btn" href="#">${nameAdmin}</a>`;

    let wordDetail = document.getElementById("word-detail");
    let xmlHttpRequest = new XMLHttpRequest();

    xmlHttpRequest.onreadystatechange = function () {
        if(xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200){
            let data = JSON.parse(xmlHttpRequest.responseText);
            let newContent = ``;
            newContent += `
                <tr>
                    <td>ID</td>
                    <td>:</td>
                    <td>${data.id}</td>
                </tr>
                <tr>
                    <td>Word</td>
                    <td>:</td>
                    <td>${data.name}</td>
                </tr>
                <tr>
                    <td>Meaning</td>
                    <td>:</td>
                    <td>${data.content}</td>
                </tr>
                <tr>
                    <td>Pronounce</td>
                    <td>:</td>
                    <td>${data.pronounce}</td>
                </tr>
                <tr>
                    <td>Part of speech</td>
                    <td>:</td>
                    <td>${data.partOfSpeech}</td>
                </tr>
                <tr>
                    <td>Example</td>
                    <td>:</td>
                    <td>${data.example}</td>
                </tr>
                <tr>
                    <td>Example meaning</td>
                    <td>:</td>
                    <td>${data.translatedExample}</td>
                </tr>
                <tr>
                    <td>Created at</td>
                    <td>:</td>
                    <td>${data.createdAt}</td>
                </tr>
            `;
            wordDetail.innerHTML = newContent;
        }
    }
    xmlHttpRequest.open('get', url + "/api/v1/admin/words/word-detail?word-id=" + wid);
    xmlHttpRequest.setRequestHeader('Accept', 'application/json');
    xmlHttpRequest.setRequestHeader('Authorization', "Bearer " + accessToken);
    xmlHttpRequest.send();
})