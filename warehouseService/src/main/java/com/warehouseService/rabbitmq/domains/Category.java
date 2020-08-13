<<<<<<< HEAD:warehouseService/src/main/java/com/techriders/logisticservice/domains/Category.java
package com.techriders.logisticservice.domains;
=======
package com.warehouseService.rabbitmq.domains;
>>>>>>> 74e49a5e86fbe11f21dd98e2f840978f217ebe7a:warehouseService/src/main/java/com/warehouseService/rabbitmq/domains/Category.java

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Category {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Size(min=6,max=20)
    @NotBlank
    private String name;

    @Column(name="description", length=800)
    private String description;

    public Category() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category(Integer id, @Size(min = 6, max = 20) @NotBlank String name, @Size(max = 65535) String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
