public class Day {
    private int d, m, y;
    Day(String s) {
        String[] strings = s.split("\\/");
        d = Integer.valueOf(strings[0]);
        m = Integer.valueOf((strings[1]));
        y = Integer.valueOf(strings[2]);
    }

    @Override
    public String toString() {
        String d = this.d + "";
        if (d.length()<2) d = "0" + d;
        String m = this.m + "";
        if(m.length()<2) m = "0" + m;
        String y = this.y + "";
        return d+"/"+m+"/"+y;
    }
}
