package models;
import models.brownPeterson.Trial;
import play.db.ebean.*;
import javax.persistence.*;
import java.util.Date;
import play.data.format.Formats;
import java.util.List;
import com.avaje.ebean.*;
import java.util.ArrayList;

@Entity
public class ExperimentSchedule extends Model{
	@Id
	public long id;
	@Column(nullable=false, length=30)
	public String name = "Blank Experiment";
	@Column(nullable=false, length=2)
	public int noOfTrial = 3;
	@Column(nullable=false)
	public Date startDate;
	@Column(nullable=false)
	public Date expireDate;
	public ExperimentType experimentType;
	
	@OneToMany
	public List<Trial> trials = new ArrayList<Trial>();

	public ExperimentSchedule(String name, int noOfTrial, Date startDate, Date expireDate, ExperimentType experimentType) {
		this.name = name;
		this.noOfTrial = noOfTrial;
		this.startDate = startDate;
		this.expireDate = expireDate;
		this.experimentType = experimentType;
	}

	public static List<ExperimentSchedule> getAllWorkingExperiment() {
		List<ExperimentSchedule> experiments = find.where().betweenProperties("startDate", "expireDate", new Date()).findList();
		return experiments;
	}

	public static Finder<Long,ExperimentSchedule> find = new Finder(Long.class,ExperimentSchedule.class);
}