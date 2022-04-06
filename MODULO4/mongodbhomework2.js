use vem_ser

//USERS

db.createCollection("users")

db.users.insertMany(
[
    {
        "id_user" : 1,
        "name" : "admin",
        "email" : "admin",
        "password" : "$2a$12$sTeLTyUMe0kdZVV8/u8.2.XvCwNJjW9RvQLwpY2EGNDxF93Y/BXq2", 
        "type" : "false",
        "document" : "73775006036",
    },
    {
        "id_user" : 2,
        "name" : "liane",
        "email" : "liane@gmail.com",
        "password" : "$2a$12$/LF56HvufCT8nWshxZxe1.e47PwrXUTD57YncMTOMsEc1QbInekUu", 
        "type" : "false",
        "document" : "23156682047",    
    }
]  
)



//REQUESTS

db.createCollection("requests")

db.requests.insertMany(
[
    {
        "id_user" : 1,
        "id_request" : 1,
        "title" : "Vakinha1",
        "request_description" : "Ajude os necessitados1",
        "goal" : 40000,
        "reached_value" : 4,
        "status_request" : "true",
    },
    {
        "id_user" : 2,
        "id_request" : 2,
        "title" : "Vakinha2",
        "request_description" : "Ajude os necessitados2",
        "goal" : 20000,
        "reached_value" : 20000,
        "status_request" : "false",
    },
    {
        "id_user" : 2,
        "id_request" : 3,
        "title" : "Vakinha3",
        "request_description" : "Ajude os necessitados3",
        "goal" : 30000,
        "reached_value" : 30000,
        "status_request" : "false",
    },
]  
)


//FIND

db.users.find({
    "email" : "admin",
})

db.requests.find({
    "id_user" : 2
})


//FIND SPECIFIC
db.users.find({
    email : /gmail/
})


//FIND REQUESTS UNDER 30000
db.requests.find({
    "goal" : {
        $lt : 30000
    }
})


//UPDATE
db.users.updateOne(
    {id_user : 2}, 
    {
        $set: { "name" : "lianenova"}
    }
)


//DELETE
db.users.deleteOne({ 
    "name" : "lianenova" 
})


//AGGREGATE
db.users.aggregate ([{
    $lookup: {
        from: "requests",
        localField: "id_user",
        foreignField: "id_user",
        as: "users and requests"
    }
}])
