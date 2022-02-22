package exceptions;

public class BlankSpace extends Exception{
    String password;

    public BlankSpace(String password){

        super("Blank Space!");
        this.password=password;
    }
}