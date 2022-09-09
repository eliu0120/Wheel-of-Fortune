public class Phrase {

   private String[] tContent;
   private String[] fContent;

   Phrase(String a){
       tContent = new String[a.length()];
       for(int i=0;i<a.length();i++){
           tContent[i] = a.substring(i,i+1).toUpperCase();
       }
       fContent = new String[a.length()];
       for(int i=0; i<a.length();i++){
           if(tContent[i].compareTo(" ")==0){
               fContent[i] = "   ";
           }
           else if(tContent[i].compareTo("-")==0){
               fContent[i] = "-";
           }
           else
               fContent[i] = " _ ";
       }
   }//end constructor

   public boolean guess(String a){
       boolean check=false;

       for(int i=0; i<tContent.length; i++){
           if(tContent[i].compareTo(a.toUpperCase())==0){
               check=true;
           }
       }
       return check;
   }//end guess()

   public int times(String a){
       int count=0;
       for(int i=0; i<tContent.length; i++){
           if(tContent[i].compareTo(a.toUpperCase())==0){
               fContent[i]=a.toUpperCase();
               count++;
           }
       }
       return count;
   }//end guess()

   public String toStringF(){
       String rv="";
       for(int i=0; i<fContent.length;i++){
           rv+=fContent[i];
       }
       return rv;
   }

   public String toStringT(){
       String rv="";
       for(int i=0; i<tContent.length;i++){
           rv+=tContent[i];
       }
       return rv;
   }


   public boolean condition(){
       boolean check = false;
       for(int i=0; i<fContent.length;i++){
           if(fContent[i]!=tContent[i])
               check=true;
       }
       return check;
   }

   public String[] gettContent(){
       return tContent;
   }

   public void setfContent(){
       for(int i=0; i<fContent.length;i++){
           fContent[i]=tContent[i];
       }
   }
}
