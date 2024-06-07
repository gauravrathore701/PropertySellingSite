const express = require("express");


const app = express();

app.get("/", (req,res)=>{
    res.send("Application Starts")
})

app.listen(process.env.PORT, (req,res) => {
    // To Run Program use : nodemon --env-file=../.env server.js
    console.log("Listening on Port: " + process.env.PORT)
})
