package modulos.produto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ProdutosPage extends BasePage{
    public ProdutosPage(RemoteWebDriver app) {
        super(app);
    }

    public AdicionarProdutosPage clicaBotaoAdicionar() {
        //Abrir o formulario de novo produto
        app.findElement(By.id("com.lojinha:id/floatingActionButton")).click();
        return new AdicionarProdutosPage(app);
    }

}
