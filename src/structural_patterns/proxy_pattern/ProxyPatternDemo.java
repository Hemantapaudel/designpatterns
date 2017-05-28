package structural_patterns.proxy_pattern;

import java.io.IOException;

/**
 *Sometimes we need the ability to control the access to an object. For example if we need to use only a few methods of some costly 
 *objects we'll initialize those objects when we need them entirely. Until that point we can use some light objects exposing the same
 *interface as the heavy objects. These light objects are called proxies and they will instantiate those heavy objects when they are 
 *really need and by then we'll use some light objects instead. 
 *
 */

interface CommandExecutor {
	public void runCommand(String cmd) throws Exception;
}

//REAL IMPLEMANTATION (REMOTE OBJECT)
class CommandExecutorImpl implements CommandExecutor {

	@Override
	public void runCommand(String cmd) throws IOException {
                //some heavy implementation
		Runtime.getRuntime().exec(cmd);
		System.out.println("'" + cmd + "' command executed.");
	}

}

// LOCAL IMPLEMANTATION OR PROXY IMPLEMENTATION
/**
 * Now we want to provide only admin users to have full access of above class, if the user is not admin then only limited commands
 * will be allowed. Here is our very simple proxy class implementation.
 *  
 * @author Hemanta
 *
 */
class CommandExecutorProxy implements CommandExecutor {

	private boolean isAdmin;
	private CommandExecutor executor;
	
	public CommandExecutorProxy(String user, String pwd){
		if("HPAUDEL".equals(user) && "PAUDEL".equals(pwd)) isAdmin=true;
		executor = new CommandExecutorImpl();
	}
	
	@Override
	public void runCommand(String cmd) throws Exception {
		if(isAdmin){
			executor.runCommand(cmd);
		}else{
			if(cmd.trim().startsWith("rm")){
				throw new Exception("rm command is not allowed for non-admin users.");
			}else{
				executor.runCommand(cmd);
			}
		}
	}

}

public class ProxyPatternDemo {
	public static void main(String[] args) {
		CommandExecutor executor = new CommandExecutorProxy("HPAUDEL", "PAUDE");
		try {
			//executor.runCommand("ls -ltr");
			executor.runCommand("rm -rf abc.pdf");
		} catch (Exception e) {
			System.out.println("Exception Message::"+e.getMessage());
		}

	}

}
