package ru.appline.framework.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static ru.appline.framework.managers.DriverManager.getDriver;

public class MortgagePage extends BasePage {

    @FindBy(xpath = "//h2[text() = '\u200BРассчитайте ипотеку' and contains(@class, 't-header-big')]")
    WebElement field;

    @FindBy(xpath = "//iframe[@sandbox]")
    WebElement iFrame;

    static boolean checkIFrame = false;

    @FindBy(xpath = "//div[@data-label='Стоимость недвижимости']//input[@class='dc-input__input-4-8-0']")
    WebElement immovablePrice;

    @FindBy(xpath = "//div[@data-label='Первоначальный взнос']//input[@class='dc-input__input-4-8-0']")
    WebElement firstInstalment;

    @FindBy(xpath = "//div[@data-label='Срок кредита']//input[@class='dc-input__input-4-8-0']")
    WebElement creditPeriod;


    @FindBy(xpath = "//span[text()='Скидка 0,3% при покупке квартиры на ДомКлик']/..//..//input")
    WebElement domKlickCheckBox;

    @FindBy(xpath = "//span[text()='Молодая семья']/..//..//input")
    WebElement youngFamilyCheckBox;

    @FindBy(xpath = "//span[text()='Страхование жизни']/..//..//input")
    WebElement lifeInsuranceCheckBox;

    @FindBy(xpath = "//span[text()='Электронная регистрация сделки']/..//..//input")
    WebElement electroRegistrationCheckBox;

    @FindBy(xpath = "//span[text()= 'Сумма кредита']/../span[@data-e2e-id = 'mland-calculator/medium-result-credit-sum']")
    WebElement creditSumElement;

    @FindBy(xpath = "//span[text()= 'Ежемесячный платеж']/../span[@data-e2e-id = 'mland-calculator/medium-result-monthly-payment']")
    WebElement monthlyPayElement;

    @FindBy(xpath = "//span[text()= 'Необходимый доход']/../span[@data-e2e-id = 'mland-calculator/medium-result-required-income']")
    WebElement requiredIncomeElement;

    @FindBy(xpath = "//span[text()= 'Процентная ставка']/../span[@data-e2e-id = 'mland-calculator/medium-result-credit-rate']")
    WebElement rateElement;


    @Step("Проверка открытия страницы MortgagePage")
    public MortgagePage checkOpenPage(String title) {
        Assert.assertTrue("Заголовок отсутствует/не соответствует требуемому", getDriver().getTitle().toLowerCase().contains(title.toLowerCase()));
        return this;
    }


    @Step("Заполняем поля '{nameField}' значение '{value}'")
    public MortgagePage fillInFields(String nameField, int value) {
        if (!checkIFrame) {
            getDriver().switchTo().frame(iFrame);
            checkIFrame = true;
        }
        WebElement element = null;
        switch (nameField) {
            case "Стоимость недвижимости":
                fillInputField(immovablePrice, value);
                element = immovablePrice;
                break;
            case "Первоначальный взнос":
                fillInputField(firstInstalment, value);
                element = firstInstalment;
                break;
            case "Срок кредита":
                fillInputField(creditPeriod, value);
                element = creditPeriod;
                break;
            default:
                Assert.fail("Поле с наименованием '" + nameField + "' отсутствует на странице " +
                        "'Ипотека на готовое жилье'");
        }
        Assert.assertEquals("Поле '" + nameField + "' было заполнено некорректно",
                value, Integer.parseInt(element.getAttribute("value").replaceAll(" ", "")));
        return this;
    }

    @Step("Заполняем поля '{nameField}' значение '{value}'")
    public MortgagePage fillCheckBoxes(String nameField, String value) {
        WebElement element = null;
        switch (nameField) {
            case "Скидка 0,3% при покупке квартиры на ДомКлик":
                fillInputCheckBoxes(domKlickCheckBox, value);
                element = domKlickCheckBox;
                break;
            case "Страхование жизни":
                fillInputCheckBoxes(lifeInsuranceCheckBox, value);
                element = lifeInsuranceCheckBox;
                break;
            case "Молодая семья":
                fillInputCheckBoxes(youngFamilyCheckBox, value);
                element = youngFamilyCheckBox;
                break;
            case "Электронная регистрация сделки":
                fillInputCheckBoxes(electroRegistrationCheckBox, value);
                element = electroRegistrationCheckBox;
                break;
            default:
                Assert.fail("Поле с наименованием '" + nameField + "' отсутствует на странице " +
                        "'Ипотека на готовое жилье'");
        }
        Assert.assertEquals("Поле '" + nameField + "' было заполнено некорректно",
                value, element.getAttribute("aria-checked"));
        return this;
    }

    @Step("Сравниваем элемент '{nameElement}' значение '{value}'")
    public MortgagePage checkFields(String nameElement, String value) {
        switch (nameElement) {
            case "Сумма кредита":
                checkValue(creditSumElement, value, nameElement);
                break;
            case "Ежемесячный платеж":
                checkValue(monthlyPayElement, value, nameElement);
                break;
            case "Необходимый доход":
                checkValue(requiredIncomeElement, value, nameElement);
                break;
            case "Процентная ставка":
                checkValue(rateElement, value, nameElement);
                break;
            default:
                Assert.fail("Поле с наименованием '" + nameElement + "' отсутствует на странице.");
                break;
        }
        return this;
    }
}
