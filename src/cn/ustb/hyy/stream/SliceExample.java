package cn.ustb.hyy.stream;

import java.util.List;

public class SliceExample {
	public static void main(String[] args) {
		List<Dish> menu = MenuGenerator.generateMenu();
		// takeWhile: collects any elements that are satisfied with the predicate and stop iterating when not satisfied
		System.out.println("takeWhile: ");
		menu.stream()
			.takeWhile(dish -> dish.getCalories() < 320)
			.forEach(System.out::println);
		// dropWhile: 
		System.out.println("dropWhile: ");
		menu.stream()
			.dropWhile(dish -> dish.getCalories() < 320)
			.forEach(System.out::println);
	}
}
