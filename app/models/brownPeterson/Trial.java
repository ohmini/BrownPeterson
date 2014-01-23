package models.brownPeterson;

import play.db.ebean.*;
import javax.persistence.*;

@Entity
public class Trial extends Model{
	@Id
	public long id;
	public TrigramType trigramType = TrigramType.WORD;
	public TrigramLanguage trigramLanguage = TrigramLanguage.ENGLISH;

	@ManyToOne
	public QuestionSet questionSet;

	public static Trial create(QuestionSet questionSet){
		Trial trial = new Trial();
		trial.questionSet = questionSet;
		return trial;
	}
}