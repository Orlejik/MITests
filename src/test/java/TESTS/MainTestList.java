package TESTS;

import Core.BaseSeleniumTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CreditCalculationPageTest.class,
        CheckBoxesCalculationTests.class,
})

public class MainTestList extends BaseSeleniumTest {

}
