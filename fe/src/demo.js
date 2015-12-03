// JavaScript Document
var g_en = new m.Greeting('World');
var g_zh = new m.Greeting('世界');
var g_de = new m.Greeting('Welt');
var g_fr = new m.Greeting('Monde');

var gs = new m.Greetings();
gs.add(g_en);
gs.add(g_zh);
gs.add(g_de);
gs.add(g_fr);

var gv = new v.Greetings({el: $('#greetings'), collection: gs})
