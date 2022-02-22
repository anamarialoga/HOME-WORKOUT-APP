package exceptions;

public class UsernameOrPasswordIncorrect extends Exception{
    public UsernameOrPasswordIncorrect(){
        super(String.format("Incorrect username/password!"));
    }
}
