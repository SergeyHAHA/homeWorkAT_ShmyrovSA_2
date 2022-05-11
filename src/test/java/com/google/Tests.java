package com.google;

import common.ChromeDriverSettings;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;

import static com.google.Stepts.*;

public class Tests extends ChromeDriverSettings {

    @Test
    @Description("В гугле более 3 записей по слову Гладиолус?")
    public void googleSearchIsWork(){
        GoogleSearchPF googleSearchPage = new GoogleSearchPF(getChromeDriver());
        searchGladiolus(googleSearchPage, "Гладиолус", getChromeDriver());
        var searchResult = googleSearchPage.getSearchResult();
        googleSearchMore3Result(searchResult, getChromeDriver());
    }

    @Test
    @Description("В гугле найдена статья на википедию содержащая заголовок Гладиолус")
    public void googleSearchWikiGladiolus(){
        GoogleSearchPF googleSearchPage = new GoogleSearchPF(getChromeDriver());
        searchGladiolus(googleSearchPage, "Гладиолус", getChromeDriver());
        var searchResult = googleSearchPage.getSearchResult();
        isFindWikiGladiolus(searchResult, getChromeDriver());
    }

}
