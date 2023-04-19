## Hello!

This is Spring boot web api with an endpoint to convert markup to html.

Steps to run and test the application. 

1. Download the project and **run mvn spring-boot:run** through the command line from the project folder. 
2. Above step runs the application in port 8080
3. Now, send the post request to http://localhost:8080/convert  (see the request sample)
    
    {
        "markdown" : "# header1"
    }
4. Vola, you should get the html as the response.