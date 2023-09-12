package p0tests;

import com.revature.project.zero.tools.ConnectionFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class getConnectionTest {


    @Test
    public void test_The_getConnection_Method_Does_Not_Throw_An_Exception() {
        Assertions.assertDoesNotThrow( ConnectionFactory :: getConnection );
    }



}
