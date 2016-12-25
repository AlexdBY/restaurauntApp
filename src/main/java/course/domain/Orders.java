package course.domain;

import javax.persistence.*;

/**
 * Created by Alex on 13.12.2016.
 */
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "OrderID")
    private long mealId;

    @Column(name = "User")
    private String user;

    @Column(name = "mealName")
    private String mealName;

    @Column(name = "price")
    private int price;

    @Column(name = "description")
    private String description;

    public Orders() {}
    public Orders(String user, String mealName, int price, String description) {
        this.user = user;
        this.mealName = mealName;
        this.price = price;
        this.description = description;
    }

    public long getMealId() {
        return mealId;
    }

    public void setMealId(long mealId) {
        this.mealId = mealId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
