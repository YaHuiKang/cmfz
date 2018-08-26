import io.goeasy.GoEasy;
import org.junit.Test;

public class TestGoEasy {
    @Test
    public void goeasyQ(){
        GoEasy goEasy = new GoEasy("http://rest-hangzhou.goeasy.io","BC-1ce8777b150545a5b0cdbf26504aca53");
        String s = "aaaa";
        goEasy.publish("yhzchannel", s);
    }
}
