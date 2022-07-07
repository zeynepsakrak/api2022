package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;


public class practise03 extends HerOkuAppBaseUrl {


     /*
        Given
            https://restful-booker.herokuapp.com/booking/5
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is “application/json”
        And
            Response body should be like;
            {
                "firstname": "Mary",
                "lastname": "Jackson",
                "totalprice": 111,
                "depositpaid": false,
                "bookingdates": { "checkin": "2017-05-23",
                                  "checkout":"2019-07-02" }
            }
     */


    @Test
    public void get01(){

        //1. Step: Set the Url

        //https://restful-booker.herokuapp.com/booking?firstname=Aaron&lastname=Chen
        spec.pathParams("first","booking","second", 6);
        //2. Step: Set the expected data

        //3. Step: Send the request and get the response


        Response response=given().
                spec(spec).
                when().
                get("{first}/{second}");
        response.prettyPrint();

        //4. Step: Do Assertion

        response.then().assertThat().statusCode(200).
                contentType("application/json").
                body("firstname", equalTo("Mark"),
                        "lastname",equalTo( "Jones"),
                        "totalprice",equalTo(863),
                        "depositpaid",equalTo(true),"bookingdates.checkin",equalTo("2017-02-26"),
                        "bookingdates.checkout",equalTo( "2022-05-16"));
    }



}