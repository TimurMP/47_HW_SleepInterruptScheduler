package telran.printer.controller;

import telran.printer.tasks.Printer;

public class PrinterAppl {

    public static void main(String[] args) {
        Printer[] printers = new Printer[2];
        Thread[] threads = new  Thread[printers.length];

        for (int i = 0; i < threads.length; i++) {
            printers[i] = new Printer(i+1, 100,10);
            threads[i] = new Thread(printers[i]);
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].interrupt();

        }


//        Printer printer = new Printer(1, 100, 10);
//        Thread thread = new Thread(printer);
//        Printer printer2 = new Printer(2, 100, 10);
//        Thread thread2 = new Thread(printer2);
//
//        thread.start();
//        thread2.start();
//
//        thread.interrupt();
//        thread2.interrupt();
//        thread.interrupt();
//        thread2.interrupt();



    }
}
