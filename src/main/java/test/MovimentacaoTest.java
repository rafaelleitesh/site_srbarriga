package test;

import core.BaseTest;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import page.MenuPage;
import page.MovimentacaoPage;

import java.util.Arrays;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MovimentacaoTest extends BaseTest {
    MenuPage menuPage = new MenuPage();
    MovimentacaoPage movimentacaoPage = new MovimentacaoPage();

    @Test
    public void test1_CriarMovimentacao() {
        menuPage.acessarTelaMovimentacao();
        movimentacaoPage.inserirDataMovimentacao("01/02/2022");
        movimentacaoPage.inserirDataPagamento("02/02/2022");
        movimentacaoPage.inserirDescricao("Descrição inserida pelo teste.");
        movimentacaoPage.inserirInteressado("Rafael");
        movimentacaoPage.inserirValor("1000.00");
        movimentacaoPage.selecionarContaTeste("Conta para movimentacoes");
        movimentacaoPage.selecionarSituacaoPago();
        movimentacaoPage.salvarMovimentacao();
        Assert.assertEquals("Movimentação adicionada com sucesso!", movimentacaoPage.obterMensagemSucesso());
    }

    @Test
    public void test2_CamposObrigatorios() {
        menuPage.acessarTelaMovimentacao();
        movimentacaoPage.salvarMovimentacao();
        List<String> erros = movimentacaoPage.obterErros();
        Assert.assertTrue(erros.containsAll(Arrays.asList("Data da Movimentação é obrigatório",
                "Data do pagamento é obrigatório", "Descrição é obrigatório",
                "Interessado é obrigatório", "Valor é obrigatório", "Valor deve ser um número")));
        Assert.assertEquals(6, erros.size());
    }

    @Test
    public void test3_MovimentacaoFutura() {
        menuPage.acessarTelaMovimentacao();
        movimentacaoPage.inserirDataMovimentacao("01/02/2023");
        movimentacaoPage.inserirDataPagamento("02/02/2022");
        movimentacaoPage.inserirDescricao("Descrição inserida pelo teste.");
        movimentacaoPage.inserirInteressado("Rafael");
        movimentacaoPage.inserirValor("1000.00");
        movimentacaoPage.selecionarContaTeste("Conta para movimentacoes");
        movimentacaoPage.selecionarSituacaoPago();
        movimentacaoPage.salvarMovimentacao();
        List<String> erros = movimentacaoPage.obterErros();
        Assert.assertTrue(erros.containsAll(Arrays.asList("Data da Movimentação deve ser menor ou igual à data atual")));
    }
}
