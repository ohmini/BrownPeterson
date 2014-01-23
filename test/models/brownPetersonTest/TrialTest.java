import play.test.WithApplication;
import static play.test.Helpers.*;
import org.junit.*;
import static org.junit.Assert.*;
import models.brownPeterson.*;


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

	@Test
	public void trialShouldBeCreate() {
		new QuestionSet().save();
		QuestionSet q_set = QuestionSet.findById(1);
		Trial trial = Trial.create(q_set);
		assertEquals(q_set.id, trial.questionSet.id);
	}
}