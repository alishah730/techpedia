jQuery(document).ready(function($) {
	jQuery('#nav-wrap').prepend('<div id="menu-icon">MENU</div>');
	$("#menu-icon").on("click", function() {
		jQuery(".sf-menu").slideToggle();
		jQuery(this).toggleClass("active");
	});
});