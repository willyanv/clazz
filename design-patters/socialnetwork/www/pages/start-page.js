define(function (require) {

	var $api = require("api");
	
    var module = {
    	posts: [],

		on: function() {
            var success = function(reply){
            	this.posts = reply.posts;
            };
            
            var scope = this;
			$api.send('/timeline', null, {
                success: success.bind(scope)
            });
		},
		
		doPost: function(evt) {
			evt.preventDefault();
			var text = this.text ? this.text.trim() : null;
			if(!text)
			{
				alert("You have to post something");
				return;
			}
			
			this.text = '';

			this.posts.push({text: text});
			this.disabled = true;
			
            var success = function(reply) {
            	var post = reply.post;
            	this.disabled = false;
            	//TODO: update the post attributes
            };

            var error = function(reply) {
            	//TODO: notify the user and mark the post
            	alert("Post Error");
            	this.disabled = false;
            };

            var scope = this;
			$api.send('/post', {text: text}, {
                success: success.bind(scope),
                error: error.bind(scope)
            });
		}
    };
    
    return module;
});

