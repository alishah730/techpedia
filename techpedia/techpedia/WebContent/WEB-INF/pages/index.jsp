<!DOCTYPE html>
<html ng-app="techpedia">
<!-- BEGIN HEAD -->

<jsp:include page="template/NewHeader.jsp" />
	
	<!-- BEGIN SLIDER -->
	        <div id="my-slide" class="borderRadius">
            <img data-lazy-src="http://devrama.com/static/devrama-slider/images/265740754_141774705b_b.png" />
            <img data-lazy-src="http://devrama.com/static/devrama-slider/images/4247776023_81a3f048ca_b.png" />
            <img data-lazy-src="http://devrama.com/static/devrama-slider/images/4277941123_044d26b6df_b.png" />
            <img data-lazy-src="http://devrama.com/static/devrama-slider/images/4432435310_d5010f8efc_b.png" />
            <img data-lazy-src="images/s1.1.jpg" />
			</div>					   

	<br />
	<div class="customFont">
		<h2 style="text-align:center;color:white">Creativity | Collaboration | Compassion</h2>
	</div>
	<br />
	<div ng-controller="IndexController" ng-init="InitLoad()" class="container customFont borderRadius" style="background-color:#FAFAF7;padding:20px;max-width:1130px;border-radius:5px;">
		<div class="row" style="padding-left:20px;padding-right:20px;">
		<div class="span8" style="color:black; text-align:justify">
		<h3 style="font-weight: 700;">Welcome to techpedia</h3>
		
		<p style="font-size:16px;"> Techpedia, an initiative at SRISTI aims at putting the problems of micro, small and medium enterprises, informal sector, grassroots innovators and other social sectors on the agenda of the young technology students across the country. For over last sixty years, India has not utilized much the technological outputs of millions of students. But no more. Can a knowledge society really afford to ignore the huge talent distributed in thousands of polytechnics, diploma and degree colleges of engineering, pharmacy, medical science, agriculture etc.? SRISTI is providing a platform for the industry and academic institutions to collaborate, co-create and foster distributed and horizontal innovations. Most of the ideas mentioned here have been implemented in the state of Gujarat in close cooperation with Gujarat Technical University and initial results are extremely encouraging. <a href="aboutus">Read More...</a></p>
		</div>
		</div>
		    
    </div>
    
     <div id="copyright"  ng-controller="IndexController" ng-init="InitLoad()" class="container customFont" style="padding:5px;max-width:1130px;border-radius:5px;margin-top:20px;border-radius:5px;">
    	<div class="customFont borderRadius" style="background-color:#FAFAF7;padding:15px;">
			<div class="container">
				<div class="row">
					<div class="col-xs-6">
						<section>
							<div class="Spotlights">
								<div>
									<h3 style="cursor: pointer;" ng-click="viewProject(project)">{{project.projTitle}}</h3>
									<p style="cursor: pointer;" ng-click="viewProject(project)">{{project.projDescription | truncate:true:150:'...'}}

									
									<p>
									<footer>
										<a href="projects" class="button scrolly">See all</a>
									</footer>
								</div>
							</div>
						</section>
					</div>

					<div class="col-xs-6">
						<div class="row no-collapse">
							<div class="col-xs-25">
								<a style="cursor: pointer;" ng-click="viewProject(project)" class="image full"><img
									class="img-responsive" src="{{project.projImage||'images/art/project.png'}}" alt="" /></a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		</div>
    
    <div id="copyright" ng-controller="IndexController" ng-init="InitLoad()" class="container customFont" style="background-color:#FAFAF7;padding:5px;max-width:1130px;border-radius:5px;margin-top:20px;">
	<section id="third" class="main">
		<header>
			<div class="container">
				<h2>Testimonials</h2>
			</div>
		</header>
		<div class="content dark style3">
			<div class="container">
				<div class="row">
					<div class="col-xs-12">
						<div class="testimonials" style="border-left: 0px;">
							<div>
								<p class="welcome">
									{{testimonial.testimonial | truncate:true:150:'...'}} <cite>- {{testimonial.cite}}</cite>
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</div>

    <!-- Table of Contents -->
	<!--<div class="container">
    	
    		<div class="col-sm-3" id="Table_of_Contents" >
    			<div class="list-group">
    				<span class="list-group-item" style="background-color: #026881; color: #fff;">Table of Contents</span>
    				<a class="list-group-item" href="javascript:;" onclick='$("html, body").delay(100).animate({scrollTop: $("#whats-included").offset().top }, 1000);'>What's included</a>
    				<a class="list-group-item" href="javascript:;" onclick='$("html, body").delay(100).animate({scrollTop: $("#basic-setup-ltr").offset().top }, 1000);'>Basic setup</a>
    				<a class="list-group-item" href="javascript:;" onclick='$("html, body").delay(100).animate({scrollTop: $("#basic-setup-rtl").offset().top }, 1000);'>Basic setup (rtl language layout)</a>
    				<a class="list-group-item" href="javascript:;" onclick='$("html, body").delay(100).animate({scrollTop: $("#credits").offset().top }, 1000);'>Sources and Credits</a>
    				<a class="list-group-item" href="javascript:;" onclick='$("html, body").delay(100).animate({scrollTop: $("#license").offset().top }, 1000);'>License </a>
    				<a class="list-group-item" href="javascript:;" onclick='$("html, body").delay(100).animate({scrollTop: $("#documentation").offset().top }, 1000);'>Online documentation</a>
    			</div>
    		</div>
    	</div> -->
		
		<!-- FOOTER CONTENT BEGIN -->
		<jsp:include page="template/footer.jsp" />
	<!-- 	<div id="copyright" class="container customFont" style="background-color:#FAFAF7;padding:5px;max-width:1130px;border-radius:5px;margin-top:20px;">
			<div id="footer" ng-controller="FooterController" ng-init="InitLoad()" class="ng-scope">
				<footer class="row" style="margin-left: 5%">
		
			<div class="col-xs-12 col-sm-6 col-md-4">
			<h3 class="footer-title">Mentors</h3>
			ngRepeat: mentor in mentors<div class="col-xs-6 col-sm-6 col-md-4 footer-img ng-scope" ng-repeat="mentor in mentors">
				<a style="cursor: pointer;padding:5px;" ng-click="viewMentor(mentor)"><img src="images/footer/team1.jpg" alt="admin admin" title="admin admin" width="60" height="60"></a>
			</div>end ngRepeat: mentor in mentors<div class="col-xs-6 col-sm-6 col-md-4 footer-img ng-scope" ng-repeat="mentor in mentors">
				<a style="cursor: pointer;padding:5px;" ng-click="viewMentor(mentor)"><img src="images/footer/team2.jpg" alt="jhnghjkhmhj gbg" title="jhnghjkhmhj gbg" width="60" height="60"></a>
			</div>end ngRepeat: mentor in mentors<div class="col-xs-6 col-sm-6 col-md-4 footer-img ng-scope" ng-repeat="mentor in mentors">
				<a style="cursor: pointer;padding:5px;" ng-click="viewMentor(mentor)"><img src="images/footer/team3.jpg" alt="surej K " title="surej K " width="60" height="60"></a>
			</div>end ngRepeat: mentor in mentors<div class="col-xs-6 col-sm-6 col-md-4 footer-img ng-scope" ng-repeat="mentor in mentors">
				<a style="cursor: pointer;padding:5px;" ng-click="viewMentor(mentor)"><img src="images/footer/team4.jpg" alt="naimar nn" title="naimar nn" width="60" height="60"></a>
			</div>end ngRepeat: mentor in mentors<div class="col-xs-6 col-sm-6 col-md-4 footer-img ng-scope" ng-repeat="mentor in mentors">
				<a style="cursor: pointer;padding:5px;" ng-click="viewMentor(mentor)"><img src="images/footer/team5.jpg" alt="Ronoldino rm" title="Ronoldino rm" width="60" height="60"></a>
			</div>end ngRepeat: mentor in mentors<div class="col-xs-6 col-sm-6 col-md-4 footer-img ng-scope" ng-repeat="mentor in mentors">
				<a style="cursor: pointer;padding:5px;" ng-click="viewMentor(mentor)"><img src="images/footer/team6.jpg" alt="Prabhat Pathania" title="Prabhat Pathania" width="60" height="60"></a>
			</div>end ngRepeat: mentor in mentors
		</div>

		<div class="col-xs-12 col-sm-6 col-md-4">
			<h3 class="footer-title">Entrepreneurs</h3>
			<div class="col-xs-6 col-sm-6 col-md-4 footer-img">
				<img src="images/footer/team7.jpg" width="60" height="60">
			</div>

			<div class="col-xs-6 col-sm-6 col-md-4 footer-img">
				<img src="images/footer/team8.jpg" width="60" height="60">
			</div>

			<div class="col-xs-6 col-sm-6 col-md-4 footer-img">
				<img src="images/footer/team9.jpg" width="60" height="60">
			</div>

			<div class="col-xs-6 col-sm-6 col-md-4 footer-img">
				<img src="images/footer/team10.jpg" width="60" height="60">
			</div>

			<div class="col-xs-6 col-sm-6 col-md-4 footer-img">
				<img src="images/footer/team11.jpg" width="60" height="60">
			</div>

			<div class="col-xs-6 col-sm-6 col-md-4 footer-img">
				<img src="images/footer/team12.jpg" width="60" height="60">
			</div>
		</div>
		<div class="col-xs-12 col-sm-6 col-md-4">
			<h3 class="footer-title">Partners</h3>
			<div class="col-xs-6 col-sm-6 col-md-4 footer-img">
				<a href="http://www.ge.com"><img src="images/footer/ge.jpg" width="60" height="60"></a>
			</div>

			<div class="col-xs-6 col-sm-6 col-md-4 footer-img">
				<a href="http://www.tcs.com"><img src="images/footer/tcs.jpg" width="60" height="60"></a>
			</div>

			<div class="col-xs-6 col-sm-6 col-md-4 footer-img">
				<a href="http://www.birlasoft.com"><img src="images/footer/birlasoft.jpg" width="60" height="60"></a>
			</div>

			<div class="col-xs-6 col-sm-6 col-md-4 footer-img">
				<a href="http://www.techmahindra.com/pages/default.aspx"><img src="images/footer/techmahindra.jpg" width="60" height="60"></a>
			</div>

		</div>
	</footer>

