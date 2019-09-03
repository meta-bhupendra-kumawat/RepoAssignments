
function containsAlphanumeric(str) {
    var alpha = false;
    for (var i = 0; i < str.length; i++) {
        if (str.charCodeAt(i) >= 33 && str.charCodeAt(i) <= 47) {
            alpha = true; 
            break;
        }
        if (str.charCodeAt(i) >= 58 && str.charCodeAt(i) <= 64) {
            alpha = true; 
            break;
        }
        if (str.charCodeAt(i) >= 91 && str.charCodeAt(i) <= 96) {
            alpha = true; 
            break;
        }
        if (str.charCodeAt(i) >= 123 && str.charCodeAt(i) <= 126) {
            alpha = true; 
            break;
        }
    }
    return alpha;
}

function containsNumbers(str) {
    var num = false;
    for (var i = 0; i < str.length; i++) {
        if (str.charCodeAt(i) >= 48 && str.charCodeAt(i) <= 57) {
            num = true; 
            break;
        }
    }
    return num;
}

function hasNumbersOnly(str) {
    var num = true;
    for (var i = 0; i < str.length; i++) {
        if (str.charCodeAt(i) < 48 && str.charCodeAt(i) > 57) {
            num = false; 
            break;
        }
    }
    return num;
}

function hasAlphabetsOnly(str) {
    var alphabets = true;
    for (var i = 0; i < str.length; i++) {
        if (str.charCodeAt(i) < 65 || (str.charCodeAt(i) > 90 && str.charCodeAt(i) < 97) || str.charCodeAt(i) > 122) {
            alphabets = false;
            break;   
        }
    }
    return alphabets;
}

// Validate first_name.
function validateFirstName() {
    document.getElementById("first_name-error").innerHTML = "";
    var first_name = document.getElementById("first_name").value;
    if (first_name.length < 2 || !hasAlphabetsOnly(first_name)) {
        document.getElementById("first_name-error").innerHTML = "<font size='2' color='red'>Name should not contain numeric and its length > 2.</font>";
        return false;
    }
    return true;
}

 // Validate last_name.
function validateLastName() {
    document.getElementById("last_name-error").innerHTML = "";
    var last_name = document.getElementById("last_name").value;
    if (last_name.length < 2 || !hasAlphabetsOnly(last_name)) {
        document.getElementById("last_name-error").innerHTML = "<font size='2' color='red'>Name should not contain numeric and its length > 2.</font>";
        return false;
    }
    return true;
}

// Validate father_name.
function validateFatherName() {
    document.getElementById("father-name-error").innerHTML = "";
    var father_name = document.getElementById("father_name").value;
    if (father_name.length < 2 || !hasAlphabetsOnly(father_name)) {
        document.getElementById("father-name-error").innerHTML = "<font size='2' color='red'>Name should not contain numeric and its length > 2.</font>";
        return false;
    }
    return true;
}

function fullValidate() {
    var flag1 = validateFirstName();
    var flag2 = validateLastName();
    var flag3 = validateFatherName();
    var flag4 = true;
    var flag5 = true;
    var flag6 = true;
    var email = document.getElementById("email").value;
    var className = document.getElementById("class").value;
    var age = document.getElementById("age").value;
    
    document.getElementById("class-error").innerHTML = "";
    document.getElementById("age-error").innerHTML = "";

    if(email.length < 4) {
    	document.getElementById("email-error").innerHTML = "<font size='2' color='red'>Enter valid email.</font>";
    	flag4 = false;
    }
    if(className == "") {
    	document.getElementById("class-error").innerHTML = "<font size='2' color='red'>Enter class.</font>";
        flag5 = false;
    }
    if(age == "") {
    	document.getElementById("age-error").innerHTML = "<font size='2' color='red'>Enter age.</font>";
    	flag6 = false;
    }
    return flag1 && flag2 && flag3 && flag4 && flag5 && flag6; 
}