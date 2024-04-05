package fpoly.huyndph40487.qlda_bantrsua.authorization.data;

import fpoly.huyndph40487.qlda_bantrsua.authorization.data.model.User;

public final class UserFactory {
    private static User currentUser = null;

    public static void signIn(User user) {
        currentUser = user;
    }

    public static User getCurrentUser() {
        return currentUser;
    }
}