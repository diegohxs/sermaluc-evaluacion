# Register User Microservice API

## Description

Sermaluc register service it is a microservice in charge of registering new users, having as validations that the email is not repeated and that the password is valid.

## Capabilities

* Business capabilities
    * Register user

## Endpoints

| Endpoints             | Description
|-----------------------|----------------------------------------------------
| POST   /user/register | Process register new user

## Errors

| HTTP Status | message
|-------------|--------------------------
| 403         |  The email is already registered   
| 403         |  The password does not comply with the format     


