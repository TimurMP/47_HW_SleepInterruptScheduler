package telran.printer.controller;

import telran.printer.tasks.Printer;

public class PrinterAppl {

    public static void main(String[] args) throws InterruptedException {
        Printer[] printers = createPrinters(4, 100, 10);
        Thread[] threads = createThreads(printers);
        addNextThreads(printers, threads);
        executeThreads(threads);
    }




    public static Printer[] createPrinters(int amountOfPrinters, int amountOfNumbers, int portion) {
        Printer[] printers = new Printer[amountOfPrinters];
        for (int i = 0; i < printers.length; i++) {
            printers[i] = new Printer(i + 1, amountOfNumbers, portion);
        }
        return printers;
    }

    public static Thread[] createThreads(Printer[] printers) {
        Thread[] threads = new Thread[printers.length];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(printers[i]);
            threads[i].setName("Thread" + (i + 1));
            threads[i].setDaemon(true);
        }
        return threads;
    }

    public static void addNextThreads(Printer[] printers, Thread[] threads) {
        for (int i = 0; i < printers.length; i++) {
            if (i == printers.length - 1) {
                printers[i].setNextThread(threads[0]);
                break;
            }
            printers[i].setNextThread(threads[i + 1]);
        }
    }

    public static void executeThreads(Thread[] threads) throws InterruptedException {
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
            if (i == 0) {
                threads[i].interrupt();
            }
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }
    }
}
