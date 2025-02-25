public class Users {
    private String name;
    private String email;

    public Users(String name, String email){
        this.name = name;
        this.email = email;
    }
    public void setName(String Newname){
        this.name = Newname;
    }
    public String getName(){
        return this.name;
    }
    public void setEmail(String newEmail){
        this.email = newEmail;
    }
    public String getEmail(){
        return this.email;
    }

}
