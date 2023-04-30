package practice_dt;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class DTGetPractice01 extends HerOkuAppBaseUrl {

    /*
        Given
                https://restful-booker.herokuapp.com/booking/43
        When
                I send GET Request to the URL
        Then
                Status code is 200
                        {
                            "firstname": "Josh",
                            "lastname": "Allen",
                            "totalprice": 111,
                            "depositpaid": true,
                            "bookingdates": {
                                "checkin": "2018-01-01",
                                "checkout": "2019-01-01"
                            },
                            "additionalneeds": "super bowls"
                        }
     */


    @Test
    public void get01() throws IOException {

        spec.pathParams("first", "booking", "second", 202);

        //expected data
        BookingDatesPojo bookingDatesPojo= new BookingDatesPojo("2018-01-01", "2019-01-01");

        BookingPojo expectedData= new BookingPojo("John", "Smith", 111, true, bookingDatesPojo, "Breakfast");
        System.out.println("expectedData = " + expectedData);

        Response response= given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        BookingPojo actualData=new ObjectMapper().readValue(response.asString(), BookingPojo.class);
        System.out.println("actualData = " + actualData);

        SoftAssert softAssert= new SoftAssert();
        softAssert.assertEquals(response.getStatusCode(), 200);

        assertEquals(actualData.getFirstname(), expectedData.getFirstname());

        assertEquals(actualData.getLastname(), expectedData.getLastname());
        assertEquals(actualData.getTotalprice(), expectedData.getTotalprice());

        assertEquals(actualData.getDepositpaid(), expectedData.getDepositpaid());

        assertEquals(actualData.getBookingdates().getCheckin(),  bookingDatesPojo.getCheckin());
        assertEquals(actualData.getBookingdates().getCheckout(), bookingDatesPojo.getCheckout());

        assertEquals(actualData.getAdditionalneeds(), expectedData.getAdditionalneeds());

        softAssert.assertAll();



        /*

Hard Assertion-- stops the execution of the remaining codes once the error happens
                 no need to create objects by using hard assert class

Soft Assertion -- you have to create an object by using soft assert class
                  does not stop execution of remaining part of the coding
                  you have to use assertAll() to let java execute the remaining part of assertions.

 */









    }
}
