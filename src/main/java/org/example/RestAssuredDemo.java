package org.example;

import reqres.apis.reqresapis;

/**
 * Hello world!
 *
 */
public class RestAssuredDemo
{
    public static void main( String[] args )
    {

        reqresapis reqres = new reqresapis();
//      reqres.getUser();
//      reqres.createUser();
//      reqres.listUsers();
//      reqres.singleUser();
        //reqres.singleUserNotFound();
//        reqres.updateUser();
//        reqres.patchUser();
//        reqres.getUser();
        //reqres.deleteUser();
        //reqres.registerUser();
        reqres.login();
        //reqres.getUser();

    }
}
