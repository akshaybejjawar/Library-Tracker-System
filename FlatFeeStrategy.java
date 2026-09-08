package strategy;

public class FlatFeeStrategy implements LateFeeStrategy {

    @Override
    public double calculateFee(int lateDays) {
        return lateDays * 20;
    }
}