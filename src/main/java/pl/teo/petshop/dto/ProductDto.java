package pl.teo.petshop.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.EAN;
import pl.teo.petshop.entity.FileMetadata;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

@Getter @Setter @NoArgsConstructor
public class ProductDto {
    private Long id;
    @Size(max = 50, message = "{Size.productDto.name}") @NotBlank(message = "{NotBlank.productDto}")
    private String name;
    @Size(max = 50, message = "{Size.productDto.manufacturer}")
    private String manufacturer;
    @Size(max = 50, message = "{Size.productDto.supplier}")
    private String supplier;
    @EAN(message = "{EAN.productDto.ean}")
    private String ean;
    @Digits(integer = 4, fraction = 2, message = "{Digits.productDto.price}")
    private BigDecimal price;
    private Integer weightGrams;
    private Integer stock;
    private String categories;
    @Size(max = 1000, message = "{Size.productDto.description}")
    private String description;
    private Boolean active;
    private FileMetadata imageMeta;

    public ProductDto(@Size(max = 50, message = "{Size.productDto.name}") @NotBlank(message = "{NotBlank.productDto}") String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto that = (ProductDto) o;
        return Objects.equals(id, that.id) &&
                name.equals(that.name) &&
                Objects.equals(manufacturer, that.manufacturer) &&
                Objects.equals(supplier, that.supplier) &&
                Objects.equals(ean, that.ean) &&
                Objects.equals(price, that.price) &&
                Objects.equals(weightGrams, that.weightGrams) &&
                Objects.equals(stock, that.stock) &&
                Objects.equals(categories, that.categories) &&
                Objects.equals(description, that.description) &&
                Objects.equals(active, that.active) &&
                Objects.equals(imageMeta, that.imageMeta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, manufacturer, supplier, ean, price, weightGrams, stock, categories, description, active, imageMeta);
    }
}
