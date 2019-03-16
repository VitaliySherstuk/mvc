package beans.daos;

import beans.models.UserAccount;

public interface UserAccountDAO {

    void save(UserAccount userAccount);

    UserAccount getById(long id);

    void update(UserAccount userAccount);
}
