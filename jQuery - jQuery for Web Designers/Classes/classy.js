$(function(){
'use strict';

	$('body').addClass('js');
	
//	This works alongside the styling that switches the js-warning <p> to display:none 
//  when the js class is present for the "This page uses JavaScript" warning.

	var $circles = $('#circles');
	
	$circles.find(':nth-child(2)')
			.addClass('selected');
			
	$circles.find(':nth-child(4)')
			.removeClass('selected');
			
	$circles.find(':nth-child(1)')
			.toggleClass('selected');
			
	if ($('body').hasClass('js')) {
		console.log("body has the js class"");
	}
});