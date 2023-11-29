function doSubmit() {
    let frm = document.form1;
    let flag = false;
    let check = [idCheck(), pwCheck(), nameCheck(), birthCheck()];


    for (let i = 0; i < check.length; i++) {
        if (!check[i]) {
            flag = true;
        }
    }

    if (!flag) {
        if (confirm("입력한 내용이 맞나요")) {
            frm.submit();
        }
    }
}

function idCheck() {
    let frm = document.form1;
    document.getElementById("inputIdTr").style = "";
    document.getElementById('inputIdError').innerHTML = "";
    document.getElementById("inputIdTr").className = "input R";
    let regID = /^[a-z0-9_-]{4,19}$/;
    if (frm.inputId.value === '') {
        document.getElementById('inputIdError').innerHTML = "*아이디:필수정보입니다.";
        return false;
    } else if (!regID.test(frm.inputId.value)) {
        document.getElementById('inputIdError').innerHTML = "*아이디:5~20자의 영문 소문자, 숫자와 특수기호(_)(-)만 사용 가능합니다.";
        return false;
    } else {
        document.getElementById("inputIdTr").className = "input";
        return true;
    }
}
function pwCheck() {
    let frm = document.form1;
    document.getElementById("inputPwTr").style = "";
    document.getElementById('pwNo').innerHTML = "";
    document.getElementById('inputPwError').innerHTML = "";
    document.getElementById("inputPwTr").className = "input R";
    let regPw = /^[a-z0-9A-Z\W]{8,16}$/g;
    if (frm.inputPw.value === '') {
        document.getElementById('inputPwError').innerHTML = "*비밀번호:필수정보입니다.";
        return false;
    } else if (!regPw.test(frm.inputPw.value)) {
        document.getElementById('pwNo').innerHTML = "사용불가";
        document.getElementById('inputPwError').innerHTML = "*비밀번호:8~16자의 영문 대/소문자, 숫자, 특수문자를 사용해주세요.";
        return false;
    } else {
        document.getElementById("inputPwTr").className = "input";

        return true;
    }
}
function pwView() {
    let frm = document.form1;
    if (frm.inputPw.type === 'password') {
        frm.inputPw.type = "text";
        document.getElementById('pwEye').innerHTML = "<i class='icon fa-solid fa-eye-slash' onclick='pwView()'></i>";
    } else {
        frm.inputPw.type = "password";
        document.getElementById('pwEye').innerHTML = "<i class='icon fa-solid fa-eye' onclick='pwView()'></i>";
    }
}

function nameCheck() {
    let frm = document.form1;
    document.getElementById("inputNameDiv").style = "";
    document.getElementById('inputNameError').innerHTML = "";
    document.getElementById("inputNameDiv").className = "input R";
    let regName = /^[가-힣a-zA-Z]{1,}$/;
    if (frm.inputName.value === '') {
        document.getElementById('inputNameError').innerHTML = "*이름:필수정보입니다.";
        return false;
    } else if (!regName.test(frm.inputName.value)) {
        document.getElementById('inputNameError').innerHTML = "*이름:한글, 영문, 대/소문자를 사용해주세요.(특수기호,공백 사용 불가)";
        return false;
    } else {
        document.getElementById("inputNameDiv").className = "input";
        return true;
    }
}

function birthCheck() {
    let frm = document.form1;
    let date = new Date();
    let dday = '';
    dday = dday + (date.getFullYear()) + (date.getMonth() + 1) + date.getDate();
    document.getElementById("inputBirthDiv").style = "";
    document.getElementById('inputBirthError').innerHTML = "";
    document.getElementById("inputBirthDiv").className = "input R";

    let regBirth = /^(19[0-9][0-9]|20\d{2})(0[0-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])$/;
    if (frm.inputBirth.value === '') {
        document.getElementById('inputBirthError').innerHTML = "*생년월일:필수정보입니다.";
        return false;
    } else if (frm.inputBirth.value.length != 8) {
        document.getElementById('inputBirthError').innerHTML = "*생년월일:생년월일은 8자리 숫자로 입력해주세요.";
        return false;
    } else if (!regBirth.test(frm.inputBirth.value)) {
        document.getElementById('inputBirthError').innerHTML = "*생년월일:생년월일이 정확한지 확인해주세요";
        return false;
    } else if (frm.inputBirth.value < dday - 1100000) {
        document.getElementById('inputBirthError').innerHTML = "*생년월일:생년월일이 정확한지 확인해주세요";
        return false;
    } else if (frm.inputBirth.value > dday - 140000 + 1) {
        document.getElementById('inputBirthError').innerHTML = "*생년월일:만 14세 미만의 어린이는 보호자의 동의가 필요합니다.";
        document.getElementById("inputBirthDiv").className = "input";
        document.getElementById("inputBirthError").style = "color:green;";
        return false;
    }
    else {
        document.getElementById("inputBirthDiv").className = "input";
        return true;
    }
}
