package modulos.produto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LoginPage extends BasePage {
    public LoginPage(RemoteWebDriver app) {
        super(app);
    }

    public LoginPage preencheCampoUsuario(String usuario) {
        app.findElement(By.id("com.lojinha:id/user")).click();
        app.findElement(By.id("com.lojinha:id/user")).findElement(By.id("com.lojinha:id/editText")).sendKeys(usuario);
        return this;
    }

    public LoginPage preencheCampoSenha(String senha) {
        app.findElement(By.id("com.lojinha:id/password")).click();
        app.findElement(By.id("com.lojinha:id/password")).findElement(By.id("com.lojinha:id/editText")).sendKeys(senha);
        return this;
    }

    public ProdutosPage clicaBotaoLogin() {
        app.findElement(By.id("com.lojinha:id/loginButton")).click();
        return new ProdutosPage(app);
    }
}
