/**
 * 
 */
 function calculatePriceAmount(){
		var price = document.getElementById("price").value;
		var availableQuantity = document.getElementById("avl_qty").value;
		var adAmt = document.getElementById("advanceAmount").value;
		var qty = document.getElementById("qty").value;
		let totalPrice = qty * price;
		if(availableQuantity > qty){
			if(totalPrice > 10000){
				let advanceAmt = (totalPrice * 30) / 100;
				document.getElementById("totalPrice").value = totalPrice;
				document.getElementById("advanceAmount").value = advanceAmt;
			}
			else{
				document.getElementById("totalPrice").value = totalPrice;
			}
		}
		else{
			document.getElementById("alert-msg").innerHTML = "Only " + qty + " are available";
			document.getElementById("submit").disabled = true;
		}
		
	}
	