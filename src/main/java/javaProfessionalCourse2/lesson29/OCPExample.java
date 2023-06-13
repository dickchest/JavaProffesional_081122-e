package javaProfessionalCourse2.lesson29;

public class OCPExample {
    public void nonOCP() {
        String[] cities = new String[5];
        cities[0] = "Berlin";
        cities[1] = "Madrid";
        cities[2] = "Paris";
        cities[3] = "Rome";
        cities[4] = "London";

        // searchCities(cities)
    }

    public boolean nonOCP2(int x, int y){ // int criteria
         boolean result = false;

        if ((x+y) < 1000) {
            result = true;
        }
        return result;
    }
}
