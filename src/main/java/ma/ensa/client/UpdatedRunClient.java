package ma.ensa.client;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class UpdatedRunClient {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(CountryClientConfig.class);
        CountryClient client = context.getBean(CountryClient.class);

        // UpdateCountry operation
        UpdateCountryRequest updateRequest = new UpdateCountryRequest();
        Country updatedCountry = new Country();
        updatedCountry.setName("Morocco");
        updatedCountry.setCapital("Updated Rabat");
        updatedCountry.setPopulation(38000000);
        updatedCountry.setCurrency(Currency.EUR);
        updateRequest.setCountry(updatedCountry);
        UpdateCountryResponse updateResponse = client.updateCountry(updateRequest);
        System.out.println("UpdateCountry Response: " + updateResponse.getStatus());

        // DeleteCountry operation
        DeleteCountryRequest deleteRequest = new DeleteCountryRequest();
        deleteRequest.setName("France");
        DeleteCountryResponse deleteResponse = client.deleteCountry(deleteRequest);
        System.out.println("DeleteCountry Response: " + deleteResponse.getStatus());

        // GetCountry operation
        GetCountryRequest getRequest = new GetCountryRequest();
        getRequest.setName("Morocco");
        GetCountryResponse getResponse = client.getCountry(getRequest);
        if (getResponse.getCountry() != null) {
            System.out.println("GetCountry Response: " + getResponse.getCountry().getCapital());
        } else {
            System.out.println("Country not found.");
        }

        // GetAllCountries operation
        GetAllCountriesRequest getAllRequest = new GetAllCountriesRequest();
        GetAllCountriesResponse getAllResponse = client.getAllCountries(getAllRequest);
        System.out.println("GetAllCountries Response: ");
        getAllResponse.getCountries().forEach(country ->
                System.out.println("Country: " + country.getName() + ", Capital: " + country.getCapital() + ", Currency: " +country.getCurrency())
        );

        context.close();
    }
}
