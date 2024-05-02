package lab.lab5;

public class Share {
    private int shareIndex;

    private int shareValue;

    public Share(int i, int s) {
        this.shareIndex = i;
        this.shareValue = s;
    }
    public int getShareIndex() {
        return shareIndex;
    }
    public int getShareValue() {
        return shareValue;
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)",shareIndex,shareValue);
    }
}
