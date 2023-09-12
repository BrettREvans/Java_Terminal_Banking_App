package p0tests;

import com.revature.project.zero.data.UserDataManager;
import com.revature.project.zero.elements.User;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

public class UserDataManagerTests {

    @Test
    public void TestGetAllUsersMethodAndUseCountMethodToEnsureNoDuplicatesOrMissingUsers() {
        UserDataManager userDataManager = new UserDataManager();
        ArrayList<User> userList = userDataManager.getAll();
        Assertions.assertEquals(6, userList.size());
    }

    @Test
    public void TestGetUserByIdReturnsTheCorrectUserUserIdTwoShouldReturnUserNamedjjj() {
        UserDataManager userDataManager = new UserDataManager();
        User jjj = userDataManager.getById(2);
        Assertions.assertEquals("jjj", jjj.getUsername());
    }

    @Test
    public void TestGetUserByIdReturnsNullIfIdIsZero() {
        UserDataManager userDataManager = new UserDataManager();
        User user = userDataManager.getById(0);
        Assertions.assertEquals(null, user.getUsername());
    }
}
