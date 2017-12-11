package ayur.arkhipov.ru.battlenetoauthapp.utils;


public class GenderConverter {
    public static String getGender(int id) {
        switch (id){
            case 0:
                return "Male";
            case 1:
                return "Female";
        }
        return "Gender code not correct";
    }
}
