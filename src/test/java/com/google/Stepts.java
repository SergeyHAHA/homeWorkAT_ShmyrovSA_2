package com.google;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

import static common.Utils.getScreen;

public class Stepts {

    @Step("Шаг 1. Поиск по слову \"{search}\"")
    public static void searchGladiolus(GoogleSearchPF googleSearchPF, String search, WebDriver webDriver){
       googleSearchPF.search(search);
        String title = webDriver.getTitle();
        if (title.contains("Google")){
            Assertions.assertTrue(true);
        } else{
            getScreen(webDriver);
            Assertions.assertTrue(false, "Поиск не удался");
        }

    }

    @Step("Шаг 2.1 Проверка, что найдено больше 3 записей в результате поиска")
    public static void googleSearchMore3Result(List<Map<String, Object>> searchResult, WebDriver webDriver){
        if (searchResult.size()>3) {
            Assertions.assertTrue(true);
        } else {
            getScreen(webDriver);
            Assertions.assertTrue(false, "В Google найдено менее 3 записей по слову Гладиолус");
        }
    }

    @Step("Шаг 2.2 Поиск слова \"Гладолус\" в википедии")
    public static void isFindWikiGladiolus(List<Map<String, Object>> searchResult, WebDriver webDriver){
        if (searchResult.stream().filter(
                (x-> x.get("PAGE_NAME").toString().contains("Википедия")))
                .anyMatch(x->x.toString().contains("Гладиолус")))
        {
            Assertions.assertTrue(true);
        } else {
            getScreen(webDriver);
            Assertions.assertTrue(false, "Не найдена страца Вики с заголовком Гладиолус");
        }
    }

}
