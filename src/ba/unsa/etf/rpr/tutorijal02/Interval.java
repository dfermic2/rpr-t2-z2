package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private final double start;
    private final double end;
    private final boolean containsStart;
    private final boolean containsEnd;

    public Interval(double start, double end, boolean containsStart, boolean containsEnd) {
        if(start > end) throw new IllegalArgumentException("Pocetak intervala ne moze biti veci od kraja");

        this.start = start;
        this.end = end;
        this.containsStart = containsStart;
        this.containsEnd = containsEnd;
    }

    public Interval() {
        this(0, 0, false, false);
    }

    public Interval intersect(Interval i) {
        double min;
        double max;
        boolean containsMin;
        boolean constainsMax;

        if(this.start > i.start) {
            min = this.start;
            containsMin = this.containsStart;
        }
        else {
            min = i.start;
            containsMin = i.containsStart;
        }

        if(this.end < i.end) {
            max = this.end;
            constainsMax = this.containsEnd;
        }
        else {
            max = i.end;
            constainsMax = i.containsEnd;
        }

        return new Interval(min, max, containsMin, constainsMax);
    }

    public static Interval intersect(Interval i, Interval i2) {
        double min;
        double max;
        boolean containsMin;
        boolean constainsMax;

        if(i2.start > i.start) {
            min = i2.start;
            containsMin = i2.containsStart;
        }
        else {
            min = i.start;
            containsMin = i.containsStart;
        }

        if(i2.end < i.end) {
            max = i2.end;
            constainsMax = i2.containsEnd;
        }
        else {
            max = i.end;
            constainsMax = i.containsEnd;
        }

        return new Interval(min, max, containsMin, constainsMax);
    }

    public boolean isNull() {
        return (this.equals(new Interval()));
    }

    public boolean isIn(double point){
        if(this.start < point && this.end > point) return true;
        if(this.start == point && this.containsStart) return true;
        if(this.end == point && this.containsEnd) return true;
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if (obj == null) return false;

        if(obj.getClass() != this.getClass()) return false;

        final Interval other = (Interval) obj;

        if(this.start != other.start) return false;
        if(this.end != other.end) return false;
        if(this.containsStart != other.containsStart) return false;
        if(this.containsEnd != other.containsEnd) return false;

        return true;
    }

    @Override
    public String toString() {
        if(this.equals(new Interval())) return "()";

        String startBrackets;
        String endBrackets;

        if(this.containsStart) startBrackets = "[";
        else  startBrackets = "(";

        if(this.containsEnd) endBrackets = "]";
        else  endBrackets = ")";

        return startBrackets + this.start + "," + this.end + endBrackets;
    }
}
