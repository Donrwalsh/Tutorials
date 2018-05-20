$(function() {
    'use strict';
	
	var $grid = $('#bab_grid'),
		$lists = $grid.find('li');
		
//	$lists.css('background', '#600');
//	$lists.animate({width : '-=100'}, 2000);
//	$lists.fadeOut();
//	$lists.fadeIn('slow');
	
	$lists.css('background', '#600')
		.animate({width : '-=100'}, 2000)
		.fadeOut()
		.fadeIn('slow');
});