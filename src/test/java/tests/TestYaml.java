package tests;

import java.io.InputStream;
import java.util.Map;
import org.yaml.snakeyaml.Yaml;
import properties.PropertiesData;

public class TestYaml {

  public static void main(String[] args) {
      TestYaml testYaml = new TestYaml();
      testYaml.simpleYaml();
  }

  public void simpleYaml(){
    Yaml yaml = new Yaml();
    InputStream inputStream = this.getClass()
        .getClassLoader()
        .getResourceAsStream("staging.yaml");
    PropertiesData data = yaml.load(inputStream);
  }


}
