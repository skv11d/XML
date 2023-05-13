package dom;

import dom.entity.Flower;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FlowerHelper {

    private Document document;

    public FlowerHelper() throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setIgnoringElementContentWhitespace(true);

        DocumentBuilder db = dbf.newDocumentBuilder();

        document = db.parse("C:\\Users\\maxim\\OneDrive\\Рабочий стол\\xmlht2\\task1\\src\\dom\\flowers.xml");
    }

    public List<Flower> getAll() {

        List<Flower> flowers = new ArrayList<>();

        Element root = document.getDocumentElement();

        NodeList list = root.getElementsByTagName("Plant");

        for (int i = 0; i < list.getLength(); i++) {
            Flower flower = new Flower();
            String name = list.item(i).getTextContent();
            String soil = list.item(i).getTextContent();
            String origin = list.item(i).getTextContent();
            String stemColor = list.item(i).getTextContent();
            String leafColor = list.item(i).getTextContent();
            String size = list.item(i).getTextContent();
            String temperature = list.item(i).getTextContent();
            String lighting = list.item(i).getTextContent();
            String watering = list.item(i).getTextContent();
            String multiplying = list.item(i).getTextContent();
            flower.setName(name);
            flower.setSoil(soil);
            flower.setOrigin(origin);
            flower.setStemColor(stemColor);
            flower.setLeafColor(leafColor);
            flower.setSize(size);
            flower.setTemperature(temperature);
            flower.setLighting(lighting);
            flower.setWatering(watering);
            flower.setMultiplying(multiplying);
        }

        return flowers;
    }

    public void addFlower(Flower flower) throws FileNotFoundException, TransformerException {
        Element root = document.getDocumentElement();

        Element plant = document.createElement("Plant");
        Element name = document.createElement("Name");
        Element soil = document.createElement("Soil");
        Element origin = document.createElement("Origin");
        Element visualParameters = document.createElement("VisualParameters");
        Element stemColor = document.createElement("StemColor");
        Element leafColor = document.createElement("LeafColor");
        Element size = document.createElement("Size");
        Element growingTips = document.createElement("GrowingTips");
        Element temperature = document.createElement("Temperature");
        Element lighting = document.createElement("Lighting");
        Element watering = document.createElement("Watering");
        Element multiplying = document.createElement("Multiplying");

        name.setTextContent(flower.getName());
        soil.setTextContent(flower.getSoil());
        origin.setTextContent(flower.getOrigin());
        stemColor.setTextContent(flower.getStemColor());
        leafColor.setTextContent(flower.getLeafColor());
        size.setTextContent(flower.getSize());
        temperature.setTextContent(flower.getTemperature());
        lighting.setTextContent(flower.getLighting());
        watering.setTextContent(flower.getWatering());
        multiplying.setTextContent(flower.getMultiplying());

        plant.appendChild(name);
        plant.appendChild(soil);
        plant.appendChild(origin);
        plant.appendChild(visualParameters);
        visualParameters.appendChild(stemColor);
        visualParameters.appendChild(leafColor);
        visualParameters.appendChild(size);
        plant.appendChild(growingTips);
        growingTips.appendChild(temperature);
        growingTips.appendChild(lighting);
        growingTips.appendChild(watering);
        plant.appendChild(multiplying);

        root.appendChild(plant);

        DOMSource source = new DOMSource(document);
        String outputURL = "C:\\Users\\maxim\\OneDrive\\Рабочий стол\\xmlht2\\task1\\src\\dom\\flowers.xml";

        StreamResult result = new StreamResult(new FileOutputStream(outputURL));

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.transform(source, result);
    }
}
