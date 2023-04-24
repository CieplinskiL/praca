package Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Chrome;
import utils.WaitUtils;

public class LoginSteps {

    private final WebDriver driver = Chrome.getDriver();

    @Given("User is on main page")
    public void goToMainPage(){
        driver.navigate().to("http://localhost:3000/");
    }

    @Then("User switch to login form")
    public void switchTologinForm() {
        WaitUtils.sleep(3000);
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/button[1]"));
        loginButton.click();
        WaitUtils.sleep(3000);
        Assert.assertEquals("Logowanie", driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/h2")).getText());
    }

    @And("User enters login data and submit form")
    public void logInAsUser(){
      WebElement loginField = driver.findElement(By.xpath("//*[@id=\"1\"]"));
      loginField.sendKeys("test2@zz.pl");
      WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"2\"]"));
      passwordField.sendKeys("pass");
      WebElement submitLoginButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/input"));
      submitLoginButton.click();
    }

    @Then("User is on user page")
    public void checkUserPage(){
        WaitUtils.sleep(1500);
        Assert.assertEquals("http://localhost:3000/pasieki", driver.getCurrentUrl());
    }

    @And("User can logout")
    public void logout(){
        WebElement logoutButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[1]/div/div[3]/span[2]"));
        logoutButton.click();
        WaitUtils.sleep(1500);
        Assert.assertEquals("http://localhost:3000/", driver.getCurrentUrl());
    }


    @And("^User enters login data and submit form with password \"([^\"]*)\"$")
    public void logInWithPassowrdProvided(String password) {
        WebElement loginField = driver.findElement(By.xpath("//*[@id=\"1\"]"));
        loginField.sendKeys("test2@zz.pl");
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"2\"]"));
        passwordField.sendKeys(password);
        WebElement submitLoginButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/input"));
        submitLoginButton.click();
    }

    @And("^User enters login data and submit form with password \"([^\"]*)\" and login \"([^\"]*)\"$")
    public void logInWithPassowrdProvidedAndLogin(String password, String login) {
        WebElement loginField = driver.findElement(By.xpath("//*[@id=\"1\"]"));
        loginField.sendKeys(login);
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"2\"]"));
        passwordField.sendKeys(password);
        WebElement submitLoginButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/input"));
        submitLoginButton.click();
    }

    @Then("User switch to register form")
    public void switchToRegisterForm() {
        WaitUtils.sleep(3000);
        WebElement registerButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/button[2]"));
        registerButton.click();
        WaitUtils.sleep(3000);
        Assert.assertEquals("Rejestracja", driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/h2")).getText());
    }

    @Then("^User enters register data and submit form with login \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void RegisterIn(String login, String password){
        WebElement loginField = driver.findElement(By.xpath("//*[@id=\"1\"]"));
        loginField.clear();
        loginField.sendKeys(login);

        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"2\"]"));
        passwordField.clear();
        passwordField.sendKeys(password);


        WebElement passwordFieldRepeat = driver.findElement(By.xpath("//*[@id=\"3\"]"));
        passwordFieldRepeat.clear();
        passwordFieldRepeat.sendKeys(password);


        WebElement submitRegisterButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/input"));
        submitRegisterButton.click();
        WaitUtils.sleep(500);

        driver.switchTo().alert().accept();

        WaitUtils.sleep(150);
        driver.switchTo().defaultContent();



    }






}
