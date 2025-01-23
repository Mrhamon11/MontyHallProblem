import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class MontyHallSimulator
{
    IMontyHallScenario montyHallScenario;

    private int totalNumAttempts;
    private int numAttemptsDesiredPrizeReceived;
    private int numAttemptsNonDesiredPrizeReceived;

    private boolean switchDoors;
    private Random random;

    public MontyHallSimulator(IMontyHallScenario montyHallScenario, int totalNumAttempts, boolean switchDoors)
    {
        this.montyHallScenario = montyHallScenario;

        this.totalNumAttempts = totalNumAttempts;
        this.numAttemptsDesiredPrizeReceived = 0;
        this.numAttemptsNonDesiredPrizeReceived = 0;

        this.switchDoors = switchDoors;
        this.random = new Random();
    }

    private boolean getSingleResult()
    {
        this.montyHallScenario.assignPrizesToDoors();

        int ineligibleDoor = this.montyHallScenario.ineligibleDoor();
        int doorSelection = this.random.nextInt(3);
        while (doorSelection == ineligibleDoor)
        {
            doorSelection = this.random.nextInt(3);
        }

        this.montyHallScenario.acceptSelectionAndRevealDoor(doorSelection);
        PrizeTypes prize = this.montyHallScenario.givePlayerPrize(this.switchDoors);

        return this.montyHallScenario.isPrizeDesired(prize);
    }

    public void runSimulation()
    {
        for (int i = 0; i < this.totalNumAttempts; i++)
        {
            boolean result = getSingleResult();
            if (result)
            {
                this.numAttemptsDesiredPrizeReceived++;
            }
            else
            {
                this.numAttemptsNonDesiredPrizeReceived++;
            }
        }
    }

    public String getResults()
    {
        BigDecimal desired = new BigDecimal(this.numAttemptsDesiredPrizeReceived);
        BigDecimal totalAttempts = new BigDecimal(this.totalNumAttempts);
        BigDecimal successRate = desired.divide(totalAttempts, 2, RoundingMode.HALF_UP);

        StringBuilder sb = new StringBuilder();

        sb.append("Total Num Attempts: ").append(this.totalNumAttempts).append("\n");
        sb.append("Desired Prize selected ").append(this.numAttemptsDesiredPrizeReceived).append(" times").append("\n");
        sb.append("Non desired Prize selected ").append(this.numAttemptsNonDesiredPrizeReceived).append(" times").append("\n");
        sb.append("Success rate: ").append(successRate.doubleValue() * 100).append("%");

        return sb.toString();
    }
}
