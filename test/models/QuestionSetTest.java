import org.junit.*;
import static org.junit.Assert.*;
import play.test.WithApplication;
import static play.test.Helpers.*;
import models.brownPeterson.QuestionSet;

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
}