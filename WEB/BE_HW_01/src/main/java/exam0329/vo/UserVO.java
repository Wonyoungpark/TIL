package exam0329.vo;

public class UserVO {
    private String name;
    private String email;
    private String gender;
    private String[] hobbys;

    private String favorites;
    private String desc;

    public UserVO() {
    }

    public UserVO(String name, String email, String gender, String[] hobbys, String favorites, String desc) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.hobbys = hobbys;
        this.favorites = favorites;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String[] getHobbys() {
        return hobbys;
    }

    public void setHobbys(String[] hobbys) {
        this.hobbys = hobbys;
    }

    public String getFavorites() {
        return favorites;
    }

    public void setFavorites(String favorites) {
        this.favorites = favorites;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
