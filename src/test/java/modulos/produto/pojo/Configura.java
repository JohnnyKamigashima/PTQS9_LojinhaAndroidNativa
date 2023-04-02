package modulos.produto.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Configura {

    private String deviceName;
    private String udid;
    private String platformName;
    private String appPackage;
    private String appActivity;
    private String url;
    private String app;
    private int implicitWaitSeconds;
    private String usuario;
    private String password;


    public String getUsuario() {
        return usuario;
    }


    public String getPassword() {
        return password;
    }


    public String getUrl() {
        return url;
    }


    public String getApp() {
        return app;
    }


    public int getImplicitWaitSeconds() {
        return implicitWaitSeconds;
    }


    public String getDeviceName() {
        return deviceName;
    }


    public String getUdid() {
        return udid;
    }


    public String getPlatformName() {
        return platformName;
    }


    public String getAppPackage() {
        return appPackage;
    }


    public String getAppActivity() {
        return appActivity;
    }



}
