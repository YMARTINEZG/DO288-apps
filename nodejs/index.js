const express = require('express')
const app = express()
const PORT = process.env.SERVER_PORT || 5000;
const HOST = process.env.SERVER_HOST || 'local';
app.get('/', (req,res) => {
    res.send({'message':'Hello world Nodejs'})
})
app.get('/q/health', (req,res) => {
 res.json({
        message: "Application is healthy!",
        port: PORT,
        host: HOST
    });
})
app.listen(PORT, function () {
  console.log('Example app listening on port ${PORT}!');
});