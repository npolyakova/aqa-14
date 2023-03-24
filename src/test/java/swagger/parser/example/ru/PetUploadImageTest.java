package swagger.parser.example.ru;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static swagger.parser.example.ru.SwaggerUtil.writeJson;

public class PetUploadImageTest {

    @BeforeAll
    public static void getApiData() throws IOException {
        writeJson();
    }

    @BeforeEach
    public void setBaseUri() {
        RestAssured.baseURI = "https://" + SwaggerUtil.swagger.getHost() + SwaggerUtil.swagger.getBasePath();
    }

    @Test
    public void shouldUploadImage() {
        System.out.println(SwaggerUtil.swagger
                .getPath("/pet")
                .getPost()
                .getParameters()
                .get(0)
                .getName()
        );

        RequestSpecification request = RestAssured.given();
        request
                .log().uri()
                .contentType("multipart/form-data")
                .post("/pet/{petId}/uploadImage", 1)
                .then()
                .log().body()
                .statusCode(200);

    }
}
