package com.webaut.project.pages;

import com.webaut.project.core.ui.ISteps;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ListForm extends AbstractPage{

    @FindBy(css = ".list-name-input")
    private WebElement listNameTextField;

    @FindBy(css = ".mod-list-add-button")
    private WebElement addListButton;

    private void setListFields(Map<String, String> data){
        Map<String, ISteps> strategyMap = new HashMap<>();
        strategyMap.put("title", () -> action.setValue(listNameTextField, data.get("title")));
        Set<String> keys = data.keySet();
        for (String key : keys) {
            strategyMap.get(key).execute();
        }

    }

    public void addList(Map<String, String> data){
        setListFields(data);
        action.click((addListButton));
    }
}
