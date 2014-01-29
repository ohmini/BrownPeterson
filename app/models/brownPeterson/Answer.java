package models.brownPeterson;
import models.*;
import play.db.ebean.*;
import javax.persistence.*;

@Entity
public class Answer extends Model{
	@Id
	public long id;
	@Column(length=20)
	public String firstWord;
	@Column(length=20)
	public String secondWord;
	@Column(length=20)
	public String thirdWord;
	public double usedTime;
	@Column(length=3)
	public int countdownResult;

	@ManyToOne
	public User user;
	@ManyToOne
	public Quiz quiz;

	public Answer(String firstWord,String secondWord,String thirdWord,double usedTime,int countdownResult, User user, Quiz quiz){
		this.firstWord = firstWord;
		this.secondWord = secondWord;
		this.thirdWord = thirdWord;
		this.usedTime = usedTime;
		this.countdownResult = countdownResult;
		this.user = user;
		this.quiz = quiz;
	}

	public static Finder<Long, Answer> find = new Finder(Long.class, Answer.class);

}