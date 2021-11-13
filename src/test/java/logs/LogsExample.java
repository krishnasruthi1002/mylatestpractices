package logs;
import org.apache.logging.log4j.*;


public class LogsExample {

	private static Logger log= LogManager.getLogger(LogsExample.class.getName());
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		log.debug("Iam debbugging");
		log.error("Object is not present");
	}

}
