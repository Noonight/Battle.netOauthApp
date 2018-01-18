package ayur.arkhipov.ru.battlenetoauthapp.utils;


import ayur.arkhipov.ru.battlenetoauthapp.common.Language;

public class Role {
    public static String getRoleByName(String name) {
        if (Config.currentLanguage == Language.ru_RU) {
            if (name.equals(RoleNames.DPS)) {
                return "Нанесение урона";
            } else if (name.equals(RoleNames.HEALING)) {
                return "Исцеление";
            } else if (name.equals(RoleNames.TANK)) {
                return "Агрить";
            } else {
                return "Мастер арены";
            }
            /*switch (name) {
                case RoleNames.DPS:
                    return "Нанесение урона";
                case RoleNames.HEALING:
                    return "Исцеление";
                case RoleNames.TANK:
                    return "Агрить";
                default:
                    return "Мастер арены";
            }*/
        } else {
            return name;
        }
    }

    public class RoleNames {
        public static final String DPS = "DPS";
        public static final String HEALING = "HEALING";
        public static final String TANK = "TANK";
    }

}
