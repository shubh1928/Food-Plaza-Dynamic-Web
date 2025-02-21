function ChangePassValidation(){
	
	email = document.getElementById("email").value;
	if(email == ""){
		document.getElementById("emailerror").innerHTML = "Please enter your email";
		return false;
	}
	
	opass = document.getElementById("opass").value;
	dpass = parseInt(document.getElementById("opass").getAttribute("data-old"));
	
	if(opass == ""){
			document.getElementById("opasserror").innerHTML = "Please enter your old password";
			return false;
		}
	if(opass != dpass){
			document.getElementById("opasserror").innerHTML = "Old password is incorrect";
			return false;
		}
	else if(opass == dpass){
		document.getElementById("opasserror").innerHTML = "";
	}
		
		
	npass = document.getElementById("npass").value;
	if(npass == ""){
				document.getElementById("npasserror").innerHTML = "Please enter your new password";
				return false;
		}
		else if (npass != "") {
		        document.getElementById("npasserror").innerHTML = "";
		    }
	
		
	cpass = document.getElementById("cpass").value;
	if(cpass == ""){		
				document.getElementById("cpasserror").innerHTML = "Please enter your confirm password";
				return false;
		}
	if(cpass != npass){		
				document.getElementById("cpasserror").innerHTML = "Password didn't matched";
				return false;
		}
		else if (cpass == npass) {
		        document.getElementById("cpasserror").innerHTML = "";
		    }
	
		
	return true;
	
}




function AddCustValidation(){
	
	cname = document.getElementById("cname").value;
	if(cname == ""){
		document.getElementById("cnameerror").innerHTML = "Please enter customer name";
		return false;
	}
	else if (cname != "") {
	        document.getElementById("cnameerror").innerHTML = "";
	    }
		
	
	email = document.getElementById("email").value;
	if(email == ""){
			document.getElementById("emailerror").innerHTML = "Please enter your email";
			return false;
		}
		else if (email != "") {
		        document.getElementById("emailerror").innerHTML = "";
		    }	
		
	pass = document.getElementById("pass").value;
	if(pass == ""){
				document.getElementById("passerror").innerHTML = "Please enter your password";
				return false;
		}
		else if (pass != "") {
		        document.getElementById("passerror").innerHTML = "";
		    }
		
	adr = document.getElementById("adr").value;
	if(adr == ""){		
				document.getElementById("adreerror").innerHTML = "Please enter your address";
				return false;
		}
		else if (adr != "") {
		        document.getElementById("adreerror").innerHTML = "";
		    }

	cNo = document.getElementById("cNo").value;
	if(cNo == ""){		
				document.getElementById("cNoerror").innerHTML = "Please enter your contact number";
				return false;
		}	
		else if (cNo != "") {
		        document.getElementById("cNoerror").innerHTML = "";
		    }
				
	return true;
	
}




function AddFeedValidation(){
	
	uname = document.getElementById("uname").value;
	if(uname == ""){
		document.getElementById("unameerror").innerHTML = "Please enter user name";
		return false;
	}
	else if(uname != ""){
		document.getElementById("unameerror").innerHTML = "";
	}
	
	
	email = document.getElementById("email").value;
	if(email == ""){
			document.getElementById("emailerror").innerHTML = "Please enter your email";
			return false;
		}
		else if (email != "") {
		        document.getElementById("emailerror").innerHTML = "";
		    }
		
		
	review = document.getElementById("review").value;
	if(review == ""){
				document.getElementById("reviewerror").innerHTML = "Please enter review";
				return false;
		}
		else if (review != "") {
		        document.getElementById("reviewerror").innerHTML = "";
		    }
	
		
	rank = document.getElementById("rank").value;
	if(rank == ""){		
				document.getElementById("rankerror").innerHTML = "Please enter rank";
				return false;
		}
		else if (rank != "") {
		        document.getElementById("rankerror").innerHTML = "";
		    }
	

	sugge = document.getElementById("sugge").value;
	if(sugge == ""){		
				document.getElementById("suggeerror").innerHTML = "Please enter suggestion";
				return false;
		}
		else if (sugge != "") {
		        document.getElementById("suggeerror").innerHTML = "";
		    }	
		
	return true;
	
}




function AddFoodValidation(){
	
	ftype = document.getElementById("ftype").value;
	if(ftype == ""){
		document.getElementById("ftypeerror").innerHTML = "Please enter food type";
		return false;
	}
	else if (ftype != "") {
	        document.getElementById("ftypeerror").innerHTML = "";
	    }
	
	fname = document.getElementById("fname").value;
	if(fname == ""){
			document.getElementById("fnameerror").innerHTML = "Please enter food name";
			return false;
		}
		else if (fname != "") {
		        document.getElementById("fnameerror").innerHTML = "";
		    }	
		
	fquantity = document.getElementById("fquantity").value;
	if(fquantity == ""){
				document.getElementById("fquantityerror").innerHTML = "Please enter food quntity";
				return false;
		}
		else if (fquantity != "") {
		        document.getElementById("fquantityerror").innerHTML = "";
		    }
		
	fprice = document.getElementById("fprice").value;
	if(fprice == ""){		
				document.getElementById("fpriceerror").innerHTML = "Please enter food price";
				return false;
		}
		else if (fprice != "") {
		        document.getElementById("fpriceerror").innerHTML = "";
		    }
				
	return true;
	
}




