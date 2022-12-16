package com.lyngo.amondscoffeehouse;

import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdministratorTest {
    private static WebDriver driver;
    private static final String DRIVER_PATH = "chromedriver.exe";
    private static final String URL = "http://localhost:8080/amonds_coffee_house_2_war_exploded/";
//    @BeforeAll
    public static void start(){
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
    }


}
