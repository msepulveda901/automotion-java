package rectangles;

import net.itarray.automotion.internal.ResponsiveUIValidatorBase;
import net.itarray.automotion.validation.ResponsiveUIValidator;
import net.itarray.automotion.validation.UIElementValidator;
import net.itarray.automotion.validation.UISnapshot;
import net.itarray.automotion.validation.Units;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;

import static org.assertj.core.api.Assertions.assertThat;
import static rectangles.DummyWebElement.createElement;

public class PercentageToPageIntegrationTest {
    private DummyWebElement element;
    private DummyWebElement right;
    private DummyWebElement left;
    private DummyWebElement above;
    private DummyWebElement below;
    private String elementName;
    private ResponsiveUIValidatorBase base;

    @Before
    public void setUp() {
        element = (DummyWebElement) createElement(800, 400, 1300, 700);
        above = (DummyWebElement) createElement(800, 200, 1300, 300);
        below = (DummyWebElement) createElement(800, 800, 1300, 900);
        right = (DummyWebElement) createElement(1400, 400, 1700, 700);
        left = (DummyWebElement) createElement(400, 400, 700, 700);
        elementName = "under test";
    }

    public UIElementValidator createElementValidator() {
        DummyDriverFacade driverFacade = new DummyDriverFacade();
        driverFacade.setPageSize(new Dimension(2000, 1000));
        ResponsiveUIValidator uiValidator = new ResponsiveUIValidator(driverFacade);
        UISnapshot snapshot = uiValidator.snapshot();
        UIElementValidator result = snapshot.findElement(element, elementName);
        base = (ResponsiveUIValidatorBase) result;
        return result;
    }

    @Test
    public void distanceToTheRightIs100Pixels() {
        boolean validate = createElementValidator().isLeftOf(right, 100, 100).validate();
        assertThat(validate).isTrue();
    }

    @Test
    public void distanceToTheRighIs5Percent() {
        boolean validate = createElementValidator().changeMetricsUnitsTo(Units.PERCENT).isLeftOf(right, 5, 5).validate();
        assertThat(validate).isTrue();
    }

    @Test
    public void distanceToTheRightNot4Percent() {
        createElementValidator().changeMetricsUnitsTo(Units.PERCENT).isLeftOf(right, 4, 4);
        String lastMessage = base.getErrors().getLastMessage();
        assertThat(lastMessage).isNotNull();
    }

    @Test
    public void distanceToTheRigthNot6Percent() {
        createElementValidator().changeMetricsUnitsTo(Units.PERCENT).isLeftOf(right, 6, 6);
        String lastMessage = base.getErrors().getLastMessage();
        assertThat(lastMessage).isNotNull();
    }

    @Test
    public void distanceToTheLeftIs100Pixels() {
        boolean validate = createElementValidator().isRightOf(left, 100, 100).validate();
        assertThat(validate).isTrue();
    }

    @Test
    public void distanceToTheLeftIs5Percent() {
        boolean validate = createElementValidator().changeMetricsUnitsTo(Units.PERCENT).isRightOf(left, 5, 5).validate();
        assertThat(validate).isTrue();
    }

    @Test
    public void distanceToTheAboveIs100Pixels() {
        boolean validate = createElementValidator().isBelow(above, 100, 100).validate();
        assertThat(validate).isTrue();
    }

    @Test
    public void distanceToTheAboveIs10Percent() {
        boolean validate = createElementValidator().changeMetricsUnitsTo(Units.PERCENT).isBelow(above, 10, 10).validate();
        assertThat(validate).isTrue();
    }

    @Test
    public void distanceToTheBelowIs100Pixels() {
        boolean validate = createElementValidator().isAbove(below, 100, 100).validate();
        assertThat(validate).isTrue();
    }

    @Test
    public void distanceToTheBelowIs10Percent() {
        boolean validate = createElementValidator().changeMetricsUnitsTo(Units.PERCENT).isAbove(below, 10, 10).validate();
        assertThat(validate).isTrue();
    }

    @Test
    public void widthIs500Pixels() {
        assertThat(createElementValidator().hasWidthLessOrEqualTo(500).validate()).isTrue();
        assertThat(createElementValidator().hasWidthGreaterOrEqualTo(500).validate()).isTrue();
        assertThat(createElementValidator().hasWidthBetween(500, 500).validate()).isTrue();
    }

    @Test
    public void widthIs25Percent() {
        assertThat(createElementValidator().changeMetricsUnitsTo(Units.PERCENT).hasWidthLessOrEqualTo(25).validate()).isTrue();
        assertThat(createElementValidator().changeMetricsUnitsTo(Units.PERCENT).hasWidthGreaterOrEqualTo(25).validate()).isTrue();
        assertThat(createElementValidator().changeMetricsUnitsTo(Units.PERCENT).hasWidthBetween(25, 25).validate()).isTrue();
    }

    @Test
    public void heightIs300Pixels() {
        assertThat(createElementValidator().hasHeightLessOrEqualTo(300).validate()).isTrue();
        assertThat(createElementValidator().hasHeightGreaterOrEqualTo(300).validate()).isTrue();
        assertThat(createElementValidator().hasHeightBetween(300, 300).validate()).isTrue();
    }

    @Test
    public void heightIs30Percent() {
        assertThat(createElementValidator().changeMetricsUnitsTo(Units.PERCENT).hasHeightLessOrEqualTo(30).validate()).isTrue();
        assertThat(createElementValidator().changeMetricsUnitsTo(Units.PERCENT).hasHeightGreaterOrEqualTo(30).validate()).isTrue();
        assertThat(createElementValidator().changeMetricsUnitsTo(Units.PERCENT).hasHeightBetween(30, 30).validate()).isTrue();
    }

}
