package apitest;

import com.google.gson.Gson;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsStringIgnoringCase;
import  static  org.hamcrest.CoreMatchers.equalTo;

public class PostMethod {
    public static void main(String[] args){
        String baseUri = "https://jsonplaceholder.typicode.com/";

        //request scope
        RequestSpecification request = given();
        request.baseUri(baseUri);
        //content-type -> header
        request.header(new Header("Content-type", "application/json; charset-UTF-8"));

        // Gson
        Gson gson = new Gson();
        PostBody postBody = new PostBody();
        postBody.setUserId(1);
        postBody.setId("222");
        postBody.setTitle("title");
        postBody.setBody("body");
        //send request
        Response response = request.body(gson.toJson(postBody)).post("/posts");
        response.prettyPrint();

        // verify the status code
        response.then().statusCode(equalTo(201));
        response.then().statusLine(containsStringIgnoringCase("201 Created"));
        response.then().body("userId", equalTo(1));
        response.then().body("id", equalTo("101"));
        response.then().body("title", equalTo("title"));

        // just test commit in IntellJ Terminal

    }
}
