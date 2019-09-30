
function changeCurrency() {
	var displayedCurrency = document.getElementsByClassName("displayedCurrency");
	for (var i = 0; i < displayedCurrency.length; i++) {
		displayedCurrency[i].innerText = document.getElementById("currency").value;
	}
	var type = document.getElementById("type").innerText;
	var price = document.getElementById(type).querySelectorAll(".price");
	var displayedMoney = document.getElementsByClassName("rate");
	
		switch( document.getElementById("currency").value) {
		case "USD":
			for (var i = 0; i < price.length; i++)
			displayedMoney[i].innerText = Math.ceil(price[i].value / 72);
			break;
		case "INR":
			for (var i = 0; i < price.length; i++)
			displayedMoney[i].innerText = Math.ceil(price[i].value);
			break;
		case "JPY":
			for (var i = 0; i < price.length; i++)
			displayedMoney[i].innerText = Math.ceil(price[i].value / 43);
			break;
	}

}




//
// const CURRENCY = {
//     TOINR : 71.15,
//     TOJPY : 106.29 
// }
//
//
//function getCharges() {
//    var daily;
//    var monthly;
//    var yearly;
//    if (window.vehicleType == "Cycle") {
//        daily = 5;
//        monthly = 100;
//        yearly = 500;
//    } else if (window.vehicleType == "Motor Cycle") {
//        daily = 10;
//        monthly = 200;
//        yearly = 1000;
//    } else {
//        daily = 20;
//        monthly = 500;
//        yearly = 3500;
//    }
//    window.charges = [daily, monthly, yearly];
//    return window.charges;
//}
//
//function changeCurrency() {
//    var charges = getCharges();
//    var tempCharges = [];
//    window.currency = document.getElementById("currency").value;
//    if (window.currency == "")
//        return;
//    if (window.currency == "INR") {
//        for (var i = 0; i < 3; i++)
//            tempCharges.push((Math.round(charges[i] * CURRENCY.TOINR) * 100) / 100);
//    }
//    else if (window.currency == "JPY") {
//        charges.forEach(element => {
//            tempCharges.push((Math.round(element * CURRENCY.TOJPY) * 100) / 100);
//        });
//    } else {
//        charges.forEach(element => {
//            tempCharges.push(element);
//        });
//    }
//    var content = "<br><table size=40% border='1'>"
//        + "<tr>"
//        + "<td>Daily </td>"
//        + "<td><label id='Daily'>" + window.currency + " " + tempCharges[0] + "</label></td>"
//        + "</tr>"
//        + "<tr>"
//        + "<td>Monthly </td>"
//        + "<td><label id='Monthly'>" + window.currency + " " + tempCharges[1] + "</label></td>"
//        + "</tr>"
//        + "<tr>"
//        + "<td>Yearly </td>"
//        + "<td><label id='Yearly'>" + window.currency + " " + tempCharges[2] + "</label></td>"
//        + "</tr>"
//        + "</table><br>"
//        + "<label size=40%><input type='radio' name='plan' value='Daily'>"
//        + " Daily "
//        + "</label>"
//        + "<label size=40%><input type='radio' name='plan' value='Monthly'>"
//        + " Monthly "
//        + "</label>"
//        + "<label size=40%><input type='radio' name='plan' value='Yearly'>"
//        + " Yearly "
//        + "</label><br><br>"
//        + "<button type='submit' onclick='getPlan()'>Buy</button>";
//    document.getElementById("showCharges").innerHTML = content;
//}
//
//function getPlan() {
//    var radios = document.getElementsByName("plan");
//    var elementChecked;
//    var plan;
//    for (i = 0; i < radios.length; i++) {
//        if (radios[i].checked) {
//            elementChecked = radios[i].value;
//            break;
//        }
//    }
//    if (elementChecked == "Daily") {
//        plan = charges[0];
//    } else if (elementChecked == "Monthly") {
//        plan = charges[1];
//    } else {
//        plan = charges[2];
//    }
//    if (window.currency == "INR")
//        plan = (Math.round(plan * CURRENCY.TOINR) * 100) / 100;
//    else if (window.currency == "JPY")
//        plan = (Math.round(plan * CURRENCY.TOJPY) * 100) / 100;
//    document.getElementById("planSelection").innerHTML = elementChecked + " plan purchased for " + window.currency + " " + plan + ".";
//}