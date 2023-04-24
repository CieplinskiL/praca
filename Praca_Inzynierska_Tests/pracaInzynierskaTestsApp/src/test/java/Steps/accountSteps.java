package Steps;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Chrome;
import utils.WaitUtils;

public class accountSteps {
    private final WebDriver driver = Chrome.getDriver();



//    //*[@id="root"]/div[1]/div[1]/div/div[3]/span[1]/p

    @Then("User goes to account page")
    public void goToUserPageFromMainPage() {
        WebElement accountButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[1]/div/div[3]/span[1]/p"));
        WaitUtils.clickAndWait(accountButton,200);
    }

    @Then("User Changes credentials")
    public void changeCredentials() {
        WebElement accountButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[2]/button[1]"));
        WaitUtils.clickAndWait(accountButton,200);

        WebElement name = driver.findElement(By.xpath("//*[@id=\"1\"]"));
        name.clear();
        name.sendKeys("Selenium");

        WebElement surname = driver.findElement(By.xpath("//*[@id=\"2\"]"));
        surname.clear();
        surname.sendKeys("Selenium2");

        WebElement saveAccountData = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[2]/form/input"));
        WaitUtils.clickAndWait(saveAccountData,200);

        Assert.assertEquals("Imie: Selenium", driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div/h2[1]")).getText());
        Assert.assertEquals("Nazwisko: Selenium2", driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div/h2[2]")).getText());

    }

    @Then("Send illness notification")
    public void sendIllnessNotification() {
        WebElement accountButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[2]/button[3]"));
        WaitUtils.clickAndWait(accountButton,200);
        Assert.assertEquals("Powiadamianie o zgnilcu", driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[2]/h1")).getText());


        WebElement sendNotification = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[2]/form/input"));
        WaitUtils.clickAndWait(sendNotification,200);

        Assert.assertEquals("Poinformuj społeczność", driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[2]/h2")).getText());


    }

    @Then("^ChangePassword to \"([^\"]*)\"$")
    public void changePassowrd(String password) {
        WebElement changePassowrd = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[2]/button[2]"));
        WaitUtils.clickAndWait(changePassowrd,200);

        WebElement input1 = driver.findElement(By.xpath("//*[@id=\"1\"]"));
        input1.sendKeys("pass");

        WebElement input2 = driver.findElement(By.xpath("//*[@id=\"2\"]"));
        input2.sendKeys(password);

        WebElement input3 = driver.findElement(By.xpath("//*[@id=\"3\"]"));
        input3.sendKeys(password);

        WebElement changePassowrdSave = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[2]/form/input"));
        WaitUtils.clickAndWait(changePassowrdSave,500);

        driver.switchTo().alert().accept();

        WaitUtils.sleep(150);
        driver.switchTo().defaultContent();

    }


}
