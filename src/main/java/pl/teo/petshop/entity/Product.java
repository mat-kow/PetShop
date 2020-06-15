package pl.teo.petshop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;
import java.util.Objects;

@Entity @Getter @Setter
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String name;
    @Column(length = 50)
    private String manufacturer;
    @Column(length = 50)
    private String supplier;
    @Column (length = 13)
    private String ean;
    @Digits (integer = 4, fraction = 2)
    private BigDecimal price;
    private Integer weightGrams;
    private Integer stock;
    private String categories;
    @Column(length = 1000)
    private String description;
    private Boolean active;
    @OneToOne
    private FileMetadata imageMeta;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                name.equals(product.name) &&
                Objects.equals(manufacturer, product.manufacturer) &&
                Objects.equals(supplier, product.supplier) &&
                Objects.equals(ean, product.ean) &&
                Objects.equals(price, product.price) &&
                Objects.equals(weightGrams, product.weightGrams) &&
                Objects.equals(stock, product.stock) &&
                Objects.equals(categories, product.categories) &&
                Objects.equals(description, product.description) &&
                Objects.equals(active, product.active) &&
                Objects.equals(imageMeta, product.imageMeta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, manufacturer, supplier, ean, price, weightGrams, stock, categories, description, active, imageMeta);
    }
}
