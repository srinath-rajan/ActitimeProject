package Com.Actitime.TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Com.Actitime.GenericLibrary.Baseclass;
import Com.Actitime.GenericLibrary.FileLibrary;
import Com.Actitime.GenericLibrary.ListenerImplementation;
import Com.Actitime.pom.Homepage;
import Com.Actitime.pom.Taskpage;
@Listeners(ListenerImplementation.class)
public class CreateCustomer extends Baseclass {
		FileLibrary f = new FileLibrary();
	@Test
	public void createCustomer() throws EncryptedDocumentException, IOException {
		Homepage hp = new Homepage(driver);
		hp.getTasksele().click();
		
		Taskpage tp = new Taskpage(driver);
		tp.getAddnewbtn().click();
		tp.getNewcust().click();
		String name = f.readDataFromExcelFile("StudentsData", 4, 1);
		tp.getCustname().sendKeys(name);
		String desp = f.readDataFromExcelFile("StudentsData", 5, 2);
		tp.getCustdesp().sendKeys(desp);
		tp.getCreatecustbtn().click();
		String ExpectedResult = name;
		String ActualResult = driver.findElement(By.xpath("(//div[.='"+name+"'])[1]")).getText();
		SoftAssert s = new SoftAssert();
		s.assertEquals(ExpectedResult, ActualResult);
		Reporter.log("Testscript Passed Successfully", true);
		s.assertAll();
				
				
		

	}

}
