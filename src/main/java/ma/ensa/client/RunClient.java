package ma.ensa.client;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class RunClient {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new
                AnnotationConfigApplicationContext(CountryClientConfig.class);
        CountryClient client = context.getBean(CountryClient.class);

        GetCountryRequest request = new GetCountryRequest();
        request.setName("Morocco");
        GetCountryResponse resp = client.getCountry(request);
        System.out.println("response: " + resp.getCountry().getCapital());
    }
}