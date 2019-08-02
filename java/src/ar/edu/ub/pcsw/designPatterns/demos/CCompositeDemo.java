package ar.edu.ub.pcsw.designPatterns.demos;

import ar.edu.ub.pcsw.designPatterns.composite.*;

public class CCompositeDemo extends CDemoBase
{
    @Override
    public String name()
    {
        return "Composite demo";
    }

    @Override
    public void run()
    {
        CMessageProcessor mp = new CMessageProcessor();
        System.out.print("Enter a message to work with: ");
        String message = this.readString();

        System.out.println("Encoding the message:\n\t" + mp.encode(message));
        System.out.println("It seems it failed; maybe it's missing some components... Trying again:");
        mp.addComponent(new CComponentMessageEncoder());
        mp.component("message-encoder").addComponent(new CComponentCaseInverter());
        System.out.println("\t" + mp.encode(message));
        System.out.println("Much better now, but still missing some pieces... Let's give it another shot:");
        mp.component("message-encoder").addComponent(new CComponentStringReplacer());
        System.out.println("\t" + mp.encode(message));
        System.out.println("Almost there! Trying again: ");
        mp.component("message-encoder").addComponent(new CComponentStringToHexa());
        System.out.println("\t" + mp.encode(message));
        System.out.println("Looking great! But let's add it more spice:");
        mp.component("message-encoder").addComponent(new CComponentStringReverser());
        mp.component("message-encoder").addComponent(new CComponentStringFlipper());
        System.out.println("\t" + mp.encode(message));
        message = mp.encode(message);
        System.out.println("************************************************\nIt's now time to decode:");
        System.out.println("\t" + mp.decode(message));
        System.out.println("Right, we have no decoder yet... Here we go again!");
        mp.addComponent(new CComponentMessageDecoder());
        mp.component("message-decoder").addComponent(new CComponentStringFromHexa());
        System.out.println("\t" + mp.decode(message));
        System.out.println("Sigh... Need more components to decode the message...");
        mp.component("message-decoder").addComponent(new CComponentStringReplacer());
        System.out.println("\t" + mp.decode(message));
        System.out.println("Oh, forgot the inverter one:");
        mp.component("message-decoder").addComponent(new CComponentCaseInverter());
        System.out.println("\t" + mp.decode(message));
        System.out.println("Shoot, missing the reverser one");
        mp.component("message-decoder").addComponent(new CComponentStringReverser());
        System.out.println("\t" + mp.decode(message));
        System.out.println("What? Oh, right, the flipper...");;
        mp.component("message-decoder").addComponent(new CComponentStringFlipper());
        System.out.println("\t" + mp.decode(message));
    }
}
