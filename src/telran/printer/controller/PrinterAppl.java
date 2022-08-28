package telran.printer.controller;

import telran.printer.tasks.Printer;

public class PrinterAppl {

    public static void main(String[] args) {
        Printer printer = new Printer(1, 10, 3);
        printer.run();
    }
}
