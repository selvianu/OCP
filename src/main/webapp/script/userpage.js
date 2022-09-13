/**
 * 
 */
 
 let slideIndex = 0;
		
		showSlides();

		function showSlides() {
			let i;
			let slides = document.getElementsByClassName("slides");
			for (i = 0; i < slides.length; i++) {
				slides[i].style.display = "none";
			}
			slideIndex++;
			if (slideIndex > slides.length) {
				slideIndex = 1
			}
			slides[slideIndex - 1].style.display = "block";
			setTimeout(showSlides, 2000); // Change image every 2 seconds
		}

		window.onscroll = function() {myFunction()};

		var navbar = document.getElementById("nav");
		var sticky = navbar.offsetTop;
		function myFunction() {
		  if (window.pageYOffset >= sticky) {
		    navbar.classList.add("sticky")
		  } else {
		    navbar.classList.remove("sticky");
		  }
		}
		
		function showFilters(){
			var filters = document.getElementById("filters");
			if (filters.style.display === "block") {
				filters.style.display = "none";
			    } else {
			    	filters.style.display = "block";
			    }
		}
		
		var dropdown = document.getElementsByClassName("dropdown-btn");
		var i;

		for (i = 0; i < dropdown.length; i++) {
		  dropdown[i].addEventListener("click", function() {
		    this.classList.toggle("active");
		    var dropdownContent = this.nextElementSibling;
		    if (dropdownContent.style.display === "block") {
		      dropdownContent.style.display = "none";
		    } else {
		      dropdownContent.style.display = "block";
		    }
		  });
		}