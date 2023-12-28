package specbuilder;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpecificationBuilder {

    private static RequestSpecification requestSpecification =null;

    public static void buildRequestSpecification(String uri, String basepath) {
        RequestSpecBuilder specBuilder = new RequestSpecBuilder();
        specBuilder.setContentType(ContentType.JSON);
        specBuilder.setBaseUri(uri);
        specBuilder.setBasePath(basepath);
        requestSpecification = specBuilder.build();
    }

    public static RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }

}
