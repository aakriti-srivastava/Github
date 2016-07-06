package githubAPI;
import java.io.IOException;
import java.util.List;

import org.kohsuke.github.GHEventInfo;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

public class githubApi {
	
	public static void main(String args[]) {
		githubApi obj = new githubApi();
		obj.createRepoUsingApi();

		// obj.getmyself();

	}

	public void createRepoUsingApi()  {
		try {

			@SuppressWarnings("deprecation")
			GitHub github = GitHub.connectUsingPassword("aakriti-srivastava", "aakriti123");
			GHRepository repo = github.createRepository("Segment", "my first commit msg ", "xyz", true);
			repo.createContent("yo ", "i dont 9", "Segment/ram.txt ");
			System.out.println(repo.getFileContent("Segment/ram.txt"));
			System.out.println("this is the repo's UrL " + repo.getUrl());
			System.out.println(repo.getDescription());
			System.out.println("over");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void getmyself() {

		try {

			GitHub github = GitHub.connectUsingPassword("aakriti-srivastava", "aakriti123");
			// @SuppressWarnings("unused")
			// List<GHEventInfo> repo = github.getEvents();

			System.out.println(github.getMyself());
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		
		
	}
	
	
	
	

}
