$(function (){	
	$('.add-button').on('click', function() {
		$('#modal-title').text('Adding a new User');
	    $('#id').val('');
	    $('#firstname').val('');
	    $('#lastname').val('');
	    $('#username').val('');
	    $('#submit').text('Save');
  });
});

$(function (){
    $(".edit-button").click(function(){
		$('#modal-title').text('Editing a User');
		$("#id").val($(this).data("user-id"));
		$("#firstname").val($(this).data("user-firstname"));
		$("#lastname").val($(this).data("user-lastname"));
		$("#username").val($(this).data("user-username"));	
		$('#submit').text('Update');	
    });
}); 

$(function (){
        $(".delete-button").click(function(){
		var deleteUrl = "/user/delete/" + $(this).data("user-id");;
		$("#confirmDelete").attr("href", deleteUrl);		
    });
});


