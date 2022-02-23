package core;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>() {
        @Override
        protected synchronized WebDriver initialValue() {
            return initDriver();
        }
    };

    private DriverFactory() {
    }

    public static WebDriver getDriver() {
        return threadDriver.get();
    }

    public static WebDriver initDriver() {
        WebDriver driver = null;
        if (Propriedades.TIPO_EXECUCAO == Propriedades.TipoExecucao.LOCAL) {
            if (driver == null) {
                switch (Propriedades.BROWSER) {
                    case FIREFOX:
                        driver = new FirefoxDriver();
                        break;
                    case CHROME:
                        driver = new ChromeDriver();
                        break;
                }
            }
        }
        if (Propriedades.TIPO_EXECUCAO == Propriedades.TipoExecucao.GRID) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            switch (Propriedades.BROWSER) {
                case FIREFOX:
                    capabilities.setBrowserName("firefox");
                    capabilities.setPlatform(Platform.WINDOWS);
                    break;
                case CHROME:
                    capabilities.setBrowserName("chrome");
                    capabilities.setPlatform(Platform.WINDOWS);
                    break;
            }
            try {
                driver = new RemoteWebDriver(new URL("http://192.168.0.106:4444/wd/hub"), capabilities);
            } catch (MalformedURLException e) {
                System.err.println("Falha ao conectar com GRID");
                e.printStackTrace();
            }
        }
        driver.manage().window().maximize();
        return driver;
    }

    public static void killDriver() {
        WebDriver driver = getDriver();
        if (driver != null) {
            driver.quit();
            driver=null;
        }
        if (threadDriver != null) {
            threadDriver.remove();
        }
     }
}

