import org.junit.*;
import java.util.Date;
import static org.junit.Assert.*;
import play.test.WithApplication;
import static play.test.Helpers.*;
import models.brownPeterson.*;
import java.util.List;

public class BrownPetersonTest extends WithApplication {
	@Before
	public void setUp() {
		start(fakeApplication(inMemoryDatabase()));
	}

	@Test
	public void retrieveTrialList() {
		new QuestionSet().save();
		QuestionSet q_set = QuestionSet.findById(1);
		assertNotNull(q_set.createTrialList());
	}
}