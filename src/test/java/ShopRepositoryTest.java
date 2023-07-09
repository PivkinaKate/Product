import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {


    @Test

    public void testDeleteProduct() {

        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(id:1, title:"футболка", price:10_000);
        Product product2 = new Product(id:2, title:"шорты", price:20_000);
        Product product3 = new Product(id:3, title:"джинсы", price:30_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(id:3);
        Product[] actual = repo.findAll();
        Product[] expected = {product1, product2};

        Assertions.assertArrayEquals(expected, actual);


    }


    @Test

    public void testRemoveWhenProductNoExist() {
        ShopRepository repo = new ShopRepository();

        Product product1 = new Product(id:1, title:"футболка", price:10_000);
        Product product2 = new Product(id:2, title:"шорты", price:20_000);
        Product product3 = new Product(id:3, title:"джинсы", price:30_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class,
                () -> repo.remove(id:4)
        );
    }
}
