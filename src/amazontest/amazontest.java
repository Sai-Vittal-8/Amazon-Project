package amazontest;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class amazontest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.in/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
		searchbox.click();

		searchbox.sendKeys("Samsung mobiles");

		WebElement search = driver.findElement(By.id("nav-search-submit-button"));

		search.click();

		List<WebElement> Productname = driver.findElements(By.xpath("//div[@class='a-section']//h2//span"));
		System.out.println(Productname.size());
		List<WebElement> Productprice = driver.findElements(By.xpath(
				"//div[@data-component-type='s-search-result']//div[contains(@class,'price')]//span[@class='a-price-whole']"));

		System.out.println(Productprice.size());

		for (int i = 0; i < Productname.size(); i++) {

			System.out.println("Product name is:" + Productname.get(i).getText());
			System.out.println("Product name is:" + Productprice.get(i).getText());
		}
		TakesScreenshot tsObj = (TakesScreenshot) driver;
		File fileObj = tsObj.getScreenshotAs(OutputType.FILE);
		File screenshotObj = new File("src/amazontest/image.png");
		
		FileUtils.copyFile(fileObj,screenshotObj);

		driver.close();

	}

}
