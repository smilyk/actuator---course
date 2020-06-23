package smilyk.actuator.endpoints;

import org.springframework.boot.actuate.endpoint.AbstractEndpoint;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class MyCustomEndpoint extends AbstractEndpoint<List<String>> {


    public MyCustomEndpoint() {

        // id = path
        super("mycustomendpoint");
    }

    @Override
    public List<String> invoke() {

        List<String> jamBands = new ArrayList<>(5);
        jamBands.add("Umphrey's McGee");
        jamBands.add("String Cheese Incident");
        jamBands.add("moe.");
        jamBands.add("Tauk");
        jamBands.add("Widespread Panic");

        return jamBands;
    }
}
