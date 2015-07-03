define(function (require) {

	var module = {
        send: function(path, msg, handler) {
            console.log('[API] >>', path, msg);

            var controller = document.querySelector('sn-controller');
            var token      = controller ? controller.sessionCookie : null;

            var done = function(data, status, jqXHR) {
                if(data.error)
                {
                    /*
                     * See ErrorReply (java)
                     */
                    console.log('System Error:', data.message);
                    console.log(data.trace);
                    if(handler.error)
                    {
                        handler.error(data);
                    }
                }
                else
                {
                    handler.success(data);
                }
            };

            var fail = function(data, status, jqXHR) {
                handler.error(data);
            };

            var print = function(data, status, jqXHR) {
            	console.log('[API] <<', status, data);
//                if(data.error && 'Not Authorized' == data.message)
//                {
//                	/*
//                	 * Old session cookie
//                	 */
//                	var controller = document.querySelector('g-app-controller');
//                	controller.logoff();
//                }
            };

            var addAuthorizationHeader = function(jqXHR, settings) {
            	jqXHR.setRequestHeader('X-TheSocialNetwork-Auth-Token', token);
            };
            
            $.ajax({type: "POST", beforeSend: addAuthorizationHeader, url: 'http://127.0.0.1:8080/api' + path, data: msg})
            	.done(done)
                .fail(fail)
                .always(print);
        }
    };

    return module;

});
