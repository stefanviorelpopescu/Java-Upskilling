package unit_testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserTest
{
    private static final String DEFAULT_USERNAME = "user";
    private User user;

    @BeforeEach
    public void resetUser() {
        user = new User();
        user.setName(DEFAULT_USERNAME);
    }

    @Test
    public void renameSuccessfulWithDifferentName() {
        //given
        String newName = DEFAULT_USERNAME + "a";

        //when
        user.rename(newName);

        //then
        assertEquals(newName, user.getName(), "User should have been renamed when the new name is different from the old one");
    }

    @Test
    public void throwExceptionForIdenticalUsername() {
        //given
        String newName = DEFAULT_USERNAME;

        //when
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> user.rename(newName));

        //then
        assertEquals(User.IDENTICAL_USERNAME_ERROR, exception.getMessage());
    }

    @Test
    public void throwExceptionForNullOrEmptyUsername() {
        //given
        String newName = "";

        //when
        Exception emptyUsernameException = assertThrows(IllegalArgumentException.class,
                () -> user.rename(newName));
        Exception nullUsernameException = assertThrows(IllegalArgumentException.class,
                () -> user.rename(null));

        //then
        assertEquals(User.EMPTY_USERNAME_ERROR, emptyUsernameException.getMessage());
        assertEquals(User.EMPTY_USERNAME_ERROR, nullUsernameException.getMessage());
    }

    //create cu user null
    //create user empty
    //create ok
    //rename user empty
    //rename user null
    //rename ok
    //deactivate user ok
    //deactivate already deactivated user fails
}