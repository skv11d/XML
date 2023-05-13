import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {

        XMLInputFactory factory = XMLInputFactory.newFactory();

        Reader reader = new FileReader("C:\\Users\\maxim\\OneDrive\\Рабочий стол\\xmlht2\\task2\\src\\candies.xml");
        XMLStreamReader xmlStreamReader = factory.createXMLStreamReader(reader);

        while (xmlStreamReader.hasNext()) {
            switch (xmlStreamReader.next()) {
                case XMLStreamReader.START_ELEMENT:
                    String elem = xmlStreamReader.getName().toString();
                    switch (elem) {
                        case "candy":
                            for (int i = 0; i < xmlStreamReader.getAttributeCount(); i++) {
                                String attributeName = xmlStreamReader.getAttributeLocalName(i);
                                String attributeValue = xmlStreamReader.getAttributeValue(i);

                                System.out.println(attributeName + " " + attributeValue);
                            }
                            break;
                        case "name":
                            System.out.println("Name: " + xmlStreamReader.getElementText());
                            break;
                        case "flavor":
                            System.out.println("Flavor: " + xmlStreamReader.getElementText());
                            break;
                        case "color":
                            System.out.println("Color: " + xmlStreamReader.getElementText() + "\n");
                            break;
                    }
            }
        }
    }
}
