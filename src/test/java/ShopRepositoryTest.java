import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

 public class ShopRepositoryTest {


    @Test

    public void testDeleteProduct() {

        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "юбка", 10_000);
        Product product2 = new Product(2, "шорты", 20_000);
        Product product3 = new Product(3, "джинсы", 30_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(1);
        Product[] actual = repo.findAll();
        Product[] expected = {product2, product3};

        Assertions.assertArrayEquals(expected, actual);


    }


    @Test

    public void testRemoveWhenProductNoExist() {
        ShopRepository repo = new ShopRepository();

        Product product1 = new Product(1, "юбка", 10_000);
        Product product2 = new Product(2, "шорты", 20_000);
        Product product3 = new Product(3, "джинсы", 30_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class,
                () -> repo.remove(5)
        );
    }

     @Test

     public void testDeleteExistProduct() {

         ShopRepository repo = new ShopRepository();
         Product product1 = new Product(1, "юбка", 10_000);
         Product product2 = new Product(2, "шорты", 20_000);
         Product product3 = new Product(3, "джинсы", 30_000);

         repo.add(product1);
         repo.add(product2);
         repo.add(product3);
         repo.remove(3);
         Product[] actual = repo.findAll();
         Product[] expected = {product1, product2};

         Assertions.assertArrayEquals(expected, actual);


     }
}