function AddCartValidation(){
	
	fid = document.getElementById("fid").value;
	if(fid == ""){
		document.getElementById("fiderror").innerHTML = "Please enter food id";
		return false;
	}
	else if (fid != "") {
	        document.getElementById("fiderror").innerHTML = "";
	    }
	
	
	email = document.getElementById("email").value;
	if(email == ""){
			document.getElementById("emailerror").innerHTML = "Please enter your email";
			return false;
		}
		else if (email != "") {
		        document.getElementById("emailerror").innerHTML = "";
		    }
		
		
	fname = document.getElementById("fname").value;
	if(fname == ""){
				document.getElementById("fnameerror").innerHTML = "Please enter food name";
				return false;
		}
		else if (fname != "") {
		        document.getElementById("fnameerror").innerHTML = "";
		    }
		
	quan = document.getElementById("quan").value;
	availableQuantity = parseInt(document.getElementById("quan").getAttribute("data-quantity"));

	if(quan == ""){		
				document.getElementById("quanerror").innerHTML = "Please enter food quantity";
				return false;
		}
	else if (parseInt(quan) > availableQuantity) {
		        document.getElementById("quanerror").innerHTML = `Quantity entered exceeds the available quantity (${availableQuantity})`;
		        return false;
		}
		else if (quan != "" && parseInt(quan) <= availableQuantity) {
		        document.getElementById("quanerror").innerHTML = "";
		    }
		
	fprice = document.getElementById("fprice").value;
	if(fprice == ""){		
				document.getElementById("fpriceerror").innerHTML = "Please enter food price";
				return false;
		}	
		else if (fprice != "") {
		        document.getElementById("fpriceerror").innerHTML = "";
		    }
		
	tprice = document.getElementById("tprice").value;
	if(tprice == ""){		
				document.getElementById("tpriceerror").innerHTML = "Please enter total price";
				return false;
		}
		else if (tprice != "") {
		        document.getElementById("tpriceerror").innerHTML = "";
		    }
		
	return true;
	
}




function LoginValidation(){
	
	type = document.getElementById("type").value;
	if(type == "" || type == null){
		document.getElementById("selecterror").innerHTML = "Please Select altleast one type!!!";
		return false;
	}
	else if (type != "" && type != null) {
	        document.getElementById("selecterror").innerHTML = "";
	    }
	
	email = document.getElementById("email").value;
	if(email == ""){
			document.getElementById("emailerror").innerHTML = "Please enter your email";
			return false;
		}
		else if (email != "") {
		        document.getElementById("emailerror").innerHTML = "";
		    }
		
	pass = document.getElementById("pass").value;
	if(pass == ""){
				document.getElementById("passerror").innerHTML = "Please enter your password";
				return false;
		}
		else if (pass != "") {
		        document.getElementById("passerror").innerHTML = "";
		    }
		
	return true;
	
}




function UpdateCustValidation(){
	
	cname = document.getElementById("cname").value;
	if(cname == ""){
		document.getElementById("cnameerror").innerHTML = "Please enter customer name";
		return false;
	}
	else if (cname != "") {
	        document.getElementById("cnameerror").innerHTML = "";
	    }
	
	
	email = document.getElementById("email").value;
	if(email == ""){
			document.getElementById("emailerror").innerHTML = "Please enter your email";
			return false;
		} 
		else if (email != "") {
		        document.getElementById("emailerror").innerHTML = "";
		    }	
		
	pass = document.getElementById("pass").value;
	if(pass == ""){
				document.getElementById("passerror").innerHTML = "Please enter your password";
				return false;
		}
		else if (pass != "") {
		        document.getElementById("passerror").innerHTML = "";
		    }
		
	cNo = document.getElementById("cNo").value;
	if(cNo == ""){		
				document.getElementById("cNoerror").innerHTML = "Please enter your contact number";
				return false;
		}	
		else if (cNo != "") {
		        document.getElementById("cNoerror").innerHTML = "";
		    }	
		
    adr = document.getElementById("adr").value;
	if(adr == ""){		
				document.getElementById("adrerror").innerHTML = "Please enter your address";
				return false;
	    }
		else if (adr != "") {
		        document.getElementById("adrerror").innerHTML = "";
		    }

		
	return true;
	
}




function UpdateFoodValidation(){
	
	fid = document.getElementById("fid").value;
	if(fid == ""){
			document.getElementById("fiderror").innerHTML = "Please enter food ID";
			return false;
		}
		else if (fid != "") {
		        document.getElementById("fiderror").innerHTML = "";
		    }
	
	fname = document.getElementById("fname").value;
	if(fname == ""){
			document.getElementById("fnameerror").innerHTML = "Please enter food name";
			return false;
		}
		else if (fname != "") {
		        document.getElementById("fnameerror").innerHTML = "";
		    }
		
	ftype = document.getElementById("ftype").value;
	if(ftype == ""){		
			document.getElementById("ftypeerror").innerHTML = "Please enter food type";	
			return false;
		}
		else if (ftype != "") {
		        document.getElementById("ftypeerror").innerHTML = "";
		    }	
		
		
	fquantity = document.getElementById("fquantity").value;
	if(fquantity == ""){
				document.getElementById("fquantityerror").innerHTML = "Please enter food quntity";
				return false;
		}
		else if (fquantity != "") {
		        document.getElementById("fquantityerror").innerHTML = "";
		    }
	
		
	fprice = document.getElementById("fprice").value;
	if(fprice == ""){		
				document.getElementById("fpriceerror").innerHTML = "Please enter food price";
				return false;
		}
		else if (fprice != "") {
		        document.getElementById("fpriceerror").innerHTML = "";
		    }
		
	return true;
	
}