package models.brownPeterson;

import play.db.ebean.*;
import javax.persistence.*;
import java.util.Date;
import play.data.format.Formats;

@Entity
public class QuestionSet extends Model{
	@Id
	public long id;
	public String name;
	public int noOfTrial;
	public Date startDate;
	public Date expireDate;

	public QuestionSet() {
		this.name = "Brown Peterson";
		this.noOfTrial = 3;
	}

	public static QuestionSet create(String name, int noOfTrial, Date startDate, Date expireDate) {
		QuestionSet questionSet = new QuestionSet();
		questionSet.name = name;
		questionSet.noOfTrial = noOfTrial;
		questionSet.startDate = startDate;
		questionSet.expireDate = expireDate;
		return questionSet;
	}
}