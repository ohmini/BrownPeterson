package models.brownPeterson;

import play.db.ebean.*;
import javax.persistence.*;

@Entity
public class Trial extends Model{
	@Id
	public long id;
}