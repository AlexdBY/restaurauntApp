package course.domain;

import javax.persistence.*;

/**
 * Created by Alex on 12.12.2016.
 */
@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MealID")
    private long mealId;

    @Column(name = "photo")
    private String photo;

    @Column(name = "mealName")
    private String mealName;

    @Column(name = "price")
    private int price;

    @Column(name = "description")
    private String description;

    public Menu(){}
    public Menu(String photo, String mealName, int price, String description) {
        this.photo = photo;
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
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
