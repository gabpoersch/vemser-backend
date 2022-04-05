use vem_ser

db.createCollection("vakinha")

db.vakinha.insertMany(
[
    {
        "id_user" : 1,
        "name" : "admin",
        "email" : admin",
        "password" : "$2a$12$sTeLTyUMe0kdZVV8/u8.2.XvCwNJjW9RvQLwpY2EGNDxF93Y/BXq2", 
        "type" : "false",
        "document" : "73775006036"
    },
    {
        "id_user" : 2,
        "name" : "liane",
        "email" : "liane@gmail.com",
        "password" : "$2a$12$/LF56HvufCT8nWshxZxe1.e47PwrXUTD57YncMTOMsEc1QbInekUu", 
        "type" : "false",
        "document" : "23156682047"
    },
]  
)

db.vakinha.find({
    "email" : "admin",
})

db.vakinha.deleteOne({ 
    "name" : "liane" 
})