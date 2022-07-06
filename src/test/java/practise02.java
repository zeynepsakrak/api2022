import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

public class practise02 extends BaseUrls{
    /*
        1) Create a class and name it as you wish :)
        2) When
             I send a GET Request to https://jsonplaceholder.typicode.com/todos
           Then
             HTTP Status code should be "200"
             And Content type should be in "JSON" format
             And there should be 200 "title"
             And "dignissimos quo nobis earum saepe" should be one of the "title"s
             And 111, 121, and 131 should be among the "id"s
             And 4th title is "et porro tempora"
             And last title is "ipsam aperiam voluptates qui"
    */

    @Test
    public void name() {
        //1. Step: Set the Url
        spec.pathParams("first", "todos");
        //2. Step: Set the expected data
        //3. Step:Send the Request and get the Response
        Response response = given().spec(spec).when().get("/{first}");
        //4. Step:Do Assertion
        response.then().assertThat().statusCode(200).
                contentType(ContentType.JSON).
                body("title",hasSize(200),
                        "title", hasItem("dignissimos quo nobis earum saepe"),
                        "id",hasItems(111,121,131)).
                body("id",hasItem(4),
                        "title",hasItem("et porro tempora")
                ) .body("id",hasItem(200),
                        "title",hasItem("ipsam aperiam voluptates qui"));


    }
}
