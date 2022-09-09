public class Wheel {
    private static int[] value = new int[30];
    public Wheel() {
        for (int i = 0; i < 30; i++)
            value[i] = (i + 1) * 100;
    }
    public int spinWheel(Player p) {
        int x = (int) (Math.random() * 32);
        if (x < 30)
            return value[x];
        else if (x == 30) {
            bankrupt(p);
            return -1;
        }
        else
            return 0;
    }
    public void bankrupt(Player p) {
        p.setBal(0);
    }
}