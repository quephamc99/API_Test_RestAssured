package apitest;

import com.google.gson.Gson;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsStringIgnoringCase;
import  static  org.hamcrest.CoreMatchers.equalTo;

public class PutMethod {
    public static void main(String[] args){
        String baseUri = "https://jsonplaceholder.typicode.com/";
        // form up requests object and header
        RequestSpecification request = given();
        request.baseUri(baseUri);
        request.header(new Header("Content-type", "application/json; charset-UTF-8"));


        // construct body
        PostBody postBody = new PostBody();
        postBody.setUserId(3);
        postBody.setId("200");
        postBody.setTitle("put method title");
        postBody.setBody("set method body");

        Gson gson = new Gson();
        String postBodyStr = gson.toJson(postBody);

        // send request
        final int TARGET_POST_NUM =1;
        Response response = request.body(postBodyStr).put("/posts/".concat(String.valueOf(TARGET_POST_NUM)));
        response.prettyPrint();
        //response.then().body("id", equalTo(postBody.getId()));

    }
}
