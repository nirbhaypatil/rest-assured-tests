package dataprovider;
import org.testng.annotations.DataProvider;

public class ReqResData {


    @DataProvider(name = "getUserId")
    public Object [][] getUsers() {
        Object [][] users = new Object[3][2];
        users[0] = new Object[] {"1",200};
        users[1] = new Object[] {"2",200};
        users[2] = new Object[] {"10000",404};
        return users;
    }


    @DataProvider(name = "getUserData")
    public Object [][] getUserData() {
        Object [][] users = new Object[2][2];
        users[0] = new Object[] {"User.json",201};
        users[1] = new Object[] {"InvalidUser.json",200};
        return users;
    }

    @DataProvider(name = "getUserIdForDelete")
    public Object [][] getUserIdForDelete() {
        Object [][] users = new Object[2][2];
        users[0] = new Object[] {"1",204};
        users[1] = new Object[] {"2",204};
        return users;
    }

}
