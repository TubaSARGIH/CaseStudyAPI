import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UserTest {

    @Test(priority=1)
    public void test_createUser()
    {
        given().
                baseUri("https://petstore.swagger.io/v2/").
                when().
                header("Content-Type", "application/json").
                body("{ \"id\": 999 ,  \"username\": \"tuba\"}")
                .post("user")
                .then()
                .assertThat().statusCode(200);
    }

    @Test(priority=2)
    public void test_createUser2()
    {
        given().
                baseUri("https://petstore.swagger.io/v2/").
                when().
                header("Content-Type", "application/json").
                body("{ \"id\": 9999 ,  \"username\": \"tuba2\"}")
                .post("user")
                .then()
                .assertThat().statusCode(200);
    }

    @Test(priority=3)
    public void test_getUser()
    {
        Response getUserResponse = given().baseUri("https://petstore.swagger.io/v2/user/").
                and().
                when().
                get("tuba").
                then().extract().response();

        getUserResponse.then().assertThat().statusCode(200);

    }

    @Test(priority=4)
    public void test_updateUser()
    {
        given().
                baseUri("https://petstore.swagger.io/v2/").
                when().
                header("Content-Type", "application/json").
                body("{ \"id\": 9991 ,  \"username\": \"tuba\"}")
                .put("user/tuba")
                .then()
                .assertThat().statusCode(200);
    }

    @Test(priority=5)
    public void test_deleteUser()
    {
        given().
                baseUri("https://petstore.swagger.io/v2/user/").
                when()
                .delete("tuba")
                .then()
                .assertThat().statusCode(200);
    }


}
