$(document).ready(function(){
    $(function() {
        $( "#moveDate" ).datepicker();
        $( "#estimateDate" ).datepicker();
        $( "#packingDate" ).datepicker();
        $('#moveDateTime').clockpicker()
        $('#estimateDateTime').clockpicker()
        $('#packingDateTime').clockpicker()
    });
})