package models.brownPeterson;

import play.db.ebean.*;
import javax.persistence.*;

@Entity
public class Answer extends Model{
	@Id
	public long id;
	public String firstWord;
	public String secondWord;
	public String thirdWord;
	public double time;
	public int countdownResult;

	public Answer(String firstWord,String secondWord,String thirdWord,double time,int countdownResult){
		this.firstWord = firstWord;
		this.secondWord = secondWord;
		this.thirdWord = thirdWord;
		this.time = time;
		this.countdownResult = countdownResult;
	}
}