# Register User Microservice API

## Register User [POST user/register ]

+ Request for Client (application/json)

    + Body

            {
                "name": "Juan2 Rodriguez",
                "email": "corr12sesd2do3es2@gmail.com",
                "password": "1123DieAa@20",
                "phones": [
                            {
                                "number": "1123DieAa@20",
                                "cityCode": "1",
                                "counTrycode": "57"
                             }
                           ]
             }
    + Response
    
              {
                "id": "81f8c795-1174-4107-8026-8e194b1d5e6e",
                "created": "2024-09-06T16:14:23.4118611",
                "modified": "2024-09-06T16:14:23.4118611",
                "lastLogin": "2024-09-06T16:14:23.4118611",
                "token": "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIzOTcwZTAzZi05NjliLTRiZDItYWFlMS0zNmQyODZmMThhODAiLCJzdWIiOiJKdWFuMiBSb2RyaWd1ZXoiLCJpYXQiOjE3MjU2NTcyNjMsImV4cCI6MTcyNTY2MDg2M30.hBA0485GEjAuq98HkCI7sSknJYlwKxYrZ5uGdcm3150",
                "isActive": true
               }
      
    + Response Error
  
              {
                "message": "El correo ya se encuentra registrado"
              }


