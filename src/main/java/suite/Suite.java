package suite;

import core.DriverFactory;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import page.LoginPage;
import test.ContaTest;
import test.MovimentacaoTest;
import test.RemoverMovimentacaoTest;
import test.ResumoTest;

@RunWith(org.junit.runners.Suite.class)
@org.junit.runners.Suite.SuiteClasses({
        ContaTest.class,
        MovimentacaoTest.class,
        RemoverMovimentacaoTest.class,
        ResumoTest.class
})

public class Suite {
    private static LoginPage page = new LoginPage();

    @BeforeClass
    public static void reset() {
        page.acessarTelaLogin();
        page.setEmail("raphael.c.l@hotmail.com");
        page.setSenha("12345678");
        page.clicarEntrar();
        page.clicarReset();
        DriverFactory.killDriver();
    }

}
