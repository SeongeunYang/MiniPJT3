function isValidContents(contents, title) {
    if (contents == '' | title == '') {
        alert('내용을 입력해주세요');
        return false;
    }
    return true;
}

function SendPost() {
    let contents = $('#contents').val();
    let title = $('#postTitle').val();
    if (isValidContents(contents, title) == false) {
        return;
    }
    // 4. 전달할 data JSON으로 만듭니다.
    let data = {'title': title, 'username': "", 'content': contents};

    // 5. POST /api/memos 에 data를 전달합니다.
    $.ajax({
        type: "POST",
        url: "/board/newpost",
        contentType: "application/json",
        data: JSON.stringify(data),
        success: function (response) {
            alert('게시글이 저장되었습니다.');
            window.location.href = '/';
        }
    });
}