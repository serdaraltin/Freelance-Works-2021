
import java.io.Serializable;

public class Person implements Serializable {

    private static final long serialVersionUID = -3828358934295900759L;
    private String id;
    private String name;
    private String contactNo;
    private String address;
    private String licenseNo;

    public Person() {

    }

    public Person(String id, String name, String contactNo, String address, String licenseNo) {
        super();
        this.id = id;
        this.name = name;
        this.contactNo = contactNo;
        this.address = address;
        this.licenseNo = licenseNo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Person other = (Person) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "\nId         : " + id
                + "\nName       : " + name
                + "\nContact No : " + contactNo
                + "\nAddress    : " + address
                + "\nLicance No : " + licenseNo;
    }

}
