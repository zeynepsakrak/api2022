import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class BaseUrls {

    public RequestSpecification spec;

    // @Before annotation'ı kullandığımız methodlar her  Test metodondan önce çalıştırılır.
    @Before
    public void setUp(){

        spec = new RequestSpecBuilder().setBaseUri("https://jsonplaceholder.typicode.com").build();

    }




}