package ru.appline.framework.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class StartPage extends BasePage {
    @FindBy(xpath = "//li[@class = 'kitt-top-menu__item kitt-top-menu__item_first']")
    List<WebElement> menuBaseList;

    @FindBy(xpath = "//a[contains(@class, 'kitt-top-menu__link_second')]")
    List<WebElement> menuSubList;

    @Step("Переход в главное меню {nameBaseMenu}")
    public StartPage selectBaseMenu(String nameBaseMenu) {
        for (WebElement menuItem : menuBaseList) {
            if (menuItem.getText().equalsIgnoreCase(nameBaseMenu)) {
                action.moveToElement(menuItem).click().build().perform();
                return this;
            }
        }
        Assert.fail("Меню '" + nameBaseMenu + "' не было найдено на стартовой странице!");
        return this;
    }

    /**
     * Функция клика на любое подменю
     *
     * @param nameSubMenu - наименование подменю
     * @return MortgagePage - т.е. переходим на страницу {@link ru.appline.framework.pages.MortgagePage}
     */
    @Step("Выбираем подменю {nameSubMenu}")
    public MortgagePage selectSubMenu(String nameSubMenu) {
        for (WebElement menuItem : menuSubList) {
            if (menuItem.getText().equalsIgnoreCase(nameSubMenu)) {
                wait.until(ExpectedConditions.visibilityOf(menuItem));
                action.moveToElement(menuItem).click().build().perform();
                return app.getMortgagePage();
            }
        }
        Assert.fail("Подменю '" + nameSubMenu + "' не было найдено на стартовой странице!");
        return app.getMortgagePage();
    }
}
