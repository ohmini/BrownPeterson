import models.brownPeterson.*;
import models.*;
import play.test.WithApplication;
import org.junit.*;
import static org.junit.Assert.*;
import static play.test.Helpers.*;

@Ignore
public class AnswerTest extends WithApplication {
	@Before
	public void setUp(){
		start(fakeApplication(inMemoryDatabase()));
	}
	@Test
	public void shouldCreateAndNotNull(){
		Answer answer = new Answer("first word", "second word", "third word", 13.3, 99);
		assertNotNull(answer);
	}

	@Test
	public void attributeShouldBeCorrect(){
		new User("123","Secret").save();

		Answer answer = new Answer("first word", "second word", "third word", 13.3, 99);
		assertEquals("first word" , answer.firstWord);
		assertEquals("second word" , answer.secondWord);
		assertEquals("third word" , answer.thirdWord);
		assertEquals(99, answer.countdownResult);
		assertEquals(13.3, answer.time, 0.01);
	}

}