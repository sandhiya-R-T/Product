package com.task.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.task.product.Product;
import com.task.service.ProductService;



@Controller
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    // For API endpoints
    @PostMapping("/add")
    @ResponseBody
    public Product addproductApi(@RequestBody Product product) {
         productService.saveProduct(product);
         return product;
    }

    @GetMapping("/display")
    @ResponseBody
    public List<Product> displayproductsApi() {
        return productService.getAllProducts();
    }

    @GetMapping("/display/{category}")
    @ResponseBody
    public List<Product> displayproductsByCategoryApi(@PathVariable String category) {
        return productService.getProductsByCategory(category);
    }
    
    @GetMapping("/test")
    @ResponseBody
    public String test() {
    	return "this is working";
    }

    // For html
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/addproduct")
    public String addProductForm() {
        return "addproduct";
    }

    @PostMapping("/saveproduct")
    public String saveProduct(@RequestParam("name") String name, @RequestParam("price") Double price, @RequestParam("category") String category) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setCategory(category);
        productService.saveProduct(product);
        return "redirect:/api/success";
    }

    @GetMapping("/displayproducts")
    public String displayProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "displayproducts";
    }
    
    @GetMapping("/success")
    public String success() {
        return "success";
    }
}
 
