jQuery('document').ready(function($){
	
	var menuBtn = $('menu-icon'),
	menu = $('.navigation ul');
	
	menuBtn.click(function(){
		menu.addClass('show');
	});
	
	if(menu.hasClass('show')){
		menu.removeClass('show');
	}else{
		menu.addClass('show');
	}
	
});