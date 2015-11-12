// models/click.js

var mongoose = require('mongoose');
var Schema = mongoose.Schema;

var ClickSchema = new Schema({
    vocabulary: Number,
    time: Date,
    ip: String,
    agent: String
});

module.exports = mongoose.model('Click', ClickSchema);
