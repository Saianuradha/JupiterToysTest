package rough;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestClass {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Properties config =new Properties();
		Properties OR = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
		config.load(fis);
		fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
		OR.load(fis);
		
		
		
		
	}

}
