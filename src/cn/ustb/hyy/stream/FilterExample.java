package cn.ustb.hyy.stream;

import java.util.List;

public class FilterExample {
	public static void main(String[] args) {
		List<Dish> menu = MenuGenerator.generateMenu();
		// menu.forEach(System.out::println);
		// Select 2 meat dishes
		menu.stream()
			.filter(dish -> dish.getType() == Dish.Type.MEAT)
			.limit(2)
			.forEach(System.out::println);
	}
}
