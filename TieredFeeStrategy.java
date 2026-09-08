package strategy;

public class TieredFeeStrategy implements LateFeeStrategy {

    @Override
    public double calculateFee(int lateDays) {

        if (lateDays <= 5) {
            return lateDays * 10;
        } else {
            return (5 * 10) + ((lateDays - 5) * 30);
        }

    }
}