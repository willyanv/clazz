define(function (require) {

    var $api = require("api");

    var module = {
    	testSession: function(token, handler) {
			$api.send('/validate', {token: token}, {
				success: handler,
				error: handler,
			});
    	},
    };

    return module;
});
