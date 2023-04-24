package Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Chrome;
import utils.WaitUtils;

import java.util.Optional;

public class apiarySteps {

    private final WebDriver driver = Chrome.getDriver();

    @Then("User opens apiary creation form")
    public void openAddApiryForm(){
        WebElement addApiaryButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[2]/button"));
        WaitUtils.clickAndWait(addApiaryButton, 1000);
        Assert.assertEquals("Tworzenie Pasieki", driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[4]/h1")).getText());
    }

    @And("User insert data and submit apiary creation form")
    public void insertDataAndSubmitAddApiryForm(){
        WebElement nameInput = driver.findElement(By.xpath("//*[@id=\"1\"]"));
        nameInput.sendKeys("Selenium");
        WebElement submitAddApiaryFormButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[4]/form/input"));
        WaitUtils.clickAndWait(submitAddApiaryFormButton, 5000);
    }

    @Then("Apiary is created")
    public void checkCreatedPasieka(){
        Optional<WebElement> optionalApiary = driver.findElements(By.className("apiaryListEntry")).stream().filter(e -> e.findElement(By.tagName("p")).getText().equals("Pasieka: Selenium")).findFirst();
        WebElement apiary = null;
        if(optionalApiary.isPresent()){
            apiary = optionalApiary.get();
        }else{
            Assert.fail();
        }
        WaitUtils.clickAndWait(apiary,1000);
        Assert.assertEquals("Szczegóły pasieki", driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[4]/h1")).getText());
        Assert.assertEquals("Nazwa: Selenium", driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[4]/div/h2[1]")).getText());
//        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[4]/div/h2[2]")).getText().equals("Lokalizacja: Muranów") ||
//                                   driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[4]/div/h2[2]")).getText().equals("Lokalizacja: Warsaw"));
        Assert.assertEquals("Liczba uli: 0", driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[4]/div/h2[4]")).getText());
    }

    @Then("User deletes created apiary")
    public void deleteSelectedApiary() {
        WebElement apiaryDeleteButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[4]/button[2]"));
        WaitUtils.clickAndWait(apiaryDeleteButton, 500);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        WaitUtils.sleep(2000);
        alert = driver.switchTo().alert();
        alert.accept();
        WaitUtils.sleep(2000);
        Optional<WebElement> optionalApiary = driver.findElements(By.className("apiaryListEntry")).stream().filter(e -> e.findElement(By.tagName("p")).getText().equals("Pasieka: Selenium")).findFirst();
        if (optionalApiary.isPresent()) {
            Assert.fail();
        }
    }

    @And("User selects apiary selenium")
    public void selectApiarySelenium() {
        WebElement apiaryDetailsButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[4]/button[1]"));
        WaitUtils.clickAndWait(apiaryDetailsButton, 500);

    }


    @Then("User opens beehive creation form")
    public void openAddBeehiveForm(){
        WebElement addBeehiveButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[3]/button"));
        WaitUtils.clickAndWait(addBeehiveButton, 1000);
    }





    @Then("User inserts data and creates beehive SeleniumBeehive")
    public void createBeehive() {

        WebElement input1 = driver.findElement(By.xpath("//*[@id=\"1\"]"));
        input1.sendKeys("SeleniumBeehive");

        WebElement input2 = driver.findElement(By.xpath("//*[@id=\"2\"]"));
        input2.sendKeys("SeleniumAgresja");

        WebElement input3 = driver.findElement(By.xpath("//*[@id=\"3\"]"));
        input3.sendKeys("SeleniumKorpus");

        WebElement input4 = driver.findElement(By.xpath("//*[@id=\"4\"]"));
        input4.sendKeys("SeleniumRamki");

        WebElement input5 = driver.findElement(By.xpath("//*[@id=\"5\"]"));
        input5.sendKeys("SeleniumRasa");


        WebElement submitBeehive = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[5]/form/input"));
        WaitUtils.clickAndWait(submitBeehive, 5000);


    }
    @Then("User checks beehive data")
    public void checkBeehiveData() {
        WebElement thisBeehive = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[3]/div/div"));

        WaitUtils.clickAndWait(thisBeehive,1000);
        Assert.assertEquals("Nazwa: SeleniumBeehive", driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[5]/div/h2[1]")).getText());
        Assert.assertEquals("Poziom agresji: SeleniumAgresja", driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[5]/div/h2[2]")).getText());
        Assert.assertEquals("Rodzaj korpusu: SeleniumKorpus", driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[5]/div/h2[3]")).getText());
        Assert.assertEquals("Rodzaj ramek: SeleniumRamki",driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[5]/div/h2[4]")).getText());
        Assert.assertEquals("Liczba alertów: 1", driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[5]/div/h2[5]")).getText());
        Assert.assertEquals("Choroby: 0", driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[5]/div/h2[6]")).getText());


    }

    @Then("User adds food")
    public void addFood() {
        WebElement addFoodButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[4]/div[1]/span[2]/button[1]"));
        WaitUtils.clickAndWait(addFoodButton,200);

        WebElement input1 = driver.findElement(By.xpath("/html/body/div/div[1]/div[4]/form/div/input[1]"));
        input1.sendKeys("SeleniumPokarm");

        WebElement input2 = driver.findElement(By.xpath("/html/body/div/div[1]/div[4]/form/div/input[2]"));
        input2.sendKeys("1111");

        WebElement saveFood = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[4]/form/input"));
        WaitUtils.clickAndWait(saveFood,200);

        Assert.assertEquals("Pokarm: SeleniumPokarm (1111)", driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[4]/div[1]/span[1]/h2")).getText());

    }

    @Then("User adds Note")
    public void addNote() {

        WebElement noteButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[4]/div[1]/span[2]/img"));
        WaitUtils.clickAndWait(noteButton,200);
        Assert.assertEquals("Notatka Pasieki", driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[4]/h1")).getText());

        WebElement addNoteButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[4]/button[2]"));
        WaitUtils.clickAndWait(addNoteButton,200);

        WebElement calendarButtonInput = driver.findElement(By.xpath("//*[@id=\"1\"]"));
        calendarButtonInput.sendKeys("12.01.2023");

        WebElement addNoteBody = driver.findElement(By.xpath("//*[@id=\"3\"]"));
        addNoteBody.sendKeys("Selenium Notatka");
        WaitUtils.sleep(200);
        WebElement saveNote = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[4]/form/input"));
        WaitUtils.clickAndWait(saveNote,200);


        WebElement noteButtonAGAIN = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[4]/div[1]/span[2]/img"));
        WaitUtils.clickAndWait(noteButtonAGAIN,200);
        Assert.assertEquals("Selenium Notatka", driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[4]/textarea")).getText());


    }


    @Then("^User goes to Beehive details and add Scales api \"([^\"]*)\"$")
    public void addScales(String apiId){
        WebElement beehiveDetails = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[5]/button[1]"));
        WaitUtils.clickAndWait(beehiveDetails,150);

        WebElement addScalesButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[5]/button"));
        WaitUtils.clickAndWait(addScalesButton,150);



        WebElement input2 = driver.findElement(By.xpath("//*[@id=\"2\"]"));
        input2.sendKeys("SeleniumModel");

        WebElement input3 = driver.findElement(By.xpath("//*[@id=\"3\"]"));
        input3.sendKeys(apiId);

        WebElement createScales = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[5]/form/input"));
        WaitUtils.clickAndWait(createScales,150);



        WaitUtils.sleep(15000);

        Assert.assertEquals("SeleniumModel", driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[5]/div/h2[4]")).getText());

        WebElement weightGraph = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[5]/img"));
        WaitUtils.clickAndWait(weightGraph,150);

        Assert.assertEquals("Wykres Wagi", driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[3]/h1")).getText());



    }





}
