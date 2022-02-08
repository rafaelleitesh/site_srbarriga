package test;

import core.BaseTest;
import core.DriverFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import page.HomePage;
import page.MenuPage;
import page.ResumoPage;

import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ResumoTest extends BaseTest {
    MenuPage menuPage = new MenuPage();
    ResumoPage resumoPage = new ResumoPage();
    HomePage homePage = new HomePage();

    @Test
    public void test1_VerificarSaldoConta() {
        Assert.assertEquals("1000.00", homePage.obterSaldoConta("RafaelAlterado"));
    }

    @Test
    public void test2_ExcluirMovimentacao() {
        menuPage.acessarTelaResumo();
        resumoPage.clicarExcluirMovimentacao("Descrição inserida pelo teste.");
        Assert.assertEquals("Movimentação removida com sucesso!", resumoPage.obterMensagemSucesso());
    }
    
    @Test
    public void test3_ResumoMensal() {
        menuPage.acessarTelaResumo();
        Assert.assertEquals("Seu Barriga - Extrato", DriverFactory.getDriver().getTitle());

        List<WebElement> elementosEncontrados = DriverFactory.getDriver().findElements(By.xpath("//*[@id='tabelaExtrato']/tbody/tr"));
        Assert.assertEquals(0, elementosEncontrados.size());
    }
}
