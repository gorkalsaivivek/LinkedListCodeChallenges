package src;

public class FirstSetBit {
     StringBuilder stringBuilder=new StringBuilder();
    public static int getFirstSetBit(int n){



return 0;
    }

    public int extracted(int n) {
        if(n ==1 )
            return 10;
        stringBuilder.append(n %2);
        return extracted(n /2);
    }
}

class FirstSetBitStarter {
    public static void main(String[] args) {
        FirstSetBit firstSetBit=new FirstSetBit();
        firstSetBit.extracted(18);
    }
}
