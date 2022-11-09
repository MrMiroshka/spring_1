package ru.geekbrains.hw1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class modProducts {
    static List<Integer> idList;
    static boolean flag = false;

    public static Product generateProduct() {
        if (!flag) {
            idList = new ArrayList<>(10);
            flag=true;
        }
        int id;
        while (true) {
            id = 1 + (int) (new Random().nextFloat() * (42));
            if (idList.indexOf(id)!=-1) {
                continue;
            }else {
                idList.add(id);
                break;
            }
        }

        return new Product.Builder().
                cost(1 + (int) (new Random().nextFloat() * (200))).
                id(id).
                title(ProductsName.values()[new Random().nextInt(ProductsName.values().length - 1)].getTitle()).
                build();
    }
}
