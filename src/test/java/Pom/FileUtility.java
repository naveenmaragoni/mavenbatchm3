package Pom;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {

	public String readFromProperties(String Key)
	{
		FileInputStream fis=null;
		try {
			 fis=new FileInputStream("./src/test/resources/Data.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties property=new Properties();
		try {
			property.load(fis);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return property.getProperty(Key);
		
	}
}
