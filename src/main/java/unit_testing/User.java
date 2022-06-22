package unit_testing;

import lombok.Data;

@Data
public class User
{
    protected static final String EMPTY_USERNAME_ERROR = "Username should not be wmpty";
    protected static final String IDENTICAL_USERNAME_ERROR = "New name should be different from old name";

    private String name;

    public void rename(String newName) {
        if (newName == null || newName.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_USERNAME_ERROR);
        }
        if (newName.equals(this.name)) {
            throw new IllegalArgumentException(IDENTICAL_USERNAME_ERROR);
        }
        this.name = newName;
    }

    //createUser

    //deactivateUser
}
