package models.brownPeterson;

import play.db.ebean.*;
import javax.persistence.*;
import java.util.Date;
import play.data.format.Formats;
import java.util.List;

@Entity
public class ExperimentSchedule extends Model{
	@Id
	public long id;
	public String name;
	public int noOfTrial;
	public Date startDate;
	public Date expireDate;

	public ExperimentSchedule() {
		this.name = "Brown Peterson";
		this.noOfTrial = 3;
	}

	public static List<ExperimentSchedule> getCurrentWorking() {
		List<ExperimentSchedule> experimentScheduleList = findAll();
		return experimentScheduleList;
	}

	public static ExperimentSchedule findById(int id) {
		return find.byId(new Long(id));
	}

	public static ExperimentSchedule create(String name, int noOfTrial, Date startDate, Date expireDate) {
		if(isCorrectDate(startDate, expireDate)) {
			ExperimentSchedule experimentSchedule = new ExperimentSchedule();
			experimentSchedule.name = name;
			experimentSchedule.noOfTrial = noOfTrial;
			experimentSchedule.startDate = startDate;
			experimentSchedule.expireDate = expireDate;
			return experimentSchedule;
		}
		return null;
	}

	private static boolean isCorrectDate(Date startDate, Date expireDate) {
		return (startDate.before(expireDate) && (startDate.after(new Date()) || startDate.equals(new Date())));
	}

	public static List<ExperimentSchedule> findAll(){
		return find.all();
	}

	public static Finder<Long,ExperimentSchedule> find = new Finder(Long.class,ExperimentSchedule.class);
}