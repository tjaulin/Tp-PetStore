package fr.sdv.b32122.bo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class PetStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String managerName;
    @OneToOne
    @JoinColumn(unique = true)
    private Address address;
    @OneToMany(mappedBy = "petStore")
    private Set<Animal> animals;
    @ManyToMany
    @JoinTable(name = "PETS_PROD", joinColumns = @JoinColumn(name = "ID_PETS", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ID_PROD", referencedColumnName = "id") )
    private Set<Product> products;

    {
        this.products = new HashSet<>();
        this.animals = new HashSet<>();
    }

    public PetStore() {}

    public PetStore(String name, String managerName) {
        this.name = name;
        this.managerName = managerName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(Set<Animal> animals) {
        this.animals = animals;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public void addProducts(Product product) {
        this.products.add(product);
        product.getPetStores().remove(this);
    }
}
