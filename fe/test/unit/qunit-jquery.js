
QUnit.test( "click test", function( assert ) {
  assert.expect( 1 );
 
  var $body = $( "body" );
  $body.on( "click", function() {
    assert.ok( true, "body was clicked!" );
  });
  $body.trigger( "click" );
});

QUnit.test( "asynchronous test: async input focus", function( assert ) {
  var done = assert.async();
  var input = $( "#test-input" );
  setTimeout(function() {
    assert.equal( document.activeElement, input[0], "Input was focused" );
    done();
  }, 2000);
});

