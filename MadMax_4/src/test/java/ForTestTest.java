import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;

class ForTestTest {

    //random values test
    @RepeatedTest(10000)
    void repeatedTest() throws Exception {
      Assertions.assertEquals(false, Methods.isRepeats(ForTest.forTest(1)));
    }
}