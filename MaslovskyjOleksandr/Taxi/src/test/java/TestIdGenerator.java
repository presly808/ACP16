import org.junit.Assert;
import org.junit.Test;
import utils.IdGenerator;


import java.util.UUID;

public class TestIdGenerator {

    @Test
    public void testIdGeneratorMethod(){
        UUID first = IdGenerator.generateId();
        UUID second = IdGenerator.generateId();
        Assert.assertTrue(first != second);
    }
}
