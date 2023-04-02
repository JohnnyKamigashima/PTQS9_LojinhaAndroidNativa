package modulos.produto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AdicionarProdutosPage extends BasePage{
   public AdicionarProdutosPage(RemoteWebDriver app) {
       super(app);
   }

   public AdicionarProdutosPage preencheCampoNome(String nome) {
       app.findElement(By.id("com.lojinha:id/productName")).click();
       app.findElement(By.id("com.lojinha:id/productName"))
               .findElement(By.id("com.lojinha:id/editText")).sendKeys(nome);
       return this;
   }

   public AdicionarProdutosPage preencheCampoValor(String valor) {
       app.findElement(By.id("com.lojinha:id/productValue")).click();
       app.findElement(By.id("com.lojinha:id/productValue"))
               .findElement(By.id("com.lojinha:id/editText")).sendKeys(valor);
       return this;
   }

   public AdicionarProdutosPage preencheCampoCor(String cor) {
       app.findElement(By.id("com.lojinha:id/productColors")).click();
       app.findElement(By.id("com.lojinha:id/productColors"))
               .findElement(By.id("com.lojinha:id/editText")).sendKeys(cor);
       return this;
   }

   public AdicionarProdutosPage clicaBotaoSalvar() {
       app.findElement(By.id("com.lojinha:id/button")).click();
       return this;
   }

   public AdicionarProdutosPage clicaBotaoAdicionarComponente() {
       app.findElement(By.id("com.lojinha:id/addComponentButton")).click();
       return this;
   }

   public AdicionarProdutosPage preencheCampoNomeComponente(String nome) {
       app.findElement(By.id("com.lojinha:id/componentName")).click();
       app.findElement(By.id("com.lojinha:id/componentName"))
               .findElement(By.id("com.lojinha:id/editText")).sendKeys(nome);
       return this;
   }

   public AdicionarProdutosPage preencheCampoQuantidadeComponente(String quantidade) {
       app.findElement(By.id("com.lojinha:id/componentQuantity")).click();
       app.findElement(By.id("com.lojinha:id/componentQuantity"))
               .findElement(By.id("com.lojinha:id/editText")).sendKeys(quantidade);
       return this;
   }

   public AdicionarProdutosPage clicaBotaoSalvarComponente() {
       app.findElement(By.id("com.lojinha:id/saveComponentButton")).click();
       return this;
   }

   public String obterMensagemSucesso() {
       return app.findElement(By.xpath("//android.widget.Toast")).getText();
   }
}
