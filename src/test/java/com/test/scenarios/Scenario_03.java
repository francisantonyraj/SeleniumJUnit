package com.test.scenarios;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Scenario_03 {

    private WebDriver driver;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
    }

    @Test
    public void captureLinks() {
        List<WebElement> elementList = driver.findElements(By.tagName("a"));
        Iterator<WebElement> iterator = elementList.iterator();
        String url;
        List<String> list = new ArrayList<>();
        while (iterator.hasNext()) {
            url = iterator.next().getAttribute("href");
            if (url == null || url.isEmpty()) {
                list.add(url);
            }
        }
        System.out.println(list);
    }
}
