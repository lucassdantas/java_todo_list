package br.com.lucasdantas.todolist.user;

public class UserModel {
    private String username;
    private String name;
    private String password;

    public void setUserName(String username){
        this.username = username;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getUserName(){
        return this.username;
    }
    public String getName(){
        return this.name;
    }
    public String getPassword(){
        return this.password;
    }
}
