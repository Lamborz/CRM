
var copyCompany = function(){
$("#companyHidden").val($("#company").val())
};
var copySizeOfMove = function(){
$("#companySizeOfMove").val($("#sizeOfMove").val())
};
var copyMoveDate = function(){
$("#companyMoveDate").val($("#moveDate").val())
};
var copyPackingDate = function(){
$("#companyPackingDate").val($("#packingDate").val())
};
var copyZipFrom = function(){
$("#companyZipFrom").val($("#zipFrom").val())
};
var copyZipTo = function(){
$("#companyZipTo").val($("#zipTo").val())
};


var copyAllFields = function(){
copyCompany();
copySizeOfMove();
copyMoveDate();
copyPackingDate();
copyZipFrom();
copyZipTo();

}

$(document).ready(
function(){
copyAllFields();
    $("#company").change(copyCompany);
    $("#sizeOfMove").change(copySizeOfMove);
    $("#moveDate").change(copyMoveDate);
    $("#packingDate").change(copyPackingDate);
    $("#zipFrom").change(copyZipFrom);
    $("#zipTo").change(copyZipTo);
});

