package com.course.desktop.offices;

public class PassportOffice {
    private long officeId;
    private String officeAreaId;
    private String officeName;

    public PassportOffice() {
    }

    public PassportOffice(Long officeId, String officeAreaId, String officeName) {
        this.officeName = officeName;
        this.officeAreaId = officeAreaId;
        this.officeId = officeId;
    }

    public long getOfficeId() {
        return officeId;
    }

    public void setOfficeId(long officeId) {
        this.officeId = officeId;
    }

    public String getOfficeAreaId() {
        return officeAreaId;
    }

    public void setOfficeAreaId(String officeAreaId) {
        this.officeAreaId = officeAreaId;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }
}
