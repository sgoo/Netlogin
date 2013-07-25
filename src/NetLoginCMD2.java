import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class NetLoginCMD2 implements NetLoginListener {

	private NetLoginConnection conn;

	public NetLoginCMD2() {
		conn = new NetLoginConnection(this);
	}

	public static void main(String[] paramArrayOfString) throws Exception {
		NetLoginCMD2 nlcmd = new NetLoginCMD2();
		Properties p = new Properties();
		p.load(new FileInputStream("config.prop"));
		nlcmd.login(p);
	}

	public void login(Properties p) throws IOException {
		conn.login(p.getProperty("username"), p.getProperty("password"));
	}

	@Override
	public void update(int IPBalance, boolean onPeak, boolean connected) {
		System.out.println("IPBalance" + IPBalance);
		System.out.println("onPeak" + onPeak);
		System.out.println("connected" + connected);
	}

	@Override
	public void updateV3(int bytesUsed, int planType, boolean connected,
			String string) {
		System.out.println("bytesUsed" + bytesUsed);
		System.out.println("planType" + planType);
		System.out.println("connected" + connected);
		System.out.println("string" + string);
	}

}

/*
 * Location: C:\Documents and Settings\Josh\Desktop\JNetLogin.jar Qualified
 * Name: NetLogin JD-Core Version: 0.6.2
 */