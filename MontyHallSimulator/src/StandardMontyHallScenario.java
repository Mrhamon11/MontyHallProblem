import java.util.*;

public class StandardMontyHallScenario implements IMontyHallScenario
{
    private int goat1Door;
    private int goat2Door;
    private int carDoor;

    private int playerDoorSelection;
    private int revealedDoor;
    private int remainingDoor;

    @Override
    public void assignPrizesToDoors()
    {
        PrizeTypes goat1 = PrizeTypes.STANDARD_GOAT1;
        PrizeTypes goat2 = PrizeTypes.STANDARD_GOAT2;
        PrizeTypes car = PrizeTypes.CAR;

        List<PrizeTypes> prizes = new ArrayList<>();
        prizes.add(goat1);
        prizes.add(goat2);
        prizes.add(car);

        Collections.shuffle(prizes);

        for (int i = 0; i < prizes.size(); i++)
        {
            if (prizes.get(i) == car)
            {
                this.carDoor = i;
            }
            else if (prizes.get(i).equals(goat1))
            {
                this.goat1Door = i;
            }
            else if (prizes.get(i).equals(goat2))
            {
                this.goat2Door = i;
            }
        }
    }

    @Override
    public void acceptSelectionAndRevealDoor(int playerDoorSelection)
    {
        this.playerDoorSelection = playerDoorSelection;

        if (playerDoorSelection == carDoor)
        {
            this.revealedDoor = goat1Door;
            this.remainingDoor = goat2Door;
        }
        else if (playerDoorSelection == goat1Door)
        {
            this.revealedDoor = goat2Door;
            this.remainingDoor = carDoor;
        }
        else
        {
            this.revealedDoor = goat1Door;
            this.remainingDoor = carDoor;
        }
    }

    @Override
    public boolean isPrizeDesired(PrizeTypes prize) {
        return prize == PrizeTypes.CAR;
    }

    @Override
    public PrizeTypes givePlayerPrize(boolean switchDoors)
    {
        PrizeTypes playerPrize;
        int prizeDoor = switchDoors ? this.remainingDoor : this.playerDoorSelection;

        if (prizeDoor == goat1Door)
        {
            playerPrize = PrizeTypes.STANDARD_GOAT1;
        }
        else if (prizeDoor == goat2Door)
        {
            playerPrize = PrizeTypes.STANDARD_GOAT2;
        }
        else
        {
            playerPrize = PrizeTypes.CAR;
        }

        return playerPrize;
    }

    @Override
    public int ineligibleDoor() {
        return -1;
    }
}
