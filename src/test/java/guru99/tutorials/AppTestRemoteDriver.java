package guru99.tutorials;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;


import static org.testng.Assert.assertEquals;

public class AppTestRemoteDriver {

    protected WebDriver driver;

    @Test
    public void simpleTest() {
        //WebDriver driver = null;
        try {
            //File file = new File("/Applications/Google\\ Chrome.app/Contents/MacOS/Google\\ Chrome");
            System.setProperty("webdriver.chrome.driver", "/Applications/Google Chrome.app/Contents/MacOS/chromedriver"); //file.getAbsolutePath());
            driver = new ChromeDriver();
//            driver = new RemoteWebDriver(new URL("http://localhost:32771/wd/hub/"),
//                    DesiredCapabilities.chrome()) {
//            };
        } catch (NotFoundException e) {
            e.printStackTrace();
        }

        String eTitle = "Meet  Guru99 - Free Training Tutorials & Video for IT Courses";
        String aTitle = "";

        // запустить Chrome и перейти по адресу
        driver.get("http://www.guru99.com/");

        // разворачивает окно браузера
        driver.manage().window().maximize();

        // получить значение у тайтла страницы
        aTitle = driver.getTitle();

        // выполняем проверку
        assertEquals(aTitle, eTitle);

        // закрываем окно браузера
        driver.quit();
    }
}

