package SLM.project2;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class a9Alerts {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://syntaxprojects.com/javascript-alert-box-demo-homework.php");

        //1. Clicking on the Birthday reminder button
        WebElement birthdayBtn= driver.findElement(By.xpath("//button[@onclick='myAlertFunction()']"));
        birthdayBtn.click();
        //adding thread to be able to see the click
        Thread.sleep(2000);

        //switching the focus to the alert and accepting it
        Alert alert=driver.switchTo().alert();
        alert.accept();

        //2. Clicking on Delete File button and dismissing alert
        WebElement deleteBtn= driver.findElement(By.xpath("//button[@onclick='myConfirmFunction()']"));
        deleteBtn.click();
        Thread.sleep(2000);
        //changing the focus of the driver to the Alert
        alert.dismiss();

        //printing the message that appears
        WebElement text= driver.findElement(By.xpath("//p[text()='You pressed Cancel!']"));
        System.out.println(text.getText());

        //3. Clicking Enter your name button
        WebElement nameBtn= driver.findElement(By.xpath("//button[text()='Enter Your Name']"));
        nameBtn.click();

        //providing a name and accepting alert
        String nameEntered="My name";
        alert.sendKeys(nameEntered);
        alert.accept();


        //retrieving the name that appears on the UI and printing in console
        WebElement textEntered= driver.findElement(By.xpath("//p[contains(text(),'You have entered')]"));
        String textRetrieved=textEntered.getText();
        System.out.println(textRetrieved);

        //Verifying that the correct name is displayed
        if (("You have entered '"+nameEntered+"' !").equals(textRetrieved)){
            System.out.println("The name displayed in the UI is correct");
        }else {
            System.out.println("The name displayed in the UI is incorrect");
        }












    }
}