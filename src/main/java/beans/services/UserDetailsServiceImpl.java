package beans.services;

import beans.models.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final static Logger LOG = Logger.getLogger(UserDetailsServiceImpl.class);

    @Autowired
    private UserService userService;

    @Autowired
    @Qualifier("encoder")
    private PasswordEncoder passwordEncoder;

   /* @Autowired
    @Qualifier("authenticationProvider")
    private DaoAuthenticationProvider daoAuthenticationProvider;*/

    @Override
    public UserDetails loadUserByUsername(String username) {

        try {

            LOG.info("username: " + username);
            User user = userService.getUserByEmail(username);

            LOG.info("USER: " + user);
            LOG.info("USER: " + user.getName());
            LOG.info("EMAIL: " + user.getEmail());
            LOG.info("USER password: " + user.getPassword());
            LOG.info("ROLE: " + user.getRole());

            Set<GrantedAuthority> authorities = new HashSet<>();
            for(String role : user.getRole().split(",")){

                if(role!=null){
                    authorities.add( new SimpleGrantedAuthority(role.trim()));
                }
            }
            UserDetails ud = new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);

            LOG.info("MATCH: " + passwordEncoder.matches(user.getEmail(), user.getPassword()));
            return ud;
        } catch (
                NullPointerException e) {
            LOG.info(e.getMessage());
        }
        throw new UsernameNotFoundException("can not find user with name " + username);
    }


}
