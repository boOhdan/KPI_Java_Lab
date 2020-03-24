package test;

import main.animals.Animal;
import main.animals.Eagle;
import main.animals.Zebra;
import main.aviaries.Aviary;
import main.aviaries.AviaryForEagle;
import main.aviaries.AviaryForZebra;
import main.zoo.Zoo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZooTest {
    @Test
    public void TestGetCountOfAnimal(){

        List<Animal> animals =new ArrayList<>();

        Aviary<Eagle> eagleAviary = new AviaryForEagle(4);

        Eagle eagle1 =new Eagle(1.8, "gray","Rr", "male" ,5);
        Eagle eagle2 =new Eagle(1.7, "greenish","Ir", "male" ,6);
        Eagle eagle3 =new Eagle(2, "white","Se", "female" ,3);

        eagleAviary.putAnimal(eagle1);
        eagleAviary.putAnimal(eagle2);
        eagleAviary.putAnimal(eagle3);

        animals.add(eagle1);
        animals.add(eagle2);
        animals.add(eagle3);

        Aviary<Zebra> zebraAviary= new AviaryForZebra(3);

        Zebra zebra1 = new Zebra("Kt", "male",13, "striped" ,false,560);
        Zebra zebra2 = new Zebra("Df", "female",9, "striped" ,true,650);
        Zebra zebra3 = new Zebra("Ar", "male",7, "striped" ,false,460);

        zebraAviary.putAnimal(zebra1);
        zebraAviary.putAnimal(zebra2);
        zebraAviary.putAnimal(zebra3);

        animals.add(zebra1);
        animals.add(zebra2);
        animals.add(zebra3);

        Zoo zoo =new Zoo();

        zoo.addAviary(eagleAviary);
        zoo.addAviary(zebraAviary);

        assertEquals(animals.size(), zoo.getCountOfAnimals());
    }
}
