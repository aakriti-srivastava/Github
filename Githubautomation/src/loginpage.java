/* Automation of GITHUB */


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {

	WebDriver driver ;
	 
	loginpage(WebDriver driver)
	{
		this.driver= driver ; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".btn.site-header-actions-btn.mr-2")
	WebElement signinbtn;
	
	@FindBy(css =" .btn.btn-primary.btn-block")
	WebElement login;
	
	@FindBy(css = " #login_field")
	WebElement username ;
	
	@FindBy(css = " #password")
	WebElement password ;
	
	
	/* ............................... */
	
	
    public void reachsignin()
	{
		driver.get("https://github.com/");
		signinbtn.click();
	}
       
      public void loginactivty()
       {
    	   username.sendKeys("aakriti-srivastava");
    	   password.sendKeys("aakriti123");   
    	   login.click();
       }
  
      
      
	
	
}
