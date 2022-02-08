package core;

import org.junit.Before;
import org.junit.After;
import page.LoginPage;

import java.io.IOException;

public class BaseTest {
    private LoginPage page = new LoginPage();

    @Before
    public void inicializa() {
        page.acessarTelaLogin();
        page.setEmail("raphael.c.l@hotmail.com");
        page.setSenha("12345678");
        page.clicarEntrar();
    }

    @After
    public void finalizaDriver() throws IOException {
        DriverFactory.killDriver();
    }
}
