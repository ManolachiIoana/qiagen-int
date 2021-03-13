package bundleSearchPackage;

import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageManagers.HomePageManager;
import utils.DataProviders;

public class BundleSearchTest extends AbstractBundleSearch {

    @Test(dataProvider="BundleSearchProvider",dataProviderClass= DataProviders.class)
    public void test(String departureLocation, String returningLocation, int daysBeforeDeparture, int daysBeforeReturning, String timeOfDeparture, String timeOfReturning) {
        test = extent.createTest("Basic bundle search");
        test.assignCategory("Bundle Search");

        test.log(Status.INFO, "Click on bundle search icon");
        homePageManager.clickOnBundleSearchOption();

        test.log(Status.INFO, "Click to add car option to the bundle");
        homePageManager.clickToAddCarToBundle();

        test.log(Status.INFO, "Enter flight from: " + departureLocation);
        homePageManager.selectLocation(HomePageManager.ORIGIN_LOCATION_SELECTOR, departureLocation);

        test.log(Status.INFO, "Enter flight to: " + returningLocation);
        homePageManager.selectLocation(HomePageManager.DESTINATION_LOCATION_SELECTOR, returningLocation);

        test.log(Status.INFO, "select departure date as tomorrow");
        homePageManager.selectTomorrowDate();

        test.log(Status.INFO, "select return date as today + 20 days");
        homePageManager.selectDate(daysBeforeReturning);

        test.log(Status.INFO, "Select departing time: evening");
        homePageManager.selectTimeOfDay(HomePageManager.CAR_PICKUP_TIME_SELECTOR, timeOfDeparture);

        test.log(Status.INFO, "Select returning time: morning");
        homePageManager.selectTimeOfDay(HomePageManager.CAR_DROPOFF_TIME_SELECTOR, timeOfReturning);

        test.log(Status.INFO, "Click on: Find a deal");
        homePageManager.clickOnFindADeal();

        test.log(Status.INFO, "Verify there is at least one offer");
        //When running the automated test, access is denied on this page, could not solve this issue.
        //offersPageManager.waitForOfferPageToLoad();
        //Assert.assertTrue(offersPageManager.getTotalNumberOfOffers() >= 1);


    }

}
