

var userApi = Vue.resource('/users{/id}');

var app = new Vue({
    el: '#app',

    data: {
        message: [
            {id: 1, text: "qwe"},
            {id: 2, text: "asd"},
            {id: 3, text: "zxc"}
        ]
    }
});

Vue.component('form', {
    props: ['users'],
    data: function () {
        return {
            first_name: '',
            last_name: '',
            id: ''
        }
    },
    methods: {
        save: function () {

            var user = {first_name: this.first_name, last_name: this.last_name};

            userApi.save({}, user)
                .then(r => r.json()
                .then(
                    x => {this.users.push(x);
            last_name = '';
            first_name = '';
        }))

        }
    },
    template: '<div>' +
        '<input type = "text" placeholder="your name" v-model="text">' +
        '<input type = "text" placeholder="your lastname" v-model="text">' +
        '<input type = "button" value ="Save" @click="save">' +
        '</div>'


});

Vue.component('list' , {
    props : ['user','users'],
    template : '<row>' +
        '<form :users="user" :user="user" />'  +
        '</row>'

});
Vue.component('row' , {
    props : [],
    template : ''
});

var app = new Vue({
    el: '#app',
    data : {

    }
});
