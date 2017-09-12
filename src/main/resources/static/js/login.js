/**
 * 
 */
$(document).ready(function() {

	$("#submitBtn").click(function() {
		var username = $("#username").val();
		var password = $("#password").val();
		$.ajax({
			type : "POST",
			url : "loginAction",
			data : {
				'username' : username,
				'password' : password
			},
			dataType : "json",
			success : function(result, status, xhr) {
				alert(result.result);
				window.location.href="templates/home.html";
			},
			error : function(xhr, status, error) {
				alert("用户名或密码错误");
			}
		});
	});
});