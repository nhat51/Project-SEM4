import {url, accessToken, nameAdmin} from "./config.js";
document.addEventListener('DOMContentLoaded', function () {
    if(accessToken == null){
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

    let listWord = document.getElementById("list-word");
    let numberBtn = document.getElementById("number-btn");
    let prevBtn = document.getElementById("prev-btn");
    let nextBtn = document.getElementById("next-btn");
    let xmlHttpRequest = new XMLHttpRequest();

    xmlHttpRequest.onreadystatechange = function () {
        if(xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200){
            let data = JSON.parse(xmlHttpRequest.responseText);
            let totalPage = data.totalPages;
            let dataWord = data.content;
            let newContent = '';
            let newContent1 = '';
            let newContent2 = '';
            let newContent3 = '';

            for(let i = 0; i < dataWord.length; i++){
                newContent += `
                    <tr class="tr-shadow">
                        <td style="text-align: center; vertical-align: middle">${dataWord[i].id}</td>
                        <td style="text-align: center; vertical-align: middle">${dataWord[i].name}</td>
                        <td style="text-align: center; vertical-align: middle">${dataWord[i].content}</td>
                        <td style="text-align: center; vertical-align: middle">${dataWord[i].pronounce}</td>
                        <td style="text-align: center; vertical-align: middle">${dataWord[i].partOfSpeech}</td>
                        <td style="text-align: center; vertical-align: middle">${dataWord[i].createdAt}</td>
                        <td style="">
                            <button class="item" data-toggle="tooltip" data-placement="top" title="Word detail">
                                    <a href="word-detail.html?word-id=${dataWord[i].id}"><i class="zmdi zmdi-mail-send"></i></a>
                            </button>
                        </td>
                    </tr>
                    <tr class="spacer"></tr>
                `
                listWord.innerHTML = newContent;
            }

            for (let j = 1; j <= totalPage; j++){
                newContent1 += `
                    <li class="page-item ${(pid == j)?'active':''}"><a class="page-link" href="word.html?page=${j}">${j}</a></li>
                `;
                numberBtn.innerHTML = newContent1;
            }

            if(pid > 1){
                let prevPage = pid - 1;
                newContent2 = `
                    <li class="page-item">
                        <a class="page-link" href="word.html?page=${prevPage}">Previous</a>
                    </li>
                `;
                prevBtn.innerHTML = newContent2;
            }

            if(pid < totalPage){
                let nextPage = parseInt(pid) + parseInt('1');
                newContent3 = `
                    <li class="page-item">
                        <a class="page-link" href="word.html?page=${nextPage}">Next</a>
                    </li>
                `;
                nextBtn.innerHTML = newContent3;
            }
        }
    }
    xmlHttpRequest.open('get', url + "/api/v1/admin/words?page=" + pid + "&size=10");
    xmlHttpRequest.setRequestHeader('Accept', 'application/json');
    xmlHttpRequest.setRequestHeader('Authorization', "Bearer " + accessToken);
    xmlHttpRequest.send();
})