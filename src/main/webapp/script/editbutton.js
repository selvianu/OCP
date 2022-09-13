/**
 * 
 */
 function enable(trigger){
			console.log("Inside Function");
			/* var text = document.getElementsByClassName('inactive')[10]; */
			console.log(trigger);
			var cont=trigger.querySelectorAll('.inactive');
			console.log(cont.length);
			for(let i = 0; i < cont.length; i++){
				cont[i].classList.add('active');
			}
		}
		
		function disable(trigger){
			console.log("Inside Function");
			/* var text = document.getElementsByClassName('inactive')[10]; */
			console.log(trigger);
			var cont=trigger.querySelectorAll('.active');
			console.log(cont.length);
			for(let i = 0; i < cont.length; i++){
				cont[i].classList.add('inactive');
			}
		}