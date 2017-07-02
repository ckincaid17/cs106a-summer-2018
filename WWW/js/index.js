$(document).ready(function(){    
	// Adds an arrow-up / arrow-down icon to open/close collapse panels
	$('.collapse').on('show.bs.collapse', function(){
		$(this).parent().find(".glyphicon-chevron-up").removeClass("glyphicon-chevron-up").addClass("glyphicon-chevron-down");
	}).on('hide.bs.collapse', function(){
		$(this).parent().find(".glyphicon-chevron-down").removeClass("glyphicon-chevron-down").addClass("glyphicon-chevron-up");
	});

	// goes and changes each "moment" element to display how long ago that element's timestamp was.
	$(".moment").each(function(i) {
	    var date = $(this).html();
	    var fromStr = moment(date, "YYYYMMDD").fromNow();
	    $(this).html(fromStr);
	});
});