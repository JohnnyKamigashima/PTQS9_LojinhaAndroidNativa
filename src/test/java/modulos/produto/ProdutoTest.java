package modulos.produto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import modulos.produto.pages.LoginPage;
import modulos.produto.pojo.Configura;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

@DisplayName("Testes Mobile do Módulo de Produto")
 class ProdutoTest {
    WebDriver app;
    Configura config;
    String configJson = leArquivoJson("src/main/resources/json/config.json");


    public ProdutoTest() throws IOException {
    }

    String leArquivoJson(String caminho) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminho)));
    }

    @BeforeEach
    void setUp() throws JsonProcessingException, MalformedURLException {
        //Cria mapeador Jackson e coloca as informações do JSON dentro do config
        ObjectMapper mapper = new ObjectMapper();
        this.config = mapper.readValue(configJson, Configura.class);

        //Abrir o app
        DesiredCapabilities capacidades = new DesiredCapabilities();

        //capacidades.setCapability("appium:app", config.getApp());
        capacidades.setCapability("appium:deviceName", config.getDeviceName());
        capacidades.setCapability("appium:udid", config.getUdid());
        capacidades.setCapability("appium:platformName", config.getPlatformName());
        capacidades.setCapability("appium:appPackage", config.getAppPackage());
        capacidades.setCapability("appium:appActivity", config.getAppActivity());

        this.app = new RemoteWebDriver(new URL(config.getUrl()), capacidades);
        app.manage().timeouts().implicitlyWait(config.getImplicitWaitSeconds(), TimeUnit.SECONDS);
    }

    @AfterEach
    void tearDown() {
        app.quit();
    }

    @DisplayName("Validação de cadastro de produto com componente e com valor válido ")
    @ParameterizedTest(name = "Teste {index} - {displayName} R$ {1}")
    @CsvFileSource(resources = "/csv/massaProdutoValidoComponente.csv", numLinesToSkip = 1, delimiter = ';')
    @Order(0)
    void testProdutoValidoComponente(String nome, String valor, String cores, String componente, String quantidadeComponente, String resultadoEsperado)  {
        String resultado = new LoginPage((RemoteWebDriver) app)
                .preencheCampoUsuario(config.getUsuario())
                .preencheCampoSenha(config.getPassword())
                .clicaBotaoLogin()
                .clicaBotaoAdicionar()
                .preencheCampoNome(nome)
                .preencheCampoValor(valor)
                .preencheCampoCor(cores)
                .clicaBotaoSalvar()
                .clicaBotaoAdicionarComponente()
                .preencheCampoNomeComponente(componente)
                .preencheCampoQuantidadeComponente(quantidadeComponente)
                .clicaBotaoSalvarComponente()
                .obterMensagemSucesso();

        //Validar que a mensagem de valor inválido foi apresentada
        Assertions.assertEquals(resultadoEsperado,resultado);
    }

    @DisplayName("Validação de cadastro de produto com valor válido ")
    @ParameterizedTest(name = "Teste {index} - {displayName} R$ {1}")
    @CsvFileSource(resources = "/csv/massaProdutoValido.csv", numLinesToSkip = 1, delimiter = ';')
    @Order(1)
    void testProdutoValido(String nome, String valor, String cores, String componente, String quantidadeComponente, String resultadoEsperado)  {
        String resultado = new LoginPage((RemoteWebDriver) app)
                .preencheCampoUsuario(config.getUsuario())
                .preencheCampoSenha(config.getPassword())
                .clicaBotaoLogin()
                .clicaBotaoAdicionar()
                .preencheCampoNome(nome)
                .preencheCampoValor(valor)
                .preencheCampoCor(cores)
                .clicaBotaoSalvar()
                .obterMensagemSucesso();

        //Validar que a mensagem de valor inválido foi apresentada
        Assertions.assertEquals(resultadoEsperado,resultado);
    }
    @DisplayName("Validação de cadastro de produto com valor inválido ")
    @ParameterizedTest(name = "Teste {index} - {displayName} R$ {1}")
    @CsvFileSource(resources = "/csv/massaProdutoInvalido.csv", numLinesToSkip = 1, delimiter = ';')
    @Order(2)
    void testProdutoInvalido(String nome, String valor, String cores, String componente, String quantidadeComponente, String resultadoEsperado)  {
        String resultado = new LoginPage((RemoteWebDriver) app)
                .preencheCampoUsuario(config.getUsuario())
                .preencheCampoSenha(config.getPassword())
                .clicaBotaoLogin()
                .clicaBotaoAdicionar()
                .preencheCampoNome(nome)
                .preencheCampoValor(valor)
                .preencheCampoCor(cores)
                .clicaBotaoSalvar()
                .obterMensagemSucesso();
        //Validar que a mensagem de valor inválido foi apresentada
        Assertions.assertEquals(resultadoEsperado,resultado);
    }
}
