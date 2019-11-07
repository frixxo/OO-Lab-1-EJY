import static org.junit.jupiter.api.Assertions.assertEquals;
import org.testng.annotations.Test;

public class TestGallardoSpoiler{

    @Test
    public void TestGallardoSpoilerDown() {
        LamborghiniGallardo x = new LamborghiniGallardo();
        double d=x.speedFactor();
        assertEquals(3.2,d,0);
    }

    @Test
    public void TestGallardoSpoilerUp(){
        LamborghiniGallardo x = new LamborghiniGallardo();
        x.SetSpoilerUp(true);
        double d=x.speedFactor();
        assertEquals((float)2.88,(float)d,0);
    }
}