package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Logincreate {

	public static void main(String[] args) {
		WebDriver driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888/");
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("Mounikas");
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		 String acttext = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		 if(acttext.contains("Mounikas ")) {
			 System.out.println("Tc is passed");
		 }
			 
			 else {
				 System.out.println("Tc is failed");
				 }
		 WebElement adelement = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions a=new Actions(driver);
		a.moveToElement(adelement).perform();
		
		
		
		

	}

}
