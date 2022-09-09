 public class Player{
   private double bal;
   private double interest;
   private String name;
   private int playerNumber;

   public Player(){
       bal = new Double(0);
       interest = new Double(0);
       name="";
       playerNumber= new Integer(0);
   }

   public Player(double a){
       bal = new Double(0);
       interest = new Double(a);
       name="";
       playerNumber= new Integer(0);
   }

   public void setPlayerNumber(int a){
       playerNumber = new Integer(a);
   }

   public int getPlayerNumber(){
       return playerNumber;
   }

   public void setName(String a){
       name = a;
   }

   public String getName(){
       return name;
   }

   public void setBal(double a){
       bal=a;
   }
   public double getBal(){
       return bal;
   }

   public void buyVowel(){
       bal -= 250;
   }
}//end Player class



