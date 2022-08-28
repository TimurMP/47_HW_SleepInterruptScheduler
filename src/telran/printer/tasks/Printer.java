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

        try {
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        int count = numberAmount/portion;

        for (int i = 0; i < count; i++) {
            for (int j = 0; j < portion; j++) {
                System.out.print(numberToPrint);

            }
            System.out.println();

        }




    }
}
