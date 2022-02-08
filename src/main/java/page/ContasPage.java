package page;

import core.BasePage;
import org.openqa.selenium.By;

import java.nio.charset.StandardCharsets;

public class ContasPage extends BasePage {

    public void setNome(String nome) {
        escrever("nome", nome);
    }
    public void salvarConta() {
        clicar(By.xpath("//button[.='Salvar']"));
    }

    public String obterMensagemSucesso() {
        return obterValorTexto(By.xpath("//div[@class='alert alert-success']"));
    }

    public void clicarAlterarConta(String valor) {
        String rawString = "Ações";
        byte[] bytes = rawString.getBytes(StandardCharsets.UTF_8);
        String utf8EncodedString = new String(bytes, StandardCharsets.UTF_8);

        obterCelula("Conta", valor, utf8EncodedString, "tabelaContas")
                .findElement(By.xpath(".//span[@class='glyphicon glyphicon-edit']")).click();
    }

    public String obterMensagemFalha() {
        return obterValorTexto(By.xpath("//div[@class='alert alert-danger']"));
    }

    public void clicarExcluirConta(String valor) {
        obterCelula("Conta", valor, "Ações", "tabelaContas")
                .findElement(By.xpath(".//span[@class='glyphicon glyphicon-remove-circle']")).click();
    }
}
