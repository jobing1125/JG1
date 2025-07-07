package pkg;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class Google {
	ChromeDriver driver=new ChromeDriver();


	@Before
	public void setup() throws InterruptedException
	{
		 
		ChromeDriver driver=new ChromeDriver();
	Actions ac=new Actions(driver);
		driver.manage().window().maximize();
	
		driver.get("https://demoqa.com/droppable/");
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,550)");
		Thread.sleep(4000);
		WebElement drag=driver.findElement(By.xpath("//*[contains(text(),'Drag me')]"));
		WebElement drop=driver.findElement(By.xpath("//div[@id='droppable']"));
		ac.dragAndDrop(drag, drop);
		ac.perform();
		driver.quit();
				driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
		Actions act=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement menu=driver.findElement(By.xpath("//a[contains(text(),'Electronics')][1]"));
		WebElement submenu=driver.findElement(By.xpath("//a[contains(text(),'Computers and tablets')]"));
		act.moveToElement(menu).perform();
		Thread.sleep(2000);
		act.moveToElement(submenu).click();
		act.perform();
		
		
//		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
//		driver.manage().window().maximize();
		
		//Actions act=new Actions(driver);
		WebElement right=driver.findElement(By.xpath("//span[contains(text(),'right click me')]"));
		act.contextClick(right);
		Thread.sleep(2000);
		act.perform();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[text() = 'Edit']")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept()	;	
		WebElement db=driver.findElement(By.xpath("//*[contains(text(),'Double-Click Me To See Alert')]"));
		Thread.sleep(2000);
		act.doubleClick(db);
		act.perform();
//		driver.get("https://qa-web.gymhub.com/sign-in");
//		driver.manage().window().maximize();
	}
	@Test
	public void titleValidation()
	{
		
		String actualtitle=driver.getTitle();
		System.out.println(actualtitle);
		String Expect=driver.getTitle();
		if(actualtitle.equalsIgnoreCase(Expect))
			
				{
			System.out.println("Landing page succesfully launched");
				}
		else
			{
			System.out.println("Landing page is not succesfully launced");	
			}
	}
	@After
	
		public void end() throws InterruptedException, IOException
	
		{
		
		driver.findElement(By.xpath("//*[contains(text(),' Register')]")).click();
		Thread.sleep(5000);
		WebElement firstname=driver.findElement(By.xpath("/html/body/app-root/gogym/div/app-basic-info/div/form/div[1]/p[1]/input"));
		firstname.sendKeys("Arjun");
		WebElement Secondname=driver.findElement(By.xpath("/html/body/app-root/gogym/div/app-basic-info/div/form/div[1]/p[2]/input"));
		WebElement Businessname=driver.findElement(By.xpath("/html/body/app-root/gogym/div/app-basic-info/div/form/p[1]/input"));
		
		Actions act=new Actions(driver);
		Thread.sleep(2000);
		act.keyDown(firstname,Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL);
		act.keyDown(firstname, Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL);
		act.keyDown(Secondname, Keys.CONTROL).sendKeys("V");
		act.keyDown(Businessname, Keys.CONTROL).sendKeys("V");
		act.perform();
		driver.findElement(By.xpath("//*[contains(@placeholder,'Enter your email')]")).sendKeys("jobin.george@vensure.com");	
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//img[contains(@class,'logo')]")).click();
		WebElement username=driver.findElement(By.xpath("//input[contains(@placeholder,'Enter your username')]"));
		Thread.sleep(2000)
;		username.sendKeys("jobin.george@vensure.com");
		
		driver.findElement(By.xpath("//*[contains(@type,'password')]")).sendKeys("Abcd@123");
		driver.findElement(By.xpath("//*[contains(text(),' Log In ')]")).click();
//		String text=driver.findElement(By.xpath("//*[contains(@class,'add-icon-svg')]")).getText();
//		System.out.println("button name"+text);
//		if(text.equalsIgnoreCase(" Manual Check-In "))
//		{
//			System.out.println("same text");
//		}
//		else
//		{
//			System.out.println("not same text visible");
//		}
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,550)");
		File screen=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(screen,new File("C:\\Users\\Jobin.George\\OneDrive - Employer Solutions\\Pictures\\home.png"));
		
		List <WebElement> l=driver.findElements(By.tagName("a"));
		System.err.println(l.size());
		// driver.close();
				}
	}


