import play.test.WithApplication;
import static play.test.Helpers.*;
import org.junit.*;
import static org.junit.Assert.*;
import models.brownPeterson.Trial;

public class TrialTest extends WithApplication {
	@Before
	public void setUp() {
		start(fakeApplication(inMemoryDatabase()));
	}

	@Test
	public void trialShouldCreateAndNotNull(){
		assertNotNull(new Trial());
	}
}