package beans.daos.db;

import beans.daos.AbstractDAO;
import beans.daos.UserAccountDAO;
import beans.daos.UserDAO;
import beans.models.UserAccount;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository(value = "userAccountDAO")
public class UserAccountDAOImpl extends AbstractDAO implements UserAccountDAO {



    @Override
    public void save(UserAccount userAccount) {
        getCurrentSession().save(userAccount);
    }

    @Override
    public UserAccount getById(long id) {
        return (UserAccount) createBlankCriteria(UserAccount.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }

    @Override
    public void update(UserAccount userAccount) {
        getCurrentSession().update(userAccount);
    }
}
