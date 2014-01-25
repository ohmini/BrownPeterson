import play.test.WithApplication;
import static play.test.Helpers.*;
import org.junit.*;
import static org.junit.Assert.*;
import models.brownPeterson.*;
import models.*;
import java.util.Date;

public class TrialTest extends WithApplication {
	@Before
	public void setUp() {
		start(fakeApplication(inMemoryDatabase()));
	}

	@Test
	public void trialShouldCreateAndNotNull(){
		assertNotNull(new Trial());
	}

	@Test
	public void trigramShouldBeWordByDefault() {
		assertEquals(TrigramType.WORD, new Trial().trigramType);
	}
	@Test
	public void trigramShouldBeEnglishByDefault(){
		assertEquals(TrigramLanguage.ENGLISH, new Trial().trigramLanguage);
	}

	@Ignore
	@Test
	public void trialShouldBeCreate() {
		fail();
	}

	@Test
	public void trialShouldBeFindById() {
		new Trial().save();
		assertEquals(1, Trial.findById(1).id);
	}

	@Test
	public void shoudBeFindByTrialInvolvingAndNotNull(){
		Date date = new Date();
		new ExperimentSchedule("Experiment 1", 5, new Date(date.getYear()-1, 0, 1), 
			new Date(date.getYear()+1, 0, 31), ExperimentType.BROWNPETERSON).save();
		ExperimentSchedule ex = ExperimentSchedule.find.byId(new Long(1));
		Trial.create(ex).save();
		Trial.create(ex).save();
		Trial.create(ex).save();

		assertEquals(3, Trial.findInvolving(ex).size());
	}

	@Test
	public void shoudBeFindByTrialInvolvingAndReferCorrectly(){
		Date date = new Date();
		new ExperimentSchedule("Experiment 1", 5, new Date(date.getYear()-1, 0, 1), 
			new Date(date.getYear()+1, 0, 31), ExperimentType.BROWNPETERSON).save();
		ExperimentSchedule ex = ExperimentSchedule.find.byId(new Long(1));
		Trial trial = Trial.create(ex);
		assertEquals(trial.schedule.id, ex.id);
	}

	
}
