package pageManagers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class OffersPageManager {

    WebDriver driver;

    public OffersPageManager(WebDriver driver) {
        this.driver = driver;
    }

    //selectors
    public static final String OFFER_SELECTOR = "#resultsContainer .flex-card";
    public static final String MAP_SELECTOR = ".mapIcon";

    //methods
    public void waitForOfferPageToLoad(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(MAP_SELECTOR)));
    }

    public int getTotalNumberOfOffers(){
        List<WebElement> offersList = new ArrayList(driver.findElements(By.cssSelector(OFFER_SELECTOR)));
        return offersList.size();
    }

}
