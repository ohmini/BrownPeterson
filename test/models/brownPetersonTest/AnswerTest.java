import models.brownPeterson.*;
import models.*;
import play.test.WithApplication;
import org.junit.*;
import static org.junit.Assert.*;
import static play.test.Helpers.*;

public class AnswerTest extends WithApplication {
	@Before
	public void setUp(){
		start(fakeApplication(inMemoryDatabase()));
		
	}
	@Test
	public void shouldCreateAndNotNull(){new Trial().save();
		new Question("hello","world","!!!").save();
		Trial trial = Trial.findById(1);
		Question question = Question.findQuestionById(1);
		Quiz.create(200, 7, trial, question).save();
		Quiz quiz = Quiz.find.byId(new Long(1));
		new User("123","Secret").save();
		User user = User.find.byId("123");

		assertNotNull(new Answer("first word", "second word", "third word", 13.3, 99, user, quiz));
	}

	@Test
	public void attributeShouldBeCorrect(){
		new Question("hello","world","!!!").save();
		Trial trial = Trial.findById(1);
		Question question = Question.findQuestionById(1);
		Quiz.create(200, 7, trial, question).save();
		Quiz quiz = Quiz.find.byId(new Long(1));
		new User("123","Secret").save();
		User user = User.find.byId("123");
		
		Answer answer = new Answer("first word", "second word", "third word", 13.3, 99, user, quiz);

	}
}