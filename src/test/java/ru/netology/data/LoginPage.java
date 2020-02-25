package ru.netology.data;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import java.sql.SQLException;


import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private SelenideElement loginField = $("[data-test-id=login] input");
    private SelenideElement passwordField = $("[data-test-id=password] input");
    private SelenideElement loginButton = $("[data-test-id=action-login]");
    private SelenideElement errorNotification = $("[data-test-id=error-notification]");

    public VerificationPage validLogin () throws SQLException {
        loginField.setValue(DBInteractions.getLogin());
        passwordField.setValue(DataHelper.getPassword());
        loginButton.click();
        return new VerificationPage();
    }
    public VerificationPage validLoginForDifferentUser () throws SQLException {
        loginField.setValue(DBInteractions.getLoginForDifUser());
        passwordField.setValue(DataHelper.getOtherPassword());
        loginButton.click();
        return new VerificationPage();
    }
    public void notValidLogin () throws SQLException {
        loginField.setValue(DBInteractions.getLogin());
        passwordField.setValue(DataHelper.getOtherPassword());
        loginButton.click();
        errorNotification.shouldBe(Condition.visible);
    }
}
