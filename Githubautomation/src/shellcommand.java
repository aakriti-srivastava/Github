
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.*;
import java.lang.ProcessBuilder;

	public class shellcommand {
		private static String output(InputStream inputStream) throws IOException {
			StringBuilder sb = new StringBuilder();
			BufferedReader br = null;
			try {
				br = new BufferedReader(new InputStreamReader(inputStream));
				String line = null;
				while ((line = br.readLine()) != null) {
					sb.append(line + System.getProperty("line.separator"));
				}
			} finally {
				br.close();
			}
			return sb.toString();
		}
		
		public String execCommand(String[] args) {
			try {
				ProcessBuilder pb = new ProcessBuilder(args);
				Process process = pb.start();
				process.waitFor();
				if(process.exitValue()==0){
					return shellcommand.output(process.getInputStream());
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch(Exception e){
				e.printStackTrace();
			}
			return null;
		}
	
	}
	
	
