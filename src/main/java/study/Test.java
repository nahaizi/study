package study;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.subject.Subject;

public class Test {
    private static Logger log = LogManager.getLogger(Test.class);
	public static void main(String[] args) {
		log.debug("-------------------------------begin------------------------");
		
		Parent pa = (Parent) new Son();
//		pa;
		
		String pwd = new Sha256Hash("123", "SFC256").toString();
		// SHIRO login
		UsernamePasswordToken token = new UsernamePasswordToken("admin",
				pwd);
		Subject subject = SecurityUtils.getSubject();
		
		try	{
			subject.login(token);
		} catch (UnknownSessionException use) {
			
		    subject = new Subject.Builder().buildSubject();
		    subject.login(token);
		}
	}
}
