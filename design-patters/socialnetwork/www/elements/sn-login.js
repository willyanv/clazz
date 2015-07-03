define(function (require) {

    var $api = require("api");

    var module = {
        disabled: false,
        message: false,
        messageType: '',

        doLogin: function(evt, detail, sender) {
            evt.preventDefault();
            if(this.username && this.password)
            {
                this.disabled = true;
                this.message = 'Checking username/password. Please wait!';
                this.messageType = 'info';
                var success = function(reply) {
                    if(reply.token)
                    {
                        this.message = "Welcome " + this.username;
                        this.messageType = "success";
                        var controller = document.querySelector('sn-controller');
                        controller.onSessionVerified(reply.token);
                    }
                    else
                    {
                        this.message = "Bad username/password";
                        this.messageType = "warning";
                    }
                    this.disabled = false;
                };

                var error = function(reply) {
                    this.message = "System Error: " + reply.message;
                    this.messageType = "danger";
                    this.disabled = false;
                };

                var scope = this;

                $api.send('/auth', { username: this.username, password: this.password},{
                    success: success.bind(scope),
                    error: error.bind(scope)
                });
            }
            else
            {
                this.message = "Please provide a username and password";
                this.messageType = 'warning';
            }
        }
    };

    return module;

});
