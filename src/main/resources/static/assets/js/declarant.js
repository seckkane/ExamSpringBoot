$(function (){	
	$('.add-button').on('click', function() {
		$('#modal-title').text('Ajout Nouveau Déclarant');
	    $('#id').val('');
	    $('#adresse').val('');
	    $('#email').val('');
	    $('#raisonSociale').val('');
	    $('#telephone').val('');
	    $('#submit').text('Ajouter');
	    $('#submit').show();
		$('#cancel').text('Annuler');
  });
});

$(function (){
    $(".edit-button").click(function(){
		$('#modal-title').text('Mis a jour Déclarant');
		$("#id").val($(this).data("declarant-id"));
		$("#adresse").val($(this).data("declarant-adresse"));
		$("#email").val($(this).data("declarant-email"));
		$("#raisonSociale").val($(this).data("declarant-raisonsociale"));
		$("#telephone").val($(this).data("declarant-telephone"));	
		$('#submit').text('Mettre a jour');	
		$('#submit').show();
		$('#cancel').text('Annuler');
    });
}); 

$(function (){
    $(".show-button").click(function(){
		$('#modal-title').text('Details - Declarant');
		$("#id").val($(this).data("declarant-id"));
		$("#adresse").val($(this).data("declarant-adresse"));
		$("#email").val($(this).data("declarant-email"));
		$("#raisonSociale").val($(this).data("declarant-raisonsociale"));
		$("#telephone").val($(this).data("declarant-telephone"));		
		$('#submit').hide();
		$('#cancel').text('Fermer');
    });
}); 

$(function (){
        $(".delete-button").click(function(){
		var deleteUrl = "/declarant/delete/" + $(this).data("declarant-id");;
		$("#confirmDelete").attr("href", deleteUrl);		
    });
});

$(function (){
        $('#countryid').on('change', function() {
        if ($(this).val() === "") {
        	$(this).prop('required', true);
        } else {
        	$(this).prop('required', false);
     	}
    });
});

