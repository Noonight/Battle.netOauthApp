package ayur.arkhipov.ru.battlenetoauthapp.common.network.model;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Sc2Profile implements Parcelable {

    private List<CharactersBean> characters;

    public Sc2Profile(Parcel in) {
    }

    @Override
    public String toString() {
        return "Sc2Profile{" +
                "characters=" + characters +
                '}';
    }

    public static final Creator<Sc2Profile> CREATOR = new Creator<Sc2Profile>() {
        @Override
        public Sc2Profile createFromParcel(Parcel in) {
            return new Sc2Profile(in);
        }

        @Override
        public Sc2Profile[] newArray(int size) {
            return new Sc2Profile[size];
        }
    };

    public Sc2Profile() {

    }

    public List<CharactersBean> getCharacters() {
        return characters;
    }

    public void setCharacters(List<CharactersBean> characters) {
        this.characters = characters;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }

    public static class CharactersBean {
        @Override
        public String toString() {
            return "CharactersBean{" +
                    "id=" + id +
                    ", realm=" + realm +
                    ", name='" + name + '\'' +
                    ", displayName='" + displayName + '\'' +
                    ", clanName='" + clanName + '\'' +
                    ", clanTag='" + clanTag + '\'' +
                    ", profilePath='" + profilePath + '\'' +
                    ", portrait=" + portrait +
                    ", avatar=" + avatar +
                    ", career=" + career +
                    ", swarmLevels=" + swarmLevels +
                    ", campaign=" + campaign +
                    ", season=" + season +
                    ", rewards=" + rewards +
                    ", achievements=" + achievements +
                    '}';
        }

        /**
         * id : 5990790
         * realm : 1
         * name : Monni#159
         * displayName : Monni
         * clanName :
         * clanTag :
         * profilePath : /profile/5990790/1/Monni/
         * portrait : {"x":0,"y":0,"w":90,"h":90,"offset":0,"url":"http://media.blizzard.com/sc2/portraits/0-90.jpg"}
         * avatar : {"x":0,"y":0,"w":90,"h":90,"offset":0,"url":"http://media.blizzard.com/sc2/portraits/0-0.jpg"}
         * career : {"primaryRace":"UNKNOWN","terranWins":0,"protossWins":0,"zergWins":0,"seasonTotalGames":0,"careerTotalGames":0}
         * swarmLevels : {"level":0,"terran":{"level":0,"totalLevelXP":5000,"currentLevelXP":0},"zerg":{"level":0,"totalLevelXP":5000,"currentLevelXP":0},"protoss":{"level":0,"totalLevelXP":5000,"currentLevelXP":0}}
         * campaign : {}
         * season : {"seasonId":34,"seasonNumber":4,"seasonYear":2017,"totalGamesThisSeason":0}
         * rewards : {"selected":[18730036,656055948,1333792768,1500394717,1751841167,2009110693,2359737029,2820704051,2951153716,3065782512,3673336716,3717180683,3979921667,4067220888],"earned":[1159285604,3484380374,4179780094]}
         * achievements : {"points":{"totalPoints":10,"categoryPoints":{"4330138":0,"4386911":0,"4364473":0,"4325379":10,"4325410":0,"4325377":0}},"achievements":[{"achievementId":91475035553880,"completionDate":1429507199}]}
         */

        private int id;
        private int realm;
        private String name;
        private String displayName;
        private String clanName;
        private String clanTag;
        private String profilePath;
        private PortraitBean portrait;
        private AvatarBean avatar;
        private CareerBean career;
        private SwarmLevelsBean swarmLevels;
        private CampaignBean campaign;
        private SeasonBean season;
        private RewardsBean rewards;
        private AchievementsBeanX achievements;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getRealm() {
            return realm;
        }

        public void setRealm(int realm) {
            this.realm = realm;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDisplayName() {
            return displayName;
        }

        public void setDisplayName(String displayName) {
            this.displayName = displayName;
        }

        public String getClanName() {
            return clanName;
        }

        public void setClanName(String clanName) {
            this.clanName = clanName;
        }

        public String getClanTag() {
            return clanTag;
        }

        public void setClanTag(String clanTag) {
            this.clanTag = clanTag;
        }

        public String getProfilePath() {
            return profilePath;
        }

        public void setProfilePath(String profilePath) {
            this.profilePath = profilePath;
        }

        public PortraitBean getPortrait() {
            return portrait;
        }

        public void setPortrait(PortraitBean portrait) {
            this.portrait = portrait;
        }

        public AvatarBean getAvatar() {
            return avatar;
        }

        public void setAvatar(AvatarBean avatar) {
            this.avatar = avatar;
        }

        public CareerBean getCareer() {
            return career;
        }

        public void setCareer(CareerBean career) {
            this.career = career;
        }

        public SwarmLevelsBean getSwarmLevels() {
            return swarmLevels;
        }

        public void setSwarmLevels(SwarmLevelsBean swarmLevels) {
            this.swarmLevels = swarmLevels;
        }

        public CampaignBean getCampaign() {
            return campaign;
        }

        public void setCampaign(CampaignBean campaign) {
            this.campaign = campaign;
        }

        public SeasonBean getSeason() {
            return season;
        }

        public void setSeason(SeasonBean season) {
            this.season = season;
        }

        public RewardsBean getRewards() {
            return rewards;
        }

        public void setRewards(RewardsBean rewards) {
            this.rewards = rewards;
        }

        public AchievementsBeanX getAchievements() {
            return achievements;
        }

        public void setAchievements(AchievementsBeanX achievements) {
            this.achievements = achievements;
        }

        public static class PortraitBean {
            @Override
            public String toString() {
                return "PortraitBean{" +
                        "x=" + x +
                        ", y=" + y +
                        ", w=" + w +
                        ", h=" + h +
                        ", offset=" + offset +
                        ", url='" + url + '\'' +
                        '}';
            }

            /**
             * x : 0
             * y : 0
             * w : 90
             * h : 90
             * offset : 0
             * url : http://media.blizzard.com/sc2/portraits/0-90.jpg
             */

            private int x;
            private int y;
            private int w;
            private int h;
            private int offset;
            private String url;

            public int getX() {
                return x;
            }

            public void setX(int x) {
                this.x = x;
            }

            public int getY() {
                return y;
            }

            public void setY(int y) {
                this.y = y;
            }

            public int getW() {
                return w;
            }

            public void setW(int w) {
                this.w = w;
            }

            public int getH() {
                return h;
            }

            public void setH(int h) {
                this.h = h;
            }

            public int getOffset() {
                return offset;
            }

            public void setOffset(int offset) {
                this.offset = offset;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class AvatarBean {
            @Override
            public String toString() {
                return "AvatarBean{" +
                        "x=" + x +
                        ", y=" + y +
                        ", w=" + w +
                        ", h=" + h +
                        ", offset=" + offset +
                        ", url='" + url + '\'' +
                        '}';
            }

            /**
             * x : 0
             * y : 0
             * w : 90
             * h : 90
             * offset : 0
             * url : http://media.blizzard.com/sc2/portraits/0-0.jpg
             */

            private int x;
            private int y;
            private int w;
            private int h;
            private int offset;
            private String url;

            public int getX() {
                return x;
            }

            public void setX(int x) {
                this.x = x;
            }

            public int getY() {
                return y;
            }

            public void setY(int y) {
                this.y = y;
            }

            public int getW() {
                return w;
            }

            public void setW(int w) {
                this.w = w;
            }

            public int getH() {
                return h;
            }

            public void setH(int h) {
                this.h = h;
            }

            public int getOffset() {
                return offset;
            }

            public void setOffset(int offset) {
                this.offset = offset;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class CareerBean {
            @Override
            public String toString() {
                return "CareerBean{" +
                        "primaryRace='" + primaryRace + '\'' +
                        ", terranWins=" + terranWins +
                        ", protossWins=" + protossWins +
                        ", zergWins=" + zergWins +
                        ", seasonTotalGames=" + seasonTotalGames +
                        ", careerTotalGames=" + careerTotalGames +
                        '}';
            }

            /**
             * primaryRace : UNKNOWN
             * terranWins : 0
             * protossWins : 0
             * zergWins : 0
             * seasonTotalGames : 0
             * careerTotalGames : 0
             */

            private String primaryRace;
            private int terranWins;
            private int protossWins;
            private int zergWins;
            private int seasonTotalGames;
            private int careerTotalGames;

            public String getPrimaryRace() {
                return primaryRace;
            }

            public void setPrimaryRace(String primaryRace) {
                this.primaryRace = primaryRace;
            }

            public int getTerranWins() {
                return terranWins;
            }

            public void setTerranWins(int terranWins) {
                this.terranWins = terranWins;
            }

            public int getProtossWins() {
                return protossWins;
            }

            public void setProtossWins(int protossWins) {
                this.protossWins = protossWins;
            }

            public int getZergWins() {
                return zergWins;
            }

            public void setZergWins(int zergWins) {
                this.zergWins = zergWins;
            }

            public int getSeasonTotalGames() {
                return seasonTotalGames;
            }

            public void setSeasonTotalGames(int seasonTotalGames) {
                this.seasonTotalGames = seasonTotalGames;
            }

            public int getCareerTotalGames() {
                return careerTotalGames;
            }

            public void setCareerTotalGames(int careerTotalGames) {
                this.careerTotalGames = careerTotalGames;
            }
        }

        public static class SwarmLevelsBean {
            public static class TerranBean {
                @Override
                public String toString() {
                    return "TerranBean{" +
                            "level=" + level +
                            ", totalLevelXP=" + totalLevelXP +
                            ", currentLevelXP=" + currentLevelXP +
                            '}';
                }

                /**
                 * level : 0
                 * totalLevelXP : 5000
                 * currentLevelXP : 0
                 */

                private int level;
                private int totalLevelXP;
                private int currentLevelXP;

                public int getLevel() {
                    return level;
                }

                public void setLevel(int level) {
                    this.level = level;
                }

                public int getTotalLevelXP() {
                    return totalLevelXP;
                }

                public void setTotalLevelXP(int totalLevelXP) {
                    this.totalLevelXP = totalLevelXP;
                }

                public int getCurrentLevelXP() {
                    return currentLevelXP;
                }

                public void setCurrentLevelXP(int currentLevelXP) {
                    this.currentLevelXP = currentLevelXP;
                }
            }

            public static class ZergBean {
                @Override
                public String toString() {
                    return "ZergBean{" +
                            "level=" + level +
                            ", totalLevelXP=" + totalLevelXP +
                            ", currentLevelXP=" + currentLevelXP +
                            '}';
                }

                /**
                 * level : 0
                 * totalLevelXP : 5000
                 * currentLevelXP : 0
                 */

                private int level;
                private int totalLevelXP;
                private int currentLevelXP;

                public int getLevel() {
                    return level;
                }

                public void setLevel(int level) {
                    this.level = level;
                }

                public int getTotalLevelXP() {
                    return totalLevelXP;
                }

                public void setTotalLevelXP(int totalLevelXP) {
                    this.totalLevelXP = totalLevelXP;
                }

                public int getCurrentLevelXP() {
                    return currentLevelXP;
                }

                public void setCurrentLevelXP(int currentLevelXP) {
                    this.currentLevelXP = currentLevelXP;
                }
            }

            public static class ProtossBean {
            }
        }

        public static class CampaignBean {
        }

        public static class SeasonBean {
            @Override
            public String toString() {
                return "SeasonBean{" +
                        "seasonId=" + seasonId +
                        ", seasonNumber=" + seasonNumber +
                        ", seasonYear=" + seasonYear +
                        ", totalGamesThisSeason=" + totalGamesThisSeason +
                        '}';
            }

            /**
             * seasonId : 34
             * seasonNumber : 4
             * seasonYear : 2017
             * totalGamesThisSeason : 0
             */

            private int seasonId;
            private int seasonNumber;
            private int seasonYear;
            private int totalGamesThisSeason;

            public int getSeasonId() {
                return seasonId;
            }

            public void setSeasonId(int seasonId) {
                this.seasonId = seasonId;
            }

            public int getSeasonNumber() {
                return seasonNumber;
            }

            public void setSeasonNumber(int seasonNumber) {
                this.seasonNumber = seasonNumber;
            }

            public int getSeasonYear() {
                return seasonYear;
            }

            public void setSeasonYear(int seasonYear) {
                this.seasonYear = seasonYear;
            }

            public int getTotalGamesThisSeason() {
                return totalGamesThisSeason;
            }

            public void setTotalGamesThisSeason(int totalGamesThisSeason) {
                this.totalGamesThisSeason = totalGamesThisSeason;
            }
        }

        public static class RewardsBean {
            private List<Integer> selected;
            private List<Integer> earned;

            public List<Integer> getSelected() {
                return selected;
            }

            public void setSelected(List<Integer> selected) {
                this.selected = selected;
            }

            public List<Integer> getEarned() {
                return earned;
            }

            public void setEarned(List<Integer> earned) {
                this.earned = earned;
            }

            @Override
            public String toString() {
                return "RewardsBean{" +
                        "selected=" + selected +
                        ", earned=" + earned +
                        '}';
            }
        }

        public static class AchievementsBeanX {
            @Override
            public String toString() {
                return "AchievementsBeanX{" +
                        "points=" + points +
                        ", achievements=" + achievements +
                        '}';
            }

            /**
             * points : {"totalPoints":10,"categoryPoints":{"4330138":0,"4386911":0,"4364473":0,"4325379":10,"4325410":0,"4325377":0}}
             * achievements : [{"achievementId":91475035553880,"completionDate":1429507199}]
             */

            private PointsBean points;
            private List<AchievementsBean> achievements;

            public PointsBean getPoints() {
                return points;
            }

            public void setPoints(PointsBean points) {
                this.points = points;
            }

            public List<AchievementsBean> getAchievements() {
                return achievements;
            }

            public void setAchievements(List<AchievementsBean> achievements) {
                this.achievements = achievements;
            }

            public static class PointsBean {
                @Override
                public String toString() {
                    return "PointsBean{" +
                            "totalPoints=" + totalPoints +
                            ", categoryPoints=" + categoryPoints +
                            '}';
                }

                /**
                 * totalPoints : 10
                 * categoryPoints : {"4330138":0,"4386911":0,"4364473":0,"4325379":10,"4325410":0,"4325377":0}
                 */

                private int totalPoints;
                private CategoryPointsBean categoryPoints;

                public int getTotalPoints() {
                    return totalPoints;
                }

                public void setTotalPoints(int totalPoints) {
                    this.totalPoints = totalPoints;
                }

                public CategoryPointsBean getCategoryPoints() {
                    return categoryPoints;
                }

                public void setCategoryPoints(CategoryPointsBean categoryPoints) {
                    this.categoryPoints = categoryPoints;
                }

                public static class CategoryPointsBean {
                    @Override
                    public String toString() {
                        return "CategoryPointsBean{" +
                                "_$4330138=" + _$4330138 +
                                ", _$4386911=" + _$4386911 +
                                ", _$4364473=" + _$4364473 +
                                ", _$4325379=" + _$4325379 +
                                ", _$4325410=" + _$4325410 +
                                ", _$4325377=" + _$4325377 +
                                '}';
                    }

                    /**
                     * 4330138 : 0
                     * 4386911 : 0
                     * 4364473 : 0
                     * 4325379 : 10
                     * 4325410 : 0
                     * 4325377 : 0
                     */

                    @SerializedName("4330138")
                    private int _$4330138;
                    @SerializedName("4386911")
                    private int _$4386911;
                    @SerializedName("4364473")
                    private int _$4364473;
                    @SerializedName("4325379")
                    private int _$4325379;
                    @SerializedName("4325410")
                    private int _$4325410;
                    @SerializedName("4325377")
                    private int _$4325377;

                    public int get_$4330138() {
                        return _$4330138;
                    }

                    public void set_$4330138(int _$4330138) {
                        this._$4330138 = _$4330138;
                    }

                    public int get_$4386911() {
                        return _$4386911;
                    }

                    public void set_$4386911(int _$4386911) {
                        this._$4386911 = _$4386911;
                    }

                    public int get_$4364473() {
                        return _$4364473;
                    }

                    public void set_$4364473(int _$4364473) {
                        this._$4364473 = _$4364473;
                    }

                    public int get_$4325379() {
                        return _$4325379;
                    }

                    public void set_$4325379(int _$4325379) {
                        this._$4325379 = _$4325379;
                    }

                    public int get_$4325410() {
                        return _$4325410;
                    }

                    public void set_$4325410(int _$4325410) {
                        this._$4325410 = _$4325410;
                    }

                    public int get_$4325377() {
                        return _$4325377;
                    }

                    public void set_$4325377(int _$4325377) {
                        this._$4325377 = _$4325377;
                    }
                }
            }

            public static class AchievementsBean {
                @Override
                public String toString() {
                    return "AchievementsBean{" +
                            "achievementId=" + achievementId +
                            ", completionDate=" + completionDate +
                            '}';
                }

                /**
                 * achievementId : 91475035553880
                 * completionDate : 1429507199
                 */

                private long achievementId;
                private int completionDate;

                public long getAchievementId() {
                    return achievementId;
                }

                public void setAchievementId(long achievementId) {
                    this.achievementId = achievementId;
                }

                public int getCompletionDate() {
                    return completionDate;
                }

                public void setCompletionDate(int completionDate) {
                    this.completionDate = completionDate;
                }
            }
        }
    }
}
