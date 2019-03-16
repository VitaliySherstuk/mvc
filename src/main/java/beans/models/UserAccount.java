package beans.models;

import java.math.BigDecimal;

public class UserAccount {

    private Long id;
    private BigDecimal money;

    public UserAccount() {
    }

    public UserAccount(Long id, BigDecimal money) {
        this.id = id;
        this.money = money;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "id=" + id +
                ", money=" + money +
                '}';
    }
}
