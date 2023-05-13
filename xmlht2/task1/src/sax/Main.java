package sax;

import org.xml.sax.SAXException;
import sax.entity.Flower;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        FlowerHandler fh = new FlowerHandler();

        File file = new File("C:\\Users\\maxim\\OneDrive\\Рабочий стол\\xmlht2\\task1\\src\\sax\\flowers.xml");
        parser.parse(file, fh);

        List<Flower> flowers = fh.getFlowers();

        System.out.println("All flowers: ");

        for (Flower flower : flowers) {
            System.out.println(flower.getName() + " " + flower.getSoil() + " " + flower.getOrigin() + " " + flower.getStemColor()
                + " " + flower.getLeafColor() + " " + flower.getSize() + " " + flower.getTemperature() + " " + flower.getLighting()
                + " " + flower.getWatering() + " " + flower.getMultiplying());
        }
    }
}