package design_patterns.facade.controller;

import design_patterns.facade.facade.UserFacade;
import design_patterns.facade.service.UserAccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;

@Controller("/user-account")
public class UserAccountController
{
    private final UserAccountService userAccountService;
    private final UserFacade userFacade;

    public UserAccountController(UserAccountService userAccountService, UserFacade userFacade)
    {
        this.userAccountService = userAccountService;
        this.userFacade = userFacade;
    }

    @PutMapping("/addAccount")
    public boolean addUserAccount() {
        return userFacade.addUserAccount("", "");
    }
}
