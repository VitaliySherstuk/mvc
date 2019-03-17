package beans.services;

import beans.daos.UserAccountDAO;
import beans.models.UserAccount;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userAccountServiceImpl")
@Transactional
public class UserAccountServiceImpl implements UserAccountService{

    private final static Logger LOG = Logger.getLogger(UserAccountServiceImpl.class);

    @Autowired
    @Qualifier("userAccountDAO")
    UserAccountDAO userAccountDAO;

    @Override
    public void updateUserAccount(UserAccount userAccount){
        userAccountDAO.update(userAccount);
        if(userAccount.getMoney().doubleValue()<0){
            throw new RuntimeException("not money");
        }
    }

    @Override
    public void createUserAccount(UserAccount userAccount) {
        userAccountDAO.save(userAccount);
    }

    @Override
    public UserAccount getById(long id) {
        return userAccountDAO.getById(id);
    }
}
