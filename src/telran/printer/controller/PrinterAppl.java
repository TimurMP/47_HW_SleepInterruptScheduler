package telran.printer.controller;

import telran.printer.tasks.Printer;

public class PrinterAppl {

    public static void main(String[] args) {
        Printer[] printers = new Printer[2];
        Thread[] threads = new  Thread[printers.length];

        for (int i = 0; i < threads.length; i++) {
            printers[i] = new Printer(i+1, 100,10);
            threads[i] = new Thread(printers[i]);
            threads[i].setName("Thread" + (i+1));


        }

        for (int i = 0; i < printers.length; i++) {
            if (i == printers.length-1){

                printers[i].setNextThread(threads[0]);
                break;
            }
            printers[i].setNextThread(threads[i+1]);

        }


        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
            if (i == 0){
                threads[i].interrupt();
            }


        }

//        for (int i = 0; i < printers.length; i++) {
//            System.out.println(printers[i]);
//
//        }
















    }
}
