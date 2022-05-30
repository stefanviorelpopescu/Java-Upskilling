package design_patterns.facade.controller;

import design_patterns.facade.facade.UserFacade;
import design_patterns.facade.service.UserLoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller("/user")
public class UserLoginController
{
    private final UserLoginService userLoginService;
    private final UserFacade userFacade;

    public UserLoginController(UserLoginService userLoginService, UserFacade userFacade)
    {
        this.userLoginService = userLoginService;
        this.userFacade = userFacade;
    }

    @PostMapping("/login")
    public boolean loginUser(String username) {
        return userLoginService.loginUser(username);
    }

    @PostMapping("/logout")
    public boolean logoutUser(String username) {
        return userLoginService.logoutUser(username);
    }

    @PutMapping("/deactivate")
    public boolean deactivateUser(String username) {
        return userFacade.deactivatetUser(username);
    }

    @PutMapping("reactivate")
    public boolean reactivateUser(String username) {
        return userLoginService.reactivateUser(username);
    }
}
