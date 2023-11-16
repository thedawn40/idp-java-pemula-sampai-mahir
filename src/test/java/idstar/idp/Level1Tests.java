package idstar.idp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class Level1Tests {


    @Test
    void testKuadrat() {

        Level1 level1 = new Level1();

        int result = level1.kuadrat(9);
        System.out.println(result);

    }

    @Test
    void testKelipatan(){

        Level1 level1 = new Level1();

        level1.kelipatanTigaDanLima(50);

    }

    @Test
    void testNomor10(){
        Level1 level1 = new Level1();

        level1.nomor10();

    }
}
