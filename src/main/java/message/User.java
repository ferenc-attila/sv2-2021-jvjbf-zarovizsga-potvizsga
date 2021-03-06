package message;

public class User {

    private Long id;
    private String username;

    public User(String username) {
        this.username = username;
    }

    public User(Long id, String username) {
        this(username);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
