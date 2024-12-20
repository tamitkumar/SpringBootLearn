package techbrain.think.insight.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import techbrain.think.insight.dto.Product;
import techbrain.think.insight.exception.ProductNotfoundException;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class TechBrainController {

    private static Map<String, Product> productRepo = new HashMap<>();

    static {
        Product honey = new Product();
        honey.setId("1");
        honey.setName("Honey");
        productRepo.put(honey.getId(), honey);
        Product almond = new Product();
        almond.setId("2");
        almond.setName("Almond");
        productRepo.put(almond.getId(), almond);
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<Object> getProducts() {
        return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
    }

    @PostMapping(value = "/add", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Object> createProduct(@RequestBody Product product)
    {
        productRepo.put(product.getId(), product);
        return new ResponseEntity<>("Product is created successfully",
                HttpStatus.CREATED);
    }

    @PutMapping(value = "/update/{id}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id,
                                                @RequestBody Product product) {
        if(!productRepo.containsKey(id))
            throw new ProductNotfoundException();
        productRepo.remove(id);
        product.setId(id);
        productRepo.put(id, product);
        return new ResponseEntity<>("Product is updated successfully",
                HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}", produces = "application/json")
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        productRepo.remove(id);
        return new ResponseEntity<>("Product is deleted successfully",
                HttpStatus.OK);
    }

    @GetMapping("/health")
    public String healthCheck() {
        return "UP";
    }


    @GetMapping("/welcome")
    public String greetings() {
        return "Hello Techie , AWS CICD Example working fine !";
    }
}
