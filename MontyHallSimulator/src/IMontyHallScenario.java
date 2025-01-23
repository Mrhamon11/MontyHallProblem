public interface IMontyHallScenario
{
    void assignPrizesToDoors();

    void acceptSelectionAndRevealDoor(int playerDoorSelection);

    boolean isPrizeDesired(PrizeType prize);

    PrizeType givePlayerPrize(boolean switchDoors);

    int ineligibleDoor();
}
