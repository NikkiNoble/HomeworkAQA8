package ru.netology;

import lombok.val;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import ru.netology.data.DBInteractions;
import ru.netology.data.DataHelper;
import ru.netology.data.LoginPage;

import java.sql.SQLException;

public class LoginTest {
    @AfterAll
    static void cleanTables() throws SQLException {
        DBInteractions.deleteTable();
    }

    @Test
    void shouldLoginWithTakingDataFromDB() throws SQLException {
        DataHelper.openPage();
        LoginPage login = new LoginPage();
        val verificationPage = login.validLogin();
        verificationPage.validVerify();
        DBInteractions.deleteCodes();
    }
    @Test
    void shouldLoginWithTakingDataFromDBWithDifUser() throws SQLException {
        DataHelper.openPage();
        LoginPage login = new LoginPage();
        val verificationPage = login.validLoginForDifferentUser();
        verificationPage.validVerify();
        DBInteractions.deleteCodes();
    }
    @Test
    void shouldShowErrorOnVerificationPage() throws SQLException {
        DataHelper.openPage();
        LoginPage login = new LoginPage();
        val verificationPage = login.validLogin();
        verificationPage.notValidVerify();
        DBInteractions.deleteCodes();
    }
    @Test
    void shouldShowErrorOnLoginPage() throws SQLException {
        DataHelper.openPage();
        LoginPage login = new LoginPage();
        login.notValidLogin();
        DBInteractions.deleteCodes();

    }

}
