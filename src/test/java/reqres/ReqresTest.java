package reqres;

import config.Settings;
import factory.UsersDataFactory;
import io.restassured.http.ContentType;
import org.aeonbits.owner.ConfigFactory;
import org.junit.Before;
import org.junit.Test;
import pojo.Users;

import java.io.IOException;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ReqresTest {

    @Before
    public void setup(){
        Settings settings = ConfigFactory.create(Settings.class);

        baseURI = settings.baseURI();
    }

    @Test
    public void deleteUsers() throws IOException {
        Users usersRegister = UsersDataFactory.deleteUsers();

        given()
            .contentType(ContentType.JSON)
            .body(usersRegister)
        .when()
            .delete("/delete/719")
        .then()
                .assertThat()
                .statusCode(200)
                .body("message", equalToIgnoringCase("Successfully! Record has been deleted"))
                .log()
            .all();
    }

    @Test
    public void creat() throws IOException {
        Users usersCreat = UsersDataFactory.creatUsers();

        given()
            .contentType(ContentType.JSON)
            .body(usersCreat)
        .when()
            .post("/create")
        .then()
            .assertThat()
            .statusCode(200)
            .body("message", equalToIgnoringCase("Successfully! Record has been added."))
                .log()
                .all();
    }
}
