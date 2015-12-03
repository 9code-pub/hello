// server.js

// BASE SETUP
// =============================================================================

var mongoose   = require('mongoose');
mongoose.connect('mongodb://localhost:11817/hello');


// call the packages we need
var express    = require('express');        // call express
var app        = express();                 // define our app using express
var bodyParser = require('body-parser');

var Click      = require('./models/click');


// configure app to use bodyParser()
// this will let us get the data from a POST
app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());

var port = process.env.PORT || 31880;        // set our port

// ROUTES FOR OUR API
// =============================================================================
var router = express.Router();              // get an instance of the express Router

// middleware to use for all requests
router.use(function(req, res, next) {
    // do logging
    console.log('Something is happening.');
    next(); // make sure we go to the next routes and don't stop here
});

// test route to make sure everything is working (accessed at GET http://localhost:31880/api)
router.get('/', function(req, res) {
    res.json({ message: 'hooray! welcome to our api!' });   
});

// more routes for our API will happen here
router.route('/clicks')

    // create a click (accessed at POST http://localhost:31880/api/clicks)
    .post(function(req, res) {
        
        var click = new Click();      // create a new instance of the Click model
        click.vocabulary = req.body.vocabulary;  // set the clicks vocabulary (comes from the request)
        click.ip = req.ip;
        click.time = new Date();
        click.agent = req.get('User-Agent');
        
        // save the click and check for errors
        click.save(function(err) {
            if (err)
                res.send(err);
            res.json({ message: 'Click created!' });
        });
        
    })

    // get all the clicks (accessed at GET http://localhost:31880/api/clicks)
    .get(function(req, res) {
        Click.find(function(err, clicks) {
            if (err)
                res.send(err);

            res.json(clicks);
        });
    });

// REGISTER OUR ROUTES -------------------------------
// all of our routes will be prefixed with /api
app.use('/api', router);

// START THE SERVER
// =============================================================================
app.listen(port);
console.log('Magic happens on port ' + port);

