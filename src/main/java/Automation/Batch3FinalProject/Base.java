package Automation.Batch3FinalProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base {
	WebDriver driver;
	public WebDriver initializeDriver() throws IOException
	{
		Properties prop=new Properties();
		FileInputStream fis =new FileInputStream("C:\\Users\\Priyanka Arora\\Downloads\\Batch3FinalProject\\src\\main\\java\\data.properties");
		prop.load(fis);
		String browser=prop.getProperty("browser");
		 if (browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\2024\\February\\chromedriver.exe");
			ChromeOptions option=new ChromeOptions();
			option.addArguments("--remote-allow-origins=*");
			driver=new ChromeDriver(option);
		}
		
		
		return driver;
		
	}
	public String getUrl() throws IOException
	{
		Properties prop=new Properties();
		FileInputStream fis =new FileInputStream("C:\\Users\\Priyanka Arora\\Downloads\\Batch3FinalProject\\src\\main\\java\\data.properties");
		prop.load(fis);
		String url=prop.getProperty("url");
		return url;
		
	}
	public void takeScreenshot(WebDriver driver,String path)
	{
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
        	String destinationFile = System.getProperty("user.dir")+"\\screenshots\\"+path+".png";
        	FileUtils.copyFile(scrFile,new File(destinationFile));
			//FileUtils.copyFile(scrFile, new File("./pageloadimage.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
			
		}
	}


}
