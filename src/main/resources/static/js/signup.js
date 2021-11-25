function SendForm() {
    let nick = $('#nickname').val();
    let pwd1 = $('#password').val();
    let pwd2 = $('#chk-password').val();
    let email = $('#email').val();

    if (CheckForm(nick, pwd1, pwd2)) {
        let userdata = {'username': nick, 'password': pwd1, 'email': email}

        $.ajax({
            type: "POST",
            url: "/user/signup",
            contentType: "application/json",
            data: JSON.stringify(userdata),
            success: function (response) {
                if(response ==="저장되었습니다."){
                    window.location.href = '/user/login';
                } else if (response === "중복된 ID 입니다.") {
                    $('#id-fail').text(response);
                    $('#id-fail').removeClass('hidden');
                } else if(response === "중복된 Email 입니다.") {
                    $('#email-fail').text(response);
                    $('#email-fail').removeClass('hidden');
                } else {
                    alert(response);
                }
            }
        });
    }
}

function CheckForm(nick, pwd1, pwd2) {
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