
public interface NetLoginListener {

	void update(int IPBalance, boolean onPeak, boolean connected);

	void updateV3(int bytesUsed, int planType, boolean connected, String string);

}
