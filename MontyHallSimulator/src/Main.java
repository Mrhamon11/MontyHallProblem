//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        IMontyHallScenario scenario = new StandardMontyHallScenario();
        MontyHallSimulator simulator1 = new MontyHallSimulator(scenario, 1000000, false);
        MontyHallSimulator simulator2 = new MontyHallSimulator(scenario, 1000000, true);

        simulator1.runSimulation();
        simulator2.runSimulation();

        System.out.println("Standard Monty Hall Scenario odds:");
        System.out.println();
        System.out.println("Switch Doors false: " + simulator1.getResults());
        System.out.println();
        System.out.println("Switch Doors true: " + simulator2.getResults());

        System.out.println("_______________________________________________________________________________\n");

        IMontyHallScenario scenario2 = new GoodGoatMontyHallScenario();
        MontyHallSimulator simulator3 = new MontyHallSimulator(scenario2, 1000000, false);
        MontyHallSimulator simulator4 = new MontyHallSimulator(scenario2, 1000000, true);

        simulator3.runSimulation();
        simulator4.runSimulation();

        System.out.println("Good Goat Monty Hall Scenario odds:");
        System.out.println();
        System.out.println("Switch Doors false: " + simulator3.getResults());
        System.out.println();
        System.out.println("Switch Doors true: " + simulator4.getResults());
    }
}