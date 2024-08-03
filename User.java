package jdbcloginpage;

import java.sql.Timestamp;

public class User {
private int id;
private String name;
private String email;
private String username;
private String password;
private Timestamp lastlogin;

public User()
{
	
}
public User(int id,String name,String email,String username,String password,Timestamp lastlogin)
{
	this.id=id;
	this.email=email;
	this.name=name;
    this.username = username;
    this.password = password;
    this.lastlogin = lastlogin;	
}
public int getid()
{
	return id;
}
public void setid(int id)
{
	this.id=id;
}
public String getname() {
    return name;
}

public void setname(String name) {
    this.name = name;
}

public String getemail() {
    return email;
}

public void setemail(String email) {
    this.email = email;
}

public String getusername() {
    return username;
}

public void setusername(String username) {
    this.username = username;
}

public String getpassword() {
    return password;
}

public void setpassword(String password) {
    this.password = password;
}

public Timestamp getlastlogin() {
    return lastlogin;
}

public void setLastLogin(Timestamp lastlogin) {
    this.lastlogin = lastlogin;
}
}


