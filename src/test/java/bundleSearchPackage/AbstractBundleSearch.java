package bundleSearchPackage;

import config.AbstractAcceptanceTest;
import pageManagers.HomePageManager;
import org.testng.annotations.BeforeMethod;
import pageManagers.OffersPageManager;

public abstract class AbstractBundleSearch extends AbstractAcceptanceTest {
    public HomePageManager homePageManager;
    public OffersPageManager offersPageManager;

    @BeforeMethod
    public void initManagers() {
        homePageManager = new HomePageManager(getWebDriver());
        offersPageManager = new OffersPageManager(getWebDriver());
    }
}
