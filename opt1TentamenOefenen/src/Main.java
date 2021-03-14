import java.util.ArrayList;

class Main {

public static void main (String[] args){

    Engine a1200 = new Engine (10, 180);

    Train NS1 = new Train (a1200);
    Coach coach2 = new Coach (39, 190);
    Coach coach3 = new Coach(40,250);
    Coach coach4 = new Coach(20,200);
    NS1.addCoach(coach3);
    NS1.addCoach(coach4);
    NS1.addCoach(coach2);


    System.out.println(a1200.getWeight());
    System.out.println(NS1.totalCapacity());

}
}


class Engine{

    private Integer weight;
    private Integer power;

    public Engine (Integer weight, Integer power)  {
        this.weight = weight;
        this.power = power;
    }

    public Integer getWeight() {
        return weight;
    }

    public Integer getPower()  {
        return power;
    }
}


class Train {
    private Engine isTowedBy;
    private ArrayList<Coach> consistsOf;

    public Train(Engine engine) {
        this.isTowedBy = engine;
        this.consistsOf = new ArrayList<Coach>();

    }


    private Integer totalWeight() {

        Integer totalWeight = 0;

        for (int i = 0; i < consistsOf.size(); i++) {
            totalWeight += consistsOf.get(i).getWeight();
        }
        totalWeight += this.isTowedBy.getWeight();
        return totalWeight;
    }

    public void addCoach(Coach coach) {

        Integer x = this.totalWeight();


        x += coach.getWeight();
        if (x <= isTowedBy.getPower()) {
            consistsOf.add(coach);

        }
    }

        public Integer totalCapacity() {

            Integer totalCapacity = 0;

            for (int i = 0; i < consistsOf.size(); i++) {
                totalCapacity += consistsOf.get(i).getCapacity();

            }
            return totalCapacity;
        }

}


    class Coach {

        private Integer weight;
        private Integer capacity;

        public Coach(Integer weight, Integer capacity) {
            this.weight = weight;
            this.capacity = capacity;
        }

        public Integer getWeight() {
            return this.weight;
        }

        public Integer getCapacity() {
            return this.capacity;
        }
    }
