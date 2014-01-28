import org.junit.*;
import java.util.Date;
import static org.junit.Assert.*;
import play.test.WithApplication;
import static play.test.Helpers.*;
import models.brownPeterson.*;
import models.*;
import java.util.List;
import com.avaje.ebean.*;
import play.libs.Yaml;

public class BrownPetersonTest extends WithApplication {
	@Before
	public void setUp() {
		start(fakeApplication(inMemoryDatabase()));
		Ebean.save((List) Yaml.load("test-data.yml"));

	}

	@Test
	public void experimentSchedule_Should_Have_1_row(){

		assertEquals(1, ExperimentSchedule.find.findRowCount());
	}
	@Test
	public void questions_should_have_3_Rows(){
		assertEquals(3, Question.find.findRowCount());
	}
	@Test
	public void users_should_have_1_Rows(){
		assertEquals(1, User.find.findRowCount());
	}

	@Ignore
	public void trials_should_have_1_row(){
		assertEquals(1, Trial.find.findRowCount());
	}

	@Test
	public void rounds_should_have_3_round(){
		assertEquals(3, Round.find.findRowCount());
	}
}