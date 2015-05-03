
package buildingmaintenance.conf.factory;


import buildingmaintenance.domain.Address;

import java.util.Map;

/**
 *
 * @author Nkosy
 */
public class AddressFactory {
    public static Address createAddress(int zipcode,
                                        int streetno,
                                        Map<String, String> values){
        Address address = new Address.Builder(streetno)
                .zipCode(zipcode)
                .streetName(values.get("streetName"))
                .city(values.get("city"))
                .build();
        return address;
    }
}
