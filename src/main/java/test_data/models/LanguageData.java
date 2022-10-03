package test_data.models;

public class LanguageData {

    private String code;
    private String label;

    public LanguageData(String code, String label) {
        this.code = code;
        this.label = label;
    }

    public String getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return "LanguageData{" +
                "code='" + code + '\'' +
                ", label='" + label + '\'' +
                '}';
    }
}
