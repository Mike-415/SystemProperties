
class SystemPropertiesImplementer 
{

	/** Executes the option the user selected
	 *   @param option the option the user selected
	 *   @param stringArg the specific property the user may want
	 */
	private static void executeOption(int option, String stringArg)
	{
		SystemProperties sysProps = new SystemProperties();
		switch(option)
		{
			case 'p':
				System.out.println("\n"+sysProps.getProperties(stringArg));  
				break;
			case 'n':
				System.out.println("\nNumber of all properties: "+sysProps.propertyCount()+"\n");
				break;
			case 'l':
				System.out.println("\n"+sysProps.getProperties()); 
				break;
			case 'h':
				sysProps.help();
				break;
			case '?':
				System.err.println("You must choose either options -n, -l, -p <nameOfProperty>, or -h");
				sysProps.help();
				System.exit(0);
				break;
		}
	}
	
	public static void main(String[] args) 
	{
		//GetOpt is a class used for parsing the user's commands from the CLI
		GetOpt options = new GetOpt(args, "nlp:h");
		options.opterr(false);
		int usersOption = -1; 
		while((usersOption = options.getopt()) != -1)
		{
			String stringArg = options.getvalue(usersOption);
			executeOption(usersOption, stringArg);
		}	
	}
}
