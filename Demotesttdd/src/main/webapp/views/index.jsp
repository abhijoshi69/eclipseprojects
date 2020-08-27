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
	<div id="viewData"></div>
	<script type="text/javascript">
		function displayUsers()
		{
			var tableData = document.getElementById("userTable").innerHTML;
			var req = new XMLHttpRequest();
			req.open("GET","display","true");
			req.send(null);
			
			req.onreadystatechange=function(){
				if(req.readyState==4 && req.status==200)
					{
						tableData ="";
						var users = JSON.parse(req.responseText);
						console.log(users);
						for(var i=0;i<users.length;i++)
							{
								tableData=tableData+"<tr>"+
														"<td>"+users[i].id+"</td>"+
														"<td>"+users[i].name+"</td>"+
														"<td>"+users[i].address+"</td>"+
														"<td>"+users[i].password+"</td>"+
														"<td><button id='"+users[i].id+"' onclick='viewbyidData(this.id)'>view</button></td>"+
														"<td><button id='"+users[i].id+"' onclick='updateData(this.id)'>update</button></td>"+
														"<td><button id='"+users[i].id+"' onclick='deleteData(this.id)'>delete</button></td>"+
														"</tr>";
								
							}
						document.getElementById("userTable").innerHTML=tableData;
					}
			}
			
			
		}
		function viewbyidData(id)
		{
			var opp = document.getElementById("viewData").innerHTML;
			var req = new XMLHttpRequest();
			req.open("GET","onedata?id="+id,"true");
			req.send(null);
			
			req.onreadystatechange=function()
			{
				if(req.readyState==4 && req.status==200)
					{
						opp ="";
						var users = JSON.parse(req.responseText);
						console.log(users);
						for(var i=0;i<users.length;i++)
							{
							opp = opp+  "ID: "+id+
							"<br/>Name: "+users[i].name+
							"<br/>Address: "+users[i].address+
							"<br/>Password: "+users[i].password;
							}
							
						
						document.getElementById("viewData").innerHTML=opp;
					}
			}
		}
		
		function deleteData(id)
		{
			var confirmation = confirm("Are you sure you want to delete the id "+id);
			var deleteData = document.getElementById("viewData").innerHTML;
			if(confirmation)
				{
					var req = new XMLHttpRequest();
					req.open("GET","delete?id="+id,"true");
					req.send(id);
			
					req.onreadystatechange=function()
					{
						if(req.readyState==4 && req.status==200)
						{
							
									console.log("data deleted successfully");
									document.getElementById("viewData").innerHTML = req.responseText;
									displayUsers();		
						}
					}
			
				}
		}
		function updateData(id)
		{
			var usersdata = document.getElementById("viewData").innerHTML;
			var req = new XMLHttpRequest();
			req.open("GET","onedata?id="+id,"true");
			req.send(null);
			
			req.onreadystatechange=function()
			{
				if(req.readyState==4 && req.status==200)
					{
						usersdata ="";
						var views = JSON.parse(req.responseText);
						console.log(views);
						for(var i=0;i<views.length;i++)
							{
							usersdata = usersdata + "<form>"+
							"ID: <input type='text' id='id' name='id' value='"+views[i].id+"'/>"+
							"<br/>Name: <input type='text' id='name' name='name' value='"+views[i].name+"'/>"+
							"<br/>Address: <input type='text' id='address' name='address' value='"+views[i].address+"'/>"+
							"<br/>Password: <input type='password' id='password' name='password' value='"+views[i].password+"'/>"+
							"<br/><button onclick='save()'>Update</button>"+	
							"</form>";
	
							}
						document.getElementById("viewData").innerHTML=usersdata;
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
			users.id=id;
			users.name=name;
			users.address=address;
			users.password=password;
			
			var req = new XMLHttpRequest();
			req.open("POST","updatedata","true");
			req.setRequestHeader("Content-type","application/json");
			req.send(JSON.stringify(users));
			
			req.onreadystatechange=function()
			{
				if(req.readyState==4 && req.status==200)
					{
						var data = JSON.parse(req.responseText);
						console.log(data);
						if(data.status)
							{
								console.log("updated successfully");
								displayUsers();
							}
						else
							{
								console.log("value not updated");
							}
						
					}
			}
		}
	</script>
</body>
</html>
