import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            File file = new File("C:\\Users\\maxim\\OneDrive\\Рабочий стол\\xmlht1\\task1\\src\\example.xml");
            Document doc = builder.parse(file);

            NodeList titleNodes = doc.getElementsByTagName("title");
            Pattern pattern = Pattern.compile("<title>(.*?)</title>");
            for (int i = 0; i < titleNodes.getLength(); i++) {
                Element titleElement = (Element) titleNodes.item(i);
                String titleText = titleElement.getTextContent();
                Matcher matcher = pattern.matcher(titleText);
                if (matcher.find()) {
                    System.out.println(matcher.group(1));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}