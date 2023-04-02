package modulos.produto.pages;

import org.openqa.selenium.remote.RemoteWebDriver;

public class BasePage {
    protected RemoteWebDriver app;
    public BasePage(RemoteWebDriver app) {
        this.app = app;
    }
}
