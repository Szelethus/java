public class ExceptionTest{

public static void main(String [] args){
   for(String arg : args){
     try{
       exceptional(arg);
       System.out.println("All is good with parameter \"" + arg + "\"");
     }catch(Exception e){
       System.out.println(e.getClass() + " " + e.getMessage());
     }
   }
 }

 static int exceptional(String str) throws TestException {
   try{
    switch(str){
      case "osztas":
        return 5/0;
      case "null":
        str = null;
        return str.length();
      case "teszt":
        throw new TestException("Teszt uzenet!");
     }
    }finally{
      System.out.println("Method \"exceptional\" ended with the \"String\" parameter \"" + str + "\"");
    }
   return 0;
  }
}

class TestException extends Exception{
  TestException(String str){
    super(str);
  }
}
