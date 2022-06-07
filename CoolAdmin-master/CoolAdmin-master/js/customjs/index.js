document.addEventListener('DOMContentLoaded', function () {
    let username = document.getElementById("username");
    let usernameData = localStorage.getItem("username");
    username.innerHTML = `<a class="js-acc-btn" href="#">${usernameData}</a>`;

    let userListTable = document.getElementById('user-list-data');
    let xmlHttpRequest = new XMLHttpRequest();
    localStorage.getItem("access_token");
    xmlHttpRequest.onreadystatechange = function () {
        if(xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200){
            let data = JSON.parse(xmlHttpRequest.responseText);
            let dataUser = data.content;
            console.log(dataUser);
            console.log(dataUser.length);
            localStorage.getItem("access_token");
            let numberUser = document.getElementById("number-user");
            numberUser.innerHTML = `<h2>${dataUser.length}</h2>
                                    <span>members online</span>`;
            let newContent = '';
            for (let i = 0; i < dataUser.length; i++){
                newContent += `
                    <tr>
                        <td>${dataUser[i].username}</td>
                        <td>${dataUser[i].fullName}</td>
                        <td>${dataUser[i].email}</td>
                        <td>${dataUser[i].phone}</td>
                        <td>${dataUser[i].status}</td>
                        <td>
                            <div class="table-data-feature">
                                <button class="item" data-toggle="tooltip" data-placement="top" title="List word">
                                    <i class="zmdi zmdi-mail-send"></i>
                                </button>
                                <button class="item" data-toggle="tooltip" data-placement="top" title="Delete">
                                    <i class="zmdi zmdi-delete"></i>
                                </button>
                            </div>
                        </td>
                    </tr>
                `
                userListTable.innerHTML = newContent;
            }
        }
    }
    xmlHttpRequest.open('get', 'http://localhost:8080/api/v1/users');
    xmlHttpRequest.setRequestHeader('Accept', 'application/json');
    xmlHttpRequest.setRequestHeader('Authorization', "Bearer " + localStorage.getItem("access_token"));
    xmlHttpRequest.send();
})