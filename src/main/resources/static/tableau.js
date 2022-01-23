// fichier tableau.js
$(document).ready(function () {
    $('#tab').DataTable({
    	 buttons: [ 'excel', 'pdf', 'copy' ]
    });
});

$('#deleteButton').on('click',function(event){
	event.preventDefault();
	console.log('nouveau click');
	var href = $(this).attr('href');
	$('#deleteModal #delRef').attr('href', href);
	$('#deleteModal').modal();
});