package ayur.arkhipov.ru.battlenetoauthapp.utils;


import ayur.arkhipov.ru.battlenetoauthapp.R;

public class Races {

    public static String getStringRaceById(int id) {
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
