package kg.megacom.Final.Project.utils.models;

public enum Language {
    KG,
    RU;


    public static Language getLang(int langId){
        switch (langId){
            case 1:return KG;
            case 2:return RU;
            default:return RU;
        }
    }
}
