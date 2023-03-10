package sphabucks.carts.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sphabucks.carts.model.Cart;
import sphabucks.carts.repository.ICartRepo;
import sphabucks.carts.vo.RequestCart;
import sphabucks.carts.vo.ResponseCart;
import sphabucks.carts.vo.ResponseCategoryList;
import sphabucks.payments.cards.vo.ResponseCard;
import sphabucks.products.model.Product;
import sphabucks.products.repository.IProductCategoryListRepository;
import sphabucks.products.repository.IProductRepository;
import sphabucks.users.model.User;
import sphabucks.users.repository.IUserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements ICartService{
    private final ICartRepo iCartRepo;
    private final IUserRepository iUserRepository;
    private final IProductRepository iProductRepository;
    private final IProductCategoryListRepository iProductCategoryListRepository;

    @Override
    public void addCart(RequestCart requestCart) {
        if(!iCartRepo.existsByProductId(requestCart.getProductId())){
            iCartRepo.save(Cart.builder()
                    .product(iProductRepository.findById(requestCart.getProductId()).get())
                    .user(iUserRepository.findById(requestCart.getUserId()).get())
                    .categoryId(iProductCategoryListRepository.findAllByProductId(requestCart.getProductId()).get(0).getBigCategory().getId())
                    .amount(requestCart.getAmount())
                    .price(iProductRepository.findById(requestCart.getProductId()).get().getPrice())
                    .name(iProductRepository.findById(requestCart.getProductId()).get().getName())
                    .isDelete(false)
                    .build());
        }else{
            Cart cart = iCartRepo.findAllByProductId(requestCart.getProductId()).get(0);
            cart.setAmount(cart.getAmount() + requestCart.getAmount());
            cart.setIsDelete(false);
            iCartRepo.save(cart);
        }

    }

    @Override
    public List<Cart> getCart(Long userId) {
        // userId ??? ?????? ????????? ???????????? ???????????? ???????????? ????????????.
        List<Cart> cartList = iCartRepo.findAllByUserId(userId);

        // List ??? ?????? ??????????????????.
        List<ResponseCart> responseCartList = new ArrayList<>();

        // ??????????????? ??????????????? ?????????
        // product ?????? ?????? ??????
        // isDelete??? true??? ?????? ????????? ??????
        return cartList;
    }

    @Override
    public Cart updateCart(RequestCart requestCart) {
        Cart cart = iCartRepo.findAllByProductIdAndUserId(requestCart.getProductId(), requestCart.getUserId()).get(0);
        cart.setAmount(requestCart.getAmount());
        iCartRepo.save(cart);

        return cart;
    }

    @Override
    @Transactional
    public void deleteCart(RequestCart requestCart) {
        List<Cart> cartlist = iCartRepo.findAllByUserId(requestCart.getUserId());
        Cart cart = null;
        for(int i=0;i<cartlist.size();i++){
            if(cartlist.get(i).getProduct().getId().equals(requestCart.getProductId())){
                cart = cartlist.get(i);
            }
        }
        if (cart != null) {
            cart.setIsDelete(true);
        }
    }

    @Override
    @Transactional
    public void deleteAll(RequestCart requestCart) {
        List<Cart> cartList = iCartRepo.findAllByUserId(requestCart.getUserId());
        for(Cart cart:cartList){
            cart.setIsDelete(true);
        }
    }


}
