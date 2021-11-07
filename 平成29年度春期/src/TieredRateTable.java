public class TieredRateTable extends TierTable{
    TieredRateTable(double ... tiers){
        super(tiers);
    }

    public double map(double amount){
        double charge = 0;
        for(int i =0; i <pairs.length-1; i++){
            if(pairs[i][0] < amount && amount < pairs[i+1][0]){
                charge += (pairs[i+1][0] - pairs[i][0])*pairs[i][0];
            } else if (amount > pairs[i+1][0]){
                charge += (amount - pairs[i+1][0])*pairs[i+1][1];
                break;
            }
        }
        return charge;
    }
}


