
public class example {
    public String reverse(String s){
        String answer = "";
        
        for (int i = 0; i < s.length(); i++) {
            answer = s.charAt(i) + answer;
        }
        
        return answer;
    }
   
    public void stringBuilderExample() {
        StringBuilder sb = new StringBuilder("start");
        // the parameters in side the the insert method what they do is 
        // tell substring they want to add the following String "le" starting 
        // on index 4 
        //  *** this doesnt remove the letter T it just pushes it away ***
        sb.insert(4, "le");
        System.out.println(sb);
    }
    
    //                      *** TESTER METHODS ***
    public void revsereTester() {
        System.out.println(reverse("abdullah"));
    }
}
