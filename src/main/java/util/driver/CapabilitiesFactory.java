package util.driver;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

/**
 * @deprecated As of release 2.0, replaced by{@link net.itarray.automotion.tools.driver.CapabilitiesFactory}
 */
@Deprecated
public class CapabilitiesFactory {

    private static DesiredCapabilities capabilities = new DesiredCapabilities();

    public static DesiredCapabilities getCapabilities() {
        return net.itarray.automotion.tools.driver.CapabilitiesFactory.getCapabilities();
    }

    public static DesiredCapabilities updateCapabilities(DesiredCapabilities desiredCapabilities, Map<String, Object> mapCapabilities) {
        return net.itarray.automotion.tools.driver.CapabilitiesFactory.updateCapabilities(desiredCapabilities, mapCapabilities);
    }
}
