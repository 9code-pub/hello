// JavaScript Document
hello = hello || {};
hello.control = hello.control || {};
var c = hello.control;
c.Gender = (function() {
  var self = this;
  var male = true;
  var female = false;
  var isMale = function(m) {
    if(m ===undefined ){
      return self.male;
    } else {
      self.male = m;
    }
  };
  var isFemale = function(m) {
    if(m ===undefined ){
      return self.female;
    } else {
      self.female = m;
    }
  };
  return {
    male: isMale,
    female: isFemale
  };
}());