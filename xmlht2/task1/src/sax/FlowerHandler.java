package sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import sax.entity.Flower;

import java.util.ArrayList;
import java.util.List;

public class FlowerHandler extends DefaultHandler {

    private String currentQName;
    private List<Flower> flowers;
    private Flower currentFlower;
    private String currentAttribute;

    FlowerHandler() {
        flowers = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start element: " + qName);
        currentQName = qName;

        if (attributes.getLength() > 0) {
            currentAttribute = attributes.getValue(0);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length);
        System.out.println("Characters: " + value);
        switch (currentQName) {
            case "Plant":
                currentFlower = new Flower();
                break;
            case "Name":
                currentFlower.setName(value);
                break;
            case "Soil":
                currentFlower.setSoil(value);
                break;
            case "Origin":
                currentFlower.setOrigin(value);
                break;
            case "StemColor":
                currentFlower.setStemColor(value);
                break;
            case "LeafColor":
                currentFlower.setLeafColor(value);
                break;
            case "Size":
                currentFlower.setSize(value);
                break;
            case "Temperature":
                currentFlower.setTemperature(value);
                break;
            case "Lighting":
                currentFlower.setLighting(value);
                break;
            case "Watering":
                currentFlower.setWatering(value);
                break;
            case "Multiplying":
                currentFlower.setMultiplying(value);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End element: " + qName);
        currentQName = "";
        if (qName.equals("Plant")) {
            flowers.add(currentFlower);
        }
    }

    public List<Flower> getFlowers() {
        return flowers;
    }
}
