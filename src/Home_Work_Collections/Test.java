package src.Home_Work_Collections;

public class Test {
    public static void main(String[] args) {
        PhoneBook book = new PhoneBook();
        book.add("Холериус", 8763425);
        book.add("Петров", 6352537);
        book.add("Константинов", 4877624);
        book.add("Карпатов", 8746721);
        book.add("Колымов", 1283709);
        book.add("Иванов", 8734512);
        book.add("Карабелов", 8073472);

        book.get("Колымов");

    }
}
