package models;

import java.util.List;
import play.db.ebean.*;
import javax.persistence.*;
@Entity
public class User extends Model{

	@Id
	public String id;
	public String password;
	public UserRole status = UserRole.STUDENT;

	public User(String id,String password){
		this.id = id;
		this.password =password;
	}

	public static List<User> getAllUser(){
		return find.all();
	}

	public static Finder<String,User> find = new Finder(String.class,User.class);
}