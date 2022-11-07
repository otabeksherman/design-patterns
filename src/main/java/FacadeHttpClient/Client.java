package FacadeHttpClient;

import java.util.concurrent.ThreadLocalRandom;

public class Client {
    public static void main(String[] args) {
        HttpFacade httpFacade = new HttpFacade();

        int id = ThreadLocalRandom.current().nextInt(10);
        System.out.println(String.format("Email of user with id %d is: %s", id,
                httpFacade.getUserEmailById(id)));

        System.out.println("New User's ID: "+
                httpFacade.createUser("morpheus", "leader"));

        System.out.println("User updated with a PUT method at " +
                httpFacade.updateUserByIdWithPut(2, "Bob", "Musician"));

        System.out.println("User updated with a PATCH method at " +
                httpFacade.updateUserByIdWithPatch(6, "Bill", "Farmer"));

        if (httpFacade.deleteUserById(2)) {
            System.out.println("User deleted successfully");
        } else {
            System.out.println("User not deleted successfully");
        }
    }
}
