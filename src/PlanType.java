import java.util.HashMap;

public class PlanType {
	private static HashMap<Integer, PlanType> planMap = new HashMap<Integer, PlanType>();

	static {
		new PlanType(16777216, "Staff");
		new PlanType(33554432, "Sponsored");
		new PlanType(50331648, "Undergraduate");
		new PlanType(67108864, "ExceededAllowance");
		new PlanType(83886080, "NoAccess");
		new PlanType(100663296, "Postgraduate");
	}
	@SuppressWarnings("unused")
	private int num;
	private String name;

	private PlanType(int num, String name) {
		this.num = num;
		this.name = name;

		planMap.put(num, this);
	}
	
	@Override
	public String toString(){
		return name;
	}

	public static PlanType getPlan(int num) {
		return planMap.get(num);
	}

}
