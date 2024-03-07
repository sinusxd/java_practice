package practice7.Flyweight;

import java.util.HashMap;

public class HouseFlyweightFactory {
    private HashMap<String, HouseFlyWeight> flyweights = new HashMap<>();

    public HouseFlyWeight getHouseFlyweight(int floors, int rooms) {
        String key = floors + "-" + rooms;
        if (!flyweights.containsKey(key)) {
            flyweights.put(key, new ConcreteHouseFlyweight(floors, rooms));
        }
        return flyweights.get(key);
    }
}
