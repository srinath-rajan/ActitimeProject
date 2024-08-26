package Com.Actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	
	//declaration
	
	@FindBy(xpath = "//div[.='Tasks']")
	private WebElement tasksele;
	
	@FindBy(xpath = "//div[.='Time-Track']")
	private WebElement timeele;
	
	@FindBy(xpath = "//div[.='Reports']")
	private WebElement reportsele;
	
	@FindBy(xpath = "//div[.='Users']")
	private WebElement Usersele;
	
	@FindBy(id = "logoutLink")
	private WebElement logoutlnk;
	
	//Initialization
	public Homepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Utilization

	public WebElement getTasksele() {
		return tasksele;
	}

	public WebElement getTimeele() {
		return timeele;
	}

	public WebElement getReportsele() {
		return reportsele;
	}

	public WebElement getUsersele() {
		return Usersele;
	}

	public WebElement getLogoutlnk() {
		return logoutlnk;
	}
	

	

}
