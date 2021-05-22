package sam.com.productapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sam.com.productapi.model.Product;
import sam.com.productapi.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    //GetAllProducts

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    //GetAProductByID
    public Product getProductByID(int id){
        return productRepository.findById(id).orElseThrow(null);
    }
    //Get A Product By Name
    public Product getProductByName(String name){
        return productRepository.findByName(name);
    }

    //save A product
    public Product saveProduct(Product product){
        return productRepository.save(product);

    }
    //save a list of Products
    public  List<Product> saveProducts(List<Product> products){
        return productRepository.saveAll(products);

    }

    //update a products
    //update a product by name
    public Product updateProduct(Product product){
        Product existingProduct= productRepository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuality(product.getQuality());
        existingProduct.setPrice(product.getPrice());

        return productRepository.save(existingProduct);

    }


    //delete a product
    public String deleteProduct(int id){
        productRepository.deleteById(id);
        return "Product deleted "+ id;

    }

}
