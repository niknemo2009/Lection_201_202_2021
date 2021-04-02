package Lection260321;

public class User {
   private int id=-1;
    String login;
    String password;
    String telephon;

    public User(String login, String password, String telephon) {
        this.login = login;
        this.password = password;
        this.telephon = telephon;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", telephon='" + telephon + '\'' +
                '\n';
    }

    public void setId(int id) {
        if(this.id==-1){
            this.id=id;
        }else{
            System.out.println("Error with modification primary key !!!");
        }
    }

    public int getId() {
        return id;
    }
}
