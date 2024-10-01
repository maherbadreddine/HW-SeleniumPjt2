package SLM.project2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class a8MultipleDropDown {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(" https://syntaxprojects.com/basic-select-dropdown-demo-homework.php");

        //1. using Select class to select option Pear
        WebElement fruitDD= driver.findElement(By.xpath("//select[@id='fav_fruit_selector']"));
        Select sel=new Select(fruitDD);
        sel.selectByValue("Pear");

        //getting all the options from the DD
        List<WebElement> allOptions=sel.getOptions();
        //printing all the options
        allOptions.forEach(x->
                System.out.println(x.getText()));
        System.out.println();

        //2.
        WebElement hobbiesDD= driver.findElement(By.xpath("//select[@id='select_multi_hobbies']"));
        Select sel2=new Select(hobbiesDD);
        if(sel2.isMultiple()){
            sel2.selectByIndex(1);
            sel2.selectByVisibleText("Cooking");
            sel2.selectByValue("Gardening");

            WebElement getAllBtn= driver.findElement(By.xpath("//button[@id='get_all']"));
            getAllBtn.click();

            //getting all the options from the hobbies DD
            List<WebElement> hobbiesOptions=sel2.getOptions();
            hobbiesOptions.forEach(x->
                    System.out.println(x.getText()));
            System.out.println();

            Thread.sleep(5000);
            sel2.deselectByIndex(1);

            getAllBtn.click();
            hobbiesOptions.forEach(x->
                    System.out.println(x.getText()));
        }
    }
}