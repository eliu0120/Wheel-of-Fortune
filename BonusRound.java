public class BonusRound {
    private String[] tContent;
    private String[] fContent;

    public BonusRound(String a) {
        tContent = new String[a.length()];
        for (int i=0;i<a.length();i++){
            tContent[i] = a.substring(i,i+1).toUpperCase();
        }
        fContent = new String[a.length()];
        for(int i=0; i<a.length();i++){
            if (tContent[i].compareTo(" ")==0){
                fContent[i] = "   ";
            }
            else if (tContent[i].compareTo("-")==0){
                fContent[i] = "-";
                //r, s, t, l, n, e
            } else if (tContent[i].compareTo("R") == 0 || tContent[i].compareTo("S") == 0 || tContent[i].compareTo("T") == 0 || tContent[i].compareTo("L") == 0 || tContent[i].compareTo("N") == 0 || tContent[i].compareTo("E") == 0) {
                fContent[i] = tContent[i];
            } else
                fContent[i] = " _ ";
        }
    }
    public void guess(String a){
        for(int i=0; i<tContent.length; i++){
            if(tContent[i].compareTo(a.toUpperCase())==0){
                fContent[i] = tContent[i];
            }
        }
    }
    public String[] gettContent(){
        return tContent;
    }
}