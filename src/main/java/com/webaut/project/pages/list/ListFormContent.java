package com.webaut.project.pages.list;

import com.webaut.project.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ListFormContent extends AbstractPage {

    @FindBy (css = "textarea:focus")
    private WebElement listHeaderEditable;

    private String listActionsButton = "//h2[text()='%s']/following-sibling::div";

    private String listTitleLabel = ".list-header-name-assist";

    private String LIST_ITEM= "//h2[text()='%s']/ancestor::div[@class='js-list list-wrapper']";

    public static final String LIST_HEADER = "//h2[contains(text(),'%s')]/preceding-sibling::div";//[@class='js-list list-wrapper']";

    public static final String LIST_PRECEDING = "/preceding-sibling::div[@class='js-list list-wrapper']/descendant::h2[text()='%s']";

    public String getListTitle(){
        return action.getAttributeFromNonVisible(By.cssSelector(listTitleLabel), "innerText");
    }
    public void clickListTitle(String listTitle){
        action.click(By.xpath((String.format(LIST_HEADER, listTitle))));
    }

    public void setListTitle(String newTitle){
        action.setValueFocus(listHeaderEditable, newTitle);
        action.setValue(listHeaderEditable, Keys.ENTER);
    }

    public ListActions clickListActionsButton(String listTitle){
        action.isElementPresent(By.xpath(String.format(listActionsButton, listTitle)));
        action.click(By.xpath(String.format(listActionsButton, listTitle)));
        return new ListActions();
    }

    public boolean isListAfter(String precedingList, String followingList){
        return action.isElementVisible(By.xpath(String.format(LIST_ITEM + LIST_PRECEDING, followingList, precedingList)));
    }

}
