package dom;

import dom.entity.Flower;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, TransformerException {

        FlowerHelper fh = new FlowerHelper();

        List<Flower> flowers = fh.getAll();

        for (Flower flower : flowers) {
            System.out.println(flower.getName() + " " + flower.getSoil() + " " + flower.getOrigin() + " " + flower.getStemColor()
                    + " " + flower.getLeafColor() + " " + flower.getSize() + " " + flower.getTemperature() + " " + flower.getLighting()
                    + " " + flower.getWatering() + " " + flower.getMultiplying());
        }

        Flower aaa = new Flower();
        aaa.setName("AAA");
        aaa.setSize("AAA");
        aaa.setOrigin("AAA");
        aaa.setStemColor("AAA");
        aaa.setLeafColor("AAA");
        aaa.setSize("AAA");
        aaa.setTemperature("AAA");
        aaa.setLighting("AAA");
        aaa.setWatering("AAA");
        aaa.setMultiplying("AAA");

        fh.addFlower(aaa);

        flowers = fh.getAll();

        for (Flower flower : flowers) {
            System.out.println(flower.getName() + " " + flower.getSoil() + " " + flower.getOrigin() + " " + flower.getStemColor()
                    + " " + flower.getLeafColor() + " " + flower.getSize() + " " + flower.getTemperature() + " " + flower.getLighting()
                    + " " + flower.getWatering() + " " + flower.getMultiplying());
        }
    }
}
