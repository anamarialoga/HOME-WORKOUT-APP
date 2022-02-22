package model;
import java.security.NoSuchAlgorithmException;

public class PremiumName {

    private String name;
    public PremiumName() {}

    public PremiumName(String name){
        this.name=name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public boolean equals(Object o) {
        if(this==o) return true;
        if(o==null || getClass()!=o.getClass())
            return false;

        PremiumName client=(PremiumName) o;

        if(!name.equals(client.name))
            return false;


        return true;
    }
    @Override
    public String toString() {
        return "Premium Customer -> " + name;
    }
}
