package telegramm.bot.sotis.domain.service.util;


import org.apache.commons.lang3.tuple.ImmutablePair;

public class CommonUtils {

    private static final ImmutablePair<String, String> FIRST = new ImmutablePair<>("I", "1");
    private static final ImmutablePair<String, String> SECOND = new ImmutablePair<>("II", "2");
    private static final ImmutablePair<String, String> THIRD = new ImmutablePair<>("III", "3");
    private static final ImmutablePair<String, String> FOURTH = new ImmutablePair<>("IV", "4");
    private static final ImmutablePair<String, String> FIFTH = new ImmutablePair<>("V", "5");
    private static final ImmutablePair<String, String> SIXTH = new ImmutablePair<>("VI", "6");
    private static final ImmutablePair<String, String> SEVENTH = new ImmutablePair<>("VII", "7");
    private static final ImmutablePair<String, String> EIGHTH = new ImmutablePair<>("VIII", "8");
    private static final ImmutablePair<String, String> NINTH = new ImmutablePair<>("IX", "9");
    private static final ImmutablePair<String, String> TENTH = new ImmutablePair<>("X", "10");
    private static final ImmutablePair<String, String> ELEVENTH = new ImmutablePair<>("XI", "11");
    private static final ImmutablePair<String, String> TWELFTH = new ImmutablePair<>("XII", "12");

    public static String changeHouse(String source) {

        return source
                .replace(TWELFTH.left, TWELFTH.right)
                .replace(ELEVENTH.left, ELEVENTH.right)
                .replace(TENTH.left, TENTH.right)
                .replace(NINTH.left, NINTH.right)
                .replace(EIGHTH.left, EIGHTH.right)
                .replace(SEVENTH.left, SEVENTH.right)
                .replace(SIXTH.left, SIXTH.right)
                .replace(FOURTH.left, FOURTH.right)
                .replace(FIFTH.left, FIFTH.right)
                .replace(THIRD.left, THIRD.right)
                .replace(SECOND.left, SECOND.right)
                .replace(FIRST.left, FIRST.right);
    }
}
