import org.junit.*;
import java.util.Date;
import static org.junit.Assert.*;
import play.test.WithApplication;
import static play.test.Helpers.*;
import models.brownPeterson.*;
import java.util.List;
import models.*;

public class ExperimentScheduleTest extends WithApplication {
	
	@Before
	public void setUp() {
		start(fakeApplication(inMemoryDatabase()));
	}

	@Test
	public void experimentScheduleShouldBeCreateCorrectlyHasNoOfTrial() {
		Date date = new Date();
		ExperimentSchedule experimentSchedule = new ExperimentSchedule("Experiment 1", 5, new Date(date.getYear()+1, 0, 1), new Date(date.getYear()+1, 0, 31), ExperimentType.BROWNPETERSON);
		
		assertEquals("Experiment 1", experimentSchedule.name);
		assertEquals(5, experimentSchedule.noOfTrial);
		assertEquals(new Date(date.getYear()+1, 0, 1), experimentSchedule.startDate);
		assertEquals(new Date(date.getYear()+1, 0, 31), experimentSchedule.expireDate);
		assertEquals(ExperimentType.BROWNPETERSON, experimentSchedule.experimentType);
	}

	@Test
	public void experimentScheduleShouldBeNotNull() {
		assertNotNull(new ExperimentSchedule());
	}
}