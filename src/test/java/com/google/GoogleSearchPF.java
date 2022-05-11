package com.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GoogleSearchPF {


    @FindBy(how = How.XPATH, xpath = "//div[@class=\"g tF2Cxc\"]")
    private List<WebElement> webElementsSearch;

    WebDriver webDriver;

   // private String selectorSearchItem;
    private final String selectorURI = ".//a[@href]";
    private final String selectorPageName = ".//a[@href]/h3";
    private final String selectorDescription = ".//div[@data-content-feature=1 or @data-content-feature = 2]//div/span[string-length() > 50]";

    private List<Map<String, Object>> searchResult = new ArrayList<>();

    public GoogleSearchPF(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public GoogleSearchPF(WebDriver webDriver, String search){
        this(webDriver);
        webDriver.get("https://www.google.com/search?q=" + search);
    }

    public void search(String search){
        webDriver.get("https://www.google.com/search?q=" + search);
    }

    public List<Map<String, Object>> getSearchResult() {
        for(var webElement : webElementsSearch){
            searchResult.add(Map.of(
                    "WEB_ELEMENT", webElement,
                    "URI", webElement.findElement(By.xpath(selectorURI)).getAttribute("href"),
                    "PAGE_NAME", webElement.findElement(By.xpath(selectorPageName)).getText(),
                    "Description", webElement.findElement(By.xpath(selectorDescription)).getText()
            ));
        }
        return searchResult;
    }
}
