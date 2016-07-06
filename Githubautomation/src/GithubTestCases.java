import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utility.Utility;
import githubAPI.githubApi;

import java.util.ArrayList;
import java.util.List;

public class GithubTestCases {
	githubApi obj;
	loginpage objlogin;
	Repositorypage objrepo;
	public static String cloneurl;
	File binaryPath = new File("/home/aakritisrivastava/Desktop/firefox (2)/firefox");
	FirefoxBinary ffbinary = new FirefoxBinary(binaryPath);
	FirefoxProfile ffProfile = new FirefoxProfile();
	public static WebDriver driver = null;
	cloningpage objclone;
	checkcommits objcommit;
	/* ............................... */

	@BeforeTest
	public void setup() {
		driver = new FirefoxDriver(ffbinary, ffProfile);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://github.com/");
	}

	// @Test(priority=0)
	public void loginActivityCase() {
		objlogin = new loginpage(driver);
		objlogin.reachsignin();
		objlogin.loginactivty();
		String expectedtitle = driver.getTitle();
		Assert.assertEquals("GitHub", expectedtitle);

	}

	@Test(priority=1)
	public void CreateRepo() {
		objlogin = new loginpage(driver);
		objlogin.reachsignin();
		objlogin.loginactivty();
		objrepo = new Repositorypage(driver);
		objrepo.CreateRepoActivity();
		objrepo.NameRepoctivty(Utility.getYamlValues("repositoryname"));
		objrepo.RepoDescriptionActivity(Utility.getYamlValues("description"));
		objrepo.Autocloning();
		objrepo.CreateRepoActivity2();
		String expectedtitle = driver.getCurrentUrl();
		System.out.println(expectedtitle);
		cloneurl = "https://github.com/aakriti-srivastava/" + Utility.getYamlValues("repositoryname");
		Assert.assertEquals("https://github.com/aakriti-srivastava/" + Utility.getYamlValues("repositoryname"),
				expectedtitle);

	}

	//@Test(priority = 2)
	public void Cloning() throws IOException {

		objlogin = new loginpage(driver);
		objlogin.reachsignin();
		objlogin.loginactivty();
		objrepo = new Repositorypage(driver);
		objrepo.CreateRepoActivity();
		objrepo.NameRepoctivty(Utility.getYamlValues("repositoryname"));
		objrepo.RepoDescriptionActivity(Utility.getYamlValues("description"));
		objrepo.Autocloning();
		objrepo.CreateRepoActivity2();
		String expectedtitle = driver.getCurrentUrl();
		System.out.println(expectedtitle);
		cloneurl = "https://github.com/aakriti-srivastava/" + Utility.getYamlValues("repositoryname") + ".git";
		Assert.assertEquals("https://github.com/aakriti-srivastava/" + Utility.getYamlValues("repositoryname"),
				expectedtitle);
		driver.get(cloneurl);
		objclone = new cloningpage(driver);
		objclone.fetchcloneurl();

	}

	
@Test(priority=4)
public void testshell3() {
		objlogin = new loginpage(driver);
		objlogin.reachsignin();
		objlogin.loginactivty();
		driver.get("https://github.com/aakriti-srivastava/" + Utility.getYamlValues("repositoryname"));
		System.out.println((new java.util.Date()).getTime());
		List<String> commands = new ArrayList<String>();
		commands.add("mkdir " + Utility.getYamlValues("repositoryname"));
		commands.add("cd " + Utility.getYamlValues("repositoryname"));
		commands.add("touch " + Utility.getYamlValues("filename"));
		commands.add("git init");
		commands.add("git remote add origin 'https://" + Utility.getYamlValues("username") + ":"
				+ Utility.getYamlValues("password") + "@github.com/" + Utility.getYamlValues("username") + "/"
				+ Utility.getYamlValues("repositoryname") + ".git'");
		commands.add("git add .");
		commands.add("git commit -m \"" + (new java.util.Date()).getTime() + "\"");
		commands.add("git pull origin master");
		commands.add("git push origin master");
		Utility.writeToFile("main/gitcommands.sh", commands);
		shellcommand gitCommands = new shellcommand();
		String[] str_arr = { "sh", "main/gitcommands.sh" };
		System.out.println(gitCommands.execCommand(str_arr));
		driver.get("https://github.com/aakriti-srivastava/" + Utility.getYamlValues("repositoryname"));
        
}



 //@Test(priority =5 )
public void testcommit() {
		objcommit = new checkcommits(driver);
		driver.get("https://github.com/aakriti-srivastava/ziyo1/commits/master");
		objcommit.fetchcommitid();
 }
 

 @Test(priority =6 )
 public void testApi() {

		githubApi obj = new githubApi();
		obj.createRepoUsingApi();
		obj.getmyself();
	
}


















	}
























