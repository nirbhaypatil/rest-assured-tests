package testcases;

import apis.ReqResApi;
import config.Config;
import dataprovider.ReqResData;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import specbuilder.RequestSpecificationBuilder;

/**
 * Get API test for https://reqres.in/.
 */
public class TestReqResAPis {

    @Parameters("env")
    @BeforeClass
    public void setUp(String env){
        RequestSpecificationBuilder.buildRequestSpecification(Config.getUri(env),Config.getBasePath());
    }

    @Test(dataProviderClass =ReqResData.class, dataProvider="getUserId")
    public void verifySingleUserApiStatus(String userId,int statusCode){
        ReqResApi reqResApi = new ReqResApi();
        Response response = reqResApi.getSingleUser(userId);

        //Validate response code is correct
        MatcherAssert.assertThat(response.getStatusCode(), Matchers.equalTo(statusCode));
    }


    @Test(dataProviderClass =ReqResData.class, dataProvider="getUserData")
    public void verifyCreateUserApiStatus(String filepath,int StatusCode){
        ReqResApi reqResApi = new ReqResApi();
        Response response = reqResApi.createUser(filepath);

        //Validate response code is correct
        MatcherAssert.assertThat(response.getStatusCode(), Matchers.equalTo(StatusCode));
    }

    @Test(dataProviderClass =ReqResData.class, dataProvider="getUserIdForDelete")
    public void verifyDeleteUserApiStatus(String userId,int statusCode){
        ReqResApi reqResApi = new ReqResApi();
        Response response = reqResApi.deleteUser(userId);

        //Validate response code is correct
        MatcherAssert.assertThat(response.getStatusCode(), Matchers.equalTo(statusCode));
    }
}
