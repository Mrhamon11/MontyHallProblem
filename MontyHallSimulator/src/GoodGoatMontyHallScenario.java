import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GoodGoatMontyHallScenario implements IMontyHallScenario
{
    private int goodGoatDoor;
    private int badGoatDoor;
    private int carDoor;

    private int playerDoorSelection;
    private int revealedDoor;
    private int remainingDoor;

    @Override
    public void assignPrizesToDoors()
    {
        PrizeTypes goodGoat = PrizeTypes.GOOD_GOAT;
        PrizeTypes badGoat = PrizeTypes.BAD_GOAD;
        PrizeTypes car = PrizeTypes.CAR;

        List<PrizeTypes> prizes = new ArrayList<>();
        prizes.add(goodGoat);
        prizes.add(badGoat);
        prizes.add(car);

        Collections.shuffle(prizes);

        for (int i = 0; i < prizes.size(); i++)
        {
            if (prizes.get(i) == car)
            {
                this.carDoor = i;
            }
            else if (prizes.get(i).equals(goodGoat))
            {
                this.goodGoatDoor = i;
            }
            else if (prizes.get(i).equals(badGoat))
            {
                this.badGoatDoor = i;
            }
        }
    }

    @Override
    public void acceptSelectionAndRevealDoor(int playerDoorSelection)
    {
        this.playerDoorSelection = playerDoorSelection;
        this.revealedDoor = badGoatDoor;

        if (playerDoorSelection == carDoor)
        {
            this.remainingDoor = goodGoatDoor;
        }
        else
        {
            this.remainingDoor = carDoor;
        }
    }

    @Override
    public boolean isPrizeDesired(PrizeTypes prize)
    {
        return prize == PrizeTypes.GOOD_GOAT;
    }

    @Override
    public PrizeTypes givePlayerPrize(boolean switchDoors)
    {
        PrizeTypes playerPrize;
        int prizeDoor = switchDoors ? this.remainingDoor : this.playerDoorSelection;

        if (prizeDoor == goodGoatDoor)
        {
            playerPrize = PrizeTypes.GOOD_GOAT;
        }
        else
        {
            playerPrize = PrizeTypes.CAR;
        }

        return playerPrize;
    }

    @Override
    public int ineligibleDoor() {
        return this.badGoatDoor;
    }


}
