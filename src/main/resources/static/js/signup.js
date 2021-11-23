function SendForm() {
    if (CheckForm()) {
        let form = document.getElementById("signup-form");
        form.setAttribute("charset", "UTF-8");
        form.setAttribute("method", "Post");  //Post 방식
        form.setAttribute("action", "/user/signup"); //요청 보낼 주소
        form.submit();
    }
}

function CheckForm() {
    let nick = $('#nickname').val();
    let pwd1 = $('#password').val();
    let pwd2 = $('#chk-password').val();

    if (CheckNickname(nick) && CheckPassword(nick, pwd1) && CheckSamePwd(pwd1, pwd2)) {
        return true;
    }
    return false;
}

function CheckNickname(nick) {
    let regexID = /^[a-zA-z0-9]{3,}$/;
    if (!regexID.test(nick)) {
        $('#id-fail').removeClass('hidden');
        return false;
    }
    $('#id-fail').addClass('hidden');
    return true;
}

function CheckPassword(nick, pwd) {
    if (pwd.includes(nick)) { //아이디가 비밀번호에 포함되었을 경우 false
        $('#pw1-fail').removeClass('hidden');
        return false;
    }

    let regexPW = /^[a-zA-z0-9]{4,12}$/;
    if (!regexPW.test(pwd)) {
        $('#pw1-fail').removeClass('hidden');
        return false;
    }

    $('#pw1-fail').addClass('hidden');
    return true;
}

function CheckSamePwd(pwd1, pwd2) {
    if (pwd1 !== pwd2) {
        $('#pw2-fail').removeClass('hidden');
        return false;
    }
    $('#pw2-fail').addClass('hidden');
    return true;
}