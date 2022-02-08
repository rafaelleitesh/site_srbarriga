package page;

import core.BasePage;
import core.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class MovimentacaoPage extends BasePage {

    public void inserirDataMovimentacao(String data) {
        escrever("data_transacao",data);
    }

    public void inserirDataPagamento(String data) {
        escrever("data_pagamento", data);
    }

    public void inserirDescricao(String texto) {
        escrever("descricao", texto);
    }

    public void inserirInteressado(String interessado) {
        escrever("interessado", interessado);
    }

    public void inserirValor(String valor) {
        escrever("valor", valor);
    }

    public void selecionarContaTeste(String conta) {
        selecionarCombo("conta", conta);
    }

    public void selecionarSituacaoPago() {
        clicar(By.id("status_pago"));
    }

    public void salvarMovimentacao() {
        clicar(By.xpath("//button[.='Salvar']"));
    }

    public String obterMensagemSucesso() {
        return obterValorTexto(By.xpath("//div[@class='alert alert-success']"));
    }

    public List<String> obterErros() {
        List<WebElement> erros = DriverFactory.getDriver().findElements(By.xpath("//div[@class='alert alert-danger']//li"));
        List<String> retorno = new ArrayList<String>();
        for (WebElement erro: erros) {
            retorno.add(erro.getText());
        }
        return retorno;
    }
}
