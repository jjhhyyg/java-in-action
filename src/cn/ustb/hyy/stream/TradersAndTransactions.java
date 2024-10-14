package cn.ustb.hyy.stream;

import java.util.List;
import java.util.Arrays;
import static java.util.Comparator.comparing;

public class TradersAndTransactions{
	public static void main(String[] args) {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		List<Transaction> transactions = Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710),
				new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950)
				);

		// 1. Find all transactions in 2011 and sort in value (from low to high)
		System.out.println();
		System.out.println("1. Find all transactions in 2011 and sort in value (from low to high): ");
		transactions.stream()
			.filter(transaction -> transaction.getYear() == 2011)
			.sorted(comparing(Transaction::getValue))
			.forEach(System.out::println);
		
		// 2. Find all cities where those traders worked
		System.out.println();
		System.out.println("2. Find all cities where those traders worked: ");
		transactions.stream()
			.map(transaction -> transaction.getTrader().getCity())
			.distinct()
			.forEach(System.out::println);

		// 3. Find all traders in Cambridge and sort in name
		System.out.println();
		System.out.println("3. Find all traders in Cambridge and sort in name: ");
		transactions.stream()
			.map(transaction -> transaction.getTrader())
			.filter(trader -> trader.getCity().equals("Cambridge"))
			.distinct()
			.sorted(comparing(Trader::getName))
			.forEach(System.out::println);

		// 4. Get all traders' name and sort in name: 
		System.out.println();
		System.out.println("4. Get all traders' name and sort in name: ");
		String s = transactions.stream()
			.map(transaction -> transaction.getTrader().getName())
			.distinct()
			.sorted((a, b) -> a.compareTo(b))
			.reduce("", (a, b) -> a + "," + b);
		System.out.println(s.substring(1));
		// 5. Is there any trader that works in Milan:
		System.out.println();
		System.out.println("5. Is there any trader that works in Milan: ");
		boolean isAnyTraderInMilan = transactions.stream()
			.anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
		System.out.println(isAnyTraderInMilan ? "There is 1 to many traders in Milan" : "There is no traders in Milan");

		// 6. Print the sum of transactions' value in Cambridge
		System.out.println();
		System.out.println("6. Print the sum of transactions' value in Cambridge: ");
		Integer sum = transactions.stream()
			.filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
			.map(Transaction::getValue)
			.reduce(0, Integer::sum);
		System.out.println("The sum of transactions' value in Cambridge is %d".formatted(sum));

		// 7. What is the highest value among all: 
		System.out.println();
		System.out.println("7. What is the highest value among all: ");
		transactions.stream()
			.map(Transaction::getValue)
			.reduce(Integer::max)
			.ifPresent(System.out::println);
		
		// 8. What is the lowest value among all: 
		System.out.println();
		System.out.println("8. What is the lowest value among all: ");
		transactions.stream()
			.map(transaction -> transaction.getValue())
			.reduce(Integer::min)
			.ifPresent(System.out::println);
	}
}
