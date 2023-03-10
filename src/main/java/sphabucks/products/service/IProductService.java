package sphabucks.products.service;

import sphabucks.products.model.Product;
import sphabucks.products.vo.RequestProduct;
import sphabucks.products.vo.ResponseProduct;
import sphabucks.products.vo.ResponseSearchMenu;
import sphabucks.products.vo.ResponseSearchProduct;

import java.util.List;

public interface IProductService {
    void addProduct(RequestProduct requestProduct);
    ResponseProduct getProduct(Long productId);
    List<Product> getAll();

    // 베스트 상품 조회 메서드 (대분류 카테고리별 조회)
    List<ResponseProduct> getBestBigCategory(Integer bigCategoryId);

    // 상품 검색 메서드 (키워드 검색)
    List<ResponseSearchProduct> searchProductKeyword(String keyword);

    // 상품 검색 상단 메뉴 호출 (키워드 검색)
    ResponseSearchMenu searchProductKeywordMenu(String keyword);

}
