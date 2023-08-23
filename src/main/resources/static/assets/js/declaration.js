$(function (){	
	$('.add-button').on('click', function() {
		$('#modal-title').text('Ajout Nouvelle Declaration');
	    $('#id').val('');
	    $('#declarantid').val('');
	    $('#montantDeclaration').val('');
	    $('#submit').text('Ajouter');
	    $('#submit').show();
		$('#cancel').text('Annuler');
  });
});

$(function (){
    $(".edit-button").click(function(){
		$('#modal-title').text('Mis a jour Déclarant');
		$("#id").val($(this).data("declaration-id"));
		$("#dateDeclaration").val($(this).data("declaration-datedeclaration"));
		$("#declarantid").val($(this).data("declaration-declarantid"));
		$("#montantDeclaration").val($(this).data("declaration-montantdeclaration"));
		$('#submit').text('Mettre a jour');	
		$('#submit').show();
		$('#cancel').text('Annuler');
    });
});  

$(function (){
        $(".delete-button").click(function(){
		var deleteUrl = "/declaration/delete/" + $(this).data("declaration-id");;
		$("#confirmDelete").attr("href", deleteUrl);		
    });
});

$(function (){
        $('#declarantid').on('change', function() {
        if ($(this).val() === "") {
        	$(this).prop('required', true);
        } else {
        	$(this).prop('required', false);
     	}
    });
});

