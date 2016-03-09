

 <html> 
 <head> <title>Create Greetings</title> 
 
 
 
  </head> <body> <h1>Custom Greetings</h1>	<form method="POST"> 
	Greeting ID: <input type="text" name="id" /><br/> 
	Content: <input type="text" name="content" /><br/> 
	Priority: <input type="text" name="priority" /><br/>
	Type: <input type="text" name="type" /><br/>
	House No.: <input type="text" name="Address[0].houseNo" /><br/>
	Address Id: <input type="text" name="Address[0].address_id" /><br/>
	<input type="submit" value="Register" /> 
	</form> 
</body>
 </html>
