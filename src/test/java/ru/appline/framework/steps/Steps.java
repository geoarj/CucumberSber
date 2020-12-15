package ru.appline.framework.steps;

import io.cucumber.datatable.DataTable;

import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import ru.appline.framework.managers.ManagerPages;

public class Steps {
    /**
     * Менеджер страничек
     * @see ManagerPages#getManagerPages()
     */
    private ManagerPages app = ManagerPages.getManagerPages();

    @Когда("^Загружена стартовая страница$")
    public void getMainPage(){
        app.getStartPage();
    }

    @Когда("^Переход в главное меню '(.*)'$")
    public void selectNameBaseMenu(String nameBaseMenu){
        app.getStartPage().selectBaseMenu(nameBaseMenu);
    }

    @Когда("^Выбираем подменю '(.*)'$")
    public void selectNameSubMenu(String nameSubMenu){
        app.getStartPage().selectSubMenu(nameSubMenu);
    }

    @Тогда("^Проверка открытия страницы '(.*)'$")
    public void checkOpenPage(String pageTitle) {
        app.getMortgagePage().checkOpenPage(pageTitle);
    }

    @Когда("^Заполняем форму поле/значение$")
    public void fillInFields(DataTable dataTable){
        dataTable.cells().forEach(
                raw -> {
                    app.getMortgagePage().fillInFields(raw.get(0), Integer.parseInt(raw.get(1)));
                });
    }

    @Когда("Выбор статуса чек-боксов")
    public void fillCheckBoxes(DataTable dataTable) {
        dataTable.cells().forEach(
                raw -> {
                    app.getMortgagePage().fillCheckBoxes(raw.get(0), raw.get(1));
                }
        );
    }

    @Когда("Проверка рассчитанных значений")
    public void checkFields(DataTable dataTable) {
        dataTable.cells().forEach(
                raw -> {
                    app.getMortgagePage().checkFields(raw.get(0), raw.get(1));
                }
        );
    }


}