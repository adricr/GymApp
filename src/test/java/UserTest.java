import com.ac.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private User user;
    private String username = "ACR";
    private String password = "12345678";
    @BeforeEach
    void setUp() {
        //Initialise User obj
        user = new User(String.format("%07d",0),username, password);
    }
    @Test
    void testGetUsername() {
        assertEquals(username,user.getUsername());
    }

    @Test
    void testGetPassword() {
        assertEquals(password,user.getPassword());
    }

    @Test
    void testSetUsername() {
        user.setUsername("Manue");
        assertEquals("Manue", user.getUsername());
    }

    @Test
    void testSetPassword() {
        user.setPassword("pass");
        assertEquals("pass",user.getPassword());
    }


}