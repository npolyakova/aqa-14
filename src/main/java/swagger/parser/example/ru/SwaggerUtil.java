package swagger.parser.example.ru;

import io.swagger.models.Swagger;
import io.swagger.parser.SwaggerParser;
import io.swagger.util.Json;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SwaggerUtil {

    public static Swagger swagger = new SwaggerParser().read("https://petstore.swagger.io/v2/swagger.json");

    public static void writeJson() throws IOException {
        String jsonString = Json.pretty(swagger);

        File swaggerJsonFile = new File("src/main/resources/swagger.json");
        FileWriter fw = new FileWriter(swaggerJsonFile);
        fw.write(jsonString);
        fw.close();
    }
}
