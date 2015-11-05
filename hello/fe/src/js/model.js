// JavaScript Document
hello = hello || {};
hello.model = hello.model || {};
var m = hello.model;

m.Guest = Backbone.Model.extend({
  initialize: function(){
    this.on("change:visitTime", function(){
      console.log("The visit time of the guest was increased to %d", this.get('visitTime'));
    });
  },
  defaults: {
    nickName: '',
    visitTime: 0,
    feature: [],
    accesses: [],
    greetings: []
  },
  validate: function(attrs){
    if(attrs.nickName == ''){
      return 'The nick name can\'t be empty';
    }
  },
  setNickName: function(nickName){
    this.set('nickName', nickName, {validate: true});
  },
  increaseVisitTime: function(time){
    var t = this.get('visitTime');
    this.set('visitTime', (t + 1));
  }
});

m.Access = Backbone.Model.extend({
  initialize: function(){
    console.log(new Date(this.get('time')));
  },
  defaults: {
    time: Date.now(),
    agent: navigator.userAgent,
  }
});

m.Accesses = Backbone.Collection.extend({model: Access});

hello.model.feature = hello.model.feature || {};
var mf = hello.model.feature;
mf.Gender = Backbone.Model.extend({
  defaults: {
    male: true,
    female: false
  },

  _gender: function(gender, m) {
    if(m ===undefined ){
      return this.get(gender);
    } else {
      this.set(gender, m);
    }
  },
  male: function(m) {
    return this._gender('male', m)
  },
  female: function(m) {
    return this._gender('female', m)
  }
});
