# Spring Security JWT Demo

Pluralsight tutorial on Spring security with JWT

## How To

 - start the keycloak server. `cd etc` and `docker-compose up -d`
 - wait 2-3 minutes for the server to be up `http://localhost:9999/auth`
 - login is `admin` and `password`. No need to do this.
 - start the spring boot application
 - The default user is `james` and password is `james`.
 - generate a token from the client for james. `cd etc` and `. ./token-for one james`
 - you can use the token in insomnia. It's stored as an env variable so echo it. `echo $TOKEN`
 - The spring boot app connects to the auth server to verify tokens for requests.
 - To check the tokens go to `https://jwt.io/#debugger-io`

## References

 - https://app.pluralsight.com/library/courses/securing-spring-data-rest-apis/table-of-contents
 - https://github.com/jzheaux/resolutions
  
