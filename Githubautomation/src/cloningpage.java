import java.util.Scanner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class cloningpage {
	
	WebDriver driver ; 
	cloningpage(WebDriver driver)
	{
		this.driver= driver ; 
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(css= ".btn.btn-sm.btn-primary.select-menu-button.js-menu-target" )
	WebElement cloneurlbtn ;
	
	@FindBy(css=" .clone-options:nth-child(1) .js-zeroclipboard")
	WebElement copybtn ;
	
	
	
	public void fetchcloneurl()
	{
		cloneurlbtn.click();
		copybtn.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
