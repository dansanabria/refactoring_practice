import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.*;

/**
 * Created by danf15 on 02/08/2015.
 */
public class WebClientTest {
    @Test
    public void testGetContentOk() throws Exception {
        MockHttpURLConnection mockConnection = new MockHttpURLConnection();
        mockConnection.setupGetInputStream(
                new ByteArrayInputStream("You made it work".getBytes())
        );
        MockURL mockURL = new MockURL();
        mockURL.setupOpenConnection(mockConnection);
        WebClient client = new WebClient();
        String result = client.getContent(mockURL);
        assertEquals("You made it work", result);
    }
}