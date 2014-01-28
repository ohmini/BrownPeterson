package models;

import models.brownPeterson.Answer;
import java.util.List;
import java.util.ArrayList;
import play.db.ebean.*;
import javax.persistence.*;
@Entity
public class User extends Model{

	@Id
	public String id;
	public String password;
	public UserRole status = UserRole.STUDENT;

	@OneToMany
	List<Answer> answers = new ArrayList<Answer>();
	@OneToMany
	List<TimeLog> timeLogs = new ArrayList<TimeLog>();

	public User(String id,String password){
		this.id = id;
		this.password =password;
	}

	public static List<User> getAllUser(){
		return find.all();
	}

	public static Finder<String,User> find = new Finder(String.class,User.class);
}