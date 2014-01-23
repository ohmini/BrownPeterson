import play.test.WithApplication;
import models.brownPeterson.TrigramType;
import static play.test.Helpers.*;
import org.junit.*;
import static org.junit.Assert.*;
import models.brownPeterson.Trial;
import models.brownPeterson.TrigramLanguage;

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
}