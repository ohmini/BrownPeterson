import org.junit.*;
import java.util.Date;
import static org.junit.Assert.*;
import play.test.WithApplication;
import static play.test.Helpers.*;
import models.brownPeterson.*;
import java.util.List;

public class QuestionSetTest extends WithApplication {
	@Before
	public void setUp() {
		start(fakeApplication(inMemoryDatabase()));
	}

	@Test
	public void questionSetShouldCreateAndNotNull(){
		QuestionSet q_set = new QuestionSet();
		assertNotNull(q_set);
	}

	@Test
	public void questionSetShouldSetDefaultWhenCreate() {
		QuestionSet q_set = new QuestionSet();
		assertEquals("Brown Peterson", q_set.name);
		assertEquals(3, q_set.noOfTrial);
		assertNull(q_set.startDate);
		assertNull(q_set.expireDate);
	}

	@Test
	public void questionSetShouldChangeValueOfTrialBySet(){
		QuestionSet q_set = new QuestionSet();
		q_set.setNoOfTrial(5);
		assertEquals(5, q_set.noOfTrial);
	}
	@Test
	public void questionSetShouldChangeValueOfTrialToTenBySet(){
		QuestionSet q_set = new QuestionSet();
		q_set.setNoOfTrial(10);
		assertEquals(10, q_set.noOfTrial);
	}

	@Test
	public void questionSetShouldChangeNameBySet() {
		QuestionSet q_set = new QuestionSet();
		q_set.setName("Project HIP !!!");
		assertEquals("Project HIP !!!", q_set.name);
	}

	@Test
	public void questionSetShouldBeCreateBySubmit() {
		QuestionSet q_set = QuestionSet.create("Experiment 1", 3, new Date(114,1,30), new Date(114,1,31));
		assertNotNull(q_set);
	}

	@Test
	public void questionSetShouldBeModifableWhenSubmit(){
		QuestionSet q_set = QuestionSet.create("Experiment 1", 3, new Date(114,1,30), new Date(114,1,31));
		assertEquals("Experiment 1", q_set.name);
		assertEquals(3, q_set.noOfTrial);
		assertEquals(new Date(114, 1, 30),q_set.startDate);
		assertEquals(new Date(114, 1, 31),q_set.expireDate);
	}

	@Test
	public void startDateQuestionSetShouldBeforeExpireDateQuestionSet() {
		QuestionSet q_set = QuestionSet.create("Experiment 1", 3, new Date(114,1,30), new Date(114,1,29));
		assertNull(q_set);
	}

	@Test
	public void startDateofQuesitionSetShouldAfterCurrentDate(){
		QuestionSet q_set = QuestionSet.create("Experiment 1", 3, new Date(114,0,10), new Date(114,0,11));
		assertNull(q_set);
	}

	@Test
	public void startDateofQuesitionSetShouldEqualsCurrentDate(){
		QuestionSet q_set = QuestionSet.create("Experiment 1", 3, new Date(), new Date(114,0,31));
		assertNotNull(q_set);
	}

    @Test
    public void retrieveAllQuestionSet(){

        QuestionSet.create("Experiment 1", 3, new Date(114,2,10), new Date(114,2,11)).save();
        QuestionSet.create("Experiment 2", 3, new Date(114,2,10), new Date(114,2,11)).save();
        QuestionSet.create("Experiment 3", 3, new Date(114,2,10), new Date(114,2,11)).save();
        QuestionSet.create("Experiment 4", 3, new Date(114,2,10), new Date(114,2,11)).save();
        QuestionSet.create("Experiment 5", 3, new Date(114,2,10), new Date(114,2,11)).save();

        List<QuestionSet> questionSetList = QuestionSet.findAll();

        assertEquals(5,questionSetList.size());

    }

    @Test
    public void retrieveQuestionSetById() {
    	QuestionSet.create("Experiment 1", 3, new Date(114,2,10), new Date(114,2,11)).save();
        QuestionSet.create("Experiment 2", 3, new Date(114,2,10), new Date(114,2,11)).save();
        QuestionSet.create("Experiment 3", 3, new Date(114,2,10), new Date(114,2,11)).save();
        QuestionSet.create("Experiment 4", 3, new Date(114,2,10), new Date(114,2,11)).save();
        QuestionSet.create("Experiment 5", 3, new Date(114,2,10), new Date(114,2,11)).save();

        assertNotNull(QuestionSet.findById(3));
        assertEquals(3, QuestionSet.findById(3).id);
    }
}