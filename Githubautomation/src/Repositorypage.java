import java.util.Scanner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Repositorypage {

	WebDriver driver ; 
	Repositorypage(WebDriver driver)
	{
		this.driver= driver ; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css= ".btn.btn-sm.btn-primary")
	WebElement createrepobtn ; 
	
	@FindBy(css=" #repository_name ")
	WebElement reponametextfield;
	
	@FindBy(css= "#repository_description ")
	WebElement descriptionfield ;
	
	@FindBy(css="#repository_auto_init")
	WebElement autoclonecheckbox ;
	
	@FindBy(css = " .btn.btn-primary.first-in-line")
	WebElement createrepobtn2;
	/* ............................... */
	
	public void CreateRepoActivity()
	{
		createrepobtn.click();	
	}
	
	
	public void NameRepoctivty(String in )
	{
	reponametextfield.sendKeys(in);
	}
	
	
	public void RepoDescriptionActivity (String ins)
	{ 
		descriptionfield.sendKeys(ins);
		
	}
	
	
	public void Autocloning()
	{
		autoclonecheckbox.click();
		
	}
	
	public void CreateRepoActivity2()
	{
		createrepobtn2.click();	
		String activityURL = driver.getCurrentUrl();
		

	}
	
	
	
	
	
}
