import play.GlobalSettings;
import play.Application;
import models.ExperimentSchedule;
import java.util.List;
import com.avaje.ebean.Ebean;
import play.libs.Yaml;

public class Global extends GlobalSettings{
    @Override
    public void onStart(Application app){
        if(ExperimentSchedule.find.findRowCount() == 0 ){
            Ebean.save((List)Yaml.load("initial-data.yml"));
        }
    }
}