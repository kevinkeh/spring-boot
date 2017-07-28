package com.kevin.model.db1;

import java.util.Date;

public class City {
    private Integer cityid;

    private Integer continentid;

    private Integer countryid;

    private Integer provinceid;

    private String cityname;

    private String citycode;

    private String englishname;

    private String fullpinyin;

    private String shortpinyin;

    private String firstchar;

    private Byte iscapital;

    private Byte isactive;

    private Integer sortnum;

    private Date datachangeCreatetime;

    private Date datachangeLasttime;

    private Integer timezone;

    private Double longitude;

    private Double latitude;

    private Integer parentid;

    public Integer getCityid() {
        return cityid;
    }

    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    public Integer getContinentid() {
        return continentid;
    }

    public void setContinentid(Integer continentid) {
        this.continentid = continentid;
    }

    public Integer getCountryid() {
        return countryid;
    }

    public void setCountryid(Integer countryid) {
        this.countryid = countryid;
    }

    public Integer getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(Integer provinceid) {
        this.provinceid = provinceid;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname == null ? null : cityname.trim();
    }

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode == null ? null : citycode.trim();
    }

    public String getEnglishname() {
        return englishname;
    }

    public void setEnglishname(String englishname) {
        this.englishname = englishname == null ? null : englishname.trim();
    }

    public String getFullpinyin() {
        return fullpinyin;
    }

    public void setFullpinyin(String fullpinyin) {
        this.fullpinyin = fullpinyin == null ? null : fullpinyin.trim();
    }

    public String getShortpinyin() {
        return shortpinyin;
    }

    public void setShortpinyin(String shortpinyin) {
        this.shortpinyin = shortpinyin == null ? null : shortpinyin.trim();
    }

    public String getFirstchar() {
        return firstchar;
    }

    public void setFirstchar(String firstchar) {
        this.firstchar = firstchar == null ? null : firstchar.trim();
    }

    public Byte getIscapital() {
        return iscapital;
    }

    public void setIscapital(Byte iscapital) {
        this.iscapital = iscapital;
    }

    public Byte getIsactive() {
        return isactive;
    }

    public void setIsactive(Byte isactive) {
        this.isactive = isactive;
    }

    public Integer getSortnum() {
        return sortnum;
    }

    public void setSortnum(Integer sortnum) {
        this.sortnum = sortnum;
    }

    public Date getDatachangeCreatetime() {
        return datachangeCreatetime;
    }

    public void setDatachangeCreatetime(Date datachangeCreatetime) {
        this.datachangeCreatetime = datachangeCreatetime;
    }

    public Date getDatachangeLasttime() {
        return datachangeLasttime;
    }

    public void setDatachangeLasttime(Date datachangeLasttime) {
        this.datachangeLasttime = datachangeLasttime;
    }

    public Integer getTimezone() {
        return timezone;
    }

    public void setTimezone(Integer timezone) {
        this.timezone = timezone;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }
}