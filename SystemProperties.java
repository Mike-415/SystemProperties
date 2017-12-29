
import java.util.Enumeration;
import java.util.Properties;

public class SystemProperties 
{
	/** Gets either all or some specific properties of the local host's computer
	 *   @param specificProperty specify a set of properties
	 *   @param none             indicates all properties
	 *   @return the properties indicated
	 */
	
    String getProperties(String...specificProperty)
	{
    	Properties properties = System.getProperties();
	    Enumeration keys = properties.keys();
	    String results = "";
	    while(keys.hasMoreElements())
	    {
	        String key = (String)keys.nextElement();
	        String value = (String)properties.getProperty(key);
	        if(specificProperty.length > 0)
	        {
	        	if(key.contains(specificProperty[0]))
	           {
	              results += key+":   "+value+"\n\n";
	           }
	        }
	        else
	        {
	        	results += key+":   "+value+"\n\n";
	        }
	     
	     }
	     if(results.length() <=1)
	     {
	    	 System.err.println("Invalid property name");
	     }
	     return results;
	}
	
    /** Get the total amount of all properties
     * @return the property count
     */
	int propertyCount()
	{
		return System.getProperties().size();
	}
	
	/** Displays the help option
	 */
	void help()
	{
		System.out.println("\nPlease choose one of the following options:");
		System.out.println("   General options:");
		System.out.println("\t'-n': The number of all properties");
		System.out.println("\t'-l': The list of all properties");
		System.out.println("\t'-h': Help menu");
		System.out.println("   Specific options:");
		System.out.println("\t'-p <property-name>' : Properties that contain the String argument ");
		System.out.println("\t                       following the option\n");
	}
	

}
