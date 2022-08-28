package telran.printer.tasks;

public class Printer implements Runnable {
    int numberToPrint;
    int numberAmount;
    int portion;

    Thread nextThread;


    public void setNextThread(Thread nextThread) {
        this.nextThread = nextThread;
    }

    public Printer(int numberToPrint, int numberAmount, int portion) {
        this.numberToPrint = numberToPrint;
        this.numberAmount = numberAmount;
        this.portion = portion;
    }

    @Override
    public void run() {
        int count = numberAmount / portion;

        for (int i = 0; i < count; i++) {
            try {
                Thread.sleep(Long.MAX_VALUE);
            } catch (InterruptedException e) {
                for (int j = 0; j < portion; j++) {
                    System.out.print(numberToPrint);

                }
                System.out.println();
                nextThread.interrupt();

            }


        }
    }


    @Override
    public String toString() {
        return "Printer{" +
                "numberToPrint=" + numberToPrint +
                ", numberAmount=" + numberAmount +
                ", portion=" + portion +
                ", nextThread=" + nextThread.getName() +
                '}';
    }
}
