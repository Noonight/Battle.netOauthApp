package ayur.arkhipov.ru.battlenetoauthapp.utils;


import ayur.arkhipov.ru.battlenetoauthapp.R;
import ayur.arkhipov.ru.battlenetoauthapp.common.Language;

public class Races {

    public static String getStringRaceById(int id) {
        if (Config.currentLanguage == Language.ru_RU) {
            switch (id) {
                case 1:
                    return "Человек";
                case 2:
                    return "Орк";
                case 3:
                    return "Дворф";
                case 4:
                    return "Ночной эльф";
                case 5:
                    return "Нежить";
                case 6:
                    return "Таурен";
                case 7:
                    return "Гном";
                case 8:
                    return "Троль";
                case 9:
                    return "Новая расса аракоа";
                case 10:
                    return "Кровавый эльф";
                case 11:
                    return "Дреней";
                default:
                    return "Мертвый кабанчик";
            }
        } else {
            switch (id) {
                case 1:
                    return "Human";
                case 2:
                    return "Orc";
                case 3:
                    return "Dwarf";
                case 4:
                    return "Nightelf";
                case 5:
                    return "Undead";
                case 6:
                    return "Tauren";
                case 7:
                    return "Gnome";
                case 8:
                    return "Troll";
                case 10:
                    return "Blood elf";
                case 11:
                    return "Draenei";
                default:
                    return "Not correct id";
            }
        }
    }

}
