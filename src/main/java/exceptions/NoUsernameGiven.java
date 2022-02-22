package exceptions;

public class NoUsernameGiven extends Exception {
    String username;

    public NoUsernameGiven(String username) {

        super("Username field - empty!");
        this.username=username;
    }
}
