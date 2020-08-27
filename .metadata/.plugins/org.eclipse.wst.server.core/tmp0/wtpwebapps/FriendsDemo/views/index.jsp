<html>
<body onload="displayUsers()">
	<table border="1">
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Address</th>
				<th>Password</th>
			</tr>
		</thead>
		<tbody id="userTable">
		</tbody>
	</table>
	<br>
	<br>
	<div id="details"></div>
	<script type="text/javascript">
		function displayUsers()
		{
			var tableData = document.getElementById("userTable").innerHTML;
			var req = new XMLHttpRequest();
			req.open("GET","display","true");
			req.send(null);
			
			req.onreadystatechange=function()
			{
				if(req.readyState==4 && req.status==200)
					{
						tableData="";
						var users = JSON.parse(req.responseText);
						console.log(users);
						for(var i=0;i<users.length;i++)
							{
								tableData = tableData + "<tr>"+
															"<td>"+users[i].id+"</td>"+
															"<td>"+users[i].name+"</td>"+
															"<td>"+users[i].address+"</td>"+
															"<td>"+users[i].password+"</td>"+
															"<td><button id='"+users[i].id+"' onclick='viewData(this.id)'>View</button></td>"+
															"<td><button id='"+users[i].id+"' onclick='updateData(this.id)'>Update</button></td>"+
															"<td><button id='"+users[i].id+"' onclick='deleteData(this.id)'>Delete</button></td>"+
														"</tr>";
							}
						document.getElementById("userTable").innerHTML = tableData;
					}
			}
		}
		
		function viewData(id)
		{
			var detailsData = document.getElementById("details").innerHTML;
			var req = new XMLHttpRequest();
			req.open("GET","view?id="+id,"true");
			req.send(id);
			
			req.onreadystatechange=function()
			{
				if(req.readyState==4 && req.status==200)
					{
						detailsData="";
						var users = JSON.parse(req.responseText);
						console.log(users);
						for(var i=0;i<users.length;i++)
							{
								detailsData = detailsData + "<div style='border:2px solid blue;border-radius:5px;width:30%;height:30%;padding: 4px;margin: 4px;font-size:20px;font-family: Arial Black'>"+
															"ID: "+users[i].id+"<br/>"+
															"Name: "+users[i].name+"<br/>"+
															"Address: "+users[i].address+"<br/>"+
															"Password: "+users[i].password+"<br/>"+
															"</div>";
							}
						document.getElementById("details").innerHTML = detailsData;
					}
			}
		}
		
		function updateData(id)
		{
			var detailsData = document.getElementById("details").innerHTML;
			var req = new XMLHttpRequest();
			req.open("GET","editdetails?id="+id,"true");
			req.send(id);
			
			req.onreadystatechange=function()
			{
				if(req.readyState==4 && req.status==200)
					{
						detailsData="";
						var users = JSON.parse(req.responseText);
						console.log(users);
						for(var i=0;i<users.length;i++)
							{
								detailsData = detailsData + "<div style='border:2px solid blue;border-radius:5px;width:30%;heigth:30%;padding: 4px;margin:4px;font-size: 15px;font-family:Times New Roman'>"+
															"<form>"+
																"ID:<input type='text' name='id' id='id' value='"+users[i].id+"'/><br><br>"+
																"Name:<input type='text' name='name' id='name' value='"+users[i].name+"'/><br><br>"+
																"Address:<input type='text' name='address' id='address' value='"+users[i].address+"'/><br><br>"+
																"Password:<input type='password' name='password' id='password' value='"+users[i].password+"'/><br><br>"+
																"<button onclick='save()'>Update</button>"+
															"</form>"+
															"</div>";
							}
						document.getElementById("details").innerHTML = detailsData;
					}
			}
		}
		
		function save()
		{
			var id = document.getElementById("id").value;
			var name = document.getElementById("name").value;
			var address = document.getElementById("address").value;
			var password = document.getElementById("password").value;
			
			var users = {};
			users.id = id;
			users.name = name;
			users.address = address;
			users.password = password;
			
			console.log(users);
			
			var detailsData = document.getElementById("details");
			var req = new XMLHttpRequest();
			req.open("POST","update",true);
			req.setRequestHeader("Content-type","application/json");
			req.send(JSON.stringify(users));
			
			req.onreadystatechange=function()
			{
				if(req.readyState==4 && req.status==200)
					{
						detailsData.innerHTML = req.responseText;
						displayUsers();
					}
				else
					{
						detailsData.innerHTML = req.responseText;
						displayUsers();
					}
			}
		}
	</script>
</body>
</html>
