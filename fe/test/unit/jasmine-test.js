describe("A case of basic functions", function() {
  var name;

  it("sayHello", function() {
    name = "Conan";
    var exp = "Hello Conan";
    expect(exp).toEqual(sayHello(name));
  });
});

describe("Another case of basic functions", function() {
  it("reverse word",function(){
    expect("DCBA").toEqual(reverse("ABCD"));
    expect("Conan").toEqual(reverse("nanoC"));
  });
});

describe("A suite of jasmine's function", function() {
  it("Expectations",function(){
    expect("AAA").toEqual("AAA");
    expect(52.78).toMatch(/\d*.\d\d/);
    expect(null).toBeNull();
    expect("ABCD").toContain("B");
    expect(52,78).toBeLessThan(99);
    expect(52.78).toBeGreaterThan(18);

    var x = true;
    var y;
    expect(x).toBe(true);
    expect(x).toBeDefined();
    expect(y).toBeUndefined();
    expect(x).toBeTruthy();
    expect(!x).toBeFalsy();

    var fun = function() { return a + 1;};
    expect(fun).toThrow();
  });
});

describe("Setup and Teardown",function(){
  var foo;
  beforeEach(function() {
    foo = 0;
    foo += 1;
  });
  afterEach(function() {
    foo = 0;
  });

  it("is just a function, so it can contain any code", function() {
    expect(foo).toEqual(1);
  });

  it("can have more than one expectation", function() {
    expect(foo).toEqual(1);
    expect(true).toEqual(true);
  });
});

xdescribe("Disabling Specs and Suites", function() {
  it("Disabling Specs and Suites",function(){
    expect("AAA").toEqual("AAA");
  });
});

describe("Asynchronous specs", function() {
  var value;
  beforeEach(function(done) {
    setTimeout(function() {
      value = 0;
      done();
    }, 1);
  });
  it("should support async execution of test preparation and expectations", function(done) {
    value++;
    expect(value).toBeGreaterThan(0);
    done();
  });
  describe("long asynchronous specs", function() {
    var originalTimeout;
    beforeEach(function() {
      originalTimeout = jasmine.DEFAULT_TIMEOUT_INTERVAL;
      jasmine.DEFAULT_TIMEOUT_INTERVAL = 1000;
    });

    it("takes a long time", function(done) {
      setTimeout(function() {
        done();
      }, 9000);
    });

    afterEach(function() {
      jasmine.DEFAULT_TIMEOUT_INTERVAL = originalTimeout;
    });
  });
});