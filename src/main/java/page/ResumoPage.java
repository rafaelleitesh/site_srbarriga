package page;

import core.BasePage;
import org.openqa.selenium.By;

public class ResumoPage extends BasePage {

    public void clicarExcluirMovimentacao(String valor) {
        obterCelula("Descrição", valor, "Ações", "tabelaExtrato")
                .findElement(By.xpath(".//span[@class='glyphicon glyphicon-remove-circle']")).click();
    }

    public String obterMensagemSucesso() {
        return obterValorTexto(By.xpath("//div[@class='alert alert-success']"));
    }

}
