package page;

import core.BasePage;
import core.DriverFactory;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    public void acessarTelaLogin() {
        DriverFactory.getDriver().get("https://seubarriga.wcaquino.me");
    }

    public void setEmail(String email) {
        escrever("email", email);
    }

    public void setSenha(String senha) {
        escrever("senha", senha);
    }

    public void clicarEntrar() {
        clicar(By.xpath("//button[.='Entrar']"));
    }

}
