<html>
<head>

<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script>
	$(function(){
		 console.log('get');
		 $.get("/postsJsonData", function(data, status){
		 	console.log(data);
		 	console.log(status);
		 	data.posts.forEach(function(val, key){
		 		console.log(val.title);
		 	});
	    });
	});
</script>

</head>
<body>
	${message}
	<h2>Post</h2>
	${postList}
	
	<h2>Post</h2>
	
	<#list postList.posts as post>
		<h3>${post.title}</h3>
		<p>${post.content}</p>
	</#list>
		
</body>
</html>