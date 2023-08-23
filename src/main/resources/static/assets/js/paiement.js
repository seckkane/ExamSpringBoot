$(function (){	
	$('.add-button').on('click', function() {
		$('#modal-title').text('Ajout Nouveau Paiement');
	    $('#id').val('');
	    $('#declarationid').val('');
	    $("#declarationid").prop("disabled", false);
	    $('#montantPaiement').val('');
	    $('#submit').text('Ajouter');
	    $('#submit').show();
		$('#cancel').text('Annuler');
  });
});

$(function (){
    $(".edit-button").click(function(){
		$('#modal-title').text('Mise a jour Déclaration');
		$("#id").val($(this).data("paiement-id"));
		$("#datePaiement").val($(this).data("paiement-datepaiement"));
		$("#declarationid").val($(this).data("paiement-declarationid"));
		$("#declarationid").prop("disabled", true);
		$("#montantPaiement").val($(this).data("paiement-montantpaiement"));
		$('#submit').text('Mettre a jour');	
		$('#submit').show();
		$('#cancel').text('Annuler');
    });
});  

$(function (){
        $(".delete-button").click(function(){
		var deleteUrl = "/paiement/delete/" + $(this).data("paiement-id");;
		$("#confirmDelete").attr("href", deleteUrl);		
    });
});

$(function (){
        $('#declarationid').on('change', function() {
        if ($(this).val() === "") {
        	$(this).prop('required', true);
        } else {
        	$(this).prop('required', false);
     	}
    });
});

