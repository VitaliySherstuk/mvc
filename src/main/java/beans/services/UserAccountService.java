package beans.services;

import beans.models.User;
import beans.models.UserAccount;

import java.math.BigDecimal;

public interface UserAccountService {

    void updateUserAccount(UserAccount userAccount);

    void createUserAccount(UserAccount userAccount);

    UserAccount getById(long id);

}
