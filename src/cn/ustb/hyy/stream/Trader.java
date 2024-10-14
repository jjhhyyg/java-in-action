package cn.ustb.hyy.stream;

public class Trader {
	private final String name;
	private final String city;
	public Trader(String n, String c) {
		this.name = n;
		this.city = c;
	}
	public String getName() {
		return name;
	}
	public String getCity() {
		return city;
	}
	@Override
	public String toString() {
		return "Trader: %s in %s".formatted(name, city);
	}
}
