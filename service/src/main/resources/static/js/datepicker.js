$(document).ready(function(){
    $(function() {
        $( "#moveDate" ).datepicker();
        $( "#storageDate" ).datepicker();
        $( "#estimateDate" ).datepicker();
        $( "#packingDate" ).datepicker();
        $('#moveDateTime').clockpicker()
        $('#estimateDateTime').clockpicker()
        $('#packingDateTime').clockpicker()
    });
})