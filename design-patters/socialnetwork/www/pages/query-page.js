define(function (require) {

	var $api = require("api");
	
    var module = {
    	documents: [],

		queryChanged: function(previous, value) {

			var success = function(reply) {
            	this.documents = reply.documents;
            };

            var scope = this;
			$api.send('/search', {query: this.query}, {
                success: success.bind(scope)
            });
		},
    };
    
    return module;
});

