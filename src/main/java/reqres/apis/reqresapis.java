package reqres.apis;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class reqresapis {


    public void login(){
        given()
                .body("{\n" +
                        "    \"email\": \"eve.holt@reqres.in\",\n" +
                        "    \"password\": \"cityslicka\"\n" +
                        "}")
        .when().post("https://reqres.in/api/users/2")
                .then().log().all();

    }

    public void registerUser(){
        given().body("{\n" +
                        "    \"email\": \"eve.holt@reqres.in\",\n" +
                        "    \"password\": \"pistol\"\n" +
                        "}")
        .when().post("https://reqres.in/api/register")
        .then().log().all();
    }
    public void deleteUser(){
        given()
        .when().delete("https://reqres.in/api/users/2")
        .then().log().all();
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

    public void singleUserNotFound(){
         given()
        .when()
        .get("https://reqres.in/api/users/23")
        .then().log().all();
    }

    public void getUser(){

        System.out.println( "Hello World!" );
        given()
                .when()
                .get("https://reqres.in/api/user/2").
                then().
                log()
                .all();
    }

    public void singleUser(){
        given()
                .when().get("https://reqres.in/api/userss/2")
                .then().log().all();
    }

    public void listUsers(){
                given()
                .when().get("https://reqres.in/api/users?page=2")
                .then().log().status();
    }

    public void createUser(){
        given().contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"name\": \"Nirbhay Patil\",\n" +
                        "    \"job\": \"Patil\"\n" +
                        "}")
                .when()
                .post("https://reqres.in/api/users")
                .then().log().body();


    }
}
