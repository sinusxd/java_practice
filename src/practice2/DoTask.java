package practice2;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class DoTask {
    private static List<Human> create(int count){
        String[] names = {"Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Grace", "Henry", "Ivy", "Jack"};
        String[] surnames = {"Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor"};
        List<Human> humans = new ArrayList<>();
        Random random = new Random();
        for(int i = 0 ; i < count ; ++i){
            String name = names[random.nextInt(10)];
            String lastName = surnames[random.nextInt(10)];
            int weight = random.nextInt(120) + 10;
            int year = random.nextInt(124) + 1900;
            int month = random.nextInt(12) + 1;
            int maxDayOfMonth = LocalDate.of(year, month, 1).lengthOfMonth();
            int day = random.nextInt(maxDayOfMonth) + 1;
            LocalDate birthDate = LocalDate.of(year, month, day);
            int age = Period.between(birthDate, LocalDate.now()).getYears();
            Human human = new Human(age, name, lastName,birthDate , weight);
            humans.add(human);
        }
        return humans;
    }
    public static void solve(){
        List<Human> list = DoTask.create(10);
        System.out.println(list);
        Stream<Human> stream = list.stream();
        AtomicInteger sum = new AtomicInteger(0);
        stream.filter(human -> human.getWeight() > human.getAge())
                .sorted(((o1, o2) -> o2.getLastName().compareTo(o1.getLastName())))
                .forEach( obj -> {
                    System.out.println(obj);
                    sum.addAndGet(obj.getAge());
                });
        System.out.println("Сумма = " + sum.toString());
    }
}
