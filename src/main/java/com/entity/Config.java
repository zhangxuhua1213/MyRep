package com.entity;

public class Config {
    private String yueka;

    private String jika;

    private String nianka;

    private String zhongshenka;

    public Config(String yueka, String jika, String nianka, String zhongshenka) {
        this.yueka = yueka;
        this.jika = jika;
        this.nianka = nianka;
        this.zhongshenka = zhongshenka;
    }

    public Config() {
        super();
    }

    public String getYueka() {
        return yueka;
    }

    public void setYueka(String yueka) {
        this.yueka = yueka == null ? null : yueka.trim();
    }

    public String getJika() {
        return jika;
    }

    public void setJika(String jika) {
        this.jika = jika == null ? null : jika.trim();
    }

    public String getNianka() {
        return nianka;
    }

    public void setNianka(String nianka) {
        this.nianka = nianka == null ? null : nianka.trim();
    }

    public String getZhongshenka() {
        return zhongshenka;
    }

    public void setZhongshenka(String zhongshenka) {
        this.zhongshenka = zhongshenka == null ? null : zhongshenka.trim();
    }
}