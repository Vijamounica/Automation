package Generic_Utility;

import java.io.FileInputStream;
import java.util.Properties;

public class Property_file_utility {
public String readdatafrompropertyfile(String key) throws Throwable {
	FileInputStream FIS=new FileInputStream(Iconstant_utility.propertypath);
	Properties P=new Properties();
	P.load(FIS);
	String value = P.getProperty(key);
	return value;
}
}
