package ma.ensa.client;

import ma.ensa.mysoapservice.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class CountryClient extends WebServiceGatewaySupport {

    // Existing getCountry method
    public GetCountryResponse getCountry(GetCountryRequest request) {
        return (GetCountryResponse) getWebServiceTemplate()
                .marshalSendAndReceive(request);
    }

    // AddCountry method
    public AddCountryResponse addCountry(AddCountryRequest request) {
        return (AddCountryResponse) getWebServiceTemplate()
                .marshalSendAndReceive(request);
    }

    // UpdateCountry method
    public UpdateCountryResponse updateCountry(UpdateCountryRequest request) {
        return (UpdateCountryResponse) getWebServiceTemplate()
                .marshalSendAndReceive(request);
    }

    // DeleteCountry method
    public DeleteCountryResponse deleteCountry(DeleteCountryRequest request) {
        return (DeleteCountryResponse) getWebServiceTemplate()
                .marshalSendAndReceive(request);
    }

    // GetAllCountries method
    public GetAllCountriesResponse getAllCountries(GetAllCountriesRequest request) {
        return (GetAllCountriesResponse) getWebServiceTemplate()
                .marshalSendAndReceive(request);
    }
}
