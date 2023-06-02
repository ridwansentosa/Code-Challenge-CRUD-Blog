# API Spec

## Create Post

Request :
- Method : POST
- Endpoint : `/api/v1/posts`
- Header :
    - Content-Type: application/json
    - Accept: application/json
- Body :

```json 
{
    "title" : "string",
    "body" : "string",
    "author" : "string",
}
```

Response :

```json 
{
    "timeStamp": "date",
    "statusCode": "number",
    "message": "string",
    "data": {
        "post": {
            "id": "string",
            "title": "string",
            "body": "string",
            "author": "string",
            "createdAt": "date",
            "updatedAt": "date"
        }
    }
}
```

## List Post

Request :
- Method : GET
- Endpoint : `/api/v1/posts`
- Header :
    - Accept: application/json
- Query Param :
    - pages : number,
    - limit : number,
    - sortBy : string,
    - direction : asc/desc,

Response :

```json 
{
    "timeStamp": "date",
    "statusCode": "number",
    "message": "string",
    "data": {
        "Posts": {
            "result": [
                {
                    "id": "string",
                    "title": "string",
                    "body": "string",
                    "author": "string",
                    "createdAt": "date",
                    "updatedAt": "date"
                }
            ],
            "pages": "number",
            "elements": "number"
        }
    }
}
```

## Get Post By Id

Request :
- Method : GET
- Endpoint : `/api/v1/posts/{id}`
- Header :
    - Accept: application/json

Response :

```json 
"timeStamp": "date",
    "statusCode": "number",
    "message": "string",
    "data": {
        "post": {
            "id": "string",
            "title": "string",
            "body": "string",
            "author": "string",
            "createdAt": "date",
            "updatedAt": "date"
        }
    }
}
```

## Update Post

Request :
- Method : PUT
- Endpoint : `/api/v1/posts/{id}`
- Header :
    - Content-Type: application/json
    - Accept: application/json
- Body :

```json 
{
    "title" : "string",
    "body" : "string",
    "author" : "long",
}
```

Response :

```json 
{
    "timeStamp": "date",
    "statusCode": "number",
    "message": "string"
}
```


## Delete Product

Request :
- Method : DELETE
- Endpoint : `/api/v1/posts/{id}`
- Header :
    - Accept: application/json

Response :

```json 
{
    "timeStamp": "date",
    "statusCode": "number",
    "message": "string"
}
```
