public class Part1 {
   public void findAbc(String input){
       int index = input.indexOf("abc");
       while (true){
           if (index == -1 || index >= input.length() - 3){
               break;
           }
           String found = input.substring(index+1, index+4);
           System.out.println(found);
           index = input.indexOf("abc",index+4);
           System.out.println((index + 1) + "," + (index + 4));
       }
   }

   public void test(){
       //findAbc("abcd");
       findAbc("abcdkfjsksioehgjfhsdjfhksdfhuwabcabcajfieowj");
//              12345678901234567890123456789012345678901234
        //         ones     tens    twenties   thirties  fourties
    }               
}
