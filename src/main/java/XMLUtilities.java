import com.thoughtworks.xstream.XStream;

public class XMLUtilities {

    private XStream xStream;

    public XMLUtilities(){
        this.xStream = new XStream();
        xStream.alias("person", Person.class);
    }

    public String personToXML(Person person){
        return xStream.toXML(person);
    }

    public Person XMLtoPerson(String xml){
        return (Person)xStream.fromXML(xml);
    }

}
