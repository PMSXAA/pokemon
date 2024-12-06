package pokemon.entity;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RequestHistoryTest {
	
	@Test
	void EntityTest() {
		RequestHistory requestHistory = new RequestHistory("127.0.0.0", new Date(), "NAME", 0L, "pikachu", "pikachu");
		requestHistory.setIpOrigin("127.0.0.0");
		requestHistory.setDateRequest(new Date());
		requestHistory.setMethod("NAME");
		requestHistory.setTimeRequest(0L);
		requestHistory.setRequest("pikachu");
		requestHistory.setResponse("pikachu");
		
		Assertions.assertEquals("pikachu",requestHistory.getRequest());
		
	}

}
