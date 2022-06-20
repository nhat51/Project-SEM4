let btn = document.querySelectorAll("[data-target]");
btn.forEach((btn) => {
    btn.addEventListener('click', () => {
        localStorage.clear();
        window.location.href = './login.html';
    });
});