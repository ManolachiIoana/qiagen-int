package pageManagers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static utils.Utils.getDateAfterDays;

public class HomePageManager {

    WebDriver driver;

    public HomePageManager(WebDriver driver) {
        this.driver = driver;
    }

    //selectors
    public static final String BUNDLE_OPTION_SELECTOR = "[data-bdd='farefinder-option-bundles']";
    public static final String CAR_INSIDE_BUNDLE_SELECTOR = "[data-bdd='farefinder-package-bundleoption-car']";
    public static final String ORIGIN_LOCATION_SELECTOR = "[data-bdd='farefinder-package-origin-location-input']";
    public static final String DESTINATION_LOCATION_SELECTOR = "[data-bdd='farefinder-package-destination-location-input']";
    public static final String CAR_PICKUP_TIME_SELECTOR = "[name='carPickupTime']";
    public static final String CAR_DROPOFF_TIME_SELECTOR = "[name='carDropoffTime']";
    public static final String FIND_PACKAGE_BUTTON_SELECTOR = ".submit-button";
    public static final String DEPARTURE_DAY_SELECTOR = "[data-bdd='farefinder-package-startdate-input']";
    public static final String ARRIVAL_DAY_SELECTOR = "[data-bdd='farefinder-package-enddate-input']";
    public static final String PAGE_SELECTOR = ".farefinder-container";


    //methods
    public WebElement waitAndClick(String selector){
        WebElement element = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector)));
        element.click();
        return element;
    }

    public void clickOnBundleSearchOption(){
        waitAndClick(BUNDLE_OPTION_SELECTOR);
    }

    public void clickToAddCarToBundle(){
        waitAndClick(CAR_INSIDE_BUNDLE_SELECTOR);
    }

    public void selectLocation(String locationType, String location){
        WebElement locationInputBox = waitAndClick(locationType);
        locationInputBox.sendKeys(location);
        waitAndClick(PAGE_SELECTOR);
    }

    public void selectTomorrowDate(){
        waitAndClick(DEPARTURE_DAY_SELECTOR);
        String date = getDateAfterDays(1);
        String daySelector = ".day[aria-label='" + date + " is selected as your checkout date.']";
        waitAndClick(daySelector);
    }

    public void selectDate(int numberOfDays){
        String date = getDateAfterDays(numberOfDays);
        String daySelector = ".day[aria-label='" + date + "']";
        waitAndClick(daySelector);
    }

    public void selectTimeOfDay(String locationType, String timeOfDay){
        Select time = new Select(new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locationType))));
        time.selectByValue(timeOfDay);
    }

    public void clickOnFindADeal(){
        waitAndClick(FIND_PACKAGE_BUTTON_SELECTOR);
    }





}
