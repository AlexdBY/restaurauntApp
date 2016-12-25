package course.domain;

import java.util.List;

/**
 * Created by Alex on 16.12.2016.
 */
public class UserMeals {
    String userName;
    String userPhone;
    String userAddress;
    List<Orders> orders;

    public UserMeals() {};

    public UserMeals(String userName, List<Orders> orders) {
        this.userName = userName;
        this.orders = orders;
    }

    public UserMeals(String userName, String userPhone, String userAddress, List<Orders> orders) {
        this.userName = userName;
        this.userPhone = userPhone;
        this.userAddress = userAddress;
        this.orders = orders;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }
};


