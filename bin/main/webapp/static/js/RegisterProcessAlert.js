function submitRegistrationForm() {
    var formData = new FormData(document.getElementById('registrationForm'));

    fetch('/webflix/mvc/registerProcess', {
        method: 'POST',
        body: formData
    })
    .then(response => response.json())
    .then(data => {
        if (data.success) {
            alert('회원가입이 완료되었습니다!');
        } else {
            alert('회원가입 실패: ' + data.message);
        }
    })
    .catch(error => {
        alert('서버 오류로 회원가입을 완료할 수 없습니다.');
    });

    return false;  // 폼 제출에 의한 페이지 새로고침 방지
}

