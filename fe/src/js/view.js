// JavaScript Document
hello.view = hello.view || {};
var v = hello.view;

v.Greetings = Backbone.View.extend({
  tagName: "div",
  className: "greeting",
  template: _.template($("#greetings-template").html()),

  events: {
    "click": "say"
  },

  initialize: function() {
    this.listenTo(this.collection, "change", this.render);
  },

  render: function(){
    var self = this;
    var output = self.template({'greetings': self.collection.toJSON()});
    self.$el.html(output);
    return self;
  },

  say: function(e){
    alert($(e.target).text())
  }
});