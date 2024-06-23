const express = require("express");
const cors = require('cors')
const config=require('./config')
const PORT=4000;

const app = express();
const PropertyRouter = require('./routes/property')
const UserRouter = require('./routes/user')
app.use(express.json())
app.use(cors())

app.use('/property',PropertyRouter)
app.use('/user',UserRouter)

app.get("/", (req,res)=>{
    res.send("Application Starts")
})

app.listen(config.PORT, (req,res) => {
    // To Run Program use : nodemon --env-file=../.env server.js
    console.log("Listening on Port: "+config.PORT)
})
