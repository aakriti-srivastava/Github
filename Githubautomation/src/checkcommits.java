import java.util.Scanner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.FindElements;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class checkcommits {
	WebDriver driver ; 
	checkcommits(WebDriver driver)
	{
		this.driver= driver ; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css= ".sha.btn.btn-outline")
	WebElement commitid ;
	
	
	public void fetchcommitid()
	{
		commitid.getText();
		
	}
	
	
	
}
