package models.brownPeterson;

import play.db.ebean.*;
import javax.persistence.*;

@Entity
public class Question extends Model {
	@Id
	public Long id;
	public String firstWord;
	public String secondWord;
	public String thirdWord;

	public Question (String firstWord, String secondWord,String thirdWord){
		this.firstWord = firstWord;
		this.secondWord = secondWord;
		this.thirdWord = thirdWord;
	}

	public static Finder<Long,Question> find = new Finder(Long.class,Question.class);
}