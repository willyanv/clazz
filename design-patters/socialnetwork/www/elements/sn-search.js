define(function (require) {

    var module = {
    	doSearch: function(evt, detail, sender) {
        	evt.preventDefault();
        	window.location.hash = '/query/' + encodeURIComponent(this.query);
        },
    };
    
    return module;
});
