var loadingAddressCount = 0;
var zipFromCount = 0;
var loadingAddresses;
var loadingZip;

//Срабатывает, когда загрзился весь документ HTML
$(document).ready(
function(){
addressButtonListen();
}
);


//Срабатывает, когда щелкают мшью по кнопкам с id = addLoadAddress и submitOrder
var addressButtonListen = function(){
$("#addLoadAddress").click(addLoadAddressField);
$("#submitOrder").click(submitOrder);
}

//Добавляет поле с адресом и zip кодом
var addLoadAddressField = function(){
var nextLoadAddressIndex = loadingAddressCount + 1;
var nextZipFrom = zipFromCount +1;

loadingAddressCount += 1;
zipFromCount += 1;
var addressField = "<input type='text' class='form-control' placeHolder='Loading Address' id='loadAddress" + nextLoadAddressIndex + "'" + "/>"
var zipField ="<input style='width: 33.5%;' type='text' placeholder='Zip from' class='form-control' id='zipFrom" + nextZipFrom + "'" + " value='Zip from'/>"
$(zipField).appendTo("#zipFromDiv");
$(addressField).appendTo("#loadAddressDiv");
}

//Отпраляет форму с id = OrderForm на сервер!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
var submitOrder = function(){
collectAddressIdsNames();
alert("Теперь строка выглядит так(сначала адрес, потом соответствующие им индексы):" + loadingAddresses + ";" + loadingZip);
$("#loadingAddresses").val(loadingAddresses + ";" + loadingZip);
$("#FormOrder").submit();
}

// В цикле переберает все поля с zip кодом
var cycleZip = function(){
var zip='';
$(".zipCode").each(
         function(){
             if(zip != ''){
                zip = zip + "," + $(this).val();
             } else {
             zip = $(this).val();
             }
         }
      )
      loadingZip = zip;
}

// В цикле переберает все поля с адресом кодом
var cycle = function(){
var addresses ='';
$(".loadAddress").each(
         function(){
             if(addresses != ''){
                addresses = addresses + "," + $(this).val();
             } else{
             addresses = $(this).val();
             }
         }
      )
      loadingAddresses = addresses;
}

//Запускает циклы обработки полей с адресом и zip кодом
var collectAddressIdsNames = function(){
$("loadAddressDiv").on("change", ".loadAddress", cycle());
$("loadAddressDiv").on("change", ".zipCode", cycleZip());
}