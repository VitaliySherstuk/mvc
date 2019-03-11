package beans.models;

import org.apache.log4j.Logger;

import java.time.LocalDate;

/**
 * Created with IntelliJ IDEA.
 * User: Dmytro_Babichev
 * Date: 2/1/2016
 * Time: 7:35 PM
 */
public class User {

    private final static Logger LOG = Logger.getLogger(User.class);
    private static final String DEFAULT_ROLE = "ROLE_USER";
    private static final String DELIMETER = ", ";

    private long      id;
    private String    email;
    private String    name;
    private LocalDate birthday;
    private String password;
    private String role;

    public User() {

    }

    public User(long id, String email, String name, LocalDate birthday) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.birthday = birthday;
        this.password = email;
        this.role = DEFAULT_ROLE;
    }

    public User(String email, String name, LocalDate birthday, String role) {
        this.email = email;
        this.name = name;
        this.birthday = birthday;
        this.role = DEFAULT_ROLE;
        if(!role.equals("ROLE_USER")){
            this.role +=  DELIMETER + role;
        }
        this.password = email;
    }

    public User(String email, String name, LocalDate birthday, String password, String role) {
        this.email = email;
        this.name = name;
        this.birthday = birthday;
        this.password = password;
        this.role = DEFAULT_ROLE;
        if(!role.equals("ROLE_USER")){
            this.role +=  DELIMETER + role;
        }

    }

    public User(String email, String name, LocalDate birthday) {
        this(-1, email, name, birthday);
    }

    public User withId(long id) {
        return new User(id, email, name, birthday);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {

        if(!role.equals("ROLE_USER") && this.role==null){
            this.role=DEFAULT_ROLE + DELIMETER + role;
        }
        else if(this.role==null && role.equals("ROLE_USER")){
            this.role=DEFAULT_ROLE;
        }
        else if(!role.equals("ROLE_USER"))
        {
            this.role +=  DELIMETER + role;

        }

    }
    public String getRole() {
        return this.role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        User user = (User) o;

        if (id != user.id)
            return false;
        if (email != null ? !email.equals(user.email) : user.email != null)
            return false;
        if (name != null ? !name.equals(user.name) : user.name != null)
            return false;
        return birthday != null ? birthday.equals(user.birthday) : user.birthday == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
               "id=" + id +
               ", email='" + email + '\'' +
               ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
               ", birthday=" + birthday +
               '}';
    }
}
