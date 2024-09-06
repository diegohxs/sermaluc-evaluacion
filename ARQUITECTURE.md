# Register User Microservice API

## Description

Sermaluc register service it is a microservice in charge of registering new users, having as validations that the email is not repeated and that the password is valid.

## Capabilities

* Business capabilities
    * Register user

## Endpoints

| Endpoints             | Description
|-----------------------|----------------------------------------------------
| POST   /register/user | Process register new user

## Errors

| HTTP Status | message
|-------------|--------------------------
| 403         |  El correo ya se encuentra registrado    
| 403         |  El password no cumple con el formato     


