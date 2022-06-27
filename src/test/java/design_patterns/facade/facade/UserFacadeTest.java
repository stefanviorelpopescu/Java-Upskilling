package design_patterns.facade.facade;

import design_patterns.facade.model.User;
import design_patterns.facade.model.UserStatus;
import design_patterns.facade.service.UserAccountService;
import design_patterns.facade.service.UserLoginService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static design_patterns.facade.facade.UserMother.getUserWithAccounts;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

//@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
class UserFacadeTest
{
    private static final String USERNAME = "test_username";

    @Mock
    UserLoginService userLoginService;
    @Mock
    UserAccountService userAccountService;

    @InjectMocks
    UserFacade userFacade;

//    @BeforeAll
//    public void setUp() {
//        userLoginService = mock(UserLoginService.class);
//        userAccountService = mock(UserAccountService.class);
//        userFacade = new UserFacade(userLoginService, userAccountService);
//    }

    @Test
    public void deactivateUser() {
        //given
        int noOfAccounts = 3;
        User userWithThreeAccounts = getUserWithAccounts(USERNAME, noOfAccounts);
        when(userLoginService.loginUser(eq(USERNAME))).thenReturn(userWithThreeAccounts);
        when(userAccountService.removeAccount(eq(userWithThreeAccounts), anyLong())).thenReturn(true);

        //when
        User actualUser = userFacade.deactivateUser(USERNAME);

        //then
        assertEquals(UserStatus.DEACTIVATED, actualUser.getStatus(), "User status should be DEACTIVATED");
        userWithThreeAccounts.getAccounts().forEach(account ->
                verify(userAccountService, times(1)).removeAccount(eq(userWithThreeAccounts), eq(account.getId())));
    }

}