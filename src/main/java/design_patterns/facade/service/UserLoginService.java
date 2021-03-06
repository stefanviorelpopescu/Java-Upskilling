package design_patterns.facade.service;

import design_patterns.facade.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserLoginService
{

    public User loginUser(String username) {
        return new User();
    }

    public boolean logoutUser(String username)
    {
        return false;
    }

    public boolean reactivateUser(String username)
    {
        return true;
    }
}
