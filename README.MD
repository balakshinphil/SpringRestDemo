# Spring REST Demo Application Docs

## Configuration
* Default port: 8000
* H2 console address: /h2
* H2 login: admin
* H2 password: 

## Endpoints
***
* ```POST /api/person```  
— Add new Person instance  
— Receives JSON object with Person object in request's body:  
```json
{
    "name": "<String>",
    "age": "<Integer>",
    "sex": "<Boolean>"
}
 ```
— Returns JSON object with ID:  
```json
{
  "id": "<Long>"
}
```
— Returns 409 status code if Person with given name already exists

* ```POST /api/person/{id}```  
— Update existed Person instance  
— Receives JSON object with Person object in request's body and ID in request's path:  
```json
{
    "name": "<String>",
    "age": "<Integer>",
    "sex": "<Boolean>"
}
 ```
— Returns 404 status code if instance with given ID not found  

* ```GET /api/person/{id}```  
— Receives ID in request's path   
— Returns JSON with Person data:
```json
{
    "name": "<String>",
    "age": "<Integer>",
    "sex": "<String>(Male/Female)"
}
```
— Returns 404 status code if instance with given ID not found  
  

* ```GET /api/persons```  
— Receives nothing  
— Returns List of Person data nodes:
```json
[
    {
      "name": "<String>",
      "age": "<Integer>",
      "sex": "<String>(Male/Female)"
    }, 
    {
      "name": "<String>",
      "age": "<Integer>",
      "sex": "<String>(Male/Female)"
    }
]
```

* ```DELETE /api/person/{id}```  
— Receives ID in request's path   
— Returns 404 status code if instance with given ID not found  