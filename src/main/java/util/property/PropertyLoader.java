package util.property;

/**
 * @deprecated As of release 2.0, replaced by{@link net.itarray.automotion.tools.property.PropertyLoader}
 */
@Deprecated
public class PropertyLoader {

    private final net.itarray.automotion.tools.property.PropertyLoader delegatee;

    public PropertyLoader(String propertyPath) {
        delegatee = new net.itarray.automotion.tools.property.PropertyLoader(propertyPath);
    }

    public String loadProperty(String name) {
        return delegatee.loadProperty(name);
    }
}