<br><br>
  
    <p>© 2014 Techpedia Design Team. All Right Reserved.</p>
	 
  </div>
 
</div> -->


    <script>
    	//Start Fix MegaNavbar on scroll page
    	//var navHeight = $('#main_navbar').offset().top;
		var navHeight = 150;
    	FixMegaNavbar(navHeight);
    	$(window).bind('scroll', function() {FixMegaNavbar(navHeight);});

    	function FixMegaNavbar(navHeight) {
    	    if (!$('#main_navbar').hasClass('navbar-fixed-bottom')) {
			//console.log($(window).scrollTop());
			//console.log('navHeight='+navHeight);
			
    	        if ($(window).scrollTop() > navHeight) {
    	            $('#main_navbar').addClass('navbar-fixed-top')
    	            $('body').css({'margin-top': $('#main_navbar').height()+'px'});
    	            if ($('#main_navbar').parent('div').hasClass('container')) $('#main_navbar').children('div').addClass('container').removeClass('container-fluid');
    	            else if ($('#main_navbar').parent('div').hasClass('container-fluid')) $('#main_navbar').children('div').addClass('container-fluid').removeClass('container');
    	        }
    	        else {
    	            $('#main_navbar').removeClass('navbar-fixed-top');
    	            $('#main_navbar').children('div').addClass('container-fluid').removeClass('container');
    	            $('body').css({'margin-top': ''});
    	        }
    	    }
    	}
    	//Start Fix MegaNavbar on scroll page


    	//Start Fix MegaNavbar on scroll page
    	//var tocHeight = $('#Table_of_Contents').offset().top;
		var tocHeight = 150;
    	FixTOC(tocHeight);
    	$(window).bind('scroll', function() {FixTOC(tocHeight);});

    	function FixTOC(tocHeight) {

    	        if ($(window).scrollTop() > (tocHeight-75)) {
                    $('#Table_of_Contents').css({'position':'relative', 'top':(($(window).scrollTop()-tocHeight)+90)+"px", 'right':'auto'});
    	        }
    	        else {
                    $('#Table_of_Contents').css({'position':'relative', 'top':'0px', 'right':'auto'});
    	        }
    	}
    	//Start Fix MegaNavbar on scroll page


    	//Next code used to prevent unexpected menu close when using some components (like accordion, tabs, forms, etc), please add the next JavaScript to your page
    	$( window ).load(function() {
    	    $(document).on('click', '.navbar .dropdown-menu', function(e) {e.stopPropagation();});
    	});

        /*SCROLL PAGE TO TOP*/
        $(document).ready(function() {
            $(".toTop").css("display", "none");

            $(window).scroll(function(){
                if($(window).scrollTop() > 0){$(".toTop").fadeIn("slow");} else {$(".toTop").fadeOut("slow");}
            });

            $(".toTop").click(function(){
                event.preventDefault();
                $("html, body").animate({scrollTop:0},"slow");
            });
        });
		
		function userLogin() {
		jQuery('.dropdown-grid').removeClass('open');
		}

    </script>
    
<!--   <script>
  
  $( document ).ready(function() {
	  
	  setTimeout(function() {
		  alert("page is loading");
		  $("#myFunction").substring(0,10).replace(/"([^"]*)"/g, "...");  
	  }, 1000);
	  });
	   


  </script> -->
</body>

</html>