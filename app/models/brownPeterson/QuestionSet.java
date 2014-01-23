package models.brownPeterson;

import play.db.ebean.*;
import javax.persistence.*;
import java.util.Date;
import play.data.format.Formats;
import java.util.List;

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
		if(startDate.before(expireDate) && (startDate.after(new Date()) || startDate.equals(new Date()))) {
			QuestionSet questionSet = new QuestionSet();
			questionSet.name = name;
			questionSet.noOfTrial = noOfTrial;
			questionSet.startDate = startDate;
			questionSet.expireDate = expireDate;
			return questionSet;
		}
		return null;
	}

	public static List<QuestionSet> findAll(){
		return find.all();
	}

	public static Finder<Long,QuestionSet> find = new Finder(Long.class,QuestionSet.class);
}