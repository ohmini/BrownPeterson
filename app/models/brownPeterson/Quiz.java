package models.brownPeterson;

import javax.persistence.*;
import play.db.ebean.*;

@Entity
public class Quiz extends Model{
	@Id
	public long id;
}