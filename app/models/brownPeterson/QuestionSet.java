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
}