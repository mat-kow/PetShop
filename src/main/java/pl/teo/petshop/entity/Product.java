package pl.teo.petshop.entity;

import org.hibernate.validator.constraints.EAN;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
public class Product {//todo messages
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Size(max = 50) @NotBlank
    @Column(length = 50)
    private String name;
    @Size(max = 50)
    @Column(length = 50)
    private String manufacturer;
    @Size(max = 50)
    @Column(length = 50)
    private String supplier;
    @EAN
    @Column (length = 13)
    private String ean;
    @Digits (integer = 4, fraction = 2)
    private BigDecimal price;
    private int weightGrams;
    private int stock;
    private String categories;
    private String description;
    private boolean active;
    @OneToOne
    private FileMetadata imageMeta;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public FileMetadata getImageMeta() {
        return imageMeta;
    }

    public void setImageMeta(FileMetadata image) {
        this.imageMeta = image;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getWeightGrams() {
        return weightGrams;
    }

    public void setWeightGrams(int weightGrams) {
        this.weightGrams = weightGrams;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
