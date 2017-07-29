package study;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.subject.Subject;

public class test {

	public static void main(String[] args) {
		String pwd = new Sha256Hash("123", "SFC256").toString();

		// SHIRO login
		UsernamePasswordToken token = new UsernamePasswordToken("admin",
				pwd);
		Subject subject = SecurityUtils.getSubject();
		
		try	{
			subject.login(token);
		} catch (UnknownSessionException use) {
			// 解决超时重新登录后sessionid无效的问题
		    subject = new Subject.Builder().buildSubject();
		    subject.login(token);
		}
	}
}
