post /users 
body (json):
{
    "user":String,
    "username":String,
    "password":String
}


post /tasks 
headers: username, password 
body (json):
{
    "username":String,
    "description":String,
    "title":String(50),
    "priority": String,
    "startAt":YYYY-MM-DDThh:mm:ss,
    "endAt":YYYY-MM-DDThh:mm:ss
} 
(the start date shold be less than the endDate, 
the endDate shold be bigger than startDate, 
the title should have maximum of 50 characteres) 

put /tasks 
headers: username, password 
body (json):
{
    "username":String,
    "description":String,
    "title":String(50),
    "priority": String,
    "startAt":YYYY-MM-DDThh:mm:ss,
    "endAt":YYYY-MM-DDThh:mm:ss
} 
(you should only change the current user tasks)

get /tasks
headers: username, password  
(this route will return the tasks of current user) 
