package utils;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name="BundleSearchProvider")
    public static Object[][] getDataFromDataprovider(){
        return new Object[][] {
                { "SFO", "LAX", 1, 20, "Evening", "Morning"}
        };

    }}

