@DataType
public class Owner {
    
    @Property()
    private final Long id;

    @Property()
    private final String name;

    @Property()
    private final String type;

    @Property()
    private final Address address;


    public Owner() {
    }

    public Owner(Long id, String name, String type, Address address) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.address = address;
    }

    public Long getId() {
        return this.id;
    }


    public String getName() {
        return this.name;
    }


    public String getType() {
        return this.type;
    }


    public Address getAddress() {
        return this.address;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Owner)) {
            return false;
        }
        Owner owner = (Owner) o;
        return Objects.equals(id, owner.id) && Objects.equals(name, owner.name) && Objects.equals(type, owner.type) && Objects.equals(address, owner.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, address);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", type='" + getType() + "'" +
            ", address='" + getAddress() + "'" +
            "}";
    }

}
