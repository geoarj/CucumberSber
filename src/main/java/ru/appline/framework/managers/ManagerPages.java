package ru.appline.framework.managers;

import ru.appline.framework.pages.MortgagePage;
import ru.appline.framework.pages.StartPage;


/**
 * @author Arkadiy_Alaverdyan
 * Класс для управления страничками
 */
public class ManagerPages {

    /**
     * Менеджер страничек
     */
    private static ManagerPages managerPages;

    /**
     * Стартовая страничка
     */
    StartPage startPage;

    /**
     * Страничка ипотеки
     */
    MortgagePage mortgagePage;

//    /**
//     * Страничка выбора полиса или тарифа
//     */
//    TarifPage tarifPage;
//
//    /**
//     * Страничка оформления полиса страхования
//     */
//    RegistrationFormPage registrationFormPage;

    /**
     * Конструктор специально запривейтили (синглтон)
     * @see ManagerPages#getManagerPages()
     */
    private ManagerPages() {
    }

    /**
     * Ленивая инициализация ManagerPages
     *
     * @return ManagerPages
     */
    public static ManagerPages getManagerPages() {
        if (managerPages == null) {
            managerPages = new ManagerPages();
        }
        return managerPages;
    }

    /**
     * Ленивая инициализация {@link ru.appline.framework.pages.StartPage}
     *
     * @return StartPage
     */
    public StartPage getStartPage() {
        if (startPage == null) {
            startPage = new StartPage();
        }
        return startPage;
    }

    /**
     * Ленивая инициализация {@link ru.appline.framework.pages.MortgagePage}
     *
     * @return StrahovaniePage
     */
    public MortgagePage getMortgagePage() {
        if (mortgagePage == null) {
            mortgagePage = new MortgagePage();
        }
        return mortgagePage;
    }
//
//    /**
//     * Ленивая инициализация {@link ru.appline.framework.pages.TarifPage}
//     *
//     * @return TarifPage
//     */
//    public TarifPage getTarifPage() {
//        if (tarifPage == null) {
//            tarifPage = new TarifPage();
//        }
//        return tarifPage;
//    }
//
//    /**
//     * Ленивая инициализация {@link ru.appline.framework.pages.RegistrationFormPage}
//     *
//     * @return RegistrationFormPage
//     */
//    public RegistrationFormPage getRegistrationFormPage() {
//        if (registrationFormPage == null) {
//            registrationFormPage = new RegistrationFormPage();
//        }
//        return registrationFormPage;
//    }
}
