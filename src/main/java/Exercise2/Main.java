package Exercise2;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        JobPosition jobPosition = new JobPosition.Builder(new Date(), "CEO", true)
                .description("BlaBla")
                .build();
        System.out.println();
    }
}
