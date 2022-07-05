import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;


import static io.restassured.RestAssured.*;

public class practise01 {
    @Test
    public void name() {
        // https://restful-booker.herokuapp.com/booking/17379 url'ine bir GET request gonderdigimizde donen Response'un,
        String url = "https://restful-booker.herokuapp.com/booking/17";
        Response response= given().when().get(url);
        //        status code'unun 200,
        //        ve content type'inin "application/json"; charset=utf-8,
        //        ve Server isimli Header'in degerinin Cowboy,
        //        ve status Line'in HTTP/1.1 200 OK
        response.then().assertThat().
                statusCode(200).
                contentType("application/json; charset=utf-8").
                statusLine("HTTP/1.1 200 OK").header("Server","Cowboy");
        //        ve response suresinin 5 sn'den kisa oldugunu manuel olarak test ediniz.
        Assert.assertTrue(response.getTime()<5000);
    }



}
