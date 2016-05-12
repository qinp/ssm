$(document).ready(function(){
	$("#add").click(function(){
		var username = $("#name").attr("value");
		var age = $("#age").attr("value");
		var user = {username:username,userage:age};
		$.ajax({
			url:"/test/json/result",
			type:"post",
			data:user,
			success:function(data){
				alert(data.username+data.userage);
			}
		});
	});
});