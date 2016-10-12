package smart4aviation.utilities;

/**
 * Created by Andy on 10/7/2016.
 */
public class BillingAddress {
    private String country;
    private String stateProvince;
    private String city;
    private String address1;
    private String zip;
    private String phoneNumber;

    public BillingAddress(String country, String stateProvince, String city, String address1, String zip, String phoneNumber) {
        this.country = country;
        this.stateProvince = stateProvince;
        this.city = city;
        this.address1 = address1;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
