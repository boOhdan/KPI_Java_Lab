package test;

import main.animals.Eagle;
import main.animals.Giraffe;
import main.animals.Lion;
import main.animals.Zebra;
import main.aviaries.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AviariesTest {
    @Test
    public void TestAddAnimalsExceptions(){
        Aviary<Eagle> eagleAviary = new AviaryForEagle(10);

        Random rand = new Random();

        for (int i=0; i<10; i++){
            eagleAviary.putAnimal(new Eagle(1.8, "gray","Roy", "male" ,rand.nextInt(5)));
        }

        Assertions.assertThrows(IllegalArgumentException.class, () -> eagleAviary.putAnimal(new Eagle()));

        Aviary<Zebra> zebraAviary= new AviaryForZebra(6);

        for (int i=0; i<4; i++){
            zebraAviary.putAnimal(new Zebra("Zi", "male",rand.nextInt(26), "striped" ,true, rand.nextInt(800)));
        }

        List<Zebra> zebras = new  ArrayList<>(
                Arrays.asList(new Zebra("Hip", "male",rand.nextInt(26), "striped" ,true, rand.nextInt(800)),
                        new Zebra("Ara", "male",rand.nextInt(13), "striped" ,false, rand.nextInt(560)),
                        new Zebra("Dom", "male",rand.nextInt(21), "striped" ,true, rand.nextInt(600)))
        );

        Assertions.assertThrows(IllegalArgumentException.class, () -> zebraAviary.putAnimal( zebras));
    }
    @Test
    public void TestAddAnimals(){
        Aviary<Eagle> eagleAviary = new AviaryForEagle(10);

        Random rand = new Random();

        int numberOfEagles = 8;
        for (int i=0; i<numberOfEagles; i++){
            eagleAviary.putAnimal(new Eagle(1.8, "gray","Roy", "male" ,rand.nextInt(5)));
        }

        assertEquals(numberOfEagles, eagleAviary.getOccupiedSeats());

        Aviary<Zebra> zebraAviary= new AviaryForZebra(10);

        int numberOfZebras = 6;
        for (int i=0; i<numberOfZebras; i++){
            zebraAviary.putAnimal(new Zebra("Zi", "male",rand.nextInt(26), "striped" ,true, rand.nextInt(800)));
        }

        List<Zebra> zebras = new  ArrayList<>(
                Arrays.asList(new Zebra("Hip", "male",rand.nextInt(26), "striped" ,true, rand.nextInt(800)),
                        new Zebra("Ara", "male",rand.nextInt(13), "striped" ,false, rand.nextInt(560)),
                        new Zebra("Dom", "male",rand.nextInt(21), "striped" ,true, rand.nextInt(600)))
        );
        zebraAviary.putAnimal(zebras);

        assertEquals(numberOfZebras + zebras.size(), zebraAviary.getOccupiedSeats());
    }
    @Test
    public void TestRemoveAnimalException(){
        Aviary<Lion> lionAviary =new AviaryForLions(3);

        lionAviary.putAnimal(new Lion("Leo", "male", 12, "yellow", 6));
        lionAviary.putAnimal(new Lion("Seo", "female", 8, "yellow", 4));

        Lion wildLion = new Lion("Simba", "male", 11, "yellow", 7);

        Assertions.assertThrows(IllegalArgumentException.class, () -> lionAviary.removeAnimal(wildLion));


        Aviary<Giraffe> giraffeAviary =new AviaryForGiraffe(6);

        giraffeAviary.putAnimal(new Giraffe("Geo", "male", 12, "yellow",true, 6));
        giraffeAviary.putAnimal(new Giraffe("Peo", "female", 8, "yellow",false, 4));

        Giraffe wildGiraffe = new Giraffe("Feo", "male", 11, "yellow",false, 7);

        Assertions.assertThrows(IllegalArgumentException.class, () -> giraffeAviary.removeAnimal(wildGiraffe));

    }
    @Test
    public void TestRemoveAnimal(){
        Aviary<Giraffe> giraffeAviary =new AviaryForGiraffe(6);

        List<Giraffe> giraffes =new ArrayList<>(
                Arrays.asList(
                        new Giraffe("Geo", "male", 12, "yellow",true, 6),
                        new Giraffe("Peo", "female", 8, "yellow",false, 4),
                        new Giraffe("Feo", "male", 11, "yellow",false, 7)
        ));

        giraffeAviary.putAnimal(giraffes);
        giraffeAviary.removeAnimal(giraffes.get(1));

        assertEquals(giraffes.size() -1, giraffeAviary.getOccupiedSeats());

    }
}
