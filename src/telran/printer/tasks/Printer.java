package telran.printer.tasks;

public class Printer implements Runnable{
    int numberToPrint;
    int numberAmount;
    int portion;

    public Printer(int numberToPrint, int numberAmount, int portion) {
        this.numberToPrint = numberToPrint;
        this.numberAmount = numberAmount;
        this.portion = portion;
    }

    @Override
    public void run() {
        int count = numberAmount/portion;

        for (int i = 0; i < count; i++) {
            for (int j = 0; j < portion; j++) {
                System.out.print(numberToPrint);

            }
            System.out.println();

        }




    }
}
