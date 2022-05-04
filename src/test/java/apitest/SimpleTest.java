package apitest;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static  io.restassured.RestAssured.given;
import  static  org.hamcrest.CoreMatchers.equalTo;

public class SimpleTest {
    public static void main(String[] args){
        String baseUri = "https://jsonplaceholder.typicode.com/";
        //request scope
        RequestSpecification request = given();
        request.baseUri(baseUri);
        request.basePath("/todos");

        //response scope
        final String First_TODO ="/1";
        Response response = request.get(First_TODO); // method get
        response.prettyPrint();
        response.then().body("userId", equalTo((2)));
        response.then().body("id", equalTo((1)));
        response.then().body("title", equalTo("delectus aut autem"));
        response.then().body("complete", equalTo(false));
    }
}
