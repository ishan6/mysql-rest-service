package pizzaloop;

import javax.persistence.*;

@Entity
public class PizzaDetails {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "pizza_id")
    private Integer pizzaId;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private Double price;
    @Column(name = "medium_price")
    private Double medium_price;
    @Column(name = "large_price")
    private Double large_price;
    @Column(name = "image_url")
    private String imageUrl;

    public Double getMedium_price() {
        return medium_price;
    }

    public void setMedium_price(Double medium_price) {
        this.medium_price = medium_price;
    }

    public Double getLiarge_price() {
        return large_price;
    }

    public void setLiarge_price(Double liarge_price) {
        this.large_price = liarge_price;
    }

    public Integer getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(Integer pizzaId) {
        this.pizzaId = pizzaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
