import java.util.List;

public interface IMontyHallScenario
{
    void assignPrizesToDoors();

    void acceptSelectionAndRevealDoor(int playerDoorSelection);

    boolean isPrizeDesired(PrizeTypes prize);

    PrizeTypes givePlayerPrize(boolean switchDoors);

    int ineligibleDoor();
}
