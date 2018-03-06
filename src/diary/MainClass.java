package diary;

public class MainClass {

    public static void main(String[] args) {

        SQLHandler.connect();
        TransactionBus transactionBus = new TransactionBus();
        System.out.println("Starting time is " + transactionBus.getStartTime());
    }
}
