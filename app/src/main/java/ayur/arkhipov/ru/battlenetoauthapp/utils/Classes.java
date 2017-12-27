package ayur.arkhipov.ru.battlenetoauthapp.utils;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;

import ayur.arkhipov.ru.battlenetoauthapp.R;

public class Classes {
    public static String getClassString(int id) {
        switch (id) {
            case 1:
                return "Warrior";
            case 2:
                return "Paladin";
            case 3:
                return "Hunter";
            case 4:
                return "Rogue";
            case 5:
                return "Priest";
            case 6:
                return "Death Knight";
            case 7:
                return "Shaman";
            case 8:
                return "Mage";
            case 9:
                return "Warlock";
            case 10:
                return "Monk";
            case 11:
                return "Druid";
            case 12:
                return "Demon Hunter";
            default:
                return "races not found";
        }
    }


    public static Integer getClassDrawableIconResId(int id) {
        switch (id) {
            case 1:
                return R.drawable.classicon_warrior;
            case 2:
                return R.drawable.classicon_paladin;
            case 3:
                return R.drawable.classicon_hunter;
            case 4:
                return R.drawable.classicon_rogue;
            case 5:
                return R.drawable.classicon_priest;
            case 6:
                return R.drawable.classicon_deathknight;
            case 7:
                return R.drawable.classicon_shaman;
            case 8:
                return R.drawable.classicon_mage;
            case 9:
                return R.drawable.classicon_warlock;
            case 10:
                return R.drawable.classicon_monk;
            case 11:
                return R.drawable.classicon_druid;
            case 12:
                return R.drawable.classicon_demonhunter;
            default:
                return R.mipmap.wow_logo;
        }
    }

    public static Integer getClassColorResId(int id) {
        switch (id) {
            case 1:
                return R.color.colorClassWarrior;
            case 2:
                return R.color.colorClassPaladin;
            case 3:
                return R.color.colorClassHunter;
            case 4:
                return R.color.colorClassRogue;
            case 5:
                return R.color.colorClassPriest;
            case 6:
                return R.color.colorClassDeathKnight;
            case 7:
                return R.color.colorClassShaman;
            case 8:
                return R.color.colorClassMage;
            case 9:
                return R.color.colorClassWarlock;
            case 10:
                return R.color.colorClassMonk;
            case 11:
                return R.color.colorClassDruid;
            case 12:
                return R.color.colorClassDemonHunter;
            default:
                return R.color.colorWhite;
        }
    }
}
