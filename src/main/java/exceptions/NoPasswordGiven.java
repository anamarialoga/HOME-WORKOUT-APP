package exceptions;

public class NoPasswordGiven extends Exception{
    String password;

    public NoPasswordGiven(String password){

        super("Password field - empty!");
        this.password=password;
    }
}
