package assignment.test;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import assignment.pages.LogIn_Page;
import assignment.utility.BaseClass;
import assignment.utility.Dataadder;

public class Login_test extends BaseClass{
	LogIn_Page login;
	
	@DataProvider (name = "data")
	public Object [][] getsignupdata() throws Exception{
	       Object data [][] = Dataadder.getTestData("Signin");
	       return data;
}
	
	@SuppressWarnings("deprecation")
	@Test(dataProvider = "data")	
	public void Assign_Assessment_or_plan(String username, String password) throws Exception {
		login = new LogIn_Page(driver);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		login.gettittle();
		login.setusername(username);
		login.setpassword(password);
		login.click_login();
			
		
   }
	
}
