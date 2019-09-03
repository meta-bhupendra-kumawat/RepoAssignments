window.onload = function() {
    var urlParams = new URLSearchParams(window.location.search);
    var id = urlParams.get('id');
    var first_name = urlParams.get('first_name');
    var last_name = urlParams.get('last_name');
    var fathers_name = urlParams.get('father_name');
    var email = urlParams.get('email');
    var className = urlParams.get('class');
    var age = urlParams.get('age');

    document.getElementById("id").value = id;
    document.getElementById("first_name").value = first_name;
    document.getElementById("last_name").value = last_name;
    document.getElementById("father_name").value = fathers_name;
    document.getElementById("email").value = email;
    document.getElementById("class").value = className;
    document.getElementById("age").value = age;
};