const express = require('express')
const db = require('../db')
const config = require('../config')
const utils= require('../utils')

const router = express.Router()

router.post('/create',(request,response)=>{
    const {title,address,city,state,district,pincode,propertyType,price,PropertyArea,bedrooms,bathrooms,description,userID} = request.body
    console.log("Property Added")
    const statement = `insert into property (title,address,city,state,district,pincode,propertyType,price,PropertyArea,bedrooms,bathrooms,description,userID,status,isDeleted) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)`
    db.pool.execute(
        statement,[title,address,city,state,district,pincode,propertyType,price,PropertyArea,bedrooms,bathrooms,description,userID,"New",0],(error,data)=>
        {
            response.send(utils.createResult(error,data))
        }
    )
})

router.put('/edit',(request,response)=>{
    const {propertyID,title,address,city,state,district,pincode,price,PropertyArea,bedrooms,bathrooms,description} = request.body
    console.log("Property Edited")
    const statement = `update property set title=?,address=?,city=?,state=?,district=?,pincode=?,price=?,PropertyArea=?,bedrooms=?,bathrooms=?,description=? where propertyID=?`
    db.pool.execute(
        statement,[title,address,city,state,district,pincode,price,PropertyArea,bedrooms,bathrooms,description,propertyID],(error,data)=>
        {
            response.send(utils.createResult(error,data))
        }
    )
})

router.post('/search',(request,response)=>{
    const {title} = request.body
    console.log("Property Name Search")
    const statement = `select propertyID,title,address,city,state,district,pincode,price,PropertyArea,bedrooms,bathrooms,description from property where title LIKE '${title}%' `
    db.pool.execute(
        statement,(error,data)=>
        {
            response.send(utils.createResult(error,data))
        }
    )
})
router.post('/id',(request,response)=>{
    const {propertyID} = request.body
    console.log("Property ID Search")
    const statement = `select propertyID,title,address,city,state,propertyType,district,pincode,price,PropertyArea,bedrooms,bathrooms,description,isDeleted  from property where propertyID =? `
    db.pool.execute(
        statement,[propertyID],(error,data)=>
        {
            response.send(utils.createResult(error,data))
        }
    )
})

router.post('/user',(request,response)=>{
    const {userID} = request.body
    console.log("Property User Searching")
    const statement = `select propertyID,title,address,city,state,district,pincode,price,PropertyArea from property where userID =? and isDeleted=0 `
    db.pool.execute(
        statement,[userID],(error,data)=>
        {
            response.send(utils.createResult(error,data))
        }
    )
})

router.delete('/delete',(request,response)=>{
    const {propertyID} = request.body
    console.log("Property Removed")
    const statement = `update property set isDeleted=1 where propertyID=? `
    db.pool.execute(
        statement,[propertyID],(error,data)=>
        {
            response.send(utils.createResult(error,data))
        }
    )
})
router.get('/view',(request,response)=>{
      const statement = `select * from property where isDeleted=0`
      console.log("All Property Viewed")
    db.pool.execute(
        statement,(error,data)=>
        {
            response.send(utils.createResult(error,data))
        }
    )
})

module.exports= router