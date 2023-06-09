package assignment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LogIn_Page {
	
public WebDriver driver;
	
    @FindBy(xpath="//h4[normalize-space()='Login Form']")
    private WebElement tittle;
	@FindBy(xpath="//input[@id='username']")
	private WebElement username;
	@FindBy(xpath="//input[@id='password']")
	private WebElement password;
	@FindBy(xpath="//button[@id='log-in']")
	private WebElement login_button;
	
	@FindBy(xpath="(//div[@id='random_id_9'])[1]")
	private WebElement error_msg;
	
	 @FindBy(xpath="//a[@id='showExpensesChart']")
	  private WebElement heading;
	
	public LogIn_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	public void gettittle() throws Exception {
		String actual = tittle.getText();
		String expected = "Login Form";
		Assert.assertEquals(actual,expected);  
		System.out.println("==== Assert Passed ====");
	}
	public void setusername(String name) throws Exception {
		username.sendKeys(name);
		System.out.println("==== User Name Provided in text box====");
	}
	
	public void setpassword(String pass) throws Exception {
		password.sendKeys(pass);
		System.out.println("==== Password Provided in text box====");
	}
	
	public void click_login() throws Exception {
		login_button.click();
		System.out.println("==== Clicked on login button====");
		   
		        try  
		        {  
		        	System.out.println(error_msg.getText());
		        }  
		            //handling the exception  
		        catch(Exception e)  
		        {  
			String actual = heading.getText();
		    String expected = "Compare Expenses";
		    Assert.assertEquals(actual,expected);  
		    System.out.println("==== Assert Passed ====");
	}
 }
	
}
