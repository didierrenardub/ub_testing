import ar.edu.ub.testing.Discount.CNameableBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CNameableTest
{
    @Test
    public void testConstructorValidStrings()
    {
        for (String valid : CTestCases.kValidStringTestCases)
        {
            CNameableBase nameable = new CNameableBase(valid);
            assertEquals(valid, nameable.name());
        }
    }

    @Test
    public void testConstructorInvalidStrings()
    {
        for (String invalid : CTestCases.kInvalidStringTestCases)
        {
            CNameableBase nameable = new CNameableBase(invalid);
            assertNotEquals(invalid, nameable.name());
        }
    }
}
