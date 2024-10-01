package SLM.project2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class a10Iframe {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://syntaxprojects.com/handle-iframe-homework.php");

        // focusing on second iframe
        driver.switchTo().frame(1);
        driver.switchTo().frame(0);

        //1. getting Age button and clicking on it
        WebElement ageBtn= driver.findElement(By.xpath("//input[@class='cb1-element']"));
        ageBtn.click();

        driver.switchTo().defaultContent(); //gets you to the main page
        driver.switchTo().frame(1); //we have to go again to the second frame
        //2. Getting the City DD
        WebElement cityDD= driver.findElement(By.xpath("//select[@id='cities']"));
        Select sel= new Select(cityDD);
        sel.selectByIndex(2);

        driver.switchTo().defaultContent();
        driver.switchTo().frame(0);

        //locating Username textbox
        WebElement username= driver.findElement(By.xpath("//input[@name='Username']"));
        username.sendKeys("username12345");





    }
}