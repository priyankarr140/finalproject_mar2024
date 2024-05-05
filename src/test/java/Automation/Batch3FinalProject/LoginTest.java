package Automation.Batch3FinalProject;

import java.io.IOException;
import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.Login1;
import resources.Data;
import resources.ReadExcel;
public class LoginTest extends Base{
	WebDriver driver;
	private static Logger log=LogManager.getLogger(LoginTest.class.getName());
	
	@Test(dataProvider="getData")
	public void navigation(String username,String password) throws IOException
	{
		try {
		driver=initializeDriver();
		driver.get(this.getUrl());		
		log.info("URl launched");			
		Login1 l1=new Login1(driver);
		l1.loginInput().sendKeys(username);
		log.info("Username entered");
		l1.loginPassword().sendKeys(password);
		l1.loginBtn().click();
		//failing the test case
		Assert.assertEquals(driver.getTitle(),"Login | Salesforce");
		//Assert.assertTrue(true);
		}
		catch(Exception ex)
		{
			log.fatal(ex);	
		}		
		//asert to compare		
	}
	@DataProvider()
	public Object[][] getData() throws IOException
	{
		ReadExcel excelRead=new ReadExcel();
		ArrayList<Data>exelData=excelRead.getData();
		//DbConnect conn=new DbConnect();
		//ArrayList<String>dbdata=conn.dbconnection();
		Object[][] data=new Object[2][2];
		data[0][0]=exelData.get(0).getUsername();
		data[0][1]=exelData.get(0).getPassword();
		data[1][0]=exelData.get(1).getUsername();
		data[1][1]=exelData.get(1).getPassword();
		
		return data;
	}


}
