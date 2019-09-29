package lms.genericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileUtils 
{
	/*Declare the path of property file*/
   String data="./Data/CommonProperties.property.txt";
   /*Declare the method to fetch the data from property file*/
   public Properties getPropertyData() throws IOException
	{
	FileInputStream fis= new FileInputStream(data);
	Properties pObj= new Properties();
	pObj.load(fis);
	return pObj;
	}

}
