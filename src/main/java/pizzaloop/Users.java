package pizzaloop;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int user_id;
    private  String name;
    private String telephone;
    private String email;
    private String nic;
    private String password;
    private int user_status;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUser_status() {
        return user_status;
    }

    public void setUser_status(int user_status) {
        this.user_status = user_status;
    }

    @Override
    public String toString() {
        return "Users{" +
                "user_id=" + user_id +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", nic='" + nic + '\'' +
                ", password='" + password + '\'' +
                ", user_status=" + user_status +
                '}';
    }
}
