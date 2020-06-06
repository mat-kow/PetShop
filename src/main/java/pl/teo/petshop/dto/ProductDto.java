package pl.teo.petshop.dto;

import org.hibernate.validator.constraints.EAN;
import pl.teo.petshop.entity.FileMetadata;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class ProductDto {
    private Long id;
    @Size(max = 50) @NotBlank
    private String name;
    @Size(max = 50)
    private String manufacturer;
    @Size(max = 50)
    private String supplier;
    @EAN
    private String ean;
    @Digits(integer = 4, fraction = 2)
    private BigDecimal price;
    private int weightGrams;
    private int stock;
    private String categories;
    @Size(max = 1000)
    private String description;
    private boolean active;
    private FileMetadata imageMeta;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
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

    public FileMetadata getImageMeta() {
        return imageMeta;
    }

    public void setImageMeta(FileMetadata imageMeta) {
        this.imageMeta = imageMeta;
    }
}
