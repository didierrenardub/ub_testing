package ar.edu.ub.pcsw.designPatterns.demos;

import ar.edu.ub.pcsw.designPatterns.builder.CPCBuilder;

public class CBuilderDemo implements IDemo
{
    @Override
    public String name()
    {
        return "Builder demo";
    }

    @Override
    public void run()
    {
        System.out.println("*********************************************");
        System.out.println("Building a PC...");
        CPCBuilder b = new CPCBuilder();
        System.out.println("\tPlacing the case...");
        b.setCase("Thermaltake", 750);
        System.out.println("\tScrewing the motherboard...");
        b.setMotherboard("ASUS", "Z370");
        System.out.println("\tPluging the processor...");
        b.setProcessor("Intel", "Core i7", 3200);
        System.out.println("\tSetting up RAM...");
        b.setRAM("Crucial", 16, 2400);
        System.out.println("\tPutting the drive...");
        b.setDrive("Western Digital", "SATA3", 1000);
        System.out.println("PC READY:");
        System.out.println(b.build());

        System.out.println("*********************************************");
        System.out.println("Building ANOTHER PC...");
        System.out.println("\tPlacing the case...");
        b.setCase("Sentey", 350);
        System.out.println("\tScrewing the motherboard...");
        b.setMotherboard("Gigabyte", "H310");
        System.out.println("\tPluging the processor...");
        b.setProcessor("Intel", "Pentium II OC", 333);
        System.out.println("\tSetting up RAM...");
        b.setRAM("Kingston", 1, 400);
        System.out.println("\tPutting the drive...");
        b.setDrive("Seagate", "IDE", 20);
        System.out.println("PC READY:");
        System.out.println(b.build());
        System.out.println("*********************************************");
    }
}
