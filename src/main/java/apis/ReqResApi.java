package apis;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import specbuilder.RequestSpecificationBuilder;

import java.io.File;

import static io.restassured.RestAssured.given;

public class ReqResApi {

    public void login(){
        given()
                .body("{\n" +
                        "    \"email\": \"eve.holt@reqres.in\",\n" +
                        "    \"password\": \"cityslicka\"\n" +
                        "}")
        .when().post("https://reqres.in/api/users/2")
                .then().assertThat().statusCode(200).log().all();

    }

    public void registerUser(){
        given().body("{\n" +
                        "    \"email\": \"eve.holt@reqres.in\",\n" +
                        "    \"password\": \"pistol\"\n" +
                        "}")
        .when().post("https://reqres.in/api/register")
        .then().log().all();
    }
    public Response deleteUser(String id){

        RequestSpecification spec = RequestSpecificationBuilder.getRequestSpecification();
        return given(spec)
                .pathParam("id",id)
                .delete("/{id}")
                .then()
                .extract()
                .response();
    }

    public void patchUser(){
        given()
        .body("{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"zion resident\"\n" +
                "}")
                .when().patch("https://reqres.in/api/users/2")
                .then().log().all();

    }

    public void updateUser(){
        given().body("{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"zion resident\"\n" +
                "}")
        .when().put("https://reqres.in/api/users/2")
                .then().log().all();
    }
    public Response createUser(String filepath){
        String base = System.getProperty("user.dir");
        String filePath = base + "\\src\\main\\resources\\"+filepath;
        File fileUserData = new File(filePath);
        RequestSpecification spec =  RequestSpecificationBuilder.getRequestSpecification();

        return given(spec)
                .body(fileUserData)
                .post()
                .then()
                .extract()
                .response();
    }
    public Response getSingleUser(String id){

        RequestSpecification spec =  RequestSpecificationBuilder.getRequestSpecification();
        return given(spec)
                .pathParam("id",id)
                .get("/{id}")
                .then()
                .extract()
                .response();
    }

    public Response listUsers(String page){
       return given()
             .when()
             .get("https://reqres.in/api/users?page=2")
             .then()
             .extract()
             .response();
    }


}
