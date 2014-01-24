package models.brownPeterson;

import play.db.ebean.*;
import javax.persistence.*;
import models.*;

@Entity
public class Trial extends Model{
	@Id
	public long id;
	public TrigramType trigramType = TrigramType.WORD;
	public TrigramLanguage trigramLanguage = TrigramLanguage.ENGLISH;

	@ManyToOne
	public ExperimentSchedule experimentSchedule;

	public static Trial create(ExperimentSchedule experimentSchedule){
		Trial trial = new Trial();
		trial.experimentSchedule = experimentSchedule;
		return trial;
	}

	public static Trial findById(int id) {
		return find.byId(new Long(id));
	}

	public static Finder<Long, Trial> find = new Finder(Long.class, Trial.class);
}