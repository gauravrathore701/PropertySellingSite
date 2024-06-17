const express = require("express");
const cors = require('cors')
const PORT=4000;

const app = express();
const PropertyRouter = require('./routes/property')
app.use(express.json())
app.use(cors())

app.use('/property',PropertyRouter)

app.get("/", (req,res)=>{
    res.send("Application Starts")
})

app.listen(PORT, (req,res) => {
    // To Run Program use : nodemon --env-file=../.env server.js
    console.log("Listening on Port: "+PORT)
})
