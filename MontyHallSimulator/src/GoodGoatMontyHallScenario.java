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
        PrizeType goodGoat = PrizeType.GOOD_GOAT;
        PrizeType badGoat = PrizeType.BAD_GOAD;
        PrizeType car = PrizeType.CAR;

        List<PrizeType> prizes = new ArrayList<>();
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
    public boolean isPrizeDesired(PrizeType prize)
    {
        return prize == PrizeType.GOOD_GOAT;
    }

    @Override
    public PrizeType givePlayerPrize(boolean switchDoors)
    {
        PrizeType playerPrize;
        int prizeDoor = switchDoors ? this.remainingDoor : this.playerDoorSelection;

        if (prizeDoor == goodGoatDoor)
        {
            playerPrize = PrizeType.GOOD_GOAT;
        }
        else
        {
            playerPrize = PrizeType.CAR;
        }

        return playerPrize;
    }

    @Override
    public int ineligibleDoor() {
        return this.badGoatDoor;
    }


}
