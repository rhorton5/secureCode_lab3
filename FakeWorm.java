import java.io.File;
import java.lang.invoke.MethodHandles;
import java.io.FileWriter;
import java.io.IOException;
public class FakeWorm {
    public static void main(String [] args) throws IOException, InterruptedException{
        
        int numID = 0; //This is used to determine which worm is being used.  If the value is 3, then the worm will stop.
        if(numID >= 3) return; //If the numID is 3, that means the class should be FakeWorm3; therefore, it will stop running.
        
        //quotation and comma are in ASCII values to prevent the usage of quotation marks for quining.
        char quotation = 34; 
        char comma = 44; 
        char [] javaPrefix = {'.','j','a','v','a'}; //Using actual characters, these are used with new String(arrayName) to create an actual string.
        
        String className = MethodHandles.lookup().lookupClass().getSimpleName().substring(0,8) + (numID + 1); //Gross method calls, but this is used to grab the class name without using strings.
                                                                                                              //Substring is used to remove the number that exists in all FakeWork, aside from the original.
        numID++; //This will need to be incremented for later.

        File f = new File(className + new String(javaPrefix));
        FileWriter fw = new FileWriter(f);

        String [] importLines = { //The other worms will be written in one line; however, Java compiler does not care about spaces.
            "import java.io.File;",
            "import java.lang.invoke.MethodHandles;",
            "import java.io.FileWriter;",
            "import java.io.IOException;",
            "public class ", //First stop at line 4.  Inject new classname here.
            "{", //line 5
            "   public static void main(String [] args) throws IOException, InterruptedException{",
            "       int numID =",// line 6 get NewID
            "       ;",
            "       if(numID >= 3) return;", 
            "       char quotation = 34;",
            "       char comma = 44;",
            "       char [] javaPrefix = {'.','j','a','v','a'};",
            "       String className = MethodHandles.lookup().lookupClass().getSimpleName().substring(0,8) + (numID + 1);",
            "       numID++;",
            "       File f = new File(className + new String(javaPrefix));",
            "       FileWriter fw = new FileWriter(f);",
            "       String [] importLines = {", //line 18
            "       };",
            "       for(int i =0; i < 5; i++)",
            "           fw.write(importLines[i]);",
            "       fw.write(className + importLines[5]);",
            "       fw.write(importLines[6] + importLines[7] + numID);",
            "       for(int i = 8; i < 18; i++)",
            "           fw.write(importLines[i]);",
            "       for(int i = 0; i < importLines.length; i++)",
            "           fw.write(quotation + importLines[i] + quotation + comma);",
            "       for(int i = 18; i < importLines.length; i++)",
            "           fw.write(importLines[i]);",
            "       fw.close();",
            "       char [] javacPrefix = {'j','a','v','a','c',' '};",
            "       char [] runPrefix = {'j','a','v','a',' '};",
            "       Runtime rt = Runtime.getRuntime();",
            "       Process p = rt.exec(new String(javacPrefix) + className + new String(javaPrefix));",
            "       p.waitFor();",
            "       Process p2 = rt.exec(new String(runPrefix) + className);",
            "       p2.waitFor();",
            "  }",
            "}",
        };
        for(int i = 0; i < 5; i++)
            fw.write(importLines[i]);
        
        fw.write(className + importLines[5]); //Get the new className.
        
        fw.write(importLines[6] + importLines[7] + numID); //Get the new numID value.
        for(int i = 8; i < 18; i++)
            fw.write(importLines[i]);

        for(int i = 0; i < importLines.length; i++)
            fw.write(quotation + importLines[i] + quotation + comma); //For all values in the importLines.
        
            for(int i = 18; i < importLines.length; i++)
            fw.write(importLines[i]); //Write the rest of the data
        
            fw.close(); //Must close before runtime activates, otherwise runtime will never execute.

        char [] javacPrefix = {'j','a','v','a','c',' '};
        char [] runPrefix = {'j','a','v','a',' '};

        //Note to self: How can I just write this information into my Quine Code?
        Runtime rt = Runtime.getRuntime();
        Process p = rt.exec(new String(javacPrefix) + className + new String(javaPrefix));
        p.waitFor();
        Process p2 = rt.exec(new String(runPrefix) + className);
        p2.waitFor();
    }
}
