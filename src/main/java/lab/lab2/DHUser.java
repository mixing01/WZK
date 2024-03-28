package lab.lab2;

import java.math.BigInteger;
import java.util.Random;

public class DHUser {
    private final long n;
    private final long myPrivateKey;

    private final long calculatedNumber;

    private long otherUserKey = -1;

    private long sessionKey;
    public DHUser(DHInitializer initializer) {
        n = initializer.getN();
        long g = initializer.getG();
        Random random = new Random();
        myPrivateKey = random.nextLong(1000,100000);
        calculatedNumber = BigInteger.valueOf(g).modPow(BigInteger.valueOf(myPrivateKey),BigInteger.valueOf(n)).longValue();
    }

    public void setOtherUserKey(long otherUserKey) {
        this.otherUserKey = otherUserKey;
    }

    public void sendKey(DHUser user){
        user.setOtherUserKey(calculatedNumber);
    }

    public void calculateSessionKey() {
        if(otherUserKey==-1) {
            System.out.println("Nie otrzymano liczby od drugiego użytkownika");
        }
        else {
            sessionKey = BigInteger.valueOf(otherUserKey).modPow(BigInteger.valueOf(myPrivateKey),BigInteger.valueOf(n)).longValue();
        }
    }

    public long getSessionKey() {
        return sessionKey;
    }
}
