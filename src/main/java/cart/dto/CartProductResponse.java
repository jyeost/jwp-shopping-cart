package cart.dto;

import cart.entity.CartProduct;

public class CartProductResponse {
    private final int id;
    private final String name;
    private final int price;
    private final String image;

    private CartProductResponse(int id, String name, int price, String image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public static CartProductResponse from(CartProduct cartProduct) {
        return new CartProductResponse(cartProduct.getCartId(), cartProduct.getName(), cartProduct.getPrice(), cartProduct.getImage());
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }
}