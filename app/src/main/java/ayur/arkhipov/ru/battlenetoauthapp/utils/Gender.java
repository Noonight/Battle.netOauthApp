package ayur.arkhipov.ru.battlenetoauthapp.utils;


import ayur.arkhipov.ru.battlenetoauthapp.common.Language;

public class Gender {
    public static String getGender(int id) {
        if (Config.currentLanguage == Language.ru_RU) {
            switch (id) {
                case 0:
                    return "Мужчина";
                case 1:
                    return "Женщина";
                default:
                    return "Гермофродит";
            }
        } else {
            switch (id) {
                case 0:
                    return "Male";
                case 1:
                    return "Female";
                default:
                    return "Gender code not correct";
            }
        }
    }
}
