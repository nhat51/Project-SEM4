import {url, accessToken, nameAdmin} from "./config.js";
document.addEventListener('DOMContentLoaded', function () {
    if (accessToken == null){
        window.location.href = './login.html';
    }

    const url_string = window.location.href.toLowerCase();
    const url_s = new URL(url_string);
    const uid = url_s.searchParams.get('article-id');

    let username = document.getElementById("username");
    username.innerHTML = `<a class="js-acc-btn" href="#">${nameAdmin}</a>`;

    let username1 = document.getElementById("username1");
    username1.innerHTML = `<a class="js-acc-btn" href="#">${nameAdmin}</a>`;

    let articleData = document.getElementById("article-data");

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
                    <td>Title</td>
                    <td>:</td>
                    <td>${data.title}</td>
                </tr>
                <tr>
                    <td>Content</td>
                    <td>:</td>
                    <td>${data.content}</td>
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
            `;
            articleData.innerHTML = newContent;
        }
    }
    xmlHttpRequest.open('get', url + "/api/v1/admin/articles/detail?articleId=" + uid);
    xmlHttpRequest.setRequestHeader('Accept', 'application/json');
    xmlHttpRequest.setRequestHeader('Authorization', "Bearer " + accessToken);
    xmlHttpRequest.send();
})