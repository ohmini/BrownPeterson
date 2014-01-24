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
	public void retrieveExperimentRunning() {

		ExperimentSchedule.create("Experiment 1", 3, new Date(114,2,10), new Date(114,2,11)).save();
        ExperimentSchedule.create("Experiment 2", 3, new Date(114,2,10), new Date(114,2,11)).save();
        ExperimentSchedule ex1 = ExperimentSchedule.create("Experiment 3", 3, new Date(114,2,22), new Date(114,2,23));
        ExperimentSchedule ex2 = ExperimentSchedule.create("Experiment 4", 3, new Date(114,2,10), new Date(114,2,25));
        ExperimentSchedule.create("Experiment 5", 3, new Date(114,2,10), new Date(114,2,11)).save();

        ex1.startDate = new Date(114,0,22);
        ex1.expireDate = new Date(114,0,25);
        ex1.save();
        ex2.startDate = new Date(114,0,10);
        ex2.expireDate = new Date(114,0,26);
        ex2.save();
		assertEquals(2,ExperimentSchedule.getCurrentWorking().size());
	}

	@Test
	public void retrieveExperimentRunningIsNotNull() {
		assertNotNull(ExperimentSchedule.getCurrentWorking());
	}

	@Test
	public void questionSetShouldCreateAndNotNull(){
		ExperimentSchedule experimentSchedule = new ExperimentSchedule();
		assertNotNull(experimentSchedule);
	}

	@Test
	public void questionSetShouldSetDefaultWhenCreate() {
		ExperimentSchedule experimentSchedule = new ExperimentSchedule();
		assertEquals("Brown Peterson", experimentSchedule.name);
		assertEquals(3, experimentSchedule.noOfTrial);
		assertNull(experimentSchedule.startDate);
		assertNull(experimentSchedule.expireDate);
	}

	@Test
	public void questionSetShouldChangeValueOfTrialBySet(){
		ExperimentSchedule experimentSchedule = new ExperimentSchedule();
		experimentSchedule.setNoOfTrial(5);
		assertEquals(5, experimentSchedule.noOfTrial);
	}
	@Test
	public void questionSetShouldChangeValueOfTrialToTenBySet(){
		ExperimentSchedule experimentSchedule = new ExperimentSchedule();
		experimentSchedule.setNoOfTrial(10);
		assertEquals(10, experimentSchedule.noOfTrial);
	}

	@Test
	public void questionSetShouldChangeNameBySet() {
		ExperimentSchedule experimentSchedule = new ExperimentSchedule();
		experimentSchedule.setName("Project HIP !!!");
		assertEquals("Project HIP !!!", experimentSchedule.name);
	}

	@Test
	public void questionSetShouldBeCreateBySubmit() {
		ExperimentSchedule experimentSchedule = ExperimentSchedule.create("Experiment 1", 3, new Date(114,1,30), new Date(114,1,31));
		assertNotNull(experimentSchedule);
	}

	@Test
	public void questionSetShouldBeModifableWhenSubmit(){
		ExperimentSchedule experimentSchedule = ExperimentSchedule.create("Experiment 1", 3, new Date(114,1,30), new Date(114,1,31));
		assertEquals("Experiment 1", experimentSchedule.name);
		assertEquals(3, experimentSchedule.noOfTrial);
		assertEquals(new Date(114, 1, 30),experimentSchedule.startDate);
		assertEquals(new Date(114, 1, 31),experimentSchedule.expireDate);
	}

	@Test
	public void startDateExperimentScheduleShouldBeforeExpireDateExperimentSchedule() {
		ExperimentSchedule experimentSchedule = ExperimentSchedule.create("Experiment 1", 3, new Date(114,1,30), new Date(114,1,29));
		assertNull(experimentSchedule);
	}

	@Test
	public void startDateofQuesitionSetShouldAfterCurrentDate(){
		ExperimentSchedule experimentSchedule = ExperimentSchedule.create("Experiment 1", 3, new Date(114,0,10), new Date(114,0,11));
		assertNull(experimentSchedule);
	}

	@Test
	public void startDateofQuesitionSetShouldEqualsCurrentDate(){
		ExperimentSchedule experimentSchedule = ExperimentSchedule.create("Experiment 1", 3, new Date(), new Date(114,0,31));
		assertNotNull(experimentSchedule);
	}

    @Test
    public void retrieveAllExperimentSchedule(){

        ExperimentSchedule.create("Experiment 1", 3, new Date(114,2,10), new Date(114,2,11)).save();
        ExperimentSchedule.create("Experiment 2", 3, new Date(114,2,10), new Date(114,2,11)).save();
        ExperimentSchedule.create("Experiment 3", 3, new Date(114,2,10), new Date(114,2,11)).save();
        ExperimentSchedule.create("Experiment 4", 3, new Date(114,2,10), new Date(114,2,11)).save();
        ExperimentSchedule.create("Experiment 5", 3, new Date(114,2,10), new Date(114,2,11)).save();

        List<ExperimentSchedule> questionSetList = ExperimentSchedule.findAll();

        assertEquals(5,questionSetList.size());

    }

    @Test
    public void retrieveExperimentScheduleById() {
    	ExperimentSchedule.create("Experiment 1", 3, new Date(114,2,10), new Date(114,2,11)).save();
        ExperimentSchedule.create("Experiment 2", 3, new Date(114,2,10), new Date(114,2,11)).save();
        ExperimentSchedule.create("Experiment 3", 3, new Date(114,2,10), new Date(114,2,11)).save();
        ExperimentSchedule.create("Experiment 4", 3, new Date(114,2,10), new Date(114,2,11)).save();
        ExperimentSchedule.create("Experiment 5", 3, new Date(114,2,10), new Date(114,2,11)).save();

        assertNotNull(ExperimentSchedule.findById(3));
        assertEquals(3, ExperimentSchedule.findById(3).id);
    }
}