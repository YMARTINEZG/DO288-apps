var restify = require('restify');
var path = require('path');

var controller = require('./controllers/items');

var db = require('./models/db');
var model = require('./models/items');

model.connect(db.params, function(err) {
    if (err) throw err;
});

const server = restify.createServer(
{
   name: 'my-api',
   version: '1.0.0' 
}) 
server.use(restify.plugins.queryParser())
server.use(restify.plugins.bodyParser());

 server.get('/hello/:name', (req, res, next) => {
  res.send({ message: `Hello, ${req.params.name}!` });
  return next();
});

server.get('/api/status', (req, res, next) => {
  res.send({ status: 'ok' });
  return next();
});

controller.context(server, '/todo/api', model); 

server.get('/*', restify.plugins.serveStatic({
    'directory': Path2D.join(__dirname,public),
    'default': 'index.html'
}));

var port = process.env.PORT || 8080;
server.listen(port, function (err) {
    if (err)
        console.error(err);
    else
        console.log('App is ready at : ' + port);
});


/* 
process.on('uncaughtException', function (err) {
    console.error(JSON.parse(JSON.stringify(err, ['stack', 'message', 'inner'], 2)))
});
*/    

