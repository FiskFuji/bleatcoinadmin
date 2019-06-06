package manage.bleatcoin.lamb.Admin.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.Objects;

@Document
public class User {
    @Id
    private String id;
    private HashMap<String, Integer> cart;
    private Credentials credentials;

    public User(String id, HashMap<String, Integer> cart, Credentials credentials) {
        this.id = id;
        this.cart = cart;
        this.credentials = credentials;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public HashMap<String, Integer> getCart() {
        return cart;
    }

    public void setCart(HashMap<String, Integer> cart) {
        this.cart = cart;
    }


    public void addToCart(String itemId, int quantity) {
        cart.put(itemId, quantity);
    }

    public void removeFromCart(String itemId){
        cart.remove(itemId);
    }

    public void clearCart(){
        cart.clear();
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getId(), user.getId()) &&
                Objects.equals(getCart(), user.getCart()) &&
                Objects.equals(getCredentials(), user.getCredentials());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCart(), getCredentials());
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", cart=" + cart +
                ", credentials=" + credentials +
                '}';
    }
}
