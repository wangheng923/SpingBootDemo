/**
 * 
 */
$(document).ready(function() {
	$("#table").hide();
	$("#msg").html("");
	$("#user_modify").click(function() {
		$("#table").toggle();
	});

	$("#submitBtn").click(function() {
		$.ajax({
			type : "POST",
			url : "/user/modify",
			data : JSON.stringify({
				"username" : $("#username").val(),
				"password" : $("#password").val()
			}),
			contentType : "application/json",
			dataType : "json",
			success : function(result, status, xhr) {
				if (result && result.errCode === 0) {
					$("#msg").html(result.result);
				} else if (result && result.errCode !== 0) {
					$("#msg").html(result.errMsg);
				}
			},
			error : function(xhr, status, error) {
				if (xhr.status === 401) {
					window.location.href = "/";
				}
				if (error) {
					$("#msg").html(error.errMsg);
				}
			}
		});
	});
});