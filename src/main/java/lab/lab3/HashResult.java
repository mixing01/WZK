package lab.lab3;

public class HashResult {

    @Override
    public String toString() {
        return hashedText;
    }
    private final String hashFunction;
    private final String originalText;
    private final String hashedText;
    private final long hashingTime;

    public String getHashFunction() {
        return hashFunction;
    }

    public String getHashedText() {
        return hashedText;
    }

    public String getOriginalText() {
        return originalText;
    }
    public long getHashingTime() {
        return hashingTime;
    }
    public int getOriginalTextLength() {
        return originalText.length();
    }

    public int getHashedTextLength() {
        return hashedText.length();
    }

    public HashResult(String hashFunction, String originalText, String hashedText, long hashingTime) {
        this.hashFunction = hashFunction;
        this.originalText = originalText;
        this.hashedText = hashedText;
        this.hashingTime = hashingTime;
    }
}
