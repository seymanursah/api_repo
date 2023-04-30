package practice_dt;

import base_urls.PetStroreBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

public class DTGetPractice02 extends PetStroreBaseUrl {
    /*
    Given
        https://petstore.swagger.io/v2/pet/findByStatus?status=available
    When
        User sends Get request
    Then
        Assert that number of pets whose status is "available" is more than 100
     */

    @Test
    public void petStoreAvailablePets(){
        spec.pathParams("first", "pet", "second", "findByStatus").queryParam("status", "available");

        Response response = given(spec).get("{first}/{second}");
        response.prettyPrint();

        int numOfAvailablePets = response.jsonPath().getList("id").size();
        System.out.println("numOfAvailablePets = " + numOfAvailablePets);

        assertTrue(numOfAvailablePets>100);




















    }




}
