package manage.bleatcoin.lamb.Admin.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.Objects;

@Document
public class User {
    @Id
    private String id;
    private Credentials credentials;
	private String coins;

    public User(String id, String coins, Credentials credentials) {
        this.id = id;
		this.coins = coins;
        this.credentials = credentials;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

	public String getCoins() {
		return coins;
	}
	
	public void setCoins(String coins) {
		this.coins = coins;
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
				Objects.equals(getCoins(), user.getCoins()) &&
                Objects.equals(getCredentials(), user.getCredentials());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCoins(), getCredentials());
    }

    @Override
    public String toString() {
        return "User {" +
                "id='" + id + '\'' +
				", coins='" + coins + '\'' +
                ", credentials=" + credentials +
                '}';
    }
}
