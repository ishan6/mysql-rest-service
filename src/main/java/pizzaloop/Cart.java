package pizzaloop;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Cart {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "user_id")
    private int userid;
    @Column(name = "pizza_id")
    private int pizza_id;
    @Column(name = "pizzaname")
    private  String pizzaname;
    @Column(name = "size")
    private  String size;
    @Column(name = "description")
    private String description;
    @Column(name = "item")
    private int item;
    @Column(name = "total")
    private Double total;
    @Column(name = "img_url")
    private String img_url;
    @Column(name = "telephone")
    private String telephone;
    @Column(name = "address")
    private String address;
    @Column(name = "cart_status")
    private int cartstatus;
    @Column(name = "paymentMethod")
    private String paymentMethod;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getPizza_id() {
        return pizza_id;
    }

    public void setPizza_id(int pizza_id) {
        this.pizza_id = pizza_id;
    }

    public String getPizzaname() {
        return pizzaname;
    }

    public void setPizzaname(String pizzaname) {
        this.pizzaname = pizzaname;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCart_status() {
        return cartstatus;
    }

    public void setCart_status(int cart_status) {
        this.cartstatus = cart_status;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", userid=" + userid +
                ", pizza_id=" + pizza_id +
                ", pizzaname='" + pizzaname + '\'' +
                ", size='" + size + '\'' +
                ", description='" + description + '\'' +
                ", item=" + item +
                ", total=" + total +
                ", img_url='" + img_url + '\'' +
                ", telephone='" + telephone + '\'' +
                ", address='" + address + '\'' +
                ", cartstatus=" + cartstatus +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }
}
