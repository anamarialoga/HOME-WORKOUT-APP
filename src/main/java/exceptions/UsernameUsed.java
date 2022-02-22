package exceptions;

public class UsernameUsed extends Exception {

    private String username;

    public UsernameUsed(String username) {

        super(String.format("Username %s already exists!", username));
        this.username = username;

    }

    public String getUsername() {
        return username;
    }
}
