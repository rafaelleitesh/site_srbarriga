package test;

import core.BaseTest;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import page.ContasPage;
import page.HomePage;
import page.MenuPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContaTest extends BaseTest {
    MenuPage menuPage = new MenuPage();
    ContasPage contasPage = new ContasPage();
    HomePage homePage = new HomePage();

    @Test
    public void test1_criarConta() {
        menuPage.acessarTelaInserirConta();
        contasPage.setNome("Rafael");
        contasPage.salvarConta();
        Assert.assertEquals("Conta adicionada com sucesso!", contasPage.obterMensagemSucesso());
    }

    @Test
    public void test2_AlterarConta() {
        menuPage.acessarTelaListaContas();
        contasPage.clicarAlterarConta("Conta para alterar");
        contasPage.setNome("Conta alterada");
        contasPage.salvarConta();
        Assert.assertEquals("Conta alterada com sucesso!", contasPage.obterMensagemSucesso());
    }

    @Test
    public void test3_CriarContaExistente() {
        menuPage.acessarTelaInserirConta();
        contasPage.setNome("Conta mesmo nome");
        contasPage.salvarConta();
        Assert.assertEquals("Já existe uma conta com esse nome!", contasPage.obterMensagemFalha());
    }

}
