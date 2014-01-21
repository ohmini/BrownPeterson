import play.test.WithApplication;
import org.junit.*;
import static org.junit.Assert.*;
import static play.test.Helpers.*;
import models.brownPeterson.Question;

public class QuestionTest extends WithApplication{
	@Before
	public void setUp(){
		start(fakeApplication(inMemoryDatabase()));
	}

	@Test
	public void createQuestion(){
        Question q = new Question("hello","world","!!!");
        assertNotNull(q);
    }

    @Test
    public void saveAndQuery(){
    	new Question("hello","world","!!!").save();
    	assertEquals(1,Question.find.findRowCount());
    }
    @Test
    public void saveAndQueryFourQuestion(){
    	new Question("hello","world","!!!").save();
    	new Question("hello","world","!!!").save();
    	new Question("hello","world","!!!").save();
    	new Question("hello","world","!!!").save();
    	assertEquals(4,Question.find.findRowCount());

    }

    @Test
    public void recieveQuestionCorrectly(){
    	new Question("hello","world","!!!").save();
    	Question q = Question.find.where().eq("id", new Long(1)).findUnique();
    	assertEquals("hello",q.firstWord);
    	assertEquals("world",q.secondWord);
    	assertEquals("!!!",q.thirdWord);
    }
    
    @Test
    public void recieveQuestionById(){
    	new Question("hello","world","!!!").save();
        Question q = Question.findQuestionById(long(1));
    	assertEquals("hello",q.firstWord);
    	assertEquals("world",q.secondWord);
    	assertEquals("!!!",q.thirdWord);
    }    

}
