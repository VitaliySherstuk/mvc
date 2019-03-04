package beans.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    @Qualifier("daoAuthenticationProvider")
    private DaoAuthenticationProvider daoAuthenticationProvider;

    @Override
    public UserDetails loadUserByUsername(String username) {

        try {
            return daoAuthenticationProvider.getUserCache().getUserFromCache(username);
        } catch (
                NullPointerException e) {
            e.printStackTrace();
        }
        throw new UsernameNotFoundException("can not find user with name " + username);
    }


}
