package model;

public class Trainer {
    private String username;
    private String password;

    public Trainer() {}

    public Trainer(String username, String password) {
        this.username=username;
        this.password=password;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public boolean equals(Object o) {
        if(this==o) return true;
        if(o==null || getClass()!=o.getClass()) return false;

        Trainer trainer=(Trainer) o;

        if(!username.equals(trainer.username)) return false;
        if(!password.equals(trainer.password)) return false;

        return true;
    }



    @Override
    public String toString() {
        return "Trainer -> " + username + password;
    }
}
