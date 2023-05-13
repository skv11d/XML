package stax;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {

        XMLInputFactory factory = XMLInputFactory.newFactory();

        Reader reader = new FileReader("C:\\Users\\maxim\\OneDrive\\Рабочий стол\\xmlht2\\task1\\src\\stax\\flowers.xml");
        XMLStreamReader xmlStreamReader = factory.createXMLStreamReader(reader);

        while (xmlStreamReader.hasNext()) {
            switch (xmlStreamReader.next()) {
                case XMLStreamReader.START_ELEMENT:
                    String elem = xmlStreamReader.getName().toString();
                    switch (elem) {
                        case "Plant":
                            for (int i = 0; i < xmlStreamReader.getAttributeCount(); i++) {
                                String attributeName = xmlStreamReader.getAttributeLocalName(i);
                                String attributeValue = xmlStreamReader.getAttributeValue(i);

                                System.out.println(attributeName + " " + attributeValue);
                            }
                            break;
                        case "Name":
                            System.out.println("Name: " + xmlStreamReader.getElementText());
                            break;
                        case "Soil":
                            System.out.println("Soil: " + xmlStreamReader.getElementText() + "\n");
                            break;
                        case "Origin":
                            System.out.println("Origin: " + xmlStreamReader.getElementText() + "\n");
                            break;
                        case "StemColor":
                            System.out.println("StemColor: " + xmlStreamReader.getElementText() + "\n");
                            break;
                        case "LeafColor":
                            System.out.println("LeafColor: " + xmlStreamReader.getElementText() + "\n");
                            break;
                        case "Size":
                            System.out.println("Size: " + xmlStreamReader.getElementText() + "\n");
                            break;
                        case "Temperature":
                            System.out.println("Temperature: " + xmlStreamReader.getElementText() + "\n");
                            break;
                        case "Lighting":
                            System.out.println("Lighting: " + xmlStreamReader.getElementText() + "\n");
                            break;
                        case "Watering":
                            System.out.println("Watering: " + xmlStreamReader.getElementText() + "\n");
                            break;
                        case "Multiplying":
                            System.out.println("Multiplying: " + xmlStreamReader.getElementText());
                            break;
                    }
            }
        }
    }
}
