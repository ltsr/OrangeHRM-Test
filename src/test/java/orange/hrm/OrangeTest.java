package orange.hrm;

import orange.hrm.account.OrangeLoginFunc;
import orange.hrm.util.DriverInit;
import orange.hrm.util.OrangeUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OrangeTest extends DriverInit {

    @Test
    public void testSearchPim() throws InterruptedException {
        OrangeLoginFunc.loginAccount(driver, wait);

        OrangeUtils.searchPim(driver, wait);

    }
}
