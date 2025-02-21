function total(){
	
	fname = document.getElementById('fname').value;
	quan = document.getElementById('quan').value;
	price = document.getElementById('fprice').value;
	
	total = price * quan;
	
	document.getElementById('tprice').value = total;
	
}

function searchdata(a)
{

	var fname1 = document.getElementById("fname").value;
	var price1 = document.getElementById("fprice").value;
	
	let xhr = new XMLHttpRequest();
	
	//precess the request
	xhr.onreadystatechange = () => {
		
		if(xhr.status == 200 && xhr.readyState == 4){
			console.log("data send successfully...");
		}
		
	}
	
	// prepare the request
	xhr.open("POST", "adddata.jsp?q=" + a + "&fname=" + fname1 + "&price=" + price1,true);
	
	xhr.send();
		
}
