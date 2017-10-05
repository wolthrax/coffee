package by.home.hryhoryeu.coffee.dto;

public class ConfigurationDTO {
    private Integer x;
    private Integer n;
    private Integer m;
    private Boolean defaultConfig;

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getN() {
        return n;
    }

    public void setN(Integer n) {
        this.n = n;
    }

    public Integer getM() {
        return m;
    }

    public void setM(Integer m) {
        this.m = m;
    }

    public Boolean getDefaultConfig() {
        return defaultConfig;
    }

    public void setDefaultConfig(Boolean defaultConfig) {
        this.defaultConfig = defaultConfig;
    }

    @Override
    public String toString() {
        return "ConfigurationDTO{" +
                "x=" + x +
                ", n=" + n +
                ", m=" + m +
                ", defaultConfig=" + defaultConfig +
                '}';
    }
}
