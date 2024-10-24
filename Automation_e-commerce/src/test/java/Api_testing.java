import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
//import org.junit.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;



public class Api_testing {

    @Test
    public void getListOfUsers() {
        given().
                when().
                get("https://reqres.in/api/users").
                then().
                assertThat().
                statusCode(200).
                body("data", not(empty())); // Check if 'data' field is not empty
    }

    @Test
    public void getUserById() {
        given().
                when().
                get("https://reqres.in/api/users/2").
                then().
                assertThat().
                statusCode(200).
                body("data.id", equalTo(2));
    }

    @Test
    public void createUser() {
        String userPayload = "{ \"name\": \"John\", \"job\": \"leader\" }";

        given().
                header("Content-Type", "application/json").
                body(userPayload).
                when().
                post("https://reqres.in/api/users").
                then().
                assertThat().
                statusCode(201).
                body("name", equalTo("John"));
    }

    @Test
    public void updateUser() {
        String userPayload = "{ \"name\": \"Morpheus\", \"job\": \"zion resident\" }";

        given().
                header("Content-Type", "application/json").
                body(userPayload).
                when().
                put("https://reqres.in/api/users/2").
                then().
                assertThat().
                statusCode(200).
                body("job", equalTo("zion resident"));
    }

    @Test
    public void deleteUser() {
        given().
                when().
                delete("https://reqres.in/api/users/2").
                then().
                assertThat().
                statusCode(204);
    }

    @Test
    public void getUserById_SchemaValidation() {
        given().
                when().
                get("https://reqres.in/api/users/2").
                then().
                assertThat().
                statusCode(200).
                body(matchesJsonSchemaInClasspath("userSchema.json")); // Reference the schema file
    }

    @DataProvider(name = "userData")
    public Object[][] getDataFromJson() throws IOException {
        return new ObjectMapper().readValue(new File("src/test/resources/data.json"), Object[][].class);
    }

    @Test(dataProvider = "userData")
    public void createUserWithData(String name, String job) {
        String payload = String.format("{ \"name\": \"%s\", \"job\": \"%s\" }", name, job);

        given().
                header("Content-Type", "application/json").
                body(payload).
                when().
                post("https://reqres.in/api/users").
                then().
                assertThat().
                statusCode(201).
                body("name", equalTo(name));
    }

}
