package name.antonsmirnov.firmata.tests;

import name.antonsmirnov.firmata.message.ReportAnalogPinMessage;
import name.antonsmirnov.firmata.serial.SerialException;
import org.junit.Test;

/**
 * Test for ReportAnalogPinMessage
 */
public class ReportAnalogPinMessageTest extends BaseFirmataTest {

    @Test
    public void testWrite() throws SerialException {
        for (int pin = 0; pin < PIN_MAX; pin++) {
            assertOk(pin, true);
            assertOk(pin, false);
        }
    }

    private void assertOk(int pin, boolean enable) throws SerialException {
        serial.clear();
        ReportAnalogPinMessage message = new ReportAnalogPinMessage(pin, enable);
        firmata.send(message);
        byte[] output = serial.getOutputStream().toByteArray();

        assertNotNull(output);
        assertEquals(2, output.length);
    }
}
