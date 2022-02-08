import java.io.File;
import java.io.FileNotFoundException;
import java.lang.invoke.MethodHandles;
import java.io.FileWriter;
import java.io.IOException;
public class FakeWorm {
    public static void main(String [] args) throws IOException{
        String javaPrefix = ".java"; //0
        int numID = 0;
        if(numID > 1) return; //2
        
        char quotation = 34; //4
        char comma = 44; 

        String className = MethodHandles.lookup().lookupClass().getSimpleName() + (++numID);

        File f = new File(className + javaPrefix); //6
        FileWriter fw = new FileWriter(f);

        String [] importLines = {
            "import java.io.File;",
            "import java.io.FileNotFoundException;",
            "import java.lang.invoke.MethodHandles;",
            "import java.io.FileWriter;",
            "public class ", //First stop at line 4.  Inject new classname here.
            "{\n",
            "   public static void main(String [] args){\n",
            "       String javaPrefix = ", //Second stop at line 6; Inject ".java"
            ";\n",
            "int numID = ", //Third stop at 7; Inject new numID
            ";\n",
            "if(numID < 1) return;\n",
            "String className = MethodHandles.lookup().lookupClass().getSimpleName() + (++numID);\n",
            "char quotation = 34;\n",
            "char comma = 44;\n",
            "File f = new File(className + javaPrefix);\n",
            "FileWriter fw = new FileWriter(f);\n",
            "String [] importLines = {", //Write everything here
            "};"
        };
        for(int i = 0; i < 4; i++)
            System.out.println(importLines[i]);
        
        System.out.print(importLines[4] + className + importLines[5]);


        //fw.close();
    }
}
