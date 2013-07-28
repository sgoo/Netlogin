import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class NetLoginCMD implements NetLoginListener {

	private NetLoginConnection conn;
	private Integer startingBytes = null;

	public NetLoginCMD() {
		conn = new NetLoginConnection(this);
	}

	public static void main(String[] paramArrayOfString) throws Exception {
		NetLoginCMD nlcmd = new NetLoginCMD();
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
	public void updateV3(int bytesUsed, int planType, boolean connected, String string) {
		if (startingBytes == null) {
			startingBytes = bytesUsed;
		}
		System.out.println("This Session " + kbToStr(bytesUsed - startingBytes) + " Total: " + kbToStr(bytesUsed));
	}

	public String kbToStr(double kb) {
		String unit = "KB";
		String[] units = { "KB", "MB", "GB", "TB" };
		int i;
		for (i = 0; i < units.length; i++) {
			if (kb > 1000) {
				kb /= 1024;
				unit = units[i + 1];
			} else {
				break;
			}
		}
		return kb > 10 ? String.format("%3.0f%s", kb, unit) : String.format("%3.1f%s", kb, unit);
	}
}

/*
 * Location: C:\Documents and Settings\Josh\Desktop\JNetLogin.jar Qualified
 * Name: NetLogin JD-Core Version: 0.6.2
 */