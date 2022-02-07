public class Quine{
   public static void main(String [] args){
       char quotation = 34;
       char comma = 44;
       String [] strArray = {
"public class Quine{",
"   public static void main(String [] args){",
"       char quotation = 34;",
"       char comma = 44;",
"       String [] strArray = {",
"       };",
"       for(int i = 0; i < 3; i++){",
"           System.out.println(strArray[i]);",
"       }",
"       for(int i = 0; i < strArray.length; i++){",
"           System.out.println(strArray[i]);",
"       }",
"       for(int i = 0 ; i < strArray.length; i ++){",
"           System.out.println(quotation + strArray[i] + quotation + quotation + comma);",
"       }",
"   }",
"}",
       };
       for(int i = 0; i < 3; i++){
           System.out.println(strArray[i]);
       }
       for(int i = 0; i < strArray.length; i++){
           System.out.println(strArray[i]);
       }
       for(int i = 0 ; i < strArray.length; i ++){
           System.out.println(quotation + strArray[i] + quotation + quotation + comma);
       }
   }
}
