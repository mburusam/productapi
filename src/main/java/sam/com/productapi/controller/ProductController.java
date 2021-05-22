package sam.com.productapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sam.com.productapi.model.Product;
import sam.com.productapi.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/allproducts")
    public List<Product> GetAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/productById/{id}")
    public Product getProductById(@PathVariable int id) {
        return productService.getProductByID(id);
    }

    @GetMapping("/productByname/{name}")
    public Product getProductByName(@PathVariable String name) {
        return productService.getProductByName(name);
    }

    @PutMapping("/updateproduct")

    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @PostMapping("/addproduct")
    public Product AddProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    //save products
    @PostMapping("/addproducts")
    public List<Product> AddProducts(@RequestBody List<Product> products) {
        return productService.saveProducts(products);
    }


    //delete
    @DeleteMapping("delete/{id}")
    public String deleteById(@PathVariable int id) {
        return productService.deleteProduct(id);
    }

}

