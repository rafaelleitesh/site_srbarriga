package page;

import core.BasePage;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    public String obterSaldoConta(String valor) {
        return obterCelula("Conta", valor, "Saldo", "tabelaSaldo").getText();
    }
}
