/**
 * effe - Custom JS.
 * Copyright (c) 2011 92five.net
 * @version 1.0
 *
 * http://92five.net
 */
 $(document).ready(function(){
							
$('.single_image').hover(
function(){
$(this).stop().fadeTo('slow',0.4);
},
function(){
$(this).stop().fadeTo('slow',1);
});
						
							
							
//This is basic - uses default settings
$("a.single_image").fancybox();
//Using custom settings
$("a#inline").fancybox({
					   'hideOnContentClick': true
					   });
//Apply fancybox to multiple items
$("a.group").fancybox({
		'transitionIn'	:	'elastic',
		'transitionOut'	:	'elastic',
		'speedIn'		:	600, 
		'speedOut'		:	200, 
		'overlayShow'	:	false
		});
 
 //Animated scrolling		   
      $('a[href*=#]').click(function() {
        if (location.pathname.replace(/^\//,'') == this.pathname.replace(/^\//,'')
        && location.hostname == this.hostname) {
          var $target = $(this.hash);
          $target = $target.length && $target
          || $('[name=' + this.hash.slice(1) +']');
          if ($target.length) {
            var targetOffset = $target.offset().top;
            $('html,body')
            .animate({scrollTop: targetOffset}, 1000);
           return false;
          }
        }
      });
	  $('ul#filter a').click(function() {
		$(this).css('outline','none');
		$('ul#filter .current').removeClass('current');
		$(this).parent().addClass('current');
		
		var filterVal = $(this).text().toLowerCase().replace(' ','-');
				
		if(filterVal == 'all') {
			$('ul#portfolio li.hidden').fadeIn('slow').removeClass('hidden');
		} else {
			$('ul#portfolio li').each(function() {
				if(!$(this).hasClass(filterVal)) {
					$(this).fadeOut('normal').addClass('hidden');
				} else {
					$(this).fadeIn('slow').removeClass('hidden');
				}
			});
		}
		return false;
	});
//some quicksand js
	  	var items = $('#stage li'),
		itemsByTags = {};
// Looping though all the li items:
	items.each(function(i){
		var elem = $(this),
			tags = elem.data('tags').split(',');
// Adding a data-id attribute. Required by the Quicksand plugin:
		elem.attr('data-id',i);
		$.each(tags,function(key,value){
// Removing extra whitespace:
			value = $.trim(value);
			if(!(value in itemsByTags)){
// Create an empty array to hold this item:
				itemsByTags[value] = [];
			}
// Each item is added to one array per tag:
			itemsByTags[value].push(elem);
		});
	});
// Creating the "Everything" option in the menu:
	createList('Everything',items);
// Looping though the arrays in itemsByTags:
	$.each(itemsByTags,function(k,v){
		createList(k,v);
	});
	$('#filter a').live('click',function(e){
		var link = $(this);
		
		link.addClass('active').siblings().removeClass('active');
// Using the Quicksand plugin to animate the li items.
// It uses data('list') defined by our createList function:
$('#stage').quicksand(link.data('list').find('li'));
		e.preventDefault();
	});
$('#filter a:first').click();
function createList(text,items){
// This is a helper function that takes the
// text of a menu button and array of li items
// Creating an empty unordered list:
		var ul = $('<ul>',{'class':'hidden'});
		$.each(items,function(){
// Creating a copy of each li item
// and adding it to the list:
			$(this).clone().appendTo(ul);
		});
		ul.appendTo('#container');
// Creating a menu item. The unordered list is added
// as a data parameter (available via .data('list'):
		var a = $('<a>',{
			html: text,
			href:'#',
			data: {list:ul}
		}).appendTo('#filter');
	}
 });