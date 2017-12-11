package ayur.arkhipov.ru.battlenetoauthapp.common.network.model;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WowCharacters {

    private List<CharactersBean> characters;

    public List<CharactersBean> getCharacters() {
        return characters;
    }

    public void setCharacters(List<CharactersBean> characters) {
        this.characters = characters;
    }

    public static class CharactersBean {
        /**
         * name : Задруляка
         * realm : Eversong
         * battlegroup : Vindication
         * class : 11
         * race : 8
         * gender : 1
         * level : 15
         * achievementPoints : 4260
         * thumbnail : eversong/206/136758734-avatar.jpg
         * spec : {"name":"Restoration","role":"HEALING","backgroundImage":"bg-druid-restoration","icon":"spell_nature_healingtouch","description":"Uses heal-over-time Nature spells to keep allies alive.","order":3}
         * lastModified : 1419953372000
         * guild : Первая Кровь
         * guildRealm : Gordunni
         */

        private String name;
        private String realm;
        private String battlegroup;
        @SerializedName("class")
        private int classX;
        private int race;
        private int gender;
        private int level;
        private int achievementPoints;
        private String thumbnail;
        private SpecBean spec;
        private long lastModified;
        private String guild;
        private String guildRealm;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRealm() {
            return realm;
        }

        public void setRealm(String realm) {
            this.realm = realm;
        }

        public String getBattlegroup() {
            return battlegroup;
        }

        public void setBattlegroup(String battlegroup) {
            this.battlegroup = battlegroup;
        }

        public int getClassX() {
            return classX;
        }

        public void setClassX(int classX) {
            this.classX = classX;
        }

        public int getRace() {
            return race;
        }

        public void setRace(int race) {
            this.race = race;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public int getAchievementPoints() {
            return achievementPoints;
        }

        public void setAchievementPoints(int achievementPoints) {
            this.achievementPoints = achievementPoints;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public SpecBean getSpec() {
            return spec;
        }

        public void setSpec(SpecBean spec) {
            this.spec = spec;
        }

        public long getLastModified() {
            return lastModified;
        }

        public void setLastModified(long lastModified) {
            this.lastModified = lastModified;
        }

        public String getGuild() {
            return guild;
        }

        public void setGuild(String guild) {
            this.guild = guild;
        }

        public String getGuildRealm() {
            return guildRealm;
        }

        public void setGuildRealm(String guildRealm) {
            this.guildRealm = guildRealm;
        }

        @Override
        public String toString() {
            return "CharactersBean{" +
                    "name='" + name + '\'' +
                    ", realm='" + realm + '\'' +
                    ", battlegroup='" + battlegroup + '\'' +
                    ", classX=" + classX +
                    ", race=" + race +
                    ", gender=" + gender +
                    ", level=" + level +
                    ", achievementPoints=" + achievementPoints +
                    ", thumbnail='" + thumbnail + '\'' +
                    ", spec=" + spec +
                    ", lastModified=" + lastModified +
                    ", guild='" + guild + '\'' +
                    ", guildRealm='" + guildRealm + '\'' +
                    '}';
        }

        public static class SpecBean {
            /**
             * name : Restoration
             * role : HEALING
             * backgroundImage : bg-druid-restoration
             * icon : spell_nature_healingtouch
             * description : Uses heal-over-time Nature spells to keep allies alive.
             * order : 3
             */

            private String name;
            private String role;
            private String backgroundImage;
            private String icon;
            private String description;
            private int order;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getRole() {
                return role;
            }

            public void setRole(String role) {
                this.role = role;
            }

            public String getBackgroundImage() {
                return backgroundImage;
            }

            public void setBackgroundImage(String backgroundImage) {
                this.backgroundImage = backgroundImage;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public int getOrder() {
                return order;
            }

            public void setOrder(int order) {
                this.order = order;
            }

            @Override
            public String toString() {
                return "SpecBean{" +
                        "name='" + name + '\'' +
                        ", role='" + role + '\'' +
                        ", backgroundImage='" + backgroundImage + '\'' +
                        ", icon='" + icon + '\'' +
                        ", description='" + description + '\'' +
                        ", order=" + order +
                        '}';
            }
        }
    }

    @Override
    public String toString() {
        return "WowCharacters{" +
                "characters=" + characters +
                '}';
    }
}
