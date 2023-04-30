package gmibank_api;

import Utils.AuthenticationGmiBank;
import Utils.ObjectMapperUtils;
import base_urls.GmiBankApiBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.Country;
import pojos.Customer;
import pojos.User;

import java.util.ArrayList;

import static Utils.AuthenticationGmiBank.gmiBankToken;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class GetCustomer extends GmiBankApiBaseUrl {

     /*
     Given
     https://www.gmibank.com/api/tp-customers/110452
     When
   I send GET Request to the URL
Then
   Status code is 200
   And response body is like {
                                     "id": 110452,
                                     "firstName": "Jasmine",
                                     "lastName": "Stehr",
                                     "middleInitial": "V",
                                     "email": "marni.zboncak@yahoo.com",
                                     "mobilePhoneNumber": "463-609-2097",
                                     "phoneNumber": "1-112-497-0270",
                                     "zipCode": "16525",
                                     "address": "14387 Al Ridge5343 Bert Burgs",
                                     "city": "Waltermouth",
                                     "ssn": "761-59-2911",
                                     "createDate": "2021-11-28T21:00:00Z",
                                     "zelleEnrolled": false,
                                     "country": {
                                         "id": 3,
                                         "name": "USA",
                                         "states": null
                                     },
                                     "state": "California",
                                     "user": {
                                         "id": 110016,
                                         "login": "leopoldo.reinger",
                                         "firstName": "Jasmine",
                                         "lastName": "Stehr",
                                         "email": "marni.zboncak@yahoo.com",
                                         "activated": true,
                                         "langKey": "en",
                                         "imageUrl": null,
                                         "resetDate": null
                                     },
                                     "accounts": []
                                 }

   */

    @Test
    public void getCustomerById(){

        //Set the url
        spec.pathParams("first", "api", "second", "tp-customers", "third", 110452);


        //Set the expected data

        
        Country country = new Country( "USA", null);
        User user = new User(110016, "leopoldo.reinger", "Jasmine", "Stehr", "marni.zboncak@yahoo.com", true, "en", null, null);
        ArrayList<Object> accountList = new ArrayList<>();
        Customer expectedData = new Customer(110452, "Jasmine", "Stehr", "V", "marni.zboncak@yahoo.com", "463-609-2097", "1-112-497-0270", "16525", "14387 Al Ridge5343 Bert Burgs", "Waltermouth", "761-59-2911", "2021-11-28T21:00:00Z", false, country, "California", user, accountList);
        System.out.println("expectedData = " + expectedData);


        //Send the request and get the response

        Response response = given(spec).get("{first}/{second}/{third}");
        response.prettyPrint();


        //Do assertion
        Customer actualData = ObjectMapperUtils.convertJsonToJavaObject(response.asString(), Customer.class);
        System.out.println("actualData = " + actualData);


        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getId(), actualData.getId());
        assertEquals(expectedData.getFirstName(), actualData.getFirstName());
        assertEquals(expectedData.getLastName(), actualData.getLastName());
        assertEquals(expectedData.getMiddleInitial(), actualData.getMiddleInitial());
        assertEquals(expectedData.getEmail(), actualData.getEmail());
        assertEquals(expectedData.getMobilePhoneNumber(), actualData.getMobilePhoneNumber());
        assertEquals(expectedData.getPhoneNumber(), actualData.getPhoneNumber());
        assertEquals(expectedData.getZipCode(), actualData.getZipCode());
        assertEquals(expectedData.getAddress(), actualData.getAddress());
        assertEquals(expectedData.getCity(), actualData.getCity());
        assertEquals(expectedData.getSsn(), actualData.getSsn());
        assertEquals(expectedData.getCreateDate(), actualData.getCreateDate());
        assertEquals(expectedData.isZelleEnrolled(), actualData.isZelleEnrolled());












    }



}
