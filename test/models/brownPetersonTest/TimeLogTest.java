import models.*;
import models.brownPeterson.*;
import org.junit.*;
import static org.junit.Assert.*;
import play.test.WithApplication;
import static play.test.Helpers.*;
import java.util.List;

public class TimeLogTest extends WithApplication{
	@Before
	public void setUp(){
		start(fakeApplication(inMemoryDatabase()));

	}
}