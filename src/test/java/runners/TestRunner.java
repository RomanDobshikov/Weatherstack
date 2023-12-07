package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = {"io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"},
    features = "src/test/resources/features",
    glue = {"stepdefinitions"}
)
public class TestRunner {

    @AfterClass
    public static void envProps() throws IOException {
        final String filePath = System.getProperty("user.dir") +
            "/target/allure-results/environment.properties";

        final File propsFile = new File(filePath);
        if (propsFile.exists()) {
            propsFile.delete();
        }

        FileOutputStream fos = new FileOutputStream(propsFile);

        Properties properties = new Properties();
        properties.setProperty("developer", "Roman Dobshikov");
        properties.setProperty("baseUrl", "https://weatherstack.com/");

        properties.store(fos, "allure runtime properties");
    }
}
