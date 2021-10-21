package properties;

import java.io.InputStream;
import org.yaml.snakeyaml.Yaml;

public class PropertiesReader {

  public PropertiesData readProperties(){
    Yaml yaml = new Yaml();
    InputStream inputStream = this.getClass()
        .getClassLoader()
        .getResourceAsStream("staging.yaml");
    return yaml.load(inputStream);
  }

}
