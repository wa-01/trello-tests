package com.webaut.project.core.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverAction {
    private WebDriver driver;
    private WebDriverWait wait;

    public WebDriverAction(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    public void click(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    public void setValue(By selector, String value) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
        driver.findElement(selector).sendKeys(value);
    }

    public void setValue(WebElement webElement, String value) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.sendKeys(value);
    }

    public void clickJS(WebElement webElement) {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", webElement);
    }

    public String getText(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        return webElement.getText();
    }

    public String getText(By selector) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
        return driver.findElement(selector).getText();
    }

    public String getAttribute(WebElement webElement, String attribute) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        return webElement.getAttribute(attribute);
    }

    public String getAttributeFromNonVisible(By selector, String attribute) {
        wait.until(ExpectedConditions.presenceOfElementLocated(selector));
        return driver.findElement(selector).getAttribute(attribute);
    }

    public String getAttribute(By selector, String attribute) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
        return driver.findElement(selector).getAttribute(attribute);
    }

    public boolean isSelected(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        return webElement.isSelected();
    }

    public boolean isElementVisible(final By element) {
        try {
            driver.findElement(element);
        } catch (final NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public void moveElement(By source, By target){
        wait.until(ExpectedConditions.visibilityOfElementLocated(source));
        wait.until(ExpectedConditions.visibilityOfElementLocated(target));
        WebElement destination = driver.findElement(target);
        Actions action = new Actions(driver);
        action.clickAndHold(driver.findElement(source)).build().perform();
        action.moveByOffset(-1,-1).build().perform();
        action.moveToElement(destination, destination.getLocation().getX() + destination.getSize().getWidth()/2,
                destination.getLocation().getY() + destination.getSize().getHeight()/2).build().perform();
        action.release().perform();//.moveByOffset(-1,-1)
        //action.dragAndDrop(driver.findElement(source), driver.findElement(target)).build().perform();
    }
}
