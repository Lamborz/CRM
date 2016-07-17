
var changeTotalSumPerHours = function(){
    var ratePerHour = $("#ratePerHour").val();
    var hours = $("#totalForFirstHours").val();
    $("#totalForHours").val(ratePerHour * hours);
}

//Заполняет поля, инпуты и т.д. после обработки первичных данных\
//на сервере
var fillPaymentsFormAfterHandle = function(data){
/*    var packingMaterials = data.packingMaterials;
    var packingMaterialsTariff = data.packingMaterialsTariff;
    var shrinkSum = data.shrinkSum;
    var tapeSum = data.tapeSum;
    var shrinkSum = data.shrinkSum;*/
   $("#ratePerHour").val(data.ratePerHour);
   var ratePerHour = $("#ratePerHour").val();
   var hours = $("#totalForFirstHours").val();
   $("#totalForHours").val(ratePerHour * hours);
}

var refreshPaymentDetails = function(){
    $.ajax({
      method: "get",
      url: "/payments/details",
      dataType: 'json',
      data: $("#paymentsDetailsForm").serialize(),
      success: fillPaymentsFormAfterHandle
    });
}




