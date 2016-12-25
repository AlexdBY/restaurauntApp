package course.domain;

/**
 * Created by Alex on 12.12.2016.
 */
public class Meal {
    private String photo;
    private String name;
    private int price;
    private String description;

    public Meal(String photo, String name, int price, String description) {
        this.photo = photo;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
