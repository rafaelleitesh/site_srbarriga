package test;

import core.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import page.ContasPage;
import page.MenuPage;

public class RemoverMovimentacaoTest extends BaseTest {

    @Test
    public void testExcluirContaComMovimentacao() {
        MenuPage menuPage = new MenuPage();
        ContasPage contasPage = new ContasPage();

        menuPage.acessarTelaListaContas();
        contasPage.clicarExcluirConta("Conta com movimentacao");
        Assert.assertEquals("Conta em uso na movimentações", contasPage.obterMensagemFalha());
    }
}
