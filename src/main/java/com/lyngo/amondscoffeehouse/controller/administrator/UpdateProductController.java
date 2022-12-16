package com.lyngo.amondscoffeehouse.controller.administrator;

import com.lyngo.amondscoffeehouse.dao.*;
import com.lyngo.amondscoffeehouse.dto.Product;
import com.lyngo.amondscoffeehouse.dto.ProductImage;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet(name = "UpdateProductController", value = "/UpdateProductController")
@MultipartConfig(fileSizeThreshold=1024*1024*10,
                 // file size after which the file will be temporarily stored on disk (default: 0)
                 maxFileSize=1024*1024*10,
                 // maximum size of an uploaded file (default: unlimited)
                 maxRequestSize=1024*1024*10*5
                 // maximum size of a multipart/form-data request which includes all uploaded files  (default: unlimited)
                 // all these size are in bytes
//                 location = ""
                 // absolute path to a directory on the file system (default "")
                 // where the file will be stored temporarily if parts are processed or file's size exceeds fileSizeThreshold
                )
public class UpdateProductController extends HttpServlet {
    private static final String IMAGE_INPUT_NAME = "imgPath";
    private static final String UPLOAD_DIRECTORY = "image" + File.separator + "products";

    private static final String ERROR = "errorPage.html";
    private static final String SUCCESS = "productManagementPage.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = ERROR;
        try {
            // update product information
            int productId = Integer.parseInt(request.getParameter("productId"));
            String productName = request.getParameter("productName");
            int categoryId = Integer.parseInt(request.getParameter("category"));
            BigDecimal price = new BigDecimal(request.getParameter("price"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            String description = request.getParameter("description");
            ICategoryDAO categoryDAO = new CategoryDAO();
            IProductDAO productDAO = new ProductDAO();
            productDAO.updateProduct(new Product(productId, productName,price,quantity,description, categoryDAO.getCategory(categoryId)));


            // update product image if any
            if(request.getParameter("imgPath") != null){
                IProductImagesDAO productImagesDAO = new ProductImagesDAO();
                String imgPath;
                String path = request.getServletContext().getRealPath("").split("target")[0]
                        + "src" + File.separator + "main" + "webapp" + File.separator + UPLOAD_DIRECTORY;
                // the absolute path of servlet context will look like this
                // ../project-name/target/artifactId-version
                File file = new File(path);
                if(!file.exists()){
                    file.mkdirs();
                }

                Product product = productDAO.getProduct(productId);
                int imgCount = product.getProductImages().size();
                for(Part part: request.getParts()){
                    if(part.getName().equals(IMAGE_INPUT_NAME)){
                        part.write(path + File.separator + productName + imgCount);
                        imgPath = UPLOAD_DIRECTORY + File.separator + productName + imgCount++;
                        productImagesDAO.insertProductImage(new ProductImage(imgPath, product));
                    }
                }
            }

            url = SUCCESS;
        } catch (Exception e){
            log("Error at UpdateProductController: " + e);
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
