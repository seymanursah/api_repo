package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Get05 extends HerOkuAppBaseUrl {

    /*
       Given
           https://restful-booker.herokuapp.com/booking
       When
           User sends get request to the URL
       Then
           Status code is 200
         And
             Among the data there should be someone whose firstname is "John" and lastname is "Smith"
    */


    @Test
    public void get05(){

        //Set the URL
        spec.pathParam("first", "booking").queryParams("firstname", "John",
                "lastname", "Smith");


        //Set the expected data



        //Send the request and get the respond
        Response response = given().spec(spec).when().get("{first}");
        response.prettyPrint();


        //Do assertion
        assertEquals(200, response.statusCode());

        //Among the data there should be someone whose firstname is "John" and lastname is "Smith"

        assertTrue(response.asString().contains("bookingid"));

       //query params da filterlayinca bize bookingid return yapiyorsa, bu deme oluyor ki data icinde adi soyadi john smith olan birisi var en az bir tane




    }




















}